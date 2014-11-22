package com.deluan.isonic.subsonic.responses

enum SubsonicError {
    GENERIC(0, 'A generic error'),
    MISSING_PARAMETER(10, 'Required parameter is missing'),
    CLIENT_TOO_OLD(20, 'Incompatible Subsonic REST protocol version. Client must upgrade'),
    SERVER_TOO_OLD(30, 'Incompatible Subsonic REST protocol version. Server must upgrade'),
    AUTHENTICATION_FAIL(40, 'Wrong username or password'),
    AUTHORIZATION_FAIL(50, 'User is not authorized for the given operation'),
    TRIAL_EXPIRED(60, 'The trial period for the Subsonic server is over. Please upgrade to Subsonic Premium. Visit subsonic.org for details'),
    DATA_NOT_FOUND(70, 'The requested data was not found')

    Integer code
    String message

    SubsonicError(code, message) {
        this.code = code
        this.message = message
    }

}