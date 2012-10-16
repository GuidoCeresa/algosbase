/**
 * Created by IntelliJ IDEA.
 * User: Gac
 * Date: 07/04/12
 * Time: 08:40
 */

// Da usare solo con versione 2.0 o successive di Idea
// Usa il database H2

// Devi creare il database esternamente
// Devi modificare qui il nome del database
def dataBase = 'test'

dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "root"
    password = ""
} // end of dataSource

hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
} // end of hibernate

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:h2:${dataBase};MVCC=TRUE"
            pooled = true
            properties {
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            } // end of properties
        } // end of dataSource
    } // end of development

    test {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
        } // end of dataSource
    } // end of test

    production {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/${dataBase}?useUnicode=yes&characterEncoding=UTF-8"
        } // end of dataSource
    } // end of production
} // end of environments
