package com.deluan.isonic.itunes

import com.deluan.isonic.util.Loggable
import com.worldsworstsoftware.itunes.ItunesLibrary
import com.worldsworstsoftware.itunes.parser.ItunesLibraryParser
import com.worldsworstsoftware.itunes.util.ItunesLibraryFinder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ItunesLibraryLoader implements Loggable {

    @Value('${itunes.library.path}')
    String libraryPath

    public ItunesLibrary loadLibrary() {
        String libraryLocation = libraryPath ?: ItunesLibraryFinder.findLibrary()
        if (libraryLocation == null) {
            logger.error("Couldn't find iTunes Library")
            return null
        }

        loadLibrary(libraryLocation)
    }

    public ItunesLibrary loadLibrary(String libraryLocation) {
        if (ItunesLibraryFinder.fileIsItunesLibrary(libraryLocation)) {
            logger.info("Found iTunes library at ${libraryLocation}")
        } else {
            logger.error("File '${libraryLocation}' is NOT an iTunes Library XML")
            return null
        }
        def library = ItunesLibraryParser.parseLibrary(libraryLocation)
        logger.info("Loaded ${library.tracks.size()} tracks")
        return library
    }
}
