package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 08:50
 * To change this template use File | Settings | File Templates.
 */
class LibTestoTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }


    protected void tearDown() {
        super.tearDown()
    }

    /**
     * Forza il primo carattere della stringa a maiuscolo
     * Restituisce una stringa
     * Un numero ritorna un numero
     * Un nullo ritorna un nullo
     * Un oggetto non stringa ritorna uguale
     */

    void testPrimaMaiuscola() {
        String minuscola = 'tuttominuscolo'
        String maiuscola = 'Tuttominuscolo'
        String richiesto = 'Tuttominuscolo'
        int numero = 125789
        def ottenuto
        String misto = '4prova'
        ArrayList lista = new ArrayList()

        ottenuto = Lib.Txt.primaMaiuscola(minuscola)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.primaMaiuscola(maiuscola)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.primaMaiuscola(numero)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Txt.primaMaiuscola(null)
        assert ottenuto == null

        ottenuto = Lib.Txt.primaMaiuscola(misto)
        assert ottenuto in String
        assert ottenuto == misto

        ottenuto = Lib.Txt.primaMinuscola(lista)
        assert ottenuto in List
        assert ottenuto == lista
    }// fine tests

    /**
     * Forza il primo carattere della stringa a minuscolo
     * Restituisce una stringa
     * Un numero ritorna un numero
     * Un nullo ritorna un nullo
     * Un oggetto non stringa ritorna uguale
     */

    void testPrimaMinuscola() {
        String minuscola = 'tuttoMinuscolo'
        String maiuscola = 'TuttoMinuscolo'
        String richiesto = 'tuttoMinuscolo'
        int numero = 125789
        def ottenuto
        def misto = '4prova'
        ArrayList lista = new ArrayList()

        ottenuto = Lib.Txt.primaMinuscola(minuscola)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.primaMinuscola(maiuscola)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.primaMinuscola(numero)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Txt.primaMinuscola(null)
        assert ottenuto == null

        ottenuto = Lib.Txt.primaMinuscola(misto)
        assert ottenuto in String
        assert ottenuto == misto

        ottenuto = Lib.Txt.primaMinuscola(lista)
        assert ottenuto in List
        assert ottenuto == lista
    }// fine tests

    /**
     * Elimina la testa iniziale della stringa, se esiste.
     * <p/>
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca la testa, restituisce la stringa
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @param testa da eliminare
     *
     * @return uscita stringa convertita
     */

    void testLevaTesta() {
        String testoUno = 'SeptuttoMinuscolo'
        String testoDue = 'Sep tuttoMinuscolo '
        String testoTre = 'Sep Sep tuttoMinuscolo Sep '
        String testoQuattro = 'tuttoSepMinuscolo'
        String richiesto = 'tuttoMinuscolo'
        String richiestoTre = 'Sep tuttoMinuscolo Sep'
        String testa = 'Sep'
        def ottenuto
        int numero = 785

        ottenuto = Lib.Txt.levaTesta(testoUno, testa)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaTesta(testoDue, testa)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaTesta(testoTre, testa)
        assert ottenuto in String
        assert ottenuto == richiestoTre

        ottenuto = Lib.Txt.levaTesta(testoUno, null)
        assert ottenuto in String
        assert ottenuto == testoUno

        ottenuto = Lib.Txt.levaTesta(null, null)
        assert ottenuto == null

        ottenuto = Lib.Txt.levaTesta(numero, null)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Txt.levaTesta(numero, testa)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Txt.levaTesta(testoQuattro, testa)
        assert ottenuto in String
        assert ottenuto == testoQuattro

        ottenuto = Lib.Txt.levaTesta(testoUno, numero)
        assert ottenuto in String
        assert ottenuto == testoUno
    }// fine tests

    /**
     * Elimina la coda terminale della stringa, se esiste.
     * <p/>
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca la coda, restituisce la stringa
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     * @param stringaIn testo in ingresso
     * @param coda da eliminare
     *
     * @return stringa convertita
     */

    void testLevaCoda() {
        String testoUno = 'tuttoMinuscoloSep'
        String testoDue = 'tuttoMinuscolo Sep'
        String testoTre = 'tuttoMinuscolo Sep '
        String testoQuattro = 'tuttoSepMinuscolo'
        String richiesto = 'tuttoMinuscolo'
        String richiestoQuattro = 'tuttoSepMinuscolo'
        String coda = 'Sep'
        def ottenuto
        int numero = 785

        ottenuto = Lib.Txt.levaCoda(testoUno, coda)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaCoda(testoDue, coda)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaCoda(testoTre, coda)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaCoda(testoUno, null)
        assert ottenuto in String
        assert ottenuto == testoUno

        ottenuto = Lib.Txt.levaCoda(null, null)
        assert ottenuto == null

        ottenuto = Lib.Txt.levaCoda(numero, null)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Txt.levaCoda(numero, coda)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Txt.levaCoda(testoQuattro, coda)
        assert ottenuto in String
        assert ottenuto == richiestoQuattro

        ottenuto = Lib.Txt.levaCoda(testoUno, numero)
        assert ottenuto in String
        assert ottenuto == testoUno
    }// fine tests

    void testLevaCoda2() {
        String testo = 'lun, mar, mer, gio, ven, sab, dom, '
        String richiesto = 'lun, mar, mer, gio, ven, sab, dom'
        String codaA = ', '
        String codaB = ', '
        String ottenuto

        ottenuto = Lib.Txt.levaCoda(testo, codaA)
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaCoda(testo, codaB)
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Sostituisce tutte le occorrenze.
     * <p/>
     * Esegue solo se il testo è valido
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param testoIn in ingresso
     * @param oldStringa da eliminare
     * @param newStringa da sostituire
     * @return testoOut convertito
     */

    void testSostituisce() {
        String testo
        String oldStringa
        String newStringa
        String richiesto
        String ottenuto

        testo = 'marioxlino vede sxempre lui'
        oldStringa = 'x'
        newStringa = ''
        richiesto = 'mariolino vede sempre lui'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'marioxlino vede sxempre lui'
        oldStringa = 'vede'
        newStringa = 'guarda'
        richiesto = 'marioxlino guarda sxempre lui'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = '125.785,00'
        oldStringa = '.'
        newStringa = ''
        richiesto = '125785,00'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = '123,456,789'
        oldStringa = ','
        newStringa = '.'
        richiesto = '123.456.789'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = '123.456.789'
        oldStringa = '.'
        newStringa = ','
        richiesto = '123,456,789'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmarioxlino vede sxempre lui'
        oldStringa = 'x'
        newStringa = ''
        richiesto = 'mariolino vede sempre lui'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmarioxlino vede sxempre luix'
        oldStringa = 'x'
        newStringa = ''
        richiesto = 'mariolino vede sempre lui'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario$lino vede s$empre lui$'
        oldStringa = '$'
        newStringa = 'y'
        richiesto = 'xmarioylino vede syempre luiy'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario\nlino vede s\nempre lui\n'
        oldStringa = '\n'
        newStringa = '<br>'
        richiesto = 'xmario<br>lino vede s<br>empre lui<br>'
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario{{lino vede s{{empre lui{{'
        oldStringa = '{{'
        newStringa = '[['
        richiesto = 'xmario[[lino vede s[[empre lui[['
        ottenuto = Lib.Txt.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Elimina tutti i caratteri contenuti nella stringa.
     * <p/>
     * Esegue solo se il testo è valido
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param testoIn in ingresso
     * @param subStringa da eliminare
     * @return testoOut stringa convertita
     */

    void testLevaTesto() {
        String testo = 'Prova di scrittura per levare dei caratteri'
        String uno = 'levare'
        String richiestoUno = 'Prova di scrittura per  dei caratteri'
        String due = 'caratteri'
        String richiestoDue = 'Prova di scrittura per levare dei '
        String ottenuto

        ottenuto = Lib.Txt.levaTesto(testo, uno)
        assert ottenuto in String
        assert ottenuto == richiestoUno

        ottenuto = Lib.Txt.levaTesto(testo, due)
        assert ottenuto in String
        assert ottenuto == richiestoDue
    }// fine tests

    /**
     * Elimina tutti i punti contenuti nella stringa.
     * <p/>
     * Esegue solo se la stringa è valida
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @return uscita stringa convertita
     */

    void testLevaPunti() {
        def numeroUno = '123g456'
        def numeroDue = '123.456'
        def numeroTre = '123456'
        def numeroQuattro = '123456.0'
        def numeroCinque = '123,456'
        def lista = ['uno', 'due']
        def richiesto = '123456'
        def richiestoDue = '1234560'
        def ottenuto

        ottenuto = Lib.Txt.levaPunti(numeroUno)
        assert ottenuto in String
        assert ottenuto == numeroUno

        ottenuto = Lib.Txt.levaPunti(null)
        assert ottenuto == null

        ottenuto = Lib.Txt.levaPunti(lista)
        assert ottenuto in List
        assert ottenuto == lista

        ottenuto = Lib.Txt.levaPunti(numeroDue)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaPunti(numeroTre)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaPunti(numeroQuattro)
        assert ottenuto in String
        assert ottenuto == richiestoDue

        ottenuto = Lib.Txt.levaPunti(numeroCinque)
        assert ottenuto in String
        assert ottenuto == numeroCinque
    }// fine tests

    /**
     * Elimina tutte le virgole contenute nella stringa.
     * <p/>
     * Esegue solo se la stringa è valida
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @return uscita stringa convertita
     */

    void testLevaVirgola() {
        def numeroUno = '123g456'
        def numeroDue = '123,456'
        def numeroTre = '123456'
        def numeroQuattro = '123456,0'
        def numeroCinque = '123.456'
        def lista = ['uno', 'due']
        def richiesto = '123456'
        def richiestoDue = '1234560'
        def ottenuto

        ottenuto = Lib.Txt.levaVirgole(numeroUno)
        assert ottenuto in String
        assert ottenuto == numeroUno

        ottenuto = Lib.Txt.levaVirgole(null)
        assert ottenuto == null

        ottenuto = Lib.Txt.levaVirgole(lista)
        assert ottenuto in List
        assert ottenuto == lista

        ottenuto = Lib.Txt.levaVirgole(numeroDue)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaVirgole(numeroTre)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.levaVirgole(numeroQuattro)
        assert ottenuto in String
        assert ottenuto == richiestoDue

        ottenuto = Lib.Txt.levaVirgole(numeroCinque)
        assert ottenuto in String
        assert ottenuto == numeroCinque
    }// fine tests

    /**
     * Formattazione di un numero.
     * <p/>
     * Il numero può arrivare come stringa, intero o double
     * Se la stringa contiene punti e virgole, viene pulita
     * Se la stringa non è convertibile in numero, viene restituita uguale
     * Inserisce il punto separatore ogni 3 cifre
     * Se arriva un oggetto non previsto, restituisce l'oggetto

     * @param numero da formattare (stringa, intero o double)
     * @return numero formattato
     */

    void testFormatNum() {
        String numText
        def lista = ['uno', 'due']
        def richiesto
        def ottenuto

        numText = '123g456'
        richiesto = '123g456'
        ottenuto = Lib.Txt.formatNum(numText)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Txt.formatNum(null)
        assert ottenuto == null

        ottenuto = Lib.Txt.formatNum(lista)
        assert ottenuto in List
        assert ottenuto == lista

        numText = '123,456'
        richiesto = '123.456'
        ottenuto = Lib.Txt.formatNum(numText)
        assert ottenuto in String
        assert ottenuto == richiesto

        numText = '123456'
        richiesto = '123.456'
        ottenuto = Lib.Txt.formatNum(numText)
        assert ottenuto in String
        assert ottenuto == richiesto

        numText = '123456,0'
        richiesto = '1.234.560'
        ottenuto = Lib.Txt.formatNum(numText)
        assert ottenuto in String
        assert ottenuto == richiesto

        numText = '123456789'
        richiesto = '123.456.789'
        ottenuto = Lib.Txt.formatNum(numText)
        assert ottenuto in String
        assert ottenuto == richiesto

        numText = '1234567890'
        richiesto = '1.234.567.890'
        ottenuto = Lib.Txt.formatNum(numText)
        assert ottenuto in String
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Formattazione di un numero.
     * <p/>
     * Il numero può arrivare come stringa, intero o double
     * Se la stringa contiene punti e virgole, viene pulita
     * Se la stringa non è convertibile in numero, viene restituita uguale
     * Inserisce il punto separatore ogni 3 cifre
     * Se arriva un oggetto non previsto, restituisce l'oggetto

     * @param numero da formattare (stringa, intero o double)
     * @return numero formattato
     */

    void testFormatNum2() {
        int num
        def numero
        def richiesto
        def ottenuto

        num = 123456
        richiesto = '123.456'
        ottenuto = Lib.Txt.formatNum(num)
        assert ottenuto in String
        assert ottenuto == richiesto

        numero = 123456789
        richiesto = '123.456.789'
        ottenuto = Lib.Txt.formatNum(numero)
        assert ottenuto in String
        assert ottenuto == richiesto

        numero = 1234567890
        richiesto = '1.234.567.890'
        ottenuto = Lib.Txt.formatNum(numero)
        assert ottenuto in String
        assert ottenuto == richiesto

        numero = 123456.0
        richiesto = '1.234.560'
        ottenuto = Lib.Txt.formatNum(numero)
        assert ottenuto in String
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Restituisce la posizione di un tag in un testo
     * Riceve una lista di tag da provare
     * Restituisce la prima posizione tra tutti i tag trovati
     *
     * @param testo in ingresso
     * @param lista di stringhe/interi, oppure singola stringa/intero
     *
     * @return posizione della prima stringa trovata
     *         -1 se non ne ha trovato nessuna
     *         -1 se il primo parametro è nullo o vuoto, oppure non è una stringa
     *         -1 se il secondo parametro è nullo
     *         -1 se il secondo parametro non è ne una lista di stringhe/interi, ne una stringa/intero
     */

    void testGetPos() {
        String testoUno = 'In questo 14 testo uno volte scrivo la parola due e tre pertanto la trovo'
        String testoDue = 'In questo tre testo tre volte scrivo la parola due e uno pertanto la trovo'
        String strUno = 'uno'
        int numUno = 14
        def lista = [strUno, 'due', 'tre']
        int num = 999
        int richiestoUno = 19
        int richiestoDue = 10
        int ottenuto

        ottenuto = Lib.Txt.getPos(null, lista)
        assert ottenuto in Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Txt.getPos('', lista)
        assert ottenuto in Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Txt.getPos(num, lista)
        assert ottenuto in Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Txt.getPos(testoUno, null)
        assert ottenuto in Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Txt.getPos(testoUno, '')
        assert ottenuto in Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Txt.getPos(testoUno, strUno)
        assert ottenuto in Integer
        assert ottenuto == richiestoUno

        ottenuto = Lib.Txt.getPos(testoUno, numUno)
        assert ottenuto in Integer
        assert ottenuto == richiestoDue

        ottenuto = Lib.Txt.getPos(testoUno, lista)
        assert ottenuto in Integer
        assert ottenuto == richiestoUno

        ottenuto = Lib.Txt.getPos(testoDue, lista)
        assert ottenuto in Integer
        assert ottenuto == richiestoDue

    }// fine test

    void testGetPos2() {
        String testo = "Bio\n" +
                "|Nome = Nina\n" +
                "|Cognome = Skeime\n" +
                "|Sesso = F\n" +
                "|LuogoNascita = \n" +
                "|GiornoMeseNascita = 21 maggio\n" +
                "|AnnoNascita = 1962\n" +
                "|LuogoMorte =\n" +
                "|GiornoMeseMorte =\n" +
                "|AnnoMorte =\n" +
                "|PreAttività = è un'ex\n" +
                "|Attività = fondista\n" +
                "|Nazionalità = norvegese"

        def lista = new ArrayList()
        int ottenuto

        lista.add("|Titolo ")
        lista.add("|Titolo=")
        lista.add("|Titolo\t")
        lista.add("|Titolo =")
        lista.add(" |Titolo ")
        lista.add(" |Titolo=")
        lista.add(" |Titolo\t")
        lista.add(" |Titolo =")

        ottenuto = Lib.Txt.getPos(testo, lista)
        assert ottenuto == LibTesto.INT_NULLO
    }// fine tests

    /**
     * Estrae da un testo il contenuto compreso fra i tag.
     *
     * Esegue solo se il testo ed i tag sono validi
     * Elimina spazi vuoti
     *
     * @param testo completo da esaminare
     * @param tagIni tag iniziale per il contenuto richiesto
     * @param tagEnd tag finale per il contenuto richiesto
     * @return contenuto richiesto tra i due tag
     */

    void testEstrae() {
        String testo = 'In questo 14 testo uno volte scrivo la parola due e tre pertanto la trovo'
        String tagIni = 'volte'
        String tagEnd = 'la'
        String richiesto = 'scrivo'
        String ottenuto

        ottenuto = Lib.Txt.estrae(testo, tagIni, tagEnd)
        assert ottenuto == richiesto
    }// fine test

}// fine della classe di test
