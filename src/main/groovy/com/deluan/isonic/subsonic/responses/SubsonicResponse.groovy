package com.deluan.isonic.subsonic.responses

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = 'subsonic-response')
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode

class SubsonicResponse {
    @XmlAttribute
    String status = 'ok'

    @XmlAttribute
    String version = '1.0.0'

    License license
    SubsonicError error

    public static withError(SubsonicError error) {
        new SubsonicResponse(status: 'failed', error: error)
    }

    public static withGenericError(String message) {
        def error = new SubsonicError(message: message)
        def response = withError(error)
        response
    }

}
