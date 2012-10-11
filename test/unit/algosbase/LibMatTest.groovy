package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 5-10-12
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
class LibMatTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }


    protected void tearDown() {
        super.tearDown()
    }

    /**
     * Controlla se il numero è pari
     *
     * @param num da controllare
     * @return vero se è pari
     */
    void testPari() {
        int uno = 2
        int due = 3
        int tre = 12450
        int quattro = 12451
        def valoreNonValido = 'stringa'
        boolean pari

        pari = Lib.Mat.isPari(uno)
        assert pari

        pari = Lib.Mat.isPari(due)
        assert !pari

        pari = Lib.Mat.isPari(tre)
        assert pari

        pari = Lib.Mat.isPari(quattro)
        assert !pari

        pari = Lib.Mat.isPari(valoreNonValido)
        assertFalse(pari)
    }// fine tests

    /**
     * Controlla se il numero è dispari
     *
     * @param num da controllare
     * @return vero se è dispari
     */
    void testDispari() {
        int uno = 2
        int due = 3
        int tre = 12450
        int quattro = 12451
        boolean dispari

        dispari = Lib.Mat.isDispari(uno)
        assert !dispari

        dispari = Lib.Mat.isDispari(due)
        assert dispari

        dispari = Lib.Mat.isDispari(tre)
        assert !dispari

        dispari = Lib.Mat.isDispari(quattro)
        assert dispari
    }// fine tests

    /**
     * Divisione tra due numeri arrotondata all'intero più vicino
     * (superiore od inferiore)
     *
     * @param primo numero
     * @param secondo numero
     * @return intero arrotondato
     */
    void testDivisioneArrotondata() {
        int numeratore
        int denominatore
        int ottenuto
        int richiesto

        numeratore = 8
        denominatore = 4
        richiesto = 2
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 4
        denominatore = 8
        richiesto = 1
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 4
        denominatore = 9
        richiesto = 0
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 8
        denominatore = -4
        richiesto = -2
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 9
        denominatore = 4
        richiesto = 2
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 9
        denominatore = 5
        richiesto = 2
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 9
        denominatore = 6
        richiesto = 2
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 9
        denominatore = 7
        richiesto = 1
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 9
        denominatore = 8
        richiesto = 1
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

        numeratore = 9
        denominatore = 9
        richiesto = 1
        ottenuto = Lib.Mat.divRound(numeratore, denominatore)
        assert ottenuto == richiesto

    } // fine test

} // fine della classe di test
