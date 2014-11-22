package com.deluan.isonic.subsonic.responses

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = 'subsonic-response', namespace = 'http://subsonic.org/restapi')
class SubsonicResponse extends HashMap {
    public static final String PROTOCOL_VERSION = '1.0.0'

    public static withEmptyElement() {
        def response = new SubsonicResponse()
        response['status'] = 'ok'
        response['version'] = PROTOCOL_VERSION
        response
    }

    public static withElement(Object element) {
        def response = new SubsonicResponse()
        response['status'] = 'ok'
        response['version'] = PROTOCOL_VERSION
        response.put(element.class.simpleName.toLowerCase(), element)
        response
    }

    public static withError(SubsonicError error) {
        def response = new SubsonicResponse()
        response['status'] = 'failed'
        response['version'] = PROTOCOL_VERSION
        response.put('error', [
                code   : error.code,
                message: error.message
        ])
        response
    }

    public static withGenericError(String message) {
        def response = withError(SubsonicError.GENERIC)
        response.error.message = message
        response
    }

}
