package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 09:01
 * To change this template use File | Settings | File Templates.
 */
class LibArrayTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }


    protected void tearDown() {
        super.tearDown()
    }

    // Estrae i valori unici da un array con (eventuali) valori doppi
    // Ordina l'array
    // @param valoriDoppi
    // @return valoriUnici ordinati
    void testValoriUnici() {
        ArrayList valoriDoppi = new ArrayList()
        valoriDoppi.add('abc')
        valoriDoppi.add('abc')
        valoriDoppi.add('abc')
        valoriDoppi.add('def')
        valoriDoppi.add('def')
        valoriDoppi.add('ghi')
        def ottenuto

        ottenuto = Lib.Array.valoriUnici(valoriDoppi);
        assert ottenuto in ArrayList
        assert ottenuto.size() == 3
        assert ottenuto[0] == 'abc'
        assert ottenuto[1] == 'def'
        assert ottenuto[2] == 'ghi'
    } // fine del test

    /**
     * Somma due array (liste)
     *
     * Almeno uno dei due array in ingresso deve essere non nullo
     * I valori negli array sono unici
     * Normalmente si usa di meno la somma disordinata
     *
     * Se entrambi i parametri sono liste della stessa classe, restituisce la somma
     * Se entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
     * Se entrambi i parametri sono nulli, restituisce un nullo
     * Se uno dei parametri è nullo e l'altro è una lista, restituisce la lista
     * Se uno dei parametri è nullo e l'altro non è una lista, restituisce un nullo
     * Se uno dei parametri è una lista, l'altro non è una lista ma è della stessa classe, restituisce la somma
     * Se uno dei parametri è una lista, l'altro non è una lista ma non è della stessa classe, restituisce un nullo
     *
     * @param arrayPrimo
     * @param arraySecondo
     * @return arraySomma disordinato
     */

    void testSommaDisordinata() {
        def primoNum = [7, 87, 4, 25, 1, 12]
        def secondoNum = [11, 7, 55, 4]
        def primoStr = ['due', 'otto', 'alfa']
        def secondoStr = ['otto', 'gamma', 'due']
        int num = 999
        String stringa = 'ultima'
        def ottenuto
        int numRichiesto = 8
        int strRichiesto = 4
        int primoRichiesto = 7

        // entrambi i parametri sono nulli, restituisce un nullo
        ottenuto = Lib.Array.sommaDisordinata(null, null)
        assert ottenuto == null

        // uno dei parametri è nullo e l'altro è una lista, restituisce la lista
        ottenuto = Lib.Array.sommaDisordinata(primoNum, null)
        assert ottenuto in List
        assert ottenuto == primoNum

        // uno dei parametri è nullo e l'altro è una lista, restituisce la lista
        ottenuto = Lib.Array.sommaDisordinata(null, secondoNum)
        assert ottenuto in List
        assert ottenuto == secondoNum

        // entrambi i parametri sono liste della stessa classe, restituisce la somma
        ottenuto = Lib.Array.sommaDisordinata(primoNum, secondoNum)
        assert ottenuto in List
        assert ottenuto.size() == numRichiesto

        // entrambi i parametri sono liste della stessa classe, restituisce la somma
        ottenuto = Lib.Array.sommaDisordinata(primoStr, secondoStr)
        assert ottenuto in List
        assert ottenuto.size() == strRichiesto

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.sommaDisordinata(primoNum, secondoStr)
        assert ottenuto == null

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.sommaDisordinata(primoStr, secondoNum)
        assert ottenuto == null

        // uno dei parametri è una lista, l'altro non è una lista ma è della stessa classe, restituisce la somma
        ottenuto = Lib.Array.sommaDisordinata(primoNum, num)
        assert ottenuto in List
        assert ottenuto.size() == primoRichiesto

        // uno dei parametri è una lista, l'altro non è una lista ma è della stessa classe, restituisce la somma
        ottenuto = Lib.Array.sommaDisordinata(primoStr, stringa)
        assert ottenuto in List
        assert ottenuto.size() == strRichiesto

        // uno dei parametri è una lista, l'altro non è una lista ma non è della stessa classe, restituisce un nullo
        ottenuto = Lib.Array.sommaDisordinata(primoNum, stringa)
        assert ottenuto == null

        // uno dei parametri è una lista, l'altro non è una lista ma non è della stessa classe, restituisce un nullo
        ottenuto = Lib.Array.sommaDisordinata(primoStr, num)
        assert ottenuto == null
    }// fine tests

    /**
     * Somma due array (liste) e restituisce una lista ordinata
     *
     * Almeno uno dei due array in ingresso deve essere non nullo
     * I valori negli array sono unici
     * Normalmente si usa di più la somma ordinata
     *
     * Se entrambi i parametri sono liste della stessa classe, restituisce la somma ordinata
     * Se entrambi i parametri sono liste ma di classe diversas, restituisce un nullo
     * Se entrambi i parametri sono nulli, restituisce un nullo
     * Se uno dei parametri è nullo e l'altro è una lista, restituisce la lista ordinata
     * Se uno dei parametri è nullo e l'altro non è una lista, restituisce un nullo
     * Se uno dei parametri è una lista, l'altro non è una lista ma è della stessa classe, restituisce la somma ordinata
     * Se uno dei parametri è una lista, l'altro non è una lista ma non è della stessa classe, restituisce un nullo
     *
     * @param arrayPrimo
     * @param arraySecondo
     * @return arraySomma ordinato
     */

    void testSomma() {
        def primoNum = [7, 87, 4, 25, 1, 12]
        def primoNumOrd = [1, 4, 7, 12, 25, 87]
        def secondoNum = [11, 7, 55, 4]
        def secondoNumOrd = [4, 7, 11, 55]
        def richiestoNum = [1, 4, 7, 11, 12, 25, 55, 87]
        def primoStr = ['due', 'otto', 'alfa']
        def secondoStr = ['otto', 'gamma', 'due']
        def richiestoStr = ['alfa', 'due', 'gamma', 'otto']
        int num = 999
        def richiestoPrimoPiuNum = [1, 4, 7, 12, 25, 87, 999]
        String stringa = 'beta'
        def richiestoPrimoPiuStr = ['alfa', 'beta', 'due', 'otto']
        def ottenuto

        // entrambi i parametri sono nulli, restituisce un nullo
        ottenuto = Lib.Array.somma(null, null)
        assert ottenuto == null

        // uno dei parametri è nullo e l'altro è una lista, restituisce la lista ordinata
        ottenuto = Lib.Array.somma(primoNum, null)
        assert ottenuto in List
        assert ottenuto == primoNumOrd

        // uno dei parametri è nullo e l'altro è una lista, restituisce la lista ordinata
        ottenuto = Lib.Array.somma(null, secondoNum)
        assert ottenuto in List
        assert ottenuto == secondoNumOrd

        // entrambi i parametri sono liste della stessa classe, restituisce la somma ordinata
        ottenuto = Lib.Array.somma(primoNum, secondoNum)
        assert ottenuto in List
        assert ottenuto == richiestoNum

        // entrambi i parametri sono liste della stessa classe, restituisce la somma ordinata
        ottenuto = Lib.Array.somma(primoStr, secondoStr)
        assert ottenuto in List
        assert ottenuto == richiestoStr

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.somma(primoNum, secondoStr)
        assert ottenuto == null

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.somma(primoStr, secondoNum)
        assert ottenuto == null

        // uno dei parametri è una lista, l'altro non è una lista ma è della stessa classe, restituisce la somma ordinata
        ottenuto = Lib.Array.somma(primoNum, num)
        assert ottenuto in List
        assert ottenuto == richiestoPrimoPiuNum

        // uno dei parametri è una lista, l'altro non è una lista ma è della stessa classe, restituisce la somma ordinata
        ottenuto = Lib.Array.somma(primoStr, stringa)
        assert ottenuto in List
        assert ottenuto == richiestoPrimoPiuStr

        // uno dei parametri è una lista, l'altro non è una lista ma non è della stessa classe, restituisce un nullo
        ottenuto = Lib.Array.somma(primoNum, stringa)
        assert ottenuto == null

        // uno dei parametri è una lista, l'altro non è una lista ma non è della stessa classe, restituisce un nullo
        ottenuto = Lib.Array.somma(primoStr, num)
        assert ottenuto == null
    }// fine tests

    /**
     * Differenza tra due array (liste) e restituisce una lista
     *
     * Il primo array in ingresso deve essere non nullo e deve essere una lista
     * I valori negli array sono unici
     * Normalmente si usa di meno la differenza disordinata
     *
     * Se entrambi i parametri sono liste della stessa classe, restituisce la differenza
     * Se entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
     * Se il primo parametro è nullo, restituisce un nullo
     * Se il primo parametro non è una lista, restituisce un nullo
     * Se entrambi i parametri sono nulli, restituisce un nullo
     * Se il secondo parametro è nullo, oppure una lista vuota (zero elementi), restituisce il primo array
     * Se il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza
     * Se il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
     *
     * @param arrayPrimo
     * @param arraySecondo
     * @return arrayDifferenza disordinata
     */

    void testDifferenzaDisordinata() {
        def primoNum = [7, 87, 4, 25, 1, 12]
        def secondoNum = [11, 7, 55, 4]
        def richiestoNum = [87, 25, 1, 12]
        def arrayVuoto = []
        def primoStr = ['due', 'otto', 'beta', 'alfa', 'omicron']
        def secondoStr = ['otto', 'gamma', 'due']
        def richiestoStr = ['beta', 'alfa', 'omicron']
        int num = 4
        def richiestoPrimoMenoNum = [7, 87, 25, 1, 12]
        String stringa = 'beta'
        def richiestoPrimoMenoStr = ['due', 'otto', 'alfa', 'omicron']
        def ottenuto

        // entrambi i parametri sono nulli, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(null, null)
        assert ottenuto == null

        // il primo parametro è nullo, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(null, secondoNum)
        assert ottenuto == null

        // il primo parametro non è una lista, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(num, secondoNum)
        assert ottenuto == null

        // il primo parametro non è una lista, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(stringa, secondoStr)
        assert ottenuto == null

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(primoNum, secondoStr)
        assert ottenuto == null

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(primoStr, secondoNum)
        assert ottenuto == null

        // entrambi i parametri sono liste della stessa classe, restituisce la differenza
        ottenuto = Lib.Array.differenzaDisordinata(primoNum, secondoNum)
        assert ottenuto in List
        assert ottenuto == richiestoNum

        // entrambi i parametri sono liste della stessa classe, restituisce la differenza
        ottenuto = Lib.Array.differenzaDisordinata(primoStr, secondoStr)
        assert ottenuto in List
        assert ottenuto == richiestoStr

        // il secondo parametro è nullo, restituisce la differenza,restituisce il primo array
        ottenuto = Lib.Array.differenzaDisordinata(primoNum, null)
        assert ottenuto in List
        assert ottenuto == primoNum

        // il secondo parametro è una lista vuota (zero elementi), restituisce il primo array
        ottenuto = Lib.Array.differenzaDisordinata(primoNum, arrayVuoto)
        assert ottenuto in List
        assert ottenuto == primoNum

        // il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza
        ottenuto = Lib.Array.differenzaDisordinata(primoNum, num)
        assert ottenuto in List
        assert ottenuto == richiestoPrimoMenoNum

        // il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza
        ottenuto = Lib.Array.differenzaDisordinata(primoStr, stringa)
        assert ottenuto in List
        assert ottenuto == richiestoPrimoMenoStr

        // il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(primoNum, stringa)
        assert ottenuto == null

        // il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
        ottenuto = Lib.Array.differenzaDisordinata(primoStr, num)
        assert ottenuto == null
    }// fine tests

    /**
     * Differenza tra due array (liste) e restituisce una lista ordinata
     *
     * Il primo array in ingresso deve essere non nullo e deve essere una lista
     * I valori negli array sono unici
     * Normalmente si usa di più la differenza ordinata
     *
     * Se entrambi i parametri sono liste della stessa classe, restituisce la differenza ordinata
     * Se entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
     * Se il primo parametro è nullo, restituisce un nullo
     * Se il primo parametro non è una lista, restituisce un nullo
     * Se entrambi i parametri sono nulli, restituisce un nullo
     * Se il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza ordinata
     * Se il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
     *
     * @param arrayPrimo
     * @param arraySecondo
     * @return arrayDifferenza ordinata
     */

    void testDifferenza() {
        def primoNum = [7, 87, 4, 25, 1, 12]
        def secondoNum = [11, 7, 55, 4]
        def richiestoNum = [1, 12, 25, 87]
        def primoStr = ['due', 'otto', 'beta', 'alfa', 'omicron']
        def secondoStr = ['otto', 'gamma', 'due']
        def richiestoStr = ['alfa', 'beta', 'omicron']
        int num = 4
        def richiestoPrimoMenoNum = [1, 7, 12, 25, 87]
        String stringa = 'beta'
        def richiestoPrimoMenoStr = ['alfa', 'due', 'omicron', 'otto']
        def ottenuto

        // entrambi i parametri sono nulli, restituisce un nullo
        ottenuto = Lib.Array.differenza(null, null)
        assert ottenuto == null

        // il primo parametro è nullo, restituisce un nullo
        ottenuto = Lib.Array.differenza(null, secondoNum)
        assert ottenuto == null

        // il primo parametro non è una lista, restituisce un nullo
        ottenuto = Lib.Array.differenza(num, secondoNum)
        assert ottenuto == null

        // il primo parametro non è una lista, restituisce un nullo
        ottenuto = Lib.Array.differenza(stringa, secondoStr)
        assert ottenuto == null

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.differenza(primoNum, secondoStr)
        assert ottenuto == null

        // entrambi i parametri sono liste ma di classe diversa, restituisce un nullo
        ottenuto = Lib.Array.differenza(primoStr, secondoNum)
        assert ottenuto == null

        // entrambi i parametri sono liste della stessa classe, restituisce la differenza
        ottenuto = Lib.Array.differenza(primoNum, secondoNum)
        assert ottenuto in List
        assert ottenuto == richiestoNum

        // entrambi i parametri sono liste della stessa classe, restituisce la differenza
        ottenuto = Lib.Array.differenza(primoStr, secondoStr)
        assert ottenuto in List
        assert ottenuto == richiestoStr

        // il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza
        ottenuto = Lib.Array.differenza(primoNum, num)
        assert ottenuto in List
        assert ottenuto == richiestoPrimoMenoNum

        // il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza
        ottenuto = Lib.Array.differenza(primoStr, stringa)
        assert ottenuto in List
        assert ottenuto == richiestoPrimoMenoStr

        // il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
        ottenuto = Lib.Array.differenza(primoNum, stringa)
        assert ottenuto == null

        // il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
        ottenuto = Lib.Array.differenza(primoStr, num)
        assert ottenuto == null
    }// fine tests


    void testUnivoco() {
        def listaNum = [7, 87, 4, 25, 1, 12]
        def listaStr = ['due', 'otto', 'beta', 'alfa', 'omicron']
        def richiestoNum = [7, 87, 4, 25, 1, 12, 17]
        def richiestoStr = ['due', 'otto', 'beta', 'alfa', 'omicron', 'gamma']
        int numOld = 4
        int numNew = 17
        String strOld = 'beta'
        String strNew = 'gamma'

        if (!listaNum.contains(numOld)) {
            listaNum.add(numOld)
        }// fine del blocco if
        assert listaNum.size() == 6
        assert listaNum == listaNum

        if (!listaNum.contains(numNew)) {
            listaNum.add(numNew)
        }// fine del blocco if
        assert listaNum.size() == 7
        assert listaNum == richiestoNum

        if (!listaStr.contains(strOld)) {
            listaStr.add(strOld)
        }// fine del blocco if
        assert listaStr.size() == 5
        assert listaStr == listaStr

        if (!listaStr.contains(strNew)) {
            listaStr.add(strNew)
        }// fine del blocco if
        assert listaStr.size() == 6
        assert listaStr == richiestoStr
    }// fine tests

    /**
     * Aggiunge un elemento alla lista solo se non già esistente
     *
     * @param array
     * @param elemento
     * @return vero se l'elemento è stato aggiunto
     */

    void testAdd() {
        def listaNum = [7, 87, 4, 25, 1, 12]
        def listaStr = ['due', 'otto', 'beta', 'alfa', 'omicron']
        def richiestoNum = [7, 87, 4, 25, 1, 12, 17]
        def richiestoStr = ['due', 'otto', 'beta', 'alfa', 'omicron', 'gamma']
        int numOld = 4
        int numNew = 17
        String strOld = 'beta'
        String strNew = 'gamma'
        boolean aggiunto

        aggiunto = Lib.Array.add(listaNum, numOld)
        assert !aggiunto
        assert listaNum.size() == 6
        assert listaNum == listaNum

        aggiunto = Lib.Array.add(listaNum, numNew)
        assert aggiunto
        assert listaNum.size() == 7
        assert listaNum == richiestoNum

        aggiunto = Lib.Array.add(listaStr, strOld)
        assert !aggiunto
        assert listaStr.size() == 5
        assert listaStr == listaStr

        aggiunto = Lib.Array.add(listaStr, strNew)
        assert aggiunto
        assert listaStr.size() == 6
        assert listaStr == richiestoStr
    }// fine tests

    /**
     * Ordina una mappa secondo le chiavi
     *
     * Una HashMap è -automaticamente- ordinata secondo le proprie chiavi
     * Viceversa una LinkedHashMap ha un -proprio ordine interno- fissato alla creazione
     *
     * @param mappaIn ingresso da ordinare
     *
     * @return mappa ordinata
     */

    void testOrdina() {
        HashMap mappa = new HashMap()
        LinkedHashMap mappaOrdinata = new LinkedHashMap()
        LinkedHashMap ottenuta
        Set insieme
        List lista
        String strUno = 'alfa'
        String strDue = 'beta'
        String strTre = 'delta'

        // mappa semplice non ordinata in creazione e che si ordina secondo le chiavi
        mappa.put(strTre, null)
        mappa.put(strDue, null)
        mappa.put(strUno, null)

        ottenuta = Lib.Array.ordinaMappa(mappa)
        assert ottenuta.size() == 3
        insieme = ottenuta.keySet()
        lista = insieme.asList()
        assert lista.get(1) == strDue

        // mappa  ordinata
        mappaOrdinata.put(strTre, null)
        mappaOrdinata.put(strDue, null)
        mappaOrdinata.put(strUno, null)

        ottenuta = Lib.Array.ordinaMappa(mappa)
        assert ottenuta.size() == 3
        insieme = ottenuta.keySet()
        lista = insieme.asList()
        assert lista.get(1) == strDue

    }// fine tests

    /**
     * Utility di conversione di una stringa.
     *
     * Crea una lista da un testo usando una stringa come separatore
     * Di solito la stringa è sempre di 1 carattere
     * Elementi nulli o vuoti non vengono aggiunti alla lista
     * Vengono eliminati gli spazi vuoti iniziali e finali
     * Se il separatore è vuoto o nullo, restituisce una lista di un elemento uguale al testo
     * ricevuto
     *
     * @param testo da suddividere
     * @param sep carattere stringa di separazione
     *
     * @return una lista contenente le parti di stringa separate
     */

    void testCreaLista() {
        ArrayList<String> lista
        String sep = ','
        String sepNullo = ''
        String strUno = ' alfa,beta,delta '
        String strDue = 'alfa,beta,delta'
        String strTre = 'alfa , beta , delta'
        String strQuattro = 'alfa;beta,delta'
        String strCinque = 'alfa,,delta'

        // lista normale
        lista = Lib.Array.creaLista(strUno, sep)
        assert lista.size() == 3
        assert lista.get(1) == 'beta'

        lista = Lib.Array.creaLista(strDue, sep)
        assert lista.size() == 3
        assert lista.get(1) == 'beta'

        lista = Lib.Array.creaLista(strTre, sep)
        assert lista.size() == 3
        assert lista.get(1) == 'beta'

        // lista ridotta
        lista = Lib.Array.creaLista(strQuattro, sep)
        assert lista.size() == 2
        assert lista.get(1) == 'delta'

        lista = Lib.Array.creaLista(strCinque, sep)
        assert lista.size() == 2
        assert lista.get(1) == 'delta'

        lista = Lib.Array.creaLista(strDue, sepNullo)
        assert lista.size() == 1
        assert lista.get(0) == strDue


    }// fine tests

    /**
     * Utility di conversione di una stringa.
     *
     * Crea una lista da un testo usando una stringa come separatore
     * Di solito la stringa è sempre di 1 carattere
     * Elementi nulli o vuoti non vengono aggiunti alla lista
     * Vengono eliminati gli spazi vuoti iniziali e finali
     * Se il separatore è vuoto o nullo, restituisce una lista di un elemento uguale al testo
     * ricevuto
     *
     * @param testo da suddividere
     * @param sep carattere stringa di separazione
     *
     * @return una lista contenente le parti di stringa separate
     */

    void testCreaLista2() {
        ArrayList<String> lista
        String strUno = ' alfa,beta,delta '
        String strDue = 'alfa,beta,delta'
        String strTre = 'alfa , beta , delta'
        String strQuattro = 'alfa;beta,delta'
        String strCinque = 'alfa,,delta'

        // lista normale
        lista = Lib.Array.creaLista(strUno)
        assert lista.size() == 3
        assert lista.get(1) == 'beta'

        lista = Lib.Array.creaLista(strDue)
        assert lista.size() == 3
        assert lista.get(1) == 'beta'

        lista = Lib.Array.creaLista(strTre)
        assert lista.size() == 3
        assert lista.get(1) == 'beta'

        // lista ridotta
        lista = Lib.Array.creaLista(strQuattro)
        assert lista.size() == 2
        assert lista.get(1) == 'delta'

        lista = Lib.Array.creaLista(strCinque)
        assert lista.size() == 2
        assert lista.get(1) == 'delta'
    }// fine tests

    /**
     * Converte un array di stringhe in una lista di stringhe.
     * <p/>
     * Esegue solo se l'array non è nullo <br>
     *
     * @param array da convertire
     *
     * @return lista di stringhe contenente gli elementi dell'array
     */

    void testCreaLista3() {
        String[] array = new String[3]
        ArrayList<String> lista
        array[0] = 'alfa'
        array[1] = 'beta'
        array[2] = 'delta'

        lista = Lib.Array.creaLista(array)
        assert lista.size() == 3
        assert lista.get(1) == array[1]
    }// fine tests

    // Estrae le righe da un testo
    // Esegue solo se il testo è valido
    // Se arriva un oggetto non stringa, restituisce null
    //
    // @param testo in ingresso
    // @return array di righe
    void testRighe() {
        String testo = 'primaRiga\nSeconda\nTerza'
        def ottenuto

        ottenuto = Lib.Array.getRigheTrim(testo)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 3
        assert ottenuto[0] == 'primaRiga'
        assert ottenuto[1] == 'Seconda'
        assert ottenuto[2] == 'Terza'
    }// fine tests

    void testRighe2() {
        String testo = '\tprimaRiga\t\n\t\tSeconda\nTerza'
        def ottenuto

        ottenuto = Lib.Array.getRigheTrim(testo)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 3
        assert ottenuto[0] == 'primaRiga'
        assert ottenuto[1] == 'Seconda'
        assert ottenuto[2] == 'Terza'
    }// fine tests


    void testRighe3() {
        String testo = '\tprimaRiga\t\n\t\tSeconda\tTerza'
        def ottenuto

        ottenuto = Lib.Array.getRigheTrim(testo)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 2
        assert ottenuto[0] == 'primaRiga'
        assert ottenuto[1] == 'Seconda\tTerza'
    }// fine tests

    void testParole() {
        String testo = 'this is a test'
        def ottenuto

        ottenuto = Lib.Array.getWords(testo)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 4
        assert ottenuto[0] == 'this'
        assert ottenuto[1] == 'is'
        assert ottenuto[2] == 'a'
        assert ottenuto[3] == 'test'
    }// fine tests



    void testBlocchi() {
        String testo = 'this is a test'
        def ottenuto

        ottenuto = Lib.Array.getBlocchi(testo,' ')
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 4
        assert ottenuto[0] == 'this'
        assert ottenuto[1] == 'is'
        assert ottenuto[2] == 'a'
        assert ottenuto[3] == 'test'
    }// fine tests


    void testBlocchi2() {
        String testo = 'primaRiga\nSeconda\nTerza'
        def ottenuto

        ottenuto = Lib.Array.getBlocchi(testo,'\n')
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 3
        assert ottenuto[0] == 'primaRiga'
        assert ottenuto[1] == 'Seconda'
        assert ottenuto[2] == 'Terza'
    }// fine tests


}// fine della classe di test
