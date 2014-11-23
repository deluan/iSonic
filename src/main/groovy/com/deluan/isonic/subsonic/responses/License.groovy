package com.deluan.isonic.subsonic.responses

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute

@XmlAccessorType(XmlAccessType.NONE)
class License {
    @XmlAttribute
    Boolean valid = true
}
