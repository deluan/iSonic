package com.deluan.isonic.itunes


import org.springframework.data.annotation.Id
import org.springframework.data.solr.core.mapping.Indexed
import org.springframework.data.solr.core.mapping.SolrDocument

@SolrDocument
class Track {
    @Indexed("_type_")
    private type = this.class.simpleName.toLowerCase()

    @Id String id
    @Indexed String name
    @Indexed String artist
    @Indexed String album
    @Indexed String genre
    @Indexed String kind
    @Indexed Long size
    @Indexed Long totalTime
    @Indexed Integer number
    @Indexed Integer count
    @Indexed Integer year
    @Indexed String location
    @Indexed Boolean compilation
}
