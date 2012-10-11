package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 5-10-12
 * Time: 08:23
 * To change this template use File | Settings | File Templates.
 */

import java.sql.Time
import java.sql.Timestamp
import java.text.DateFormat
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Repository di funzionalità per la gestione delle date. </p> Tutti i metodi sono statici <br> I
 * metodi non hanno modificatore così sono visibili all'esterno del package solo utilizzando
 * l'interfaccia unificata <b>Lib</b><br>
 *
 * @author Guido Andrea Ceresa, Alessandro Valbonesi
 * @author gac
 * @version 1.0    / 11-mag-2006 ore 6.15.57
 */
public class LibDate {

    /**
     * numero di millisecondi in un giorno (86.400 secondi)
     */
    private static final long MSEC_PER_DAY = 86400000

    /**
     * Istanza del calendario del programma
     */
    private static GregorianCalendar calendario

    /**
     * Oggetto formattatore per le date.
     * <p/>
     * Converte data->testo e testo->data
     */
    private static SimpleDateFormat dateFormat = null

    /**
     * Oggetto formattatore per le date.
     * <p/>
     * Converte data->testo e testo->data interpreta l'anno a 2 cifre
     */
    private static SimpleDateFormat shortDateFormat = null

    /**
     * Data convenzionalmente interpretata come vuota
     */
    private static Date dataVuota

    /**
     * Metodo statico.
     * Invocato la prima volta che la classe statica viene richiamata nel programma <br>
     */
    static {
        /* variabili e costanti locali di lavoro */
        GregorianCalendar calendari
        long millisec
        Date data
        SimpleDateFormat df
        SimpleDateFormat sdf

        try { // prova ad eseguire il codice

            /* crea il calendario */
            calendario = new GregorianCalendar(0, 0, 0, 0, 0, 0)
            LibDate.setCalendario(calendario)

            /* crea la data convenzionalmente vuota */
            millisec = calendario.getTimeInMillis()
            data = new Date(millisec)
            LibDate.setDataVuota(data)

            /**
             * regola il calendario come non-lenient
             * (se la data non è valida non effettua la
             * rotazione automatica dei valori dei campi,
             * es. 32-12-2004 non diventa 01-01-2005)
             */
            calendario.setLenient(false)

            /* crea i formattatori per le date */
            df = new SimpleDateFormat("dd-MM-yyyy")
            sdf = new SimpleDateFormat("dd-MM-yy")
            df.setCalendar(calendario)
            sdf.setCalendar(calendario)
            LibDate.setDateFormat(df)
            LibDate.setShortDateFormat(sdf)

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch        /* crea il calendario */
    } // fine del metodo

    /**
     * Aggiunge (o sottrae) ad un una data i giorni indicati.
     *
     * Se i giorni sono negativi, li sottrae
     * Esegue solo se la data è valida (non nulla e non vuota)
     *
     * @param data di riferimento
     * @param giorni da aggiungere
     * @return la data risultante
     */
    static Date add(Date data, int giorni) {
        /* variabili e costanti locali di lavoro */
        Date nuovaData = data
        long rif
        long delta
        long nuova

        if (data && giorni) {
            rif = data.getTime()
            delta = giorni * MSEC_PER_DAY
            nuova = rif + delta
            nuovaData = new Date(nuova)
        }// fine del blocco if

        /* valore di ritorno */
        return nuovaData
    } // fine del metodo

    /**
     * Differenza in giorni tra le date indicate.
     * Esegue solo se le data sono valide
     *
     * Se le due date sono uguali la differenza è zero
     * Se le due date sono consecutive la differenza è uno, ecc...
     *
     * @param dataUno finale
     * @param dataDue iniziale
     * @return il numero di giorni passati tra le due date
     *         sempre positivo anche se le date sono invertite
     */
    static int getGiorni(Date dataUno, Date dataDue) {
        /* variabili e costanti locali di lavoro */
        int giorni = 0
        java.util.Date d1
        java.util.Date d2
        long iniziale
        long finale
        double delta

        if (dataDue && dataUno) {

            /* rimuove le informazioni sull'ora */
            d1 = dropTime(dataUno)
            d2 = dropTime(dataDue)

            finale = d1.getTime()
            iniziale = d2.getTime()

            delta = finale - iniziale

            giorni = (int) Math.round(delta / MSEC_PER_DAY)

            giorni = Math.abs(giorni)
        }// fine del blocco if-else

        /* valore di ritorno */
        return giorni
    } // fine del metodo

    /**
     * Elimina l'ora da una data.
     * Imposta le informazioni sull'ora a zero
     *
     * @param dateIn la data dalla quale eliminare l'ora
     * @return la data senza ora
     */
    static Date dropTime(Date dateIn) {
        /* variabili e costanti locali di lavoro */
        Date dateOut = null
        Calendar cal

        if (dateIn) {
            cal = Calendar.getInstance()
            cal.setTime(dateIn)
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.MILLISECOND, 0)
            dateOut = cal.getTime()
        }// fine del blocco if

        /* valore di ritorno */
        return dateOut
    } // fine del metodo

    /**
     * Aggiunge ad un timestamp i secondi indicati.
     * Se i secondi sono negativi, li sottrae <br>
     *
     * @param time timestamp di riferiemento
     * @param secondi da aggiungere
     * @return la data risultante
     */
    static Timestamp add(Timestamp time, Number secondi) {
        /* variabili e costanti locali di lavoro */
        Timestamp nuovoTimestamp = null
        long msec
        long delta
        long nuova

        if (time) {
            msec = time.getTime()
            delta = secondi * 1000
            nuova = msec + delta
            nuovoTimestamp = new Timestamp(nuova)
        }// fine del blocco if

        /* valore di ritorno */
        return nuovoTimestamp
    } // fine del metodo

    /**
     * Calcola quanti secondi sono passati tra due timestamp o tra due date
     *
     * @param timeStamp1 il primo timestamp
     * @param timeStamp2 il secondo timestamp
     * @param data1 la prima data
     * @param data2 la seconda data
     * @return il numero di secondi passati tra due timestamp
     *         sempre positivo anche se i timestamp sono invertiti
     * @return il numero di secondi passati tra le due date
     *         sempre positivo anche se le date sono invertite
     */
    static long getSecondi(tempoUno, tempoDue) {
        /* variabili e costanti locali di lavoro */
        long secondi = 0
        long time1, time2
        long diff

        if (tempoUno && tempoDue) {
            time1 = tempoUno.getTime()
            time2 = tempoDue.getTime()
            diff = time1 - time2

            if (diff) {
                secondi = Lib.Mat.divRound(diff, 1000)
                if (secondi) {
                    secondi = Math.abs(secondi)
                }// fine del blocco if
            }// fine del blocco if
        }// fine del blocco if

        /* valore di ritorno */
        return secondi
    } // fine del metodo

    /**
     * Calcola quanti minuti sono passati tra due timestamp o tra due date
     *
     * @param timeStamp1 il primo timestamp
     * @param timeStamp2 il secondo timestamp
     * @param data1 la prima data
     * @param data2 la seconda data
     * @return il numero di minuti passati tra due timestamp
     *         sempre positivo anche se i timestamp sono invertiti
     * @return il numero di minuti passati tra le due date
     *         sempre positivo anche se le date sono invertite
     */
    static int getMinuti(tempoUno, tempoDue) {
        /* variabili e costanti locali di lavoro */
        int minuti = 0
        long secondi
        int secondiPerMinuto = 60

        if (tempoUno && tempoDue) {
            secondi = LibDate.getSecondi(tempoUno, tempoDue)
            if (secondi) {
                minuti = Lib.Mat.divRound(secondi, secondiPerMinuto)
            }// fine del blocco if

        }// fine del blocco if

        /* valore di ritorno */
        return minuti
    } // fine del metodo

    /**
     * Calcola quante ore sono passate tra due timestamp o tra due date
     *
     * @param timeStamp1 il primo timestamp
     * @param timeStamp2 il secondo timestamp
     * @param data1 la prima data
     * @param data2 la seconda data
     * @return il numero di ore passate tra due timestamp
     *         sempre positivo anche se i timestamp sono invertiti
     * @return il numero di ore passate tra le due date
     *         sempre positivo anche se le date sono invertite
     */
    public static int getOre(tempoUno, tempoDue) {
        /* variabili e costanti locali di lavoro */
        int ore = 0
        int minuti
        int minutiPerOra = 60

        if (tempoUno && tempoDue) {
            minuti = LibDate.getMinuti(tempoUno, tempoDue)
            if (minuti) {
                ore = Lib.Mat.divRound(minuti, minutiPerOra)
            }// fine del blocco if
        }// fine del blocco if

        /* valore di ritorno */
        return ore
    } // fine del metodo


    private static String getWeekBase(Date giorno, boolean flagBreve) {
        String settimana = ''
        Calendar cal
        int numWeek

        if (giorno) {
            cal = Calendar.getInstance()
            cal.setTime(giorno)
            numWeek = cal.get(GregorianCalendar.DAY_OF_WEEK)

            if (flagBreve) {
                settimana = getWeekBreve(numWeek)
            } else {
                settimana = getWeekLong(numWeek)
            }// fine del blocco if-else
        }// fine del blocco if

        /* valore di ritorno */
        return settimana
    }// fine del metodo

    public static String getWeek(Date giorno) {
        return getWeekBreve(giorno)
    }// fine del metodo

    public static String getWeekBreve(Date giorno) {
        return getWeekBase(giorno, true)
    }// fine del metodo


    public static String getWeekLong(Date giorno) {
        return getWeekBase(giorno, false)
    }// fine del metodo

    public static String getWeek(int numWeek) {
        return getWeekBreve(numWeek)
    }// fine del metodo

    public static String getWeekBreve(int numWeek) {
        String settimana = ''

        if (numWeek) {
            numWeek = numWeek - 1
            if (numWeek == 0) {
                numWeek = 7
            }// fine del blocco if

            settimana = Giorno.getShort(numWeek)
        }// fine del blocco if

        return settimana
    }// fine del metodo

    public static String getWeekLong(int numWeek) {
        String settimana = ''

        if (numWeek) {
            numWeek = numWeek - 1
            if (numWeek == 0) {
                numWeek = 7
            }// fine del blocco if
            settimana = Giorno.getLong(numWeek)
        }// fine del blocco if

        return settimana
    }// fine del metodo

    private static String getMeseBase(Date giorno, boolean flagBreve) {
        String mese = ''
        Calendar cal
        int numMese

        if (giorno) {
            cal = Calendar.getInstance()
            cal.setTime(giorno)
            numMese = cal.get(GregorianCalendar.MONTH) + 1
            if (flagBreve) {
                mese = getMeseBreve(numMese)
            } else {
                mese = getMeseLong(numMese)
            }// fine del blocco if-else
        }// fine del blocco if

        /* valore di ritorno */
        return mese
    }// fine del metodo

    public static String getMese(Date giorno) {
        return getMeseBreve(giorno)
    }// fine del metodo

    public static String getMeseBreve(Date giorno) {
        return getMeseBase(giorno, true)
    }// fine del metodo


    public static String getMeseLong(Date giorno) {
        return getMeseBase(giorno, false)
    }// fine del metodo

    public static String getMese(int numMese) {
        return getMeseBreve(numMese)
    }// fine del metodo

    public static String getMeseBreve(int numMese) {
        String mese = ''

        if (numMese) {
            mese = Mese.getShort(numMese)
        }// fine del blocco if

        return mese
    }// fine del metodo

    public static String getMeseLong(int numMese) {
        String mese = ''

        if (numMese) {
            mese = Mese.getLong(numMese)
        }// fine del blocco if

        return mese
    }// fine del metodo

    /**
     * Controlla se una data è precedente ad una data di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi sono o non sono
     * compresi (come da flag) <br>
     *
     * @param dataRif data di riferimento
     * @param dataTest data da controllare
     * @param estremi true per includere anche gli estremi
     *
     * @return vero se la seconda data è precedente alla prima
     */
    private static boolean isPrecedenteBase(Date dataRif, Date dataTest, boolean estremi) {
        /* variabili e costanti locali di lavoro */
        boolean precedente = false
        boolean continua

        try { // prova ad eseguire il codice
            continua = ((dataRif != null) && (dataTest != null))

            if (continua) {
                long longRif = dataRif.getTime()
                long longTest = dataTest.getTime()

                precedente = longTest < longRif

                if (estremi) {
                    if (!precedente) {
                        if (dataTest.equals(dataRif)) {
                            precedente = true
                        }// fine del blocco if
                    }// fine del blocco if
                }// fine del blocco if
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return precedente
    } // fine del metodo

    /**
     * Controlla se una data è precedente ad una data di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi non sono compresi
     * <br> Se le date coincidono, la risposta è falsa <br>
     *
     * @param dataRif di riferiemento
     * @param dataTest da controllare
     *
     * @return vero se la seconda data è precedente alla prima
     */
    static boolean isPrecedente(Date dataRif, Date dataTest) {
        return isPrecedenteBase(dataRif, dataTest, false)
    } // fine del metodo

    /**
     * Controlla se una data è precedente ad una data di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi sono compresi
     * <br> Se le date coincidono, la risposta è vera <br>
     *
     * @param dataRif di riferiemento
     * @param dataTest da controllare
     *
     * @return vero se la seconda data è precedente alla prima
     */
    static boolean isPrecedenteUguale(Date dataRif, Date dataTest) {
        return isPrecedenteBase(dataRif, dataTest, true)
    } // fine del metodo

    /**
     * Controlla se una data è posteriore ad una data di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi sono o non sono
     * compresi (come da flag) <br>
     *
     * @param dataRif data di riferimento
     * @param dataTest data da controllare
     * @param estremi true per includere anche gli estremi
     *
     * @return vero se la seconda data è posteriore alla prima
     */
    private static boolean isPosterioreBase(Date dataRif, Date dataTest, boolean estremi) {
        /* variabili e costanti locali di lavoro */
        boolean posteriore = false
        boolean continua

        try { // prova ad eseguire il codice
            continua = ((dataRif != null) && (dataTest != null))

            if (continua) {
                long longRif = dataRif.getTime()
                long longTest = dataTest.getTime()

                posteriore = longTest > longRif

                if (estremi) {
                    if (!posteriore) {
                        if (dataTest.equals(dataRif)) {
                            posteriore = true
                        }// fine del blocco if
                    }// fine del blocco if
                }// fine del blocco if
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return posteriore
    } // fine del metodo

    /**
     * Controlla se una data è posteriore ad una data di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi non sono compresi
     * <br> Se le date coincidono, la risposta è falsa <br>
     *
     * @param dataRif di riferiemento
     * @param dataTest da controllare
     *
     * @return vero se la seconda data è posteriore alla prima
     */
    static boolean isPosteriore(Date dataRif, Date dataTest) {
        return isPosterioreBase(dataRif, dataTest, false)
    } // fine del metodo

    /**
     * Controlla se una data è posteriore ad una data di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi sono compresi
     * <br> Se le date coincidono, la risposta è vera <br>
     *
     * @param dataRif di riferiemento
     * @param dataTest da controllare
     *
     * @return vero se la seconda data è posteriore alla prima
     */
    static boolean isPosterioreUguale(Date dataRif, Date dataTest) {
        return isPosterioreBase(dataRif, dataTest, true)
    } // fine del metodo

    /**
     * Controlla se una data è compresa tra due date di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi sono o non sono
     * compresi (come da flag) <br>
     *
     * @param inizio data di riferimento iniziale dell'intervallo
     * @param fine data di riferimento finale dell'intervallo
     * @param dataTest data da controllare
     * @param estremi true per includere anche gli estremi
     *
     * @return vero se la data è compresa nell'intervallo di date
     */
    private static boolean isCompresaBase(Date inizio, Date fine, Date dataTest, boolean estremi) {
        /* variabili e costanti locali di lavoro */
        boolean compresa = false
        boolean precedente
        boolean posteriore
        boolean continua

        try { // prova ad eseguire il codice
            continua = ((inizio != null) && (fine != null) && (dataTest != null))

            if (continua) {
                if (estremi) {
                    posteriore = isPosterioreUguale(inizio, dataTest)
                    precedente = isPrecedenteUguale(fine, dataTest)
                } else {
                    posteriore = isPosteriore(inizio, dataTest)
                    precedente = isPrecedente(fine, dataTest)
                }// fine del blocco if-else

                compresa = posteriore && precedente
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return compresa
    } // fine del metodo

    /**
     * Controlla se una data è compresa tra due date di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi non sono compresi
     * <br> Se la data coincide con uno degli estremi, la risposta è falsa <br>
     *
     * @param inizio data di riferimento iniziale dell'intervallo
     * @param fine data di riferimento finale dell'intervallo
     * @param dataTest data da controllare
     *
     * @return vero se la data è compresa nell'intervallo di date
     */
    static boolean isCompresa(Date inizio, Date fine, Date dataTest) {
        return isCompresaBase(inizio, fine, dataTest, false)
    } // fine del metodo

    /**
     * Controlla se una data è compresa tra due date di riferimento.
     * <p/>
     * Esegue solo se le date sono valide (non nulle e non vuote) <br> Gli estremi sono compresi
     * <br> Se la data coincide con uno degli estremi, la risposta è vera <br>
     *
     * @param inizio data di riferimento iniziale dell'intervallo
     * @param fine data di riferimento finale dell'intervallo
     * @param dataTest data da controllare
     *
     * @return vero se la data è compresa nell'intervallo di date
     */
    static boolean isCompresaUguale(Date inizio, Date fine, Date dataTest) {
        return isCompresaBase(inizio, fine, dataTest, true)
    } // fine del metodo

    /**
     * Controlla se un intervallo check è completamente escluso dall'intervallo rif.
     * <p/>
     *
     * @param dataIniCheck inizio del periodo da controllare
     * @param dataEndCheck fine del periodo da controllare
     * @param dataIniRif inizio del periodo di riferimento
     * @param dataEndRif fine del periodo di riferimento
     *
     * @return vero se il periodo da controllare è completamente esterno al periodo di riferimento
     */
    static boolean isPeriodoEscluso(
            Date dataIniCheck,
            Date dataEndCheck,
            Date dataIniRif,
            Date dataEndRif) {
        /* variabili e costanti locali di lavoro */
        boolean escluso = true
        boolean ini
        boolean end

        try { // prova ad eseguire il codice
            ini = LibDate.isPrecedenteUguale(dataEndRif, dataIniCheck)
            end = LibDate.isPosterioreUguale(dataIniRif, dataEndCheck)

            if (ini && end) {
                escluso = false;
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return escluso
    }

    /**
     * Controlla se una data è vuota.
     * <p/>
     * Una data nulla si considera vuota <br>
     *
     * @param data data da controllare
     *
     * @return vero se la data è vuota
     */
    static boolean isVuota(Date data) {
        /* variabili e costanti locali di lavoro */
        boolean vuota = true
        boolean continua
        Date dataVuota

        try { // prova ad eseguire il codice
            continua = data != null

            if (continua) {
                dataVuota = LibDate.getDataVuota()

                vuota = dataVuota.equals(data)
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return vuota
    }

    /**
     * Restituisce una data vuota.
     * <p/>
     * La data vuota e' una data particolare convenzionalmente interpretata come vuota
     *
     * @return la data vuota
     */
    static Date getVuota() {
        /* variabili e costanti locali di lavoro */
        Date data = null
        GregorianCalendar calendario
        long millisec

        try { // prova ad eseguire il codice
            calendario = new GregorianCalendar(0, 0, 0, 0, 0, 0)

            /* crea la data convenzionalmente vuota */
            millisec = calendario.getTimeInMillis()
            data = new Date(millisec)
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch     /* crea il calendario */

        /* valore di ritorno */
        return data
    }

    /**
     * Restituisce la data corrente.
     *
     * @return la data del giorno
     */
    static Date getCorrente() {
        /* variabili e costanti locali di lavoro */
        Date dataOut = null
        Date data
        String stringa

        try { // prova ad eseguire il codice

            /* recupera la data di sistema */
            data = new Date(System.currentTimeMillis())

            // todo provvisorio!!
//            data = Lib.Date.creaData(11,7,2008);

            /* converte in stringa e poi di nuovo in data per forzare
             * la perdita della parte relativa a ore, minuti, secondi ecc...
             * che causa problemi nel confronto di date uguali */
            stringa = LibDate.getStringa(data)
            dataOut = LibDate.getData(stringa)

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return dataOut
    }

    /**
     * Restituisce l'ora corrente.
     *
     * @return l'ora corrente
     */
    static String getOra() {
        /* variabili e costanti locali di lavoro */
        String stringa = ""
        Timestamp ora
        int pos

        try { // prova ad eseguire il codice

            /* recupera la data di sistema */
            ora = new Timestamp(System.currentTimeMillis())
            stringa = ora.toString()
            stringa = stringa.trim()

            pos = stringa.indexOf(" ")
            stringa = stringa.substring(pos)

            pos = stringa.lastIndexOf(":")
            stringa = stringa.substring(0, pos)
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return stringa
    }

    /**
     * Restituisce la data minore tra due date.
     *
     * @param data1 data da controllare
     * @param data2 data da controllare
     *
     * @return la data minore
     */
    static Date getMin(Date data1, Date data2) {
        /* variabili e costanti locali di lavoro */
        Date dataMin = null

        try { // prova ad eseguire il codice
            if (LibDate.isPrecedente(data1, data2)) {
                dataMin = data2
            } else {
                dataMin = data1
            }// fine del blocco if-else
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return dataMin
    }

    /**
     * Restituisce la data maggiore tra due date.
     *
     * @param data1 prima data
     * @param data2 seconda data
     *
     * @return la data maggiore
     */
    static Date getMax(Date data1, Date data2) {
        /* variabili e costanti locali di lavoro */
        Date dataMax = null;


        try { // prova ad eseguire il codice
            if (LibDate.isPosteriore(data1, data2)) {
                dataMax = data2
            } else {
                dataMax = data1
            }// fine del blocco if-else
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return dataMax
    }

    /**
     * Restituisce la data maggiore tra una serie di date.
     *
     * @param date serie di date
     *
     * @return la data maggiore
     */
    static Date getMax(Date... date) {
        /* variabili e costanti locali di lavoro */
        Date dataMax = null

        try { // prova ad eseguire il codice

            dataMax = date[0]
            for (Date data : date) {
                if (LibDate.isPosteriore(dataMax, data)) {
                    dataMax = data
                }// fine del blocco if
            }
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return dataMax
    }

    /**
     * Restituisce un Timestamp relativo all'ora corrente.
     *
     * @return un Timestamp
     */
    static Timestamp getTimestampCorrente() {
        return new Timestamp(System.currentTimeMillis())
    }

    /**
     * Restituisce un Time relativo all'ora corrente.
     *
     * @return un Time
     */
    static Time getOraCorrente() {
        return new Time(System.currentTimeMillis())
    }

    /**
     * Restituisce i secondi passati dalla mezzanotte di oggi.
     *
     * @return i secondi passati
     */
    static int getSecondiCorrenti() {
        /* variabili e costanti locali di lavoro */
        int secondi = 0
        long mezzanotte
        long adesso
        long diff

        try { // prova ad eseguire il codice
            Calendar cal = new GregorianCalendar()
            cal.setTime(LibDate.getCorrente())
            mezzanotte = cal.getTimeInMillis()
            adesso = System.currentTimeMillis()
            diff = adesso - mezzanotte
            secondi = (int) diff / 1000
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return secondi

    }

    /**
     * Converte una data in stringa.
     * <p/>
     *
     * @param data da convertire
     *
     * @return la stringa corrispondente
     */
    static String getStringa(Date data) {
        /* variabili e costanti locali di lavoro */
        String stringa = ""
        DateFormat formatter

        try { // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                formatter = LibDate.getDateFormat()
                stringa = formatter.format(data)
            }// fine del blocco if
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return stringa
    }

    /**
     * Restituisce la data.
     * <p/>
     *
     * @param data da convertire
     * @param forma selezionata (breve o estesa)
     *
     * @return data nel formato selezionato
     */
    private static String getData(Date dataIn, Forma forma) {
        /* variabili e costanti locali di lavoro */
        String testo = ""
        String giorno
        String mese = ""
        String anno = ""
        String sep = "-"

        try { // prova ad eseguire il codice

            if (dataIn) {
                giorno = ((Integer) LibDate.getNumeroGiorno(dataIn)).toString()

                /* recupera i valori */
                switch (forma) {
                    case Forma.num:
                    case Forma.numerica:
                        mese = ((Integer) LibDate.getNumeroMese(dataIn)).toString()
                        break;
                    case Forma.breve:
                    case Forma.brevissima:
                        mese = LibDate.getMese(dataIn, Forma.breve)
                        break;
                    case Forma.estesa:
                        mese = LibDate.getMese(dataIn, Forma.estesa)
                        mese = LibTesto.primaMaiuscola(mese)
                        break;
                    default: // caso non definito
                        break;
                } // fine del blocco switch

                switch (forma) {
                    case Forma.num:
                        anno = ((Integer) LibDate.getAnno(dataIn)).toString()
                        anno = anno.substring(2)
                        break;
                    case Forma.numerica:
                    case Forma.breve:
                    case Forma.estesa:
                        anno = ((Integer) LibDate.getAnno(dataIn)).toString()
                        break;
                    case Forma.brevissima:
                        break;
                    default: // caso non definito
                        break;
                } // fine del blocco switch

                /* se la forma è estesa usa lo spazio come separatore */
                if (forma.equals(Forma.estesa)) {
                    sep = " "
                }// fine del blocco if

                /* costruisce la stringa */
                testo = giorno
                testo += sep
                testo += mese
                if (anno) {
                    testo += sep
                    testo += anno
                } // fine del blocco if
            }// fine del blocco if


        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return testo
    }

    /**
     * Restituisce la data corrente.
     * <p/>
     *
     * @param forma selezionata (breve o estesa)
     *
     * @return data corrente nel formato selezionato
     */
    private static String getDataCorrente(Forma forma) {
        /* variabili e costanti locali di lavoro */
        String data = ""
        String giorno
        String mese = ""
        String anno = ""
        String sep = "-"

        try { // prova ad eseguire il codice

            giorno = ((Integer) LibDate.getNumeroGiornoCorrente()).toString()

            /* recupera i valori */
            switch (forma) {
                case Forma.num:
                case Forma.numerica:
                    mese = ((Integer) LibDate.getNumeroMeseCorrente()).toString()
                    break;
                case Forma.breve:
                    mese = LibDate.getMeseCorrente(Forma.breve)
                    break;
                case Forma.estesa:
                    mese = LibDate.getMeseCorrente(Forma.estesa)
                    break;
                default: // caso non definito
                    break;
            } // fine del blocco switch

            switch (forma) {
                case Forma.num:
                    anno = ((Integer) LibDate.getAnnoCorrente()).toString()
                    anno = anno.substring(2)
                    break;
                case Forma.numerica:
                case Forma.breve:
                case Forma.estesa:
                    anno = ((Integer) LibDate.getAnnoCorrente()).toString()
                    break;
                default: // caso non definito
                    break;
            } // fine del blocco switch

            /* costruisce la stringa */
            data = giorno
            data += sep
            data += mese
            data += sep
            data += anno

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return data
    }

    /**
     * Restituisce la data corrente.
     * <p/>
     *
     * @return data corrente nel formato 2-9-07
     */
    static String getDataNum() {
        /* invoca il metodo delegato della classe */
        return LibDate.getDataCorrente(Forma.num)
    }

    /**
     * Restituisce la data corrente.
     * <p/>
     *
     * @return data corrente nel formato 2-9-2007
     */
    static String getDataNumerica() {
        /* invoca il metodo delegato della classe */
        return Lib.Date.getDataCorrente(Forma.numerica)
    }

    /**
     * Restituisce la data formattata estesa.
     * <p/>
     *
     * @param data da convertire
     *
     * @return data nel formato esteso
     */
    public static String getDataEstesa(Date data) {
        /* invoca il metodo delegato della classe */
        return LibDate.getData(data, Forma.estesa)
    }

    /**
     * Restituisce la data formattata.
     * <p/>
     *
     * @return data corrente nel formato 2-nov-2007
     */
    static String getDataBreve(Date data) {
        /* invoca il metodo delegato della classe */
        return LibDate.getData(data, Forma.breve)
    }

    /**
     * Restituisce la data formattata.
     * <p/>
     *
     * @return data corrente nel formato 2-nov
     */
    static String getDataBrevissima(Date data) {
        /* invoca il metodo delegato della classe */
        return LibDate.getData(data, Forma.brevissima)
    }

    /**
     * Restituisce la data corrente.
     * <p/>
     *
     * @return data corrente nel formato 2-nov-2007
     */
    static String getDataBreve() {
        /* invoca il metodo delegato della classe */
        return LibDate.getDataCorrente(Forma.breve)
    }

    /**
     * Restituisce la data corrente.
     * <p/>
     *
     * @return data corrente nel formato 2-agosto-2007
     */
    static String getDataEstesa() {
        /* invoca il metodo delegato della classe */
        return LibDate.getDataCorrente(Forma.estesa)
    }

    /**
     * Crea una data.
     * <p/>
     *
     * @param giorno il giorno del mese (1 per il primo)
     * @param mese il mese dell'anno (1 per gennaio)
     * @param anno l'anno
     *
     * @return la data creata
     */
    static Date creaData(int giorno, int mese, int anno) {
        /* variabili e costanti locali di lavoro */
        Date data = null
        Calendar cal

        try { // prova ad eseguire il codice

            cal = Calendar.getInstance()

            cal.set(Calendar.YEAR, anno)
            cal.set(Calendar.MONTH, mese - 1)
            cal.set(Calendar.DAY_OF_MONTH, giorno)

            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.MILLISECOND, 0)

            data = new java.util.Date(cal.getTime().getTime())

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return data
    }

    /**
     * Converte una stringa in data.
     * <p/>
     *
     * @param stringa da convertire
     *
     * @return la data corrispondente
     */
    static Date getData(String stringa) {
        /* variabili e costanti locali di lavoro */
        Date data = null
        DateFormat formatter

        try { // prova ad eseguire il codice
            data = Lib.Date.getVuota()
            if (Lib.Txt.isValida(stringa)) {
                formatter = LibDate.getDateFormat()
                try { // prova ad eseguire il codice
                    data = formatter.parse(stringa)
                } catch (ParseException unErrore) { // intercetta l'errore
                }// fine del blocco try-catch

            }// fine del blocco if
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return data
    }

    /**
     * Restituisce il giorno della settimana.
     * <p/>
     * Giorno scritto per intero <br>
     *
     * @param data da elaborare
     *
     * @return giorno della settimana
     */
    static String getGiorno(Date data) {
        /* variabili e costanti locali di lavoro */
        String giorno = ""
        GregorianCalendar calendario
        int pos

        try { // prova ad eseguire il codice
            if (!Lib.Date.isVuota(data)) {
                calendario = LibDate.getCalendario()
                calendario.setTime(data)
                pos = calendario.get(Calendar.DAY_OF_WEEK)

                /* la settimana inglese comincia da domenica
                 * quella italiana da lunedi */
                pos--

                /* shift della domenica */
                if (pos == 0) {
                    pos = 7
                }// fine del blocco if

                /* nel calendario i giorni della settimana cominciano da 1
                 * la Enumeration comincia da zero */
                pos--

                if ((pos >= 0) && (pos <= 7)) {
                    giorno = LibDate.Giorno.values()[pos].toString()
                }// fine del blocco if
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return giorno
    }

    /**
     * Ritorna l'anno di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return l'anno della data
     */
    static int getAnno(Date data) {
        /* variabili e costanti locali di lavoro */
        int anno = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!Lib.Date.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                anno = cal.get(Calendar.YEAR)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return anno
    }

    /**
     * Ritorna il numero del mese di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero del mese (1 per Gennaio)
     */
    static int getNumeroMese(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!Lib.Date.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.MONTH) + 1
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il nome del mese dato il numero del mese.
     * <p/>
     *
     * @param numMese numero del mese (1 per Gennaio)
     *
     * @return il nome del mese
     */
    public static String getNomeMese(int numMese) {
        /* variabili e costanti locali di lavoro */
        String month = "invalid"

        try { // prova ad eseguire il codice
            DateFormatSymbols dfs = new DateFormatSymbols()
            String[] months = dfs.getMonths()
            if (numMese > 0 && numMese <= 12) {
                month = months[numMese - 1]
            }
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return month
    }

    /**
     * Restituisce il nome del mese.
     * <p/>
     *
     * @param data fornita
     * @param forma breve o estesa
     *
     * @return il nome del mese
     */
    public static String getMese(Date data, Forma forma) {
        /* variabili e costanti locali di lavoro */
        String mese = ""
        int num
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!Lib.Date.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.MONTH)

                switch (forma) {
                    case Forma.breve:
                        mese = LibDate.Mese.getBreve(num)
                        break;
                    case Forma.estesa:
                        mese = LibDate.Mese.getEsteso(num)
                        break;
                    default: // caso non definito
                        break;
                } // fine del blocco switch
            }// fine del blocco if


        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return mese
    }

    /**
     * Ritorna il numero del giorno della settimana di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero del giorno della settimana (1=dom, 7=sab)
     */
    static int getNumeroGiornoSettimana(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.DAY_OF_WEEK)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il numero del giorno del mese di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero del giorno del mese
     */
    static int getNumeroGiorno(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.DAY_OF_MONTH)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il numero del giorno nell'anno di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero del giorno nell'anno
     */
    static int getNumeroGiornoInAnno(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.DAY_OF_YEAR)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il numero del giorno del mese di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero del giorno del mese
     */
    public static int getNumeroGiornoInMese(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.DAY_OF_MONTH)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il numero della settimana nell'anno di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero della settimana nell'anno
     */
    static int getNumeroSettimanaInAnno(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.WEEK_OF_YEAR)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna la data del primo lunedì di una data settimana.
     * <p/>
     *
     * @param numSett il numero di settimana
     * @param anno l'anno al quale il numero di settimana è riferito
     *
     * @return il primo giorno (lunedì) della settimana data
     */
    public static Date getPrimoGiornoSettimana(int numSett, int anno) {
        /* variabili e costanti locali di lavoro */
        Date data = null

        try { // prova ad eseguire il codice
            Calendar cal = Calendar.getInstance()
            cal.set(Calendar.YEAR, anno)
            cal.set(Calendar.HOUR, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.WEEK_OF_YEAR, numSett)
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
            data = cal.getTime()
            data = dropTime(data)
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return data
    }

    /**
     * Ritorna il numero delle ore di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero delle ore
     */
    static int getNumeroOre(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.HOUR_OF_DAY)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il numero dei minuti di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero dei minuti
     */
    static int getNumeroMinuti(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.MINUTE)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna il numero dei secondi di una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return il numero dei secondi
     */
    static int getNumeroSecondi(Date data) {
        /* variabili e costanti locali di lavoro */
        int num = 0
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            if (!LibDate.isVuota(data)) {
                cal = LibDate.getCalendario()
                cal.setTime(data)
                num = cal.get(Calendar.SECOND)
            }// fine del blocco if
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return num
    }

    /**
     * Ritorna l'anno corrente.
     * <p/>
     *
     * @return l'anno della data corrente
     */
    static int getAnnoCorrente() {
        return getAnno(getCorrente())
    }

    /**
     * Ritorna il numero del mese corrente.
     * <p/>
     *
     * @return il numero del mese corrente
     */
    static int getNumeroMeseCorrente() {
        return getNumeroMese(getCorrente())
    }

    /**
     * Ritorna il mese corrente.
     * <p/>
     *
     * @param forma selezionata (breve o estesa)
     *
     * @return mese corrente nella forma selezionata
     */
    private static String getMeseCorrente(Forma forma) {
        return getMese(getCorrente(), forma)
    }

    /**
     * Ritorna il numero del giorno corrente.
     * <p/>
     *
     * @return il numero del giorno corrente
     */
    static int getNumeroGiornoCorrente() {
        return getNumeroGiorno(getCorrente())
    }

    /**
     * Ritorna il numero dell'ora corrente.
     * <p/>
     *
     * @return il numero dell'ora corrente
     */
    static int getNumeroOreCorrente() {
        return getNumeroOre(getTimestampCorrente())
    }

    /**
     * Ritorna il numero di minuti corrente.
     * <p/>
     *
     * @return il numero di minuti corrente
     */
    static int getNumeroMinutiCorrente() {
        return getNumeroMinuti(getTimestampCorrente())
    }

    /**
     * Ritorna il numero di secondi corrente.
     * <p/>
     *
     * @return il numero di secondi corrente
     */
    static int getNumeroSecondiCorrente() {
        return getNumeroSecondi(getTimestampCorrente())
    }

    /**
     * Ritorna la data corrispondente all'ultimo giorno del mese relativo a una data fornita.
     * <p/>
     *
     * @param data fornita
     *
     * @return la data rappresentante l'ultimo giorno del mese
     */
    static Date getFineMese(Date data) {
        /* variabili e costanti locali di lavoro */
        Date dataFM = null
        int num
        GregorianCalendar cal

        try {    // prova ad eseguire il codice
            cal = LibDate.getCalendario()
            cal.setTime(data)
            num = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
            cal.set(Calendar.DAY_OF_MONTH, num)
            dataFM = cal.getTime()
        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return dataFM
    }

    /**
     * Ritorna una matrice di date comprese nel periodo
     * <p/>
     *
     * @param dataIniPeriodo inizio del periodo
     * @param dataFinePeriodo fine del periodo da controllare
     *
     * @return matrice di date comprese nel periodo
     */
    static Date[] getDateComprese(Date dataIniPeriodo, Date dataFinePeriodo) {
        /* variabili e costanti locali di lavoro */
        Date[] matrice = new Date[0]
        boolean continua
        int giorni

        try { // prova ad eseguire il codice
            /* controllo di congruità */
            continua = (Lib.Clas.isValidi(dataIniPeriodo, dataFinePeriodo))

            if (continua) {
                continua = Lib.Date.isPosterioreUguale(dataIniPeriodo, dataFinePeriodo)
            }// fine del blocco if

            if (continua) {
                giorni = Lib.Date.diff(dataFinePeriodo, dataIniPeriodo)
                matrice = new Date[giorni + 1]

                for (int k = 0; k < matrice.length; k++) {
                    matrice[k] = Lib.Date.add(dataIniPeriodo, k)
                } // fine del ciclo for

            }// fine del blocco if
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return matrice
    }

    /**
     * Ordina cronologicamente una mappa di date.
     * <p/>
     *
     * @param mappa di date/valore, da ordinare
     *
     * @return mappa con la chiave data, ordinata cronologicamente
     */
    static LinkedHashMap<Date, Double> ordinaMappa(LinkedHashMap<Date, Double> mappa) {
        /* variabili e costanti locali di lavoro */
        LinkedHashMap<Date, Double> mappaOut = null
        boolean continua
        Date[] finale = null
        int cont = 0
        Date giorno
        double valore

        try { // prova ad eseguire il codice
            continua = (mappa != null && mappa.size() > 0)

            /* costruisco una matrice di appoggio per ordinare le date */
            if (continua) {
                finale = new Date[mappa.size()]
                for (Date data : mappa.keySet()) {
                    finale[cont] = data
                    cont++
                } // fine del ciclo for-each
                Arrays.sort(finale)
            }// fine del blocco if

            /* spazzolo la matrice e costruisco un record ogni volta che cambia il valore */
            if (continua) {
                mappaOut = new LinkedHashMap<Date, Double>()
                for (int k = 0; k < finale.length; k++) {
                    giorno = finale[k]
                    valore = mappa.get(giorno)
                    mappaOut.put(giorno, valore)
                } // fine del ciclo for
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return mappaOut
    }

    /**
     * Costruisce la data per il 1° gennaio dell'anno in corso.
     * <p/>
     *
     * @return primo gennaio dell'anno corrente
     */
    static Date getPrimoGennaio() {
        /* variabili e costanti locali di lavoro */
        Date primo = null
        int anno

        try { // prova ad eseguire il codice
            anno = Lib.Date.getAnnoCorrente()
            primo = getPrimoGennaio(anno)
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return primo
    }

    /**
     * Costruisce la data per il 1° gennaio dell'anno indicato.
     * <p/>
     *
     * @param anno di riferimento
     *
     * @return primo gennaio dell'anno
     */
    static Date getPrimoGennaio(int anno) {
        /* variabili e costanti locali di lavoro */
        Date primo = null

        try { // prova ad eseguire il codice
            primo = Lib.Date.creaData(1, 1, anno)
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return primo
    }

    /**
     * Costruisce la data per il 31° dicembre dell'anno indicato.
     * <p/>
     *
     * @param anno di riferimento
     *
     * @return ultimo dell'anno
     */
    static Date getTrentunoDicembre(int anno) {
        /* variabili e costanti locali di lavoro */
        Date primo = null

        try { // prova ad eseguire il codice
            primo = Lib.Date.creaData(31, 12, anno)
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return primo
    }

    /**
     * Restituisce un intero che identifica il numero progressivo di un dato giorno dell'anno.
     * <p/>
     * I giorni sono collocati su una matrice di 31 righe e 12 colonne
     * quindi questa funzione può restituire anche il numero progressivo
     * di giorni non esistenti nel calendario.
     *
     * @param giorno numero del giorno (da 1 a 31)
     * @param mese numero del mese (da 1 a 12)
     *
     * @return il numero progressivo del giorno, 0 se fuori range
     */
    public static int getIndiceGiornoDellAnno(int giorno, int mese) {
        /* variabili e costanti locali di lavoro */
        int progressivo = 0
        boolean continua

        try { // prova ad eseguire il codice

            continua = ((giorno > 0) && (giorno <= 31))

            if (continua) {
                continua = ((mese > 0) && (mese <= 12))
            }// fine del blocco if

            if (continua) {
                progressivo = (31 * (mese - 1)) + giorno
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return progressivo
    }




    private static SimpleDateFormat getDateFormat() {
        return dateFormat
    }


    private static void setDateFormat(SimpleDateFormat dateFormat) {
        LibDate.dateFormat = dateFormat
    }


    private static SimpleDateFormat getShortDateFormat() {
        return shortDateFormat
    }


    private static void setShortDateFormat(SimpleDateFormat shortDateFormat) {
        LibDate.shortDateFormat = shortDateFormat
    }


    private static GregorianCalendar getCalendario() {
        return calendario
    }

    //private static void setCalendario(GregorianCalendar calendario) {
    //    LibDate.calendario = calendario;
    //}


    private static Date getDataVuota() {
        return LibDate.dataVuota
    }


    private static void setDataVuota(Date dataVuota) {
        LibDate.dataVuota = dataVuota
    }

    /**
     * Classe interna Enumerazione.
     */
    public enum Giorno {

        lunedi(),
        martedi(),
        mercoledi(),
        giovedi(),
        venerdi(),
        sabato(),
        domenica()

    }// fine della classe

    /**
     * Classe interna Enumerazione.
     */
    public static enum Mese {

        gen("gen", "gennaio"),
        feb("feb", "febbraio"),
        mar("mar", "marzo"),
        apr("apr", "aprile"),
        mag("mag", "maggio"),
        giu("giu", "giugno"),
        lug("lug", "luglio"),
        ago("ago", "agosto"),
        set("set", "settembre"),
        ott("ott", "ottobre"),
        nov("nov", "novembre"),
        dic("dic", "dicembre");

        /**
         * nome breve
         */
        private String breve

        /**
         * nome esteso
         */
        private String esteso

        /**
         * Costruttore completo con parametri.
         *
         * @param breve (gen)
         * @param esteso (gennaio)
         */
        Mese(String breve, String esteso) {
            try { // prova ad eseguire il codice
                /* regola le variabili di istanza coi parametri */
                setBreve(breve)
                setEsteso(esteso)
            } catch (Exception unErrore) { // intercetta l'errore
            }// fine del blocco try-catch
        }

        /**
         * Restituisce il nome breve del mese (3 caratteri).
         * <p/>
         *
         * @param num del mese (cominciando da 1)
         *
         * @return nome breve del mese (gennaio = 1)
         */
        public static String getBreve(int num) {
            /* variabili e costanti locali di lavoro */
            String nome = ""

            try { // prova ad eseguire il codice

                /* traverso tutta la collezione */
                for (Mese mese : Mese.values()) {
                    if (mese.ordinal() == num) {
                        nome = mese.getBreve()
                        break
                    }// fine del blocco if
                } // fine del ciclo for-each

            } catch (Exception unErrore) { // intercetta l'errore
            }// fine del blocco try-catch

            /* valore di ritorno */
            return nome
        }

        /**
         * Restituisce il nome del mese (esteso).
         * <p/>
         *
         * @param num del mese (cominciando da 1)
         *
         * @return nome esteso del mese (gennaio = 1)
         */
        public static String getEsteso(int num) {
            /* variabili e costanti locali di lavoro */
            String nome = ""

            try { // prova ad eseguire il codice

                /* traverso tutta la collezione */
                for (Mese mese : Mese.values()) {
                    if (mese.ordinal() == num) {
                        nome = mese.getEsteso()
                        break
                    }// fine del blocco if
                } // fine del ciclo for-each

            } catch (Exception unErrore) { // intercetta l'errore
            }// fine del blocco try-catch

            /* valore di ritorno */
            return nome
        }


        public String getBreve() {
            return breve
        }


        private void setBreve(String breve) {
            this.breve = breve
        }


        public String getEsteso() {
            return esteso
        }


        private void setEsteso(String esteso) {
            this.esteso = esteso
        }
    }// fine della classe

    /**
     * Classe interna Enumerazione.
     */
    public static enum Forma {

        num(),
        numerica(),
        breve(),
        brevissima(),
        estesa()

    }// fine della classe

}// fine della classe
