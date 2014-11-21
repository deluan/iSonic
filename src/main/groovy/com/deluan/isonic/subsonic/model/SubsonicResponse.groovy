package com.deluan.isonic.subsonic.model

import javax.xml.bind.annotation.*

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
        response.put('error', error)
        response
    }

}
