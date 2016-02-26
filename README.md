iSonic
======
[![Build Status](https://travis-ci.org/deluan/iSonic.svg?branch=master)](https://travis-ci.org/deluan/iSonic)
[![Coverage Status](https://img.shields.io/coveralls/deluan/iSonic.svg)](https://coveralls.io/r/deluan/iSonic)

__THIS PROJECT IS HALTED.__

I started this project as a means to learn new stuff. But Java, Spring-Boot, Solr/Lucene and Gradle are not really new to me... __So I rebooted this project as a [Go](https://golang.org/) project. The new project, _GoSonic_, can be found here: https://github.com/deluan/gosonic__

---

### About

iSonic is an application that implements the [Subsonic API](http://www.subsonic.org/pages/api.jsp), but instead of
having its own music library like the original [Subsonic application](http://www.subsonic.org), it interacts directly
with your iTunes library.

The main goals for this project are:
* Full compatibility with the available [Subsonic clients](http://www.subsonic.org/pages/apps.jsp)
* Use all metadata from iTunes
* Update play counts, last played dates, ratings, etc..  on iTunes
* Use iTunes interface to manage your music


### Building and running

You will need Java 1.7 to build and run this application. This is a [Spring Boot](http://projects.spring.io/spring-boot)
project, using [Gradle](http://www.gradle.org) as its build tool. The easiest way to run the app from the sources is
using the Gradle wrapper with the `bootRun` task:
```
$ ./gradlew bootRun

 _  ______             _
(_)/ _____)           (_)
 _( (____   ___  ____  _  ____
| |\____ \ / _ \|  _ \| |/ ___)
| |_____) ) |_| | | | | ( (___
|_(______/ \___/|_| |_|_|\____)
http://github.com/deluan/iSonic

....... . . .
....... . . . (log output here)
....... . . .
........ Started ISonicApplication in 29.737 seconds (JVM running for 31.771)
```

You can check if it is running by pointing your browser to [http://localhost:8080](http://localhost:8080). You should
view the message: _Greetings from iSonic!_

The first time you build it, Gradle will download all required dependencies (takes a looooong time). These will be
cached for the subsequent builds.

This project can be package as a standalone JAR application with the following command:
```
$ ./gradlew build                        # to build it
$ java -jar build/libs/iSonic-X.X.X.jar  # to run it (use the current version instead of X.X.X)
```


### Setup dev environment

Any _good_ IDE with Gradle support should be able to open and build the project. Check Spring Boot documentation on
[how to set-up hot swapping]
(http://docs.spring.io/spring-boot/docs/1.2.0.RC2/reference/htmlsingle/#howto-reload-java-classes-without-restarting)
so you don't need to restart the application after every change.
