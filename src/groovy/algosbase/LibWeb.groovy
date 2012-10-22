package algosbase

import org.apache.commons.logging.LogFactory

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 4-10-12
 * Time: 09:09
 * To change this template use File | Settings | File Templates.
 */
class LibWeb {

    private static def log = LogFactory.getLog(this)

    /**
     * Legge dal web una pagina.
     * Esegue solo se il domain è valido
     *
     * @param domain URL del sito (pagina)
     * @return testo html della pagina
     */
    public static String legge(String domain) {
        return LibWeb.legge(domain, '')
    } // fine del metodo

    /**
     * Legge dal web una pagina.
     * Esegue solo se il domain è valido
     *
     * @param domain URL del sito (pagina)
     * @param cookies da regolare
     * @return testo html della pagina
     */
    public static String legge(String domain, String cookies) {
        // variabili e costanti locali di lavoro
        String testo
        boolean continua = false
        URLConnection connection = null
        InputStream input = null
        InputStreamReader inputReader = null
        BufferedReader readBuffer = null
        StringBuffer textBuffer = new StringBuffer()
        String stringa

        if (domain) {
            continua = true
        }// fine del blocco if

        // find the target
        if (continua) {
            try { // prova ad eseguire il codice
                connection = new URL(domain).openConnection()
                connection = this.regolaConnessione(connection, cookies)
            } catch (Exception unErrore) { // intercetta l'errore
                log.error unErrore
            }// fine del blocco try-catch

            continua = (connection != null)
        }// fine del blocco if

        // regola l'entrata
        if (continua) {
            input = connection.getInputStream()
            inputReader = new InputStreamReader(input, 'UTF8')
            continua = (input != null)
        }// fine del blocco if

        // legge la risposta
        if (continua) {
            readBuffer = new BufferedReader(inputReader)
            while ((stringa = readBuffer.readLine()) != null) { textBuffer.append(stringa) }
        }// fine del blocco if

        // chiude
        if (readBuffer) {
            readBuffer.close()
        }// fine del blocco if

        // chiude
        if (inputReader) {
            inputReader.close()
        }// fine del blocco if

        // chiude
        if (input) {
            input.close()
        }// fine del blocco if

        // parametri e testo e token
        testo = textBuffer.toString()

        // testo = URLDecoder.decode(testo, "UTF-8")
        // testo = URLEncoder.encode(testo, "UTF-8")

        if (testo) {
            testo = testo.trim()
        }// fine del blocco if

        // valore di ritorno
        return testo
    } // fine del metodo

    /**
     * Legge una pagina wiki.
     *
     * Esegue solo se il titolo è valido
     *
     * @param titolo wiki della pagina
     * @return testo html della pagina
     */
    public static String leggeItWiki(String titolo) {
        // variabili e costanti locali di lavoro
        String contenuto = ''
        String domain
        String contenutoGrezzo1
        String contenutoGrezzo2
        String tagWiki = 'http://it.wikipedia.org/wiki/'
        String testo
        String tagIni1 = "<!-- bodyContent -->"
        String tagEnd1 = "<!-- /bodyContent -->"
        String tagIni2 = "<!-- bodycontent -->"
        String tagEnd2 = "<!-- /bodycontent -->"
        String tagIni3 = "<p>"
        String tagEnd3 = "</p>"
        String tagA = '>'
        String tagB = '<!--'
        int posA
        int posB

        if (titolo) {
            domain = tagWiki + titolo
            try { // prova ad eseguire il codice
                testo = LibWeb.legge(domain)
                if (testo) {
                    contenutoGrezzo1 = Lib.Txt.estrae(testo, tagIni1, tagEnd1)
                    contenutoGrezzo2 = Lib.Txt.estrae(contenutoGrezzo1, tagIni2, tagEnd2)
                    posA = contenutoGrezzo2.indexOf(tagA)
                    posA += tagA.length()
                    posB = contenutoGrezzo2.indexOf(tagB)
                    contenuto = contenutoGrezzo2.substring(posA, posB)
                    contenuto = Lib.Txt.estrae(contenuto, tagIni3, tagEnd3)
                }// fine del blocco if
            } catch (Exception unErrore) { // intercetta l'errore
                log.error unErrore
            }// fine del blocco try-catch
        }// fine del blocco if

        // valore di ritorno
        return contenuto
    } // fine del metodo

    /**
     * Regola la connessione.
     * Regola alcuni valori standard della connessione
     * Inserisce i cookies
     *
     * @param connection
     * @param cookies da regolare
     * @return connection regolata
     */
    private static regolaConnessione = {URLConnection connection, String cookies ->
        connection.setDoOutput(true)

        // regolo i cookies e le property
        connection.setRequestProperty('Accept-Encoding', 'GZIP');
        connection.setRequestProperty('Content-Encoding', 'GZIP');
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; it-it) AppleWebKit/418.9 (KHTML, like Gecko) Safari/419.3");
        connection.setRequestProperty('Cookie', cookies)

        // valore di ritorno
        return connection
    } // fine della closure

    /**
     * Suddivide la lista in tre colonne.
     *
     * @param listaIn in ingresso
     * @return listaOut in uscita
     */
    public static listaTreColonne(ArrayList<String> listaIn) {
        // variabili e costanti locali di lavoro
        ArrayList<String> listaOut = (ArrayList<String>) listaIn.clone()
        String tagIni = '{{MultiCol}}'
        String tagColonna = '{{ColBreak}}'
        String tagEnd = '{{EndMultiCol}}'
        int dim
        int primoTag
        int secondoTag
        int resto

        if (listaIn) {
            dim = listaIn.size()
            primoTag = dim / 3
            resto += dim % 3
            switch (dim) {
                case 0:
                case 1:
                    return listaOut
                    break
                case 2:
                    primoTag = 1
                    listaOut.add(primoTag, tagColonna)
                    listaOut.add(0, tagIni)
                    listaOut.add(tagEnd)
                    return listaOut
                    break
                case 3:
                    primoTag = 1
                    secondoTag = 2
                    listaOut.add(secondoTag, tagColonna)
                    listaOut.add(primoTag, tagColonna)
                    listaOut.add(0, tagIni)
                    listaOut.add(tagEnd)
                    return listaOut
                    break
                default: // caso non definito
                    secondoTag = primoTag * 2
                    if (resto > 0) {
                        primoTag++
                        secondoTag++
                    }// fine del blocco if
                    if (resto > 1) {
                        secondoTag++
                    }// fine del blocco if
                    listaOut.add(secondoTag, tagColonna)
                    listaOut.add(primoTag, tagColonna)
                    listaOut.add(0, tagIni)
                    listaOut.add(tagEnd)
                    return listaOut
                    break
            } // fine del blocco switch
        }// fine del blocco if

        // valore di ritorno
        return listaOut
    } // fine del metodo

} //fine della classe
