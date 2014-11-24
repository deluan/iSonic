package com.deluan.isonic.subsonic.responses

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonRootName
import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = 'subsonic-response')
@JsonRootName('subsonic-response')
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
class SubsonicResponse {
    @XmlAttribute
    String status = 'ok'

    @XmlAttribute
    String version = '1.0.0'

    SubsonicError error

    License license
    MusicFolders musicFolders

    public static withError(SubsonicError error) {
        new SubsonicResponse(status: 'failed', error: error)
    }

    public static withGenericError(String message) {
        def error = new SubsonicError(message: message)
        def response = withError(error)
        response
    }

}
