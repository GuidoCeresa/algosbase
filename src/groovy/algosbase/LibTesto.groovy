package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 08:12
 * To change this template use File | Settings | File Templates.
 */
public class LibTesto {

    // tag per il carattere punto
    public static final String PUNTO = '.'

    // tag per il carattere barra
    public static final String BARRA = '/'

    // tag per la stringa vuota
    public static final String VUOTA = ''

    // tag per la stringa spazio
    public static final String SPAZIO = ' '

    // tag per la stringa virgola
    public static final String VIRGOLA = ','

    // tag per la stringa tabulatore
    public static final String TAB = '\t'

    // tag per la stringa a capo
    public static final String CR = '\n'

    // tag per il valore falso per una posizione
    public static final int INT_NULLO = -1

    /**
     * Forza il primo carattere della stringa a maiuscolo
     * Restituisce una stringa
     * Un numero ritorna un numero
     * Un nullo ritorna un nullo
     * Un oggetto non stringa ritorna uguale
     *
     * @param entrata stringa in ingresso
     * @return uscita string in uscita
     */
    public static primaMaiuscola(entrata) {
        // variabili e costanti locali di lavoro
        def uscita = entrata
        String primo
        String rimanente

        if (entrata && entrata in String) {
            primo = entrata.substring(0, 1)
            primo = primo.toUpperCase()
            rimanente = entrata.substring(1)
            uscita = primo + rimanente
        }// fine del blocco if

        // valore di ritorno
        return uscita
    } // fine del metodo statico

    /**
     * Forza il primo carattere della stringa a minuscolo
     * Restituisce una stringa
     * Un numero ritorna un numero
     * Un nullo ritorna un nullo
     * Un oggetto non stringa ritorna uguale
     * @param entrata stringa in ingresso
     * @return uscita string in uscita
     */
    public static primaMinuscola(entrata) {
        // variabili e costanti locali di lavoro
        def uscita = entrata
        String primo
        String rimanente

        if (entrata && entrata in String) {
            primo = entrata.substring(0, 1)
            primo = primo.toLowerCase()
            rimanente = entrata.substring(1)
            uscita = primo + rimanente
        }// fine del blocco if

        // valore di ritorno
        return uscita
    } // fine del metodo statico

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
     * @return uscita stringa convertita
     */
    public static levaTesta(entrata, testa) {
        // variabili e costanti locali di lavoro
        def uscita = entrata

        if (entrata && entrata in String && testa in String) {
            uscita = entrata.trim()
            if (testa && uscita.startsWith(testa)) {
                uscita = uscita.substring(testa.length())
                uscita = uscita.trim()
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return uscita
    } // fine del metodo statico

    /**
     * Elimina la coda terminale della stringa, se esiste.
     * <p/>
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca la coda, restituisce la stringa
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param stringaIn testo in ingresso
     * @param coda da eliminare
     * @return stringa convertita
     */
    public static levaCoda(entrata, coda) {
        // variabili e costanti locali di lavoro
        def uscita = entrata

        if (entrata && entrata in String && coda in String) {
            uscita = uscita.trim()
            coda = coda.trim()
            if (coda && uscita.endsWith(coda)) {
                uscita = uscita.substring(0, uscita.length() - coda.length())
                uscita = uscita.trim()
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return uscita
    } // fine del metodo statico

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
    public static sostituisce(testoIn, oldStringa, newStringa) {
        // variabili e costanti locali di lavoro
        def testoOut = testoIn
        int pos = 0
        String prima = VUOTA
        String dopo

        if (testoIn in String && oldStringa in String && newStringa in String) {
            testoOut = testoIn.trim()
            if (testoIn.contains(oldStringa)) {

                while (pos != INT_NULLO) {
                    pos = testoIn.indexOf(oldStringa)
                    if (pos != INT_NULLO) {
                        prima += testoIn.substring(0, pos)
                        prima += newStringa
                        pos += oldStringa.length()
                        testoIn = testoIn.substring(pos)
                    }// fine del blocco if
                }// fine di while

                testoOut = prima + testoIn
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return testoOut
    } // fine del metodo statico

    /**
     * Elimina da una stringa tutti i caratteri indicati.
     * <p/>
     * Esegue solo se il testo è valido
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param testoIn in ingresso
     * @param subStringa da eliminare
     * @return testoOut stringa convertita
     */
    public static levaTesto(testoIn, subStringa) {
        // variabili e costanti locali di lavoro
        def testoOut = testoIn

        if (testoIn in String) {
            testoOut = testoIn.trim()
            if (testoOut.contains(subStringa)) {
                testoOut = LibTesto.sostituisce(testoOut, subStringa, VUOTA)
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return testoOut
    } // fine del metodo statico

    /**
     * Elimina tutti i punti contenuti nella stringa.
     * <p/>
     * Esegue solo se la stringa è valida
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @return uscita stringa convertita
     */
    public static levaPunti(entrata) {
        return LibTesto.levaTesto(entrata, PUNTO)
    } // fine del metodo statico

    /**
     * Elimina tutte le virgole contenute nella stringa.
     * <p/>
     * Esegue solo se la stringa è valida
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @return uscita stringa convertita
     */
    public static levaVirgole(entrata) {
        return LibTesto.levaTesto(entrata, VIRGOLA)
    } // fine del metodo statico

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
    public static formatNum(numero) {
        // variabili e costanti locali di lavoro
        def formattato = numero
        String sep = PUNTO
        int len
        String num3
        String num6
        String num9
        String num12

        // controllo di congruità
        if (numero in String || numero in Integer || numero in Double || numero in BigDecimal) {
            formattato = VUOTA

            if (numero in String) {
                numero = LibTesto.levaVirgole(numero)
                numero = LibTesto.levaPunti(numero)
                formattato = numero

                try { // prova ad eseguire il codice
                    Integer.decode(numero)
                    len = numero.length()
                    if (len > 3) {
                        num3 = numero.substring(0, len - 3)
                        num3 += sep
                        num3 += numero.substring(len - 3)
                        formattato = num3
                        if (len > 6) {
                            num6 = num3.substring(0, len - 6)
                            num6 += sep
                            num6 += num3.substring(len - 6)
                            formattato = num6
                            if (len > 9) {
                                num9 = num6.substring(0, len - 9)
                                num9 += sep
                                num9 += num6.substring(len - 9)
                                formattato = num9
                                if (len > 12) {
                                    num12 = num9.substring(0, len - 12)
                                    num12 += sep
                                    num12 += num9.substring(len - 12)
                                    formattato = num12
                                }// fine del blocco if
                            }// fine del blocco if
                        }// fine del blocco if
                    }// fine del blocco if
                } catch (Exception unErrore) { // intercetta l'errore
                }// fine del blocco try-catch
            }// fine del blocco if

            if (numero in Integer) {
                formattato = formatNum(numero.toString())
            }// fine del blocco if

            if (numero in BigDecimal) {
                formattato = formatNum(numero.toString())
            }// fine del blocco if

        }// fine del blocco if

        // valore di ritorno
        return formattato
    }

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
    public static getPos(testo, lista) {
        // variabili e costanti locali di lavoro
        int pos = INT_NULLO
        int posTmp
        List posizioni = new ArrayList()
        def minimo

        if (testo && testo in String && lista) {

            if (lista in Integer) {
                pos = testo.indexOf(lista.toString())
            }// fine del blocco if

            if (lista in String) {
                pos = testo.indexOf(lista)
            }// fine del blocco if

            if (lista in List) {
                lista.each {
                    posTmp = testo.indexOf(it)
                    if (posTmp != INT_NULLO) {
                        posizioni.add(posTmp)
                    }// fine del blocco if
                }// fine di each

                if (posizioni.size() > 0) {
                    minimo = posizioni.min()
                    if (minimo && minimo in Integer) {
                        pos = (int) minimo
                    }// fine del blocco if
                }// fine del blocco if
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return pos
    } // fine del metodo statico

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
    public static estrae(String testo, String tagIni, String tagEnd) {
        String contenuto = testo
        int posIni
        int posEnd

        if (testo && tagIni && tagEnd) {
            posIni = testo.indexOf(tagIni)
            posEnd = testo.indexOf(tagEnd)

            if (posIni > -1 && posEnd > -1) {
                posIni += tagIni.length()
                contenuto = testo.substring(posIni, posEnd).trim()
            }// fine del blocco if

        }// fine del blocco if

        return contenuto
    } // fine del metodo statico

}// fine della classe statica