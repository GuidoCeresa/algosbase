package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 5-10-12
 * Time: 08:24
 * To change this template use File | Settings | File Templates.
 */
class LibDateTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }


    protected void tearDown() {
        super.tearDown()
    }

    void testProvvisorio() {
    }

//    /**
//     * Elimina l'ora ed i minuti ed i secondi da una data.
//     * Imposta le informazioni a zero
//     *
//     * @param dateIn la data dalla quale eliminare l'ora
//     * @return la data senza ora
//     */
//
//    static testDrop() {
//        Calendar cal = Calendar.getInstance()
//        Date dataOriginariaConOra
//        Date dataRichiesta
//        Date dataOttenuta
//
//        cal.set(1946, Calendar.OCTOBER, 28, 13, 44, 51)
//        dataOriginariaConOra = cal.getTime()
//
//        cal = Calendar.getInstance()
//        cal.set(1946, Calendar.OCTOBER, 28, 0, 0, 0)
//        cal.set(Calendar.MILLISECOND, 0)
//        dataRichiesta = cal.getTime()
//
//        dataOttenuta = it.algos.algosbase.LibDate.dropTime(dataOriginariaConOra)
//        assert dataOttenuta == dataRichiesta
//    } // fine del test
//
//    /**
//     * Aggiunge (o sottrae) ad un una data il numero di giorni indicati.
//     *
//     * Se i giorni sono negativi, li sottrae
//     * Esegue solo se la data è valida (non nulla e non vuota)
//     *
//     * @param data di riferimento
//     * @param giorni da aggiungere
//     * @return la data risultante
//     */
//
//    void testAdd() {
//        Calendar cal = Calendar.getInstance()
//        Date dataOriginaria
//        Date dataRichiesta
//        Date dataOttenuta
//        int delta = 9
//
//        cal.set(1946, Calendar.OCTOBER, 28)
//        dataOriginaria = cal.getTime()
//
//        cal.set(1946, Calendar.NOVEMBER, 6)
//        dataRichiesta = cal.getTime()
//
//        dataOttenuta = it.algos.algosbase.LibDate.add(dataOriginaria, delta)
//        assert dataOttenuta == dataRichiesta
//    } // fine del test
//
//    /**
//     * Differenza in giorni tra le date indicate.
//     * Esegue solo se le data sono valide
//     *
//     * Se le due date sono uguali la differenza è zero
//     * Se le due date sono consecutive la differenza è uno, ecc...
//     *
//     * @param dataUno finale
//     * @param dataDue iniziale
//     * @return il numero di giorni passati tra le due date
//     *         sempre positivo anche se le date sono invertite
//     */
//
//    void testDiffGiorni() {
//        Calendar cal = Calendar.getInstance()
//        Date primaData
//        Date secondaData
//        int deltaRichiesto = 9
//        int deltaDateUguali = 0
//        int deltaOttenuto
//        int risultatoNullo = 0
//
//        cal.set(1946, Calendar.OCTOBER, 28)
//        primaData = cal.getTime()
//
//        cal.set(1946, Calendar.NOVEMBER, 6)
//        secondaData = cal.getTime()
//
//        deltaOttenuto = it.algos.algosbase.LibDate.getGiorni(primaData, secondaData)
//        assert deltaOttenuto == deltaRichiesto
//
//        deltaOttenuto = it.algos.algosbase.LibDate.getGiorni(secondaData, primaData)
//        assert deltaOttenuto == deltaRichiesto
//
//        deltaOttenuto = it.algos.algosbase.LibDate.getGiorni(primaData, primaData)
//        assert deltaOttenuto == deltaDateUguali
//
//        deltaOttenuto = it.algos.algosbase.LibDate.getGiorni(null, secondaData)
//        assert deltaOttenuto == risultatoNullo
//
//        deltaOttenuto = it.algos.algosbase.LibDate.getGiorni(primaData, null)
//        assert deltaOttenuto == risultatoNullo
//
//        deltaOttenuto = it.algos.algosbase.LibDate.getGiorni(null, null)
//        assert deltaOttenuto == risultatoNullo
//    } // fine del test
//
//    /**
//     * Aggiunge ad un timestamp i secondi indicati.
//     * Se i secondi sono negativi, li sottrae
//     *
//     * @param time timestamp di riferiemento
//     * @param secondi da aggiungere
//     * @return la data risultante
//     */
//
//    void testAddTime() {
//        Timestamp originario
//        Timestamp richiesto
//        Timestamp ottenuto
//        long secOriginari
//        long delta
//        long secRisultanti
//        int milli = 1000
//
//        secOriginari = 825003
//        delta = 25
//        secRisultanti = secOriginari + delta
//        originario = new Timestamp(secOriginari * milli)
//        richiesto = new Timestamp(secRisultanti * milli)
//        ottenuto = Lib.Date.add(originario, delta)
//        assert ottenuto == richiesto
//
//
//        secOriginari = 472551
//        delta = -829
//        secRisultanti = secOriginari + delta
//        originario = new Timestamp(secOriginari * milli)
//        richiesto = new Timestamp(secRisultanti * milli)
//        ottenuto = Lib.Date.add(originario, delta)
//        assert ottenuto == richiesto
//    } // fine del test
//
//    /**
//     * Calcola quanti secondi sono passati tra due timestamp o tra due date
//     *
//     * @param timeStamp1 il primo timestamp
//     * @param timeStamp2 il secondo timestamp
//     * @param data1 la prima data
//     * @param data2 la seconda data
//     * @return il numero di secondi passati tra due timestamp
//     *         sempre positivo anche se i timestamp sono invertiti
//     * @return il numero di secondi passati tra le due date
//     *         sempre positivo anche se le date sono invertite
//     */
//
//    void testGetSecondi() {
//        Calendar cal = Calendar.getInstance()
//        Timestamp primo
//        Timestamp secondo
//        Date primaData
//        Date secondaData
//        long secUno
//        long secDue
//        long richiesto
//        long ottenuto
//        long risultatoNullo = 0
//        int milli = 1000
//
//        secUno = 825003
//        secDue = 472551
//        richiesto = secUno - secDue
//        primo = new Timestamp(secUno * milli)
//        secondo = new Timestamp(secDue * milli)
//
//        ottenuto = Lib.Date.getSecondi(primo, secondo)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getSecondi(secondo, primo)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getSecondi(null, secondo)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getSecondi(primo, null)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getSecondi(null, null)
//        assert ottenuto == risultatoNullo
//
//        cal.set(1946, Calendar.OCTOBER, 28, 13, 22, 53)
//        primaData = cal.getTime()
//
//        cal = Calendar.getInstance()
//        cal.set(1946, Calendar.OCTOBER, 28, 13, 22, 45)
//        secondaData = cal.getTime()
//
//        richiesto = 8
//        ottenuto = Lib.Date.getSecondi(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getSecondi(secondaData, primaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getSecondi(null, secondaData)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getSecondi(primaData, null)
//        assert ottenuto == risultatoNullo
//    } // fine del test
//
//    /**
//     * Calcola quanti minuti sono passati tra due timestamp o tra due date
//     *
//     * @param timeStamp1 il primo timestamp
//     * @param timeStamp2 il secondo timestamp
//     * @param data1 la prima data
//     * @param data2 la seconda data
//     * @return il numero di minuti passati tra due timestamp
//     *         sempre positivo anche se i timestamp sono invertiti
//     * @return il numero di minuti passati tra le due date
//     *         sempre positivo anche se le date sono invertite
//     */
//
//    void testGetMinuti() {
//        Calendar cal = Calendar.getInstance()
//        Timestamp primo
//        Timestamp secondo
//        Date primaData
//        Date secondaData
//        long secUno
//        long secDue
//        int richiesto
//        int ottenuto
//        int risultatoNullo = 0
//        int milli = 1000
//        int delta = 60
//
//        secUno = 825003
//        secDue = 472551
//        richiesto = (secUno - secDue) / delta
//        primo = new Timestamp(secUno * milli)
//        secondo = new Timestamp(secDue * milli)
//
//        ottenuto = Lib.Date.getMinuti(primo, secondo)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getMinuti(secondo, primo)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getMinuti(null, secondo)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getMinuti(primo, null)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getMinuti(null, null)
//        assert ottenuto == risultatoNullo
//
//        cal.set(1946, Calendar.OCTOBER, 28, 13, 30, 53)
//        primaData = cal.getTime()
//
//        cal = Calendar.getInstance()
//        cal.set(1946, Calendar.OCTOBER, 28, 13, 22, 01)
//        secondaData = cal.getTime()
//
//        richiesto = 9
//        ottenuto = Lib.Date.getMinuti(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getMinuti(secondaData, primaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getMinuti(null, secondaData)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getMinuti(primaData, null)
//        assert ottenuto == risultatoNullo
//    } // fine del test
//
//    /**
//     * Calcola quante ore sono passate tra due timestamp o tra due date
//     *
//     * @param timeStamp1 il primo timestamp
//     * @param timeStamp2 il secondo timestamp
//     * @param data1 la prima data
//     * @param data2 la seconda data
//     * @return il numero di ore passate tra due timestamp
//     *         sempre positivo anche se i timestamp sono invertiti
//     * @return il numero di ore passate tra le due date
//     *         sempre positivo anche se le date sono invertite
//     */
//
//    void testGetOre() {
//        Calendar cal = Calendar.getInstance()
//        Timestamp primo
//        Timestamp secondo
//        Date primaData
//        Date secondaData
//        long secUno
//        long secDue
//        long diff
//        int richiesto
//        int ottenuto
//        int risultatoNullo = 0
//        int milli = 1000
//        int secondiPerOra = 60 * 60
//
//        secUno = 825003
//        secDue = 472551
//        diff = (secUno - secDue)
//        richiesto = Lib.Mat.divRound(diff, secondiPerOra)
//        primo = new Timestamp(secUno * milli)
//        secondo = new Timestamp(secDue * milli)
//
//        ottenuto = Lib.Date.getOre(primo, secondo)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getOre(secondo, primo)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getOre(null, secondo)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getOre(primo, null)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getOre(null, null)
//        assert ottenuto == risultatoNullo
//
//        cal.set(1946, Calendar.OCTOBER, 28, 13, 59, 53)
//        primaData = cal.getTime()
//
//        cal = Calendar.getInstance()
//        cal.set(1946, Calendar.OCTOBER, 28, 5, 02, 01)
//        secondaData = cal.getTime()
//
//        richiesto = 9
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getOre(secondaData, primaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getOre(null, secondaData)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getOre(primaData, null)
//        assert ottenuto == risultatoNullo
//
//        ottenuto = Lib.Date.getOre(null, null)
//        assert ottenuto == risultatoNullo
//
//        cal.set(1946, Calendar.OCTOBER, 28, 0, 0, 0)
//        primaData = cal.getTime()
//
//        cal = Calendar.getInstance()
//        cal.set(1946, Calendar.NOVEMBER, 28, 0, 0, 0)
//        secondaData = cal.getTime()
//        richiesto = 31 * 24
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getOre(secondaData, primaData)
//        assert ottenuto == richiesto
//
//        cal.set(2012, Calendar.JUNE, 30, 20, 0, 0)
//        primaData = cal.getTime()
//        cal = Calendar.getInstance()
//        cal.set(2012, Calendar.JULY, 1, 8, 0, 0)
//        secondaData = cal.getTime()
//        richiesto = 12
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        cal.set(2012, Calendar.MARCH, 22, 13, 0, 0)
//        primaData = cal.getTime()
//        cal = Calendar.getInstance()
//        cal.set(2012, Calendar.MARCH, 22, 15, 0, 0)
//        secondaData = cal.getTime()
//        richiesto = 2
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        cal.set(2012, Calendar.MARCH, 22, 13, 0, 0)
//        primaData = cal.getTime()
//        cal = Calendar.getInstance()
//        cal.set(2012, Calendar.MARCH, 22, 15, 15, 0)
//        secondaData = cal.getTime()
//        richiesto = 2
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        cal.set(2012, Calendar.MARCH, 22, 13, 0, 0)
//        primaData = cal.getTime()
//        cal = Calendar.getInstance()
//        cal.set(2012, Calendar.MARCH, 22, 15, 30, 0)
//        secondaData = cal.getTime()
//        richiesto = 3
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//        cal.set(2012, Calendar.MARCH, 22, 13, 0, 0)
//        primaData = cal.getTime()
//        cal = Calendar.getInstance()
//        cal.set(2012, Calendar.MARCH, 22, 15, 45, 0)
//        secondaData = cal.getTime()
//        richiesto = 3
//        ottenuto = Lib.Date.getOre(primaData, secondaData)
//        assert ottenuto == richiesto
//
//    } // fine del test
//
//
//    static testWeek() {
//        Calendar cal = GregorianCalendar.getInstance()
//        int numWeek
//        String richiesto
//        String ottenuto
//        Date giorno
//
//        //settimana
//        cal.set(2012, GregorianCalendar.JULY, 16)
//        giorno = cal.getTime()
//        richiesto = Giorno.lunedì.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 17)
//        giorno = cal.getTime()
//        richiesto = Giorno.martedì.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 18)
//        giorno = cal.getTime()
//        richiesto = Giorno.mercoledì.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 19)
//        giorno = cal.getTime()
//        richiesto = Giorno.giovedì.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 20)
//        giorno = cal.getTime()
//        richiesto = Giorno.venerdì.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 21)
//        giorno = cal.getTime()
//        richiesto = Giorno.sabato.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 22)
//        giorno = cal.getTime()
//        richiesto = Giorno.domenica.breve
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//
//        //venerdi
//        richiesto = 'ven'
//        cal.set(2012, GregorianCalendar.JULY, 13, 13, 44, 51)
//        giorno = cal.getTime()
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//
//        //sabato
//        richiesto = 'sab'
//        cal.set(2012, GregorianCalendar.JULY, 14)
//        giorno = cal.getTime()
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//
//        numWeek = cal.get(GregorianCalendar.DAY_OF_WEEK)
//        ottenuto = Lib.Date.getWeek(numWeek)
//        assert ottenuto == richiesto
//
//        ottenuto = Lib.Date.getWeekBreve(numWeek)
//        assert ottenuto == richiesto
//
//        richiesto = 'sabato'
//        ottenuto = Lib.Date.getWeekLong(numWeek)
//        assert ottenuto == richiesto
//
//        //domenica
//        richiesto = 'dom'
//        cal.set(2012, GregorianCalendar.JULY, 15)
//        giorno = cal.getTime()
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//
//        numWeek = cal.get(GregorianCalendar.DAY_OF_WEEK)
//        ottenuto = Lib.Date.getWeek(numWeek)
//        assert ottenuto == richiesto
//
//        //lunedi
//        richiesto = 'lun'
//        cal.set(2012, GregorianCalendar.JULY, 16)
//        giorno = cal.getTime()
//        numWeek = cal.get(GregorianCalendar.DAY_OF_WEEK)
//        ottenuto = Lib.Date.getWeek(giorno)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getWeek(numWeek)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getWeekBreve(giorno)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getWeekBreve(numWeek)
//        assert ottenuto == richiesto
//
//        richiesto = 'lunedì'
//        ottenuto = Lib.Date.getWeekLong(giorno)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getWeekLong(numWeek)
//        assert ottenuto == richiesto
//    } // fine del test
//
//
//    static testMese() {
//        Calendar cal = GregorianCalendar.getInstance()
//        int numMese
//        String richiesto
//        String ottenuto
//        Date giorno
//
//
//        cal.set(2012, GregorianCalendar.JANUARY, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.gennaio.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.FEBRUARY, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.febbraio.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.MARCH, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.marzo.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.APRIL, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.aprile.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.MAY, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.maggio.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JUNE, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.giugno.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.JULY, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.luglio.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.AUGUST, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.agosto.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.SEPTEMBER, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.settembre.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.OCTOBER, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.ottobre.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.NOVEMBER, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.novembre.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        cal.set(2012, GregorianCalendar.DECEMBER, 1)
//        giorno = cal.getTime()
//        richiesto = Mese.dicembre.breve
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//
//
//        cal.set(2012, GregorianCalendar.JULY, 13, 13, 44, 51)
//        giorno = cal.getTime()
//        numMese = cal.get(GregorianCalendar.MONTH) + 1
//
//        richiesto = 'lug'
//        ottenuto = Lib.Date.getMese(giorno)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getMeseBreve(giorno)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getMese(numMese)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getMeseBreve(numMese)
//        assert ottenuto == richiesto
//        richiesto = 'luglio'
//        ottenuto = Lib.Date.getMeseLong(giorno)
//        assert ottenuto == richiesto
//        ottenuto = Lib.Date.getMeseLong(numMese)
//        assert ottenuto == richiesto
//
//    } // fine del test

}// fine della classe
