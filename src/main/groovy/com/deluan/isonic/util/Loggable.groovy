package com.deluan.isonic.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

trait Loggable {
    Logger logger = LoggerFactory.getLogger(this.class)
}