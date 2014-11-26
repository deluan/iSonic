package com.deluan.isonic.model

class Album {
    Long id
    String name
    Artist artist
    String coverArtPath
    Integer year
    Boolean compilation
    Integer rating
    Date lastPlayed

    List<MediaFile> tracks
}
