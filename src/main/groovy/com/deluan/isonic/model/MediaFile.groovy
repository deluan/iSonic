package com.deluan.isonic.model

class MediaFile {
    Long id
    String title
    String path
    MediaType mediaType
    Album album
    Artist artist
    Artist albumArtist
    String genre
    Integer discNumber
    Integer trackNumber
    Integer duration
    String comment

    Integer rating
    Integer playCount
    Date lastPlayed
    Date dateAdded


    Long fileSize
    Integer bitRate
}
