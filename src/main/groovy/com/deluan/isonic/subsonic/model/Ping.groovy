package com.deluan.isonic.subsonic.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = 'subsonic-response', namespace = 'http://subsonic.org/restapi')
class Ping {
    @XmlAttribute
    String status = 'ok'
    @XmlAttribute
    String version = '1.10.2'
}
