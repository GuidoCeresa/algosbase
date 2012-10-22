package algosbase

import org.apache.commons.logging.LogFactory

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 5-10-12
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
class LibMat {

    private static def log = LogFactory.getLog(this)

    /**
     * Controlla se il numero è pari
     *
     * @param num da controllare
     * @return vero se è pari
     */
    public static boolean isPari(def num) {
        // variabili e costanti locali di lavoro
        boolean pari = false
        int meta
        int doppio

        if (num && num in Number) {
            meta = num / 2
            doppio = meta * 2
            if (doppio == num) {
                pari = true
            }// fine del blocco if
        } else {
            log.warn 'il parametro non è un numero'
        }// fine del blocco if-else

        // valore di ritorno
        return pari
    } // fine del metodo

    /**
     * Controlla se il numero è dispari
     *
     * @param num da controllare
     * @return vero se è dispari
     */
    public static isDispari(Number num) {
        // variabili e costanti locali di lavoro
        boolean dispari = false
        boolean pari

        if (num && num in Number) {
            pari = LibMat.isPari(num)
            dispari = !pari
        } else {
            log.warn 'il parametro non è un numero'
        }// fine del blocco if-else

        // valore di ritorno
        return dispari
    } // fine del metodo

    /**
     * Controlla se il numero è divisibile per 3
     *
     * @param num da controllare
     * @return vero se è divisibile
     */
    public static boolean isDivisibileTre(def num) {
        // variabili e costanti locali di lavoro
        boolean divisibile = false
        int meta
        int triplo

        if (num && num in Number) {
            meta = num / 3
            triplo = meta * 3
            if (triplo == num) {
                divisibile = true
            }// fine del blocco if
        } else {
            log.warn 'il parametro non è un numero'
        }// fine del blocco if-else


        // valore di ritorno
        return divisibile
    } // fine del metodo

    /**
     * Controlla se il numero NON è divisibile per 3
     *
     * @param num da controllare
     * @return vero se NON è divisibile
     */
    public static boolean isNotDivisibileTre(def num) {
        // valore di ritorno
        return !LibMat.isDivisibileTre(num)
    } // fine del metodo

    /**
     * Divisione tra due numeri arrotondata all'intero più vicino
     * (superiore od inferiore)
     *
     * @param primo numero
     * @param secondo numero
     * @return intero arrotondato
     */
    static int divRound(Number numeratore, Number denominatore) {
        /* variabili e costanti locali di lavoro */
        int risultato = 0
        double doppio

        if (numeratore && denominatore) {
            if (denominatore > 0 || denominatore < 0) {
                doppio = (numeratore / denominatore)
                if (doppio) {
                    doppio = doppio.round()
                    risultato = (int)doppio
                }// fine del blocco if
            }// fine del blocco if
        }// fine del blocco if

        /* valore di ritorno */
        return risultato
    } // fine del metodo

    /**
     * Resto dopo una divisione per tre
     *
     * @param num da controllare
     * @return resto:
     *          zero se il numero è divisibile per 3
     *          uno se il resto è 1
     *          due se il resto è 2
     */
    static int restoDivisioneTre(def num) {
        /* variabili e costanti locali di lavoro */
        int resto = 0
        def restoTemp

        if (num && num in Number) {
            if (LibMat.isNotDivisibileTre(num)) {
                resto = num % 3
            }// fine del blocco if
        } else {
            log.warn 'il parametro non è un numero'
        }// fine del blocco if-else

        // valore di ritorno
        return resto
    } // fine test

}// fine della classe statica
