// To execute: grails run-script scripts/test.groovy
String plugin = '/algos/algosbase/'
def app = '/algos/algosbase/'

String groovySuffix = '.groovy'
String gspSuffix = '.gsp'
String cssSuffix = '.css'

// The GroovyScriptEngine needs to know the root directories of your code
String[] roots = ['./scripts']
def engine = new GroovyScriptEngine(roots)

// Load the class and create an instance
def algosBaseClass = engine.loadScriptByName('AlgosBase.groovy')
algosBase = algosBaseClass.newInstance()

// Load the class and create an instance of each enumeration
def algosType = engine.loadScriptByName('AlgosType.groovy')
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

// Create a reference for each path in the map
Map mappa = algosBase.getMappaDirectory()
def conf = mappa.get('conf')
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
srcName = 'BuildConfig' + groovySuffix
destDirectory = conf
type = firstTimeTrueAndAfterwardsOnlyNotModified
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
type = onlyAlreadyExisting
tag = groovyTag
algosBase.addSource(srcName, destDirectory, type, tag)

srcName = 'main' + gspSuffix
destDirectory = layouts
type = firstTimeFalseAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.addSource(srcName, destDirectory, type, tag)

// List of files
// File standard da spostare nella corrispondente cartella dell'applicazione
srcName = '_form' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'Controller' + groovySuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'create' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'edit' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'list' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'renderEditor' + '.template'
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'show' + gspSuffix
destDirectory = scaffolding
type = firstTimeTrueAndAfterwardsOnlyNotModified
tag = gspTag
algosBase.add(srcName, destDirectory, type, tag)

// File standard da spostare nella corrispondente cartella dell'applicazione
srcName = 'errors' + cssSuffix
destDirectory = css
type = firstTimeFalseAndAfterwardsOnlyNotModified
tag = cssTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'main' + cssSuffix
destDirectory = css
type = firstTimeFalseAndAfterwardsOnlyNotModified
tag = cssTag
algosBase.add(srcName, destDirectory, type, tag)

srcName = 'mobile' + cssSuffix
destDirectory = css
type = firstTimeFalseAndAfterwardsOnlyNotModified
tag = cssTag
algosBase.add(srcName, destDirectory, type, tag)

// Call delegate method
// Elabora tutti i file elencati
//algosBase.ciclo(plugin, app)

algosBase.printAll()

// Fine dello script
println('Ending script di installazione AlgosBase')
println(algosBase.toString())
println(mappa)