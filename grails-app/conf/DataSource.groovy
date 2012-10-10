def dataBase = 'testbase'

dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    //dialect = "org.hibernate.dialect.MySQLMyISAMDialect"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    username = "root"
    password = ""
} // end of dataSource

hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
} // end of hibernate

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/${dataBase}?useUnicode=yes&characterEncoding=UTF-8"
        } // end of dataSource
    } // end of development

    test {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/${dataBase}?useUnicode=yes&characterEncoding=UTF-8"
        } // end of dataSource
    } // end of production

    production {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/${dataBase}?useUnicode=yes&characterEncoding=UTF-8"
        } // end of dataSource
    } // end of test
} // end of environments
