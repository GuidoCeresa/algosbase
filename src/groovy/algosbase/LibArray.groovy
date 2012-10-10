package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 09:00
 * To change this template use File | Settings | File Templates.
 */
public class LibArray {

    // Estrae i valori unici da un array con (eventuali) valori doppi
    // Ordina l'array
    // @param valoriDoppi
    // @return valoriUnici ordinati
    public static List valoriUnici(List valoriDoppi) {
        List valoriUnici = valoriDoppi
        Set set

        if (valoriDoppi) {
            set = new HashSet(valoriDoppi)
            if (set) {
                valoriUnici = new ArrayList(set)
            }// fine del blocco if
            valoriUnici.sort()
        }// fine del blocco if

        return valoriUnici
    } // fine del metodo

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

    public static List sommaDisordinata(arrayPrimo, arraySecondo) {
        // variabili e costanti locali di lavoro
        List arraySomma = null

        if (arrayPrimo == null && arraySecondo in List) {
            arraySomma = arraySecondo
        }// fine del blocco if

        if (arrayPrimo in List && arraySecondo == null) {
            arraySomma = arrayPrimo
        }// fine del blocco if

        if (arrayPrimo && arraySecondo) {

            if (arrayPrimo in List && arraySecondo in List) {
                if (arrayPrimo[0].class == arraySecondo[0].class) {
                    arraySomma = LibArray.valoriUnici(arrayPrimo + arraySecondo)
                }// fine del blocco if
            }// fine del blocco if

            if (arrayPrimo in List && !(arraySecondo in List)) {
                if (arrayPrimo[0].class == arraySecondo.class) {
                    arraySomma = arrayPrimo
                    arraySomma.add(arraySecondo)
                }// fine del blocco if
            }// fine del blocco if

            if (!(arrayPrimo in List) && arraySecondo in List) {
                if (arrayPrimo.class == arraySecondo[0].class) {
                    arraySomma = arraySecondo
                    arraySomma.add(arrayPrimo)
                }// fine del blocco if
            }// fine del blocco if

            if (arraySomma) {
                arraySomma = LibArray.valoriUnici(arraySomma)
            }// fine del blocco if

        }// fine del blocco if

        // valore di ritorno
        return arraySomma
    } // fine della closure

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
     *
     * @return arraySomma ordinato
     */

    public static somma(arrayPrimo, arraySecondo) {
        // variabili e costanti locali di lavoro
        def arraySomma = null

        if (arrayPrimo || arraySecondo) {
            arraySomma = LibArray.sommaDisordinata(arrayPrimo, arraySecondo)
            arraySomma?.sort()
        }// fine del blocco if

        // valore di ritorno
        return arraySomma
    } // fine della closure

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
     * Se il secondo parametro non è una lista, ma è della stessa classe del primo, restituisce la differenza
     * Se il secondo parametro non è una lista, ed è di classe diversa dal primo, restituisce un nullo
     *
     * @param arrayPrimo
     * @param arraySecondo
     *
     * @return arrayDifferenza disordinato
     */

    static differenzaDisordinata(arrayPrimo, arraySecondo) {
        // variabili e costanti locali di lavoro
        def arrayDifferenza = null

        if (arraySecondo == null) {
            return arrayPrimo
        }// fine del blocco if

        if (arraySecondo in List && arraySecondo.size() == 0) {
            return arrayPrimo
        }// fine del blocco if

        if (arrayPrimo && arrayPrimo in List) {

            if (arraySecondo in List) {
                if (arrayPrimo[0].class == arraySecondo[0].class) {
                    arrayDifferenza = new ArrayList()
                    arrayPrimo.each {
                        if (!arraySecondo.contains(it)) {
                            arrayDifferenza.add(it)
                        }// fine del blocco if
                    }// fine di each
                }// fine del blocco if
            } else {
                if (arrayPrimo[0].class == arraySecondo.class) {
                    arrayDifferenza = new ArrayList()
                    arrayPrimo.each {
                        if (arraySecondo != it) {
                            arrayDifferenza.add(it)
                        }// fine del blocco if
                    }// fine di each
                }// fine del blocco if
            }// fine del blocco if-else

        }// fine del blocco if

        // valore di ritorno
        return arrayDifferenza
    } // fine della closure

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
     *
     * @return arrayDifferenza ordinata
     */

    static differenza(arrayPrimo, arraySecondo) {
        // variabili e costanti locali di lavoro
        def arrayDifferenza = null

        if (arrayPrimo) {
            arrayDifferenza = LibArray.differenzaDisordinata(arrayPrimo, arraySecondo)
            arrayDifferenza?.sort()
        }// fine del blocco if

        // valore di ritorno
        return arrayDifferenza
    } // fine della closure

    /**
     * Aggiunge un elemento alla lista solo se non già esistente
     *
     * @param array
     * @param elemento
     *
     * @return vero se l'elemento è stato aggiunto
     */

    static add(array, elemento) {
        // variabili e costanti locali di lavoro
        boolean aggiunto = false

        if (!array.contains(elemento)) {
            aggiunto = array.add(elemento)
        }// fine del blocco if

        // valore di ritorno
        return aggiunto
    } // fine della closure

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

    static ordinaMappa(Map mappaIn) {
        /* variabili e costanti locali di lavoro */
        LinkedHashMap mappaOut = null
        Set insieme
        List lista
        int pos
        Object valore

        try { // prova ad eseguire il codice
            insieme = mappaIn.keySet()
            lista = insieme.asList()
            Collections.sort(lista)
            mappaOut = new LinkedHashMap()

            /* traverso tutta la collezione */
            for (Object chiave : lista) {
                valore = mappaIn.get(chiave)
                mappaOut.put(chiave, valore)
            } // fine del ciclo for-each
        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return mappaOut
    } // fine della closure

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

    static ArrayList<String> creaLista(String testo, String sep) {
        /* variabili e costanti locali di lavoro */
        ArrayList<String> lista = null
        String[] array

        try { // prova ad eseguire il codice
            /* protezione in ingresso */
            if (testo == null) {
                testo = ''
            }// fine del blocco if

            /* crea l'istanza di ritorno */
            lista = new ArrayList<String>()

            /* estrazione della matrice di stringhe */
            /* non uso Lib.Testo.isValida per gestire anche il tab \t */
            if ((sep != null) && (!sep.equals(' ')) && (!sep.equals(''))) {
                array = testo.split(sep)
            } else {
                array = new String[1]
                array[0] = testo
            }// fine del blocco if-else

            /* spazzola la collezione */
            for (String stringa : array) {
                if (stringa) {
                    lista.add(stringa.trim())
                }// fine del blocco if
            } // fine del ciclo for-each

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return lista
    }// fine del metodo

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
     *
     * @return una lista contenente le parti di stringa separate
     */

    static ArrayList<String> creaLista(String testo) {
        /* variabili e costanti locali di lavoro */
        String sep = ','

        /* invoca il metodo delegato della classe */
        return LibArray.creaLista(testo, sep)
    } // fine del metodo

    /**
     * Converte un array di stringhe in una lista di stringhe.
     * <p/>
     * Esegue solo se l'array non è nullo <br>
     *
     * @param array da convertire
     *
     * @return lista di stringhe contenente gli elementi dell'array
     */

    static ArrayList<String> creaLista(String[] array) {
        /* variabili e costanti locali di lavoro */
        ArrayList<String> lista = null
        boolean continua

        try {    // prova ad eseguire il codice
            /* controllo di congruità all'ingresso */
            continua = (array != null)

            /* crea l'istanza */
            if (continua) {
                lista = new ArrayList<String>()
            }// fine del blocco if

            /* spazzola tutta la collezione */
            if (continua) {
                for (String stringa : array) {
                    lista.add(stringa)
                } // fine del ciclo for-each
            }// fine del blocco if

        } catch (Exception unErrore) {    // intercetta l'errore
        } // fine del blocco try-catch

        /* valore di ritorno */
        return lista
    } // fine del metodo

    /**
     * Converte un array di interi in una lista di Integer.
     * <p/>
     * Esegue solo se l'array non è nullo <br>
     *
     * @param array da convertire
     *
     * @return lista di interi contenente gli elementi dell'array
     */

    static ArrayList<Integer> creaLista(int[] array) {
        /* variabili e costanti locali di lavoro */
        ArrayList<Integer> lista = null
        boolean continua

        try { // prova ad eseguire il codice
            /* controllo di congruità all'ingresso */
            continua = (array != null)

            /* crea l'istanza */
            if (continua) {
                lista = new ArrayList<Integer>()
            }// fine del blocco if

            /* spazzola tutta la collezione */
            if (continua) {
                for (Integer intero : array) {
                    lista.add(intero)
                } // fine del ciclo for-each
            }// fine del blocco if

        } catch (Exception unErrore) { // intercetta l'errore
        }// fine del blocco try-catch

        /* valore di ritorno */
        return lista
    } // fine del metodo

    // Elabora una lista di stringhe
    // Ogni riga elimina gli spazi vuoti iniziali e finali
    //
    // @param listaIn ingresso
    // @return listaOut uscita
    public static ArrayList<String> trimRighe(ArrayList<String> listaIn) {
        // variabili e costanti locali di lavoro
        ArrayList<String> listaOut = null

        if (listaIn) {
            listaOut = new ArrayList<String>()
            listaIn?.each {
                listaOut.add(it.trim())
            } // fine del ciclo each
        }// fine del blocco if

        // valore di ritorno
        return listaOut
    } // fine del metodo statico

    // Estrae i blocchi da un testo
    // Blocchi separati da un separatore
    // Esegue solo se il testo è valido
    // Se arriva un oggetto non stringa, restituisce null
    //
    // @param testo in ingresso
    // @param sep separatore in ingresso
    // @return array di righe
    public static ArrayList<String> getBlocchi(testo, sep) {
        // variabili e costanti locali di lavoro
        ArrayList<String> blocchi = null
        def split

        if (testo && testo in String && sep && sep in String) {
            split = testo.split(sep)
            if (split && split in String[]) {
                blocchi = LibArray.creaLista(split)
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return blocchi
    } // fine del metodo statico

    // Estrae le righe da un testo
    // Esegue solo se il testo è valido
    // Se arriva un oggetto non stringa, restituisce null
    //
    // @param testo in ingresso
    // @return array di righe
    public static ArrayList<String> getRighe(testo) {
        // variabili e costanti locali di lavoro
        ArrayList<String> righe = null
        def split

        if (testo && testo in String) {
            split = testo.split('\n')
            if (split && split in String[]) {
                righe = LibArray.creaLista(split)
                righe = LibArray.trimRighe(righe)
            }// fine del blocco if

        }// fine del blocco if

        // valore di ritorno
        return righe
    } // fine del metodo statico

    // Estrae le righe da un testo
    // Esegue solo se il testo è valido
    // Se arriva un oggetto non stringa, restituisce null
    // Ogni riga elimina gli spazi vuoti iniziali e finali
    //
    // @param testo in ingresso
    // @return array di righe
    public static ArrayList<String> getRigheTrim(testo) {
        // variabili e costanti locali di lavoro
        ArrayList<String> righe = LibArray.getRighe(testo)

        if (righe && righe.size() > 0) {
            righe = LibArray.trimRighe(righe)
        }// fine del blocco if

        // valore di ritorno
        return righe
    } // fine del metodo statico

    // Estrae le parole singole (separate da spazio) da un testo
    // Esegue solo se il testo è valido
    // Se arriva un oggetto non stringa, restituisce null
    // Ogni parola elimina gli spazi vuoti iniziali e finali
    //
    // @param testo in ingresso
    // @return array di parole
    public static ArrayList<String> getWords(testo) {
        // variabili e costanti locali di lavoro
        ArrayList<String> parole = null
        StringTokenizer tok

        if (testo && testo in String) {
            tok = new StringTokenizer(testo)
            if (tok) {
                parole = new ArrayList<String>()
                while (tok.hasMoreTokens()) {
                    parole.add(tok.nextToken())
                }
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return parole
    } // fine del metodo statico

}// fine della classe statica
