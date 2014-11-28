package com.deluan.isonic.itunes

import org.springframework.data.solr.repository.SolrCrudRepository

interface ItunesTrackRepository extends SolrCrudRepository<Track, String> {
    List<Track> findByName(String name);
}


