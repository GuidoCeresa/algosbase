/* Created by Algos s.r.l. */
/* This program is free software */
/* you can redistribute it and/or modify it under the terms of */
/* the GNU General Public License as published by the Free Software Foundation */
/* either version 2 of the License, or (at your option) any later version. */
/* This program is distributed in the hope that it will be useful, */
/* but WITHOUT ANY WARRANTY */
/* without even the implied warranty of */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. */
/* See the GNU General Public License for more details. */

grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // enable remote dependency resolution from public Algos repositories
        mavenRepo "http://77.43.32.198:8080/artifactory/plugins-release-local/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.5'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.0"
        runtime ":resources:1.1.6"
        build ":release:2.0.2"

        runtime ":algosbase:latest.integration"
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"
        build ":tomcat:$grailsVersion"
        compile ':cache:1.0.0'
    }
}
