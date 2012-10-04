package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 08:05
 * To change this template use File | Settings | File Templates.
 */
class GiornoTest extends GroovyTestCase {

    protected void setUp() {
        super.setUp()
    }// fine del metodo standard


    protected void tearDown() {
        super.tearDown()
    }// fine del metodo standard

    // la settimana ha sette giorni
    void testNumeroGiorni() {
        int richiesto = 7
        int ottenuto

        ottenuto = Giorno.values().size()
        assert ottenuto == richiesto
    } // fine del test

    // la settimana comincia dal lunedì
    void testPrimoGiorno() {
        int primo = 1
        String richiestoBreve = 'lun'
        String richiestoLungo = 'lunedì'
        String ottenuto

        ottenuto = Giorno.getShort(primo)
        assert ottenuto == richiestoBreve

        ottenuto = Giorno.getLong(primo)
        assert ottenuto == richiestoLungo
    } // fine del test

    // meglio controllare tutti i giorni
    void testTuttiGiorni() {
        assert Giorno.getShort(1) == 'lun'
        assert Giorno.getShort(2) == 'mar'
        assert Giorno.getShort(3) == 'mer'
        assert Giorno.getShort(4) == 'gio'
        assert Giorno.getShort(5) == 'ven'
        assert Giorno.getShort(6) == 'sab'
        assert Giorno.getShort(7) == 'dom'
    } // fine del test

    // lunedì è il primo giorno della settimana
    // domenica è il settimo giorno della settimana
    void testDomenica() {
        int richiesto = 7
        int ottenuto

        assert Giorno.lunedì.getOrd() == 1
        assert Giorno.martedì.getOrd() == 2
        assert Giorno.mercoledì.getOrd() == 3
        assert Giorno.giovedì.getOrd() == 4
        assert Giorno.venerdì.getOrd() == 5
        assert Giorno.sabato.getOrd() == 6
        assert Giorno.domenica.getOrd() == 7

        ottenuto = Giorno.domenica.getOrd()
        assert ottenuto == richiesto
    } // fine del test

    // nomi brevi
    void testNomiBrevi() {
        assert Giorno.lunedì.getBreve() == 'lun'
        assert Giorno.martedì.getBreve() == 'mar'
        assert Giorno.mercoledì.getBreve() == 'mer'
        assert Giorno.giovedì.getBreve() == 'gio'
        assert Giorno.venerdì.getBreve() == 'ven'
        assert Giorno.sabato.getBreve() == 'sab'
        assert Giorno.domenica.getBreve() == 'dom'
    } // fine del test

    // nomi lunghi
    void testNomiLunghi() {
        assert Giorno.lunedì.getLungo() == 'lunedì'
        assert Giorno.martedì.getLungo() == 'martedì'
        assert Giorno.mercoledì.getLungo() == 'mercoledì'
        assert Giorno.giovedì.getLungo() == 'giovedì'
        assert Giorno.venerdì.getLungo() == 'venerdì'
        assert Giorno.sabato.getLungo() == 'sabato'
        assert Giorno.domenica.getLungo() == 'domenica'
    } // fine del test

    // elenco nomi brevi
    void testElencoBrevi() {
        String richiesto = 'lun, mar, mer, gio, ven, sab, dom'
        String ottenuto

        ottenuto = Giorno.getAllShortString()
        assert ottenuto == richiesto
    } // fine del test

    // elenco nomi lunghi
    void testElencoLunghi() {
        String richiesto = 'lunedì, martedì, mercoledì, giovedì, venerdì, sabato, domenica'
        String ottenuto

        ottenuto = Giorno.getAllLongString()
        assert ottenuto == richiesto
    } // fine del test

    // lista nomi brevi
    void testListaBrevi() {
        ArrayList richiesto = ['lun', 'mar', 'mer', 'gio', 'ven', 'sab', 'dom']
        def ottenuto

        ottenuto = Giorno.getAllShortList()
        assert (ottenuto in List)
        assert ottenuto.size() == 7
        assert ottenuto == richiesto
    } // fine del test

    // lista nomi lunghi
    void testListaLunghi() {
        ArrayList richiesto = ['lunedì', 'martedì', 'mercoledì', 'giovedì', 'venerdì', 'sabato', 'domenica']
        def ottenuto

        ottenuto = Giorno.getAllLongList()
        assert (ottenuto in List)
        assert ottenuto.size() == 7
        assert ottenuto == richiesto
    } // fine del test

}// fine della classe di test
