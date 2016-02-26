package com.deluan.isonic.itunes

import spock.lang.Specification

class LibraryImporterSpec extends Specification {

    def loader
    def repository
    def importer

    def setup() {
        repository = Mock(ItunesTrackRepository)
        loader = Mock(ItunesLibraryLoader)
        importer = new LibraryImporter(loader: loader, repository: repository)
    }

    def "should"() {
        expect:
          2 == 2


    }
}
