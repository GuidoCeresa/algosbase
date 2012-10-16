import org.hibernate.mapping.Map

//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//

def plugin = "${pluginBasedir}/"
def app = "${basedir}/"
def dir = "${plugin}scripts/"

String groovySuffix = '.groovy'
String gspSuffix = '.gsp'
String cssSuffix = '.css'

// The GroovyScriptEngine needs to know the root directories of your code
String[] roots = [dir]
def engine = new GroovyScriptEngine(roots)

// Load the class and create an instance
def algosBaseClass = engine.loadScriptByName("AlgosBase.groovy")
algosBase = algosBaseClass.newInstance()

// Load the class and create an instance of each enumeration
def algosType = engine.loadScriptByName("AlgosType.groovy")
def newOnly = algosType.newOnly
def always = algosType.always
def firstTimeFalseAndAfterwardsOnlyNotModified = algosType.firstTimeFalseAndAfterwardsOnlyNotModified
def firstTimeTrueAndAfterwardsOnlyNotModified = algosType.firstTimeTrueAndAfterwardsOnlyNotModified
def onlyAlreadyExisting = algosType.onlyAlreadyExisting

// Load the class and create an instance of each enumeration
def algosTag = engine.loadScriptByName('AlgosTag.groovy')
def groovyTag = algosTag.groovy
def cssTag = algosTag.css
def gspTag = algosTag.gsp
def scaffoldingTag = algosTag.scaffolding
def templateTag = algosTag.template
def vuotoTag = algosTag.vuoto

// Create a reference for each path in the map
java.util.Map<String, String> mappa = algosBaseClass.getMappaDirectory()
def conf = mappa.get('conf')
def views = mappa.get('views')
def layouts = mappa.get('layouts')
def scaffolding = mappa.get('scaffolding')
def css = mappa.get('css')
def scripts = mappa.get('scripts')
def source = mappa.get('source')

String srcName
String destDirectory
def type
def tag

// Inizio dello script
println('Starting script di installazione AlgosBase')

// List of files
// File specifici contenuti in una apposita directory
srcName = 'ApplicationResources' + groovySuffix
destDirectory = conf
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'BootStrap' + groovySuffix
destDirectory = conf
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'BuildConfig' + groovySuffix
destDirectory = conf
type = firstTimeFalseAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'Config' + groovySuffix
destDirectory = conf
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'DataSource' + groovySuffix
destDirectory = conf
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'UrlMappings' + groovySuffix
destDirectory = conf
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'main' + gspSuffix
destDirectory = layouts
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.addSource(srcName, destDirectory, type, tag)

// List of files
// File standard da spostare nella corrispondente cartella dell'applicazione
srcName = 'index' + gspSuffix
destDirectory = views
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = '_form' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = scaffoldingTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'Controller' + groovySuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = groovyTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'create' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = scaffoldingTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'edit' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = scaffoldingTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'list' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = scaffoldingTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'renderEditor' + '.template'
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = templateTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'show' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = scaffoldingTag
algosBase.add(srcName, destDirectory, type, tag)

// File standard da spostare nella corrispondente cartella dell'applicazione
srcName = 'errors' + cssSuffix
destDirectory = css
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = cssTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'main' + cssSuffix
destDirectory = css
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = cssTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'mobile' + cssSuffix
destDirectory = css
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = cssTag
algosBase.add(srcName, destDirectory, type, tag)

// Call delegate method
// Elabora tutti i file elencati
algosBase.ciclo(plugin, app)

// Fine dello script
println('Ending script di installazione AlgosBase')
