package com.deluan.isonic.itunes

import com.deluan.isonic.util.Loggable
import com.worldsworstsoftware.itunes.ItunesLibrary
import com.worldsworstsoftware.itunes.ItunesTrack
import com.worldsworstsoftware.itunes.parser.ItunesLibraryParser
import com.worldsworstsoftware.itunes.util.ItunesLibraryFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class LibraryImporter implements Loggable {

    @Value('${itunes.library.path}')
    String libraryPath

    @Autowired
    ItunesTrackRepository repository

    @Autowired
    ItunesLibraryLoader loader

    ItunesLibrary library
    Long lastModified = 0

    void parse() {
        String libraryLocation = libraryPath ?: ItunesLibraryFinder.findLibrary()
        if (libraryLocation == null) {
            logger.error("Couldn't find iTunes Library")
            return
        }
        if (ItunesLibraryFinder.fileIsItunesLibrary(libraryLocation)) {
            logger.info("Found iTunes library at ${libraryLocation}")
        } else {
            logger.error("File '${libraryLocation}' is NOT and iTunes Library XML")
            return
        }

        if (loadLibrary(libraryLocation)) {
            clearSolrData()
            importLibrary()
        }
    }

    void clearSolrData() {
        repository.deleteAll()
    }

    void importLibrary() {
        def filteredList = []
        library.tracks.each { Integer id, ItunesTrack track ->
            if (track.trackType == 'File' && track.kind.contains('audio')) {
                filteredList << mapToSolr(track)
            }
        }
        logger.info("Filtered ${filteredList.size()} tracks to be imported")

        def partitionedList = filteredList.collate(2000)
        logger.info("${partitionedList.size()} blocks will be written to Solr")

        saveToSolr(partitionedList)
        logger.info("Finished importing ${repository.count()} tracks into Solr")
    }

    private mapToSolr(ItunesTrack track) {
        new Track(
                id: track.trackID,
                name: track.name,
                artist: track.artist,
                album: track.album,
                genre: track.genre,
                kind: track.kind,
                size: track.size,
                totalTime: track.totalTime,
                number: track.trackNumber,
                count: track.trackCount,
                year: track.year,
                location: track.location,
                compilation: track.compilation,
        )
    }

    private saveToSolr(List<List> partitionedList) {
        int total = 0
        partitionedList.eachWithIndex { subList, index ->
            repository.save(subList)
            total += subList.size()
            logger.debug("Block #${index + 1}: ${total} tracks saved")
        }
    }

    private loadLibrary(String libraryLocation) {
        Long libraryLastModified = new File(libraryLocation).lastModified()
        if (libraryLastModified > lastModified) {
            library = ItunesLibraryParser.parseLibrary(libraryLocation)
            lastModified = libraryLastModified

            logger.info("Loaded ${library.tracks.size()} tracks")
            return true
        }
        logger.debug("Library has not been modified since ${new Date(lastModified)}")
        false
    }
}
