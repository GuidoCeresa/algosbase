package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
class MeseTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }// fine del metodo standard


    protected void tearDown() {
        super.tearDown()
    }// fine del metodo standard

    // l'anno ha dodici mesi
    void testNumeroMesi() {
        int richiesto = 12
        int ottenuto

        ottenuto = Mese.values().size()
        assert ottenuto == richiesto
    } // fine del test

    // l'anno comincia da gennaio
    void testPrimoMese() {
        int primo = 1
        String richiestoBreve = 'gen'
        String richiestoLungo = 'gennaio'
        String ottenuto

        ottenuto = Mese.getShort(primo)
        assert ottenuto == richiestoBreve

        ottenuto = Mese.getLong(primo)
        assert ottenuto == richiestoLungo
    } // fine del test

    // meglio controllare tutti i mesi
    void testTuttiMese() {
        assert Mese.getShort(1) == 'gen'
        assert Mese.getShort(2) == 'feb'
        assert Mese.getShort(3) == 'mar'
        assert Mese.getShort(4) == 'apr'
        assert Mese.getShort(5) == 'mag'
        assert Mese.getShort(6) == 'giu'
        assert Mese.getShort(7) == 'lug'
        assert Mese.getShort(8) == 'ago'
        assert Mese.getShort(9) == 'set'
        assert Mese.getShort(10) == 'ott'
        assert Mese.getShort(11) == 'nov'
        assert Mese.getShort(12) == 'dic'
    } // fine del test

    // gennaio è il primo mese dell'anno
    // dicembre è il dodicesimo mese dell'anno
    void testDicembre() {
        int richiesto = 12
        int ottenuto

        assert Mese.gennaio.getOrd() == 1
        assert Mese.febbraio.getOrd() == 2
        assert Mese.marzo.getOrd() == 3
        assert Mese.aprile.getOrd() == 4
        assert Mese.maggio.getOrd() == 5
        assert Mese.giugno.getOrd() == 6
        assert Mese.luglio.getOrd() == 7
        assert Mese.agosto.getOrd() == 8
        assert Mese.settembre.getOrd() == 9
        assert Mese.ottobre.getOrd() == 10
        assert Mese.novembre.getOrd() == 11
        assert Mese.dicembre.getOrd() == 12

        ottenuto = Mese.dicembre.getOrd()
        assert ottenuto == richiesto
    } // fine del test

    // nomi brevi
    void testNomiBrevi() {
        assert Mese.gennaio.getBreve() == 'gen'
        assert Mese.febbraio.getBreve() == 'feb'
        assert Mese.marzo.getBreve() == 'mar'
        assert Mese.aprile.getBreve() == 'apr'
        assert Mese.maggio.getBreve() == 'mag'
        assert Mese.giugno.getBreve() == 'giu'
        assert Mese.luglio.getBreve() == 'lug'
        assert Mese.agosto.getBreve() == 'ago'
        assert Mese.settembre.getBreve() == 'set'
        assert Mese.ottobre.getBreve() == 'ott'
        assert Mese.novembre.getBreve() == 'nov'
        assert Mese.dicembre.getBreve() == 'dic'
    } // fine del test

    // nomi lunghi
    void testNomiLunghi() {
        assert Mese.gennaio.getLungo() == 'gennaio'
        assert Mese.febbraio.getLungo() == 'febbraio'
        assert Mese.marzo.getLungo() == 'marzo'
        assert Mese.aprile.getLungo() == 'aprile'
        assert Mese.maggio.getLungo() == 'maggio'
        assert Mese.giugno.getLungo() == 'giugno'
        assert Mese.luglio.getLungo() == 'luglio'
        assert Mese.agosto.getLungo() == 'agosto'
        assert Mese.settembre.getLungo() == 'settembre'
        assert Mese.ottobre.getLungo() == 'ottobre'
        assert Mese.novembre.getLungo() == 'novembre'
        assert Mese.dicembre.getLungo() == 'dicembre'
    } // fine del test

    // elenco nomi brevi
    void testElencoBrevi() {
        String richiesto = 'gen, feb, mar, apr, mag, giu, lug, ago, set, ott, nov, dic'
        String ottenuto

        ottenuto = Mese.getAllShortString()
        assert ottenuto == richiesto
    } // fine del test

    // elenco nomi lunghi
    void testElencoLunghi() {
        String richiesto = 'gennaio, febbraio, marzo, aprile, maggio, giugno, luglio, agosto, settembre, ottobre, novembre, dicembre'
        String ottenuto

        ottenuto = Mese.getAllLongString()
        assert ottenuto == richiesto
    } // fine del test

    // lista nomi brevi
    void testListaBrevi() {
        ArrayList richiesto = ['gen', 'feb', 'mar', 'apr', 'mag', 'giu', 'lug', 'ago', 'set', 'ott', 'nov', 'dic']
        def ottenuto

        ottenuto = Mese.getAllShortList()
        assert (ottenuto in List)
        assert ottenuto.size() == 12
        assert ottenuto == richiesto
    } // fine del test

    // lista nomi lunghi
    void testListaLunghi() {
        ArrayList richiesto = ['gennaio', 'febbraio', 'marzo', 'aprile', 'maggio', 'giugno', 'luglio', 'agosto', 'settembre', 'ottobre', 'novembre', 'dicembre']
        def ottenuto

        ottenuto = Mese.getAllLongList()
        assert (ottenuto in List)
        assert ottenuto.size() == 12
        assert ottenuto == richiesto
    } // fine del test

}// fine della classe di test
