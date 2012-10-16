// To execute: grails run-script scripts/algosbase.groovy

// Libreria di funzioni per lo script di _install
// Vengono raggruppate qui per non appesantire lo script base
// Possono essere riutilizzate in altri ambiti

class AlgosBase {

    private static String flagOverwrite = 'flagOverwrite'
    private static String grails = 'grails-app/'
    private static String web = 'web-app/'

    private static String prefix = 'AlgosBase'
    private static String suffix = '.txt'

    private static String conf = 'conf/'
    private static String views= 'views/'
    private static String layouts = 'layouts/'
    private static String src = 'src/'
    private static String templates = 'templates/'
    private static String scaffolding = 'scaffolding/'
    private static String css = 'css/'
    private static String scripts = 'scripts/'
    private static String source = 'it/algos/algosbase/source/'
    private static String dir = grails + source

    def static srcNames = [] // global list of source files to copy
    def static dstNames = [] // global list of source files to copy
    def static srcDirs = []   // global list of destination files
    def static dstDirs = []   // global list of destination files
    def static types = []                              // type of substitution
    def static tags = []                              // type of tag
    def static sourcesBool = []                        // path of file

    static String plugin
    static String app

    // Crea una mappa di tutte le directory interessate
    // Chiave=/=valore
    static Map<String, String> getMappaDirectory() {
        LinkedHashMap<String, String> mappa = new LinkedHashMap<String, String>()

        mappa.put('conf', grails + conf)
        mappa.put('views', grails + views)
        mappa.put('layouts', grails + views + layouts)
        mappa.put('scaffolding', src + templates + scaffolding)
        mappa.put('css', web + css)
        mappa.put('scripts', scripts)
        mappa.put('source', grails + source)

        return mappa
    }

    // Aggiunge agli array un file specifico contenuto nella apposita directory source
    static addSource(String nameFile, String destDirectory, type, tag) {
        srcNames.add(nameFile)
        dstNames.add(nameFile)
        srcDirs.add(dir)
        dstDirs.add(destDirectory)
        types.add(type)
        tags.add(tag)
        sourcesBool.add(true)
    }

    // Aggiunge agli array un file standard da spostare nella corrispondente cartella dell'applicazione
    static add(String nameFile, String destDirectory, type, tag) {
        srcNames.add(nameFile)
        dstNames.add(nameFile)
        srcDirs.add(destDirectory)
        dstDirs.add(destDirectory)
        types.add(type)
        tags.add(tag)
        sourcesBool.add(false)
    }

    // Delegate method for all files
    static ciclo(String pluginName, String appName) {
        if (pluginName && appName) {
            plugin = pluginName
            app = appName

            cicloAll()

        } else {
            print('------------')
            print('Plugin non chiaramente identificato')
            print('------------')
        }// fine del blocco if-else
    }

    // Delegate method for all files
    static cicloAll() {
        if (srcNames.size() == srcDirs.size() && srcDirs.size() == types.size()) {
            print('Inizio ciclo di controllo di ' + srcNames.size() + ' file')
            print('------------')

            cicloBase()

            print('------------')
            print('Fine del ciclo di controllo')
        } else {
            print('------------')
            print('Nome e numero di file non corretti')
            print('------------')
        }// fine del blocco if-else
    }


    private static cicloBase() {
        String srcName
        String dstName
        String srcDir
        String dstDir
        def type
        def tag

        for (int i = 0; i < srcNames.size(); i++) {

            srcDir = srcDirs[i].toString()
            srcName = srcNames[i].toString()
            dstDir = dstDirs[i].toString()
            dstName = dstNames[i].toString()
            type = types[i]
            tag = tags[i]

            if (sourcesBool[i]) {
                srcDir = plugin + dir
                srcName = prefix + srcName
            } else {
                srcDir = plugin + srcDir
            }// fine del blocco if-else
            dstDir = app + dstDir

            cicloSingolo(i + 1, srcDir, srcName, dstDir, dstName, type, tag)
        }
    }


    private static cicloSingolo(num, srcDir, srcName, dstDir, dstName, type, tag) {
        String srcPath = srcDir + srcName
        File srcFile = new File(srcPath)

        if (srcFile.exists()) {
            singoloFile(num, srcDir, srcName, dstDir, dstName, type, tag)
        } else {
            File srcDirDir = new File((String)srcDir)
            if (srcDirDir.exists()) {
                print('Esiste la directory sorgente: ' + srcDir)
                print(num + ') ' + 'Il file sorgente ' + srcName + ' non esiste nella cartella ' + srcDir)
            } else {
                print('? Non esiste la directory sorgente: ' + srcDir)
            }// fine del blocco if-else

        }// fine del blocco if-else
    }


    private static singoloFile(num, srcDir, srcName, dstDir, dstName, type, tag) {

        String headerTxt = getHeader(type, tag)
        String fileSrcTxt = getSrcText(srcDir, srcName)
        String fileDstTxt

        fileDstTxt = headerTxt + '\n' + fileSrcTxt
        headerTxt = getHeader(type, tag)

        switch (type) {
            case AlgosType.newOnly:
                newOnly(num, dstDir, dstName, fileDstTxt)
                break
            case AlgosType.always:
                always(num, dstDir, dstName, fileDstTxt)
                break
            case AlgosType.firstTimeFalseAndAfterwardsOnlyNotModified:
                firstTimeFalseAndAfterwardsOnlyNotModified(num, dstDir, dstName, fileDstTxt, headerTxt)
                break
            case AlgosType.firstTimeTrueAndAfterwardsOnlyNotModified:
                firstTimeTrueAndAfterwardsOnlyNotModified(num, dstDir, dstName, fileDstTxt)
                break
            case AlgosType.onlyAlreadyExisting:
                onlyAlreadyExisting(num, dstDir, dstName, fileDstTxt)
                break
            default: // caso non definito
                break
        } // fine del blocco switch

        print(num + ' - srcName: ' + srcName)
        print(num + ' - dstName: ' + dstName)
        print(num + ' - srcDir: ' + srcDir)
        print(num + ' - dstDir: ' + dstDir)
        print(num + ' - type: ' + type)
        print(num + ' - tag: ' + tag)
    }


    private static String getSrcText(srcDir, srcName) {
        String fileSrcTxt = ''
        String srcPath = srcDir + srcName
        File srcFile

        if (srcPath) {
            srcFile = new File(srcPath)
            if (srcFile) {
                fileSrcTxt = srcFile.getText()
            }// fine del blocco if
        }// fine del blocco if

        return fileSrcTxt
    }

    // se non esiste il file, lo crea (header senza flag)
    // se esiste il file, non fa nulla
    private static newOnly(num, dstDir, dstName, fileDstTxt) {
        if (esisteFile(dstDir, dstName)) {
            print(num + ') ' + 'Il file ' + dstName + ' esisteva già e non è stato modificato')
        } else {
            print(num + ') ' + 'Il file ' + dstName + ' non esisteva ed è stato creato')
            scrive(dstDir, dstName, fileDstTxt)
        }// fine del blocco if-else
    }

    // se non esiste il file, lo crea (header con flag=true)
    // se esiste il file e non c'è il flag, sovrascrive il file (header con flag=true)
    // se esiste il file e c'è il flag, controlla il flag
    // se il flag è true, sovrascrive il file
    private static always(num, dstDir, dstName, fileDstTxt) {
        if (esisteFile(dstDir, dstName)) {
            if (esisteFlag(dstDir, dstName)) {
                if (sovraScrivibile(dstDir, dstName)) {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è true ed il file è stato sovrascritto')
                    scrive(dstDir, dstName, fileDstTxt)
                } else {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è falso ed il file non è stato modificato')
                }// fine del blocco if-else
            } else {
                print(num + ') ' + 'Nel file ' + dstName + ' non era presente il flag di controllo ed il file è stato sovrascritto')
                scrive(dstDir, dstName, fileDstTxt)
            }// fine del blocco if-else
        } else {
            print(num + ') ' + 'Il file ' + dstName + ' non esisteva ed è stato creato')
            scrive(dstDir, dstName, fileDstTxt)
        }// fine del blocco if-else
    }

    // se non esiste il file, lo crea (header con flag)
    // se esiste il file e non c'è il flag, aggiunge header con flag
    //     (in testa file e senza modificare il contenuto esistente)
    // se esiste il file e c'è il flag, controlla il flag
    // se il flag è true, sovrascrive il file
    private static firstTimeFalseAndAfterwardsOnlyNotModified(num, dstDir, dstName, fileDstTxt, headerTxt) {
        if (esisteFile(dstDir, dstName)) {
            if (esisteFlag(dstDir, dstName)) {
                if (sovraScrivibile(dstDir, dstName)) {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è true ed il file è stato sovrascritto')
                    scrive(dstDir, dstName, fileDstTxt)
                } else {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è falso ed il file non è stato modificato')
                }// fine del blocco if-else
            } else {
                print(num + ') ' + 'Nel file ' + dstName + ' non era presente il flag di controllo che è stato aggiunto ma il file non è stato modificato')
                addFlag(dstDir, dstName, headerTxt)
            }// fine del blocco if-else
        } else {
            print(num + ') ' + 'Il file ' + dstName + ' non esisteva ed è stato creato')
            scrive(dstDir, dstName, fileDstTxt)
        }// fine del blocco if-else
    }

    // se non esiste il file, lo crea (header con flag=false)
    // se esiste il file e non c'è il flag, sovrascrive il file (header con flag=false)
    // se esiste il file e c'è il flag, controlla il flag
    // se il flag è true, sovrascrive il file
    private static firstTimeTrueAndAfterwardsOnlyNotModified(num, dstDir, dstName, fileDstTxt) {
        if (esisteFile(dstDir, dstName)) {
            if (esisteFlag(dstDir, dstName)) {
                if (sovraScrivibile(dstDir, dstName)) {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è true ed il file è stato sovrascritto')
                    scrive(dstDir, dstName, fileDstTxt)
                } else {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è falso ed il file non è stato modificato')
                }// fine del blocco if-else
            } else {
                print(num + ') ' + 'Nel file ' + dstName + ' non era presente il flag di controllo ed il file è stato sovrascritto')
                scrive(dstDir, dstName, fileDstTxt)
            }// fine del blocco if-else
        } else {
            print(num + ') ' + 'Il file ' + dstName + ' non esisteva ed è stato creato')
            scrive(dstDir, dstName, fileDstTxt)
        }// fine del blocco if-else
    }

    // se non esiste il file, non fa nulla
    // se esiste il file e non c'è il flag, sovrascrive il file (header con flag=false)
    // se esiste il file e c'è il flag, controlla il flag
    // se il flag è true, sovrascrive il file
    private static onlyAlreadyExisting(num, dstDir, dstName, fileDstTxt) {
        if (esisteFile(dstDir, dstName)) {
            if (esisteFlag(dstDir, dstName)) {
                if (sovraScrivibile(dstDir, dstName)) {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è true ed il file è stato sovrascritto')
                    scrive(dstDir, dstName, fileDstTxt)
                } else {
                    print(num + ') ' + 'Nel file ' + dstName + ' il flag di controllo è falso ed il file non è stato modificato')
                }// fine del blocco if-else
            } else {
                print(num + ') ' + 'Nel file ' + dstName + ' non era presente il flag di controllo ed il file è stato sovrascritto')
                scrive(dstDir, dstName, fileDstTxt)
            }// fine del blocco if-else
        } else {
            print(num + ') ' + 'Il file ' + dstName + ' non esisteva e non è stato creato')
        }// fine del blocco if-else
    }

    private static String getHeader(type, tag) {
        String headerTxt = ''
        String headerName
        String headerBase
        File headerFile

        headerName = plugin + dir + prefix + type.fileName + suffix
        headerFile = new File(headerName)

        if (headerFile.exists()) {
            headerBase = headerFile.getText()
            headerBase?.eachLine {
                if (it) {
                    headerTxt += tag.ini + it + tag.end + '\n'
                }// fine del blocco if
            }

        } else {
            print('Errore - Non esiste il file: ' + headerName)
        }// fine del blocco if-else

        return headerTxt
    }

    // Testing if the file already exists
    private static boolean esisteFile(dstDir, dstName) {
        boolean esiste = false
        String dstPath = dstDir + dstName
        File file = new File(dstPath)

        if (file) {
            if (file.exists()) {
                esiste = true
            }// fine del blocco if
        }// fine del blocco if

        return esiste
    }

    // Cerca il tag
    // Ce ne possono essere più di uno
    // Quello significativo deve avere un = prima che la linea vada a capo
    // Il tag deve essere seguito da spazio o uguale (per evitare una parola più lunga che lo contenesse)
    private static boolean esisteFlag(dstDir, dstName) {
        boolean esiste = false
        String dstPath = dstDir + dstName
        def flag = flagOverwrite
        File dstFile = new File(dstPath)
        String testo = ''
        int posIni
        int posEnd
        String uguale = '='
        String spazio = ' '
        String endLine = '\n'
        String riga
        String next

        if (dstFile) {
            testo = dstFile.getText()
        }// fine del blocco if

        if (testo) {
            while (testo.contains(flag)) {
                posIni = testo.indexOf(flag)
                posEnd = testo.indexOf(endLine, posIni)
                if (posEnd > 0) {
                    riga = testo.subSequence(posIni, posEnd)
                    riga = riga.trim()
                    if (riga.contains(uguale)) {
                        next = testo.substring(posIni + flag.length(), posIni + flag.length() + 1)
                        if (next.equals(uguale) || next.equals(spazio)) {
                            esiste = true
                        }// fine del blocco if
                    }// fine del blocco if
                }// fine del blocco if
                testo = testo.substring(posIni + 1)
            }// fine del blocco while
        }// fine del blocco if

        return esiste
    }

    // Cerca il valore del tag
    // Il valore dopo l'uguale deve essere uguale a true
    private static boolean sovraScrivibile(dstDir, dstName) {
        boolean sovraScrivibile = false
        String dstPath = dstDir + dstName
        String flag = "flagOverwrite"
        String riga
        String car
        File dstFile = new File(dstPath)
        String testo = ''
        int posIni
        int posEnd
        String uguale = "="
        String spazio = " "
        String endLine = "\n"
        String next
        String valore
        int posIniValore

        if (dstFile) {
            testo = dstFile.getText()
        }// fine del blocco if

        if (testo) {
            while (testo.contains(flag)) {
                posIni = testo.indexOf(flag)
                posEnd = testo.indexOf(endLine, posIni)
                if (posEnd > 0) {
                    riga = testo.subSequence(posIni, posEnd)
                    riga = riga.trim()
                    if (riga.contains(uguale)) {
                        next = testo.substring(posIni + flag.length(), posIni + flag.length() + 1)
                        if (next.equals(uguale) || next.equals(spazio)) {
                            posIniValore = testo.indexOf(uguale, posIni + 1)
                            valore = testo.substring(posIniValore + 1, posEnd)
                            valore = getValore(valore)
                            if (valore.equals("true")) {
                                sovraScrivibile = true
                            }// fine del blocco if
                        }// fine del blocco if
                    }// fine del blocco if
                }// fine del blocco if
                testo = testo.substring(posIni + 1)
            }// fine del blocco while
        }// fine del blocco if

        return sovraScrivibile
    }


    private static String getValore(String valore) {
        ArrayList<String> lista = AlgosTag.getAllEnd()
        valore = valore.trim()

        lista?.each {
            if (valore.endsWith(it)) {
                valore = valore.substring(0, valore.length() - it.length())
                valore = valore.trim()
            }// fine del blocco if
        }
        valore = valore.trim()

        return valore
    }


    private static scrive(String directory, String fileName, String fileDstTxt) {
        String path = directory + fileName
        File dstFile = new File(path)
        boolean creato

        if (dstFile.exists()) {
            dstFile.write(fileDstTxt)
        } else {
            def ant = new AntBuilder()
            ant.mkdir(dir: directory)
            creato = new File(path).createNewFile()

            if (creato) {
                dstFile = new File(path)
                if (dstFile.exists()) {
                    dstFile.write(fileDstTxt)
                } else {
                    print('Errore - Non sono proprio riuscito a creare il file: ' + path)
                }// fine del blocco if-else
            } else {
                print('Errore - Non sono riuscito a creare il file: ' + path)
            }// fine del blocco if-else
        }// fine del blocco if-else
    }


    private static addFlag(String directory, String fileName, String headerTxt) {
        String path = directory + fileName
        File dstFile = new File(path)
        String text

        if (dstFile.exists()) {
            text = dstFile.getText()
            text = headerTxt + '\n' + text
            dstFile.write(text)
        } else {
            print('Errore - Non sono riuscito a creare il file: ' + path)
        }// fine del blocco if-else
    }

    // Stampa (di prova)
    static printAll() {
        printTypes()
        printTags()
        printSources()
        printDest()
    }

    // Stampa (di prova)
    static printSources() {
        print('---')
        print('Prova - Nomi dei file sorgenti')
        print('---')
        srcNames.each {
            print(it)
        }
        print('---')
        print('')
    }

    // Stampa (di prova)
    static printDest() {
        print('---')
        print('Prova - Nomi delle cartelle')
        print('---')
        srcDirs.each {
            print(it)
        }
        print('---')
        print('')
    }

    // Stampa (di prova)
    static printTypes() {
        print('---')
        print('Prova - Nome di tutti i tipi')
        print('---')
        types.each {
            print(it)
        }
        println('---')
        println('')
    }

    // Stampa (di prova)
    static printTags() {
        println('---')
        println('Prova - Nome di tutti i tag')
        println('---')
        tags.each {
            print(it)
        }
        print('---')
        print('')
    }


    private static print(String text) {
        String prefixPlugin = '[algosbase] '
        println(prefixPlugin + text)
    }


}

