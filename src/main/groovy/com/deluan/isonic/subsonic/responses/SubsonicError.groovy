package com.deluan.isonic.subsonic.responses

import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute

@XmlAccessorType(XmlAccessType.NONE)
@EqualsAndHashCode
class SubsonicError {

    static final GENERIC = new SubsonicError(0, 'A generic error')
    static final MISSING_PARAMETER = new SubsonicError(10, 'Required parameter is missing')
    static final CLIENT_TOO_OLD = new SubsonicError(20, 'Incompatible Subsonic REST protocol version. Client must upgrade')
    static final SERVER_TOO_OLD = new SubsonicError(30, 'Incompatible Subsonic REST protocol version. Server must upgrade')
    static final AUTHENTICATION_FAIL = new SubsonicError(40, 'Wrong username or password')
    static final AUTHORIZATION_FAIL = new SubsonicError(50, 'User is not authorized for the given operation')
    static final TRIAL_EXPIRED = new SubsonicError(60, 'The trial period for the Subsonic server is over. Please upgrade to Subsonic Premium. Visit subsonic.org for details')
    static final DATA_NOT_FOUND = new SubsonicError(70, 'The requested data was not found')

    @XmlAttribute
    Integer code
    @XmlAttribute
    String message

    public SubsonicError() {
        this.code = 0
    }

    private SubsonicError(code, message) {
        this.code = code
        this.message = message
    }
}