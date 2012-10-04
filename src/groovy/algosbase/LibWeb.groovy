package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 4-10-12
 * Time: 09:09
 * To change this template use File | Settings | File Templates.
 */
class LibWeb {

    public static String legge(String domain) {
        return LibWeb.legge(domain, '')
    } // fine del metodo

    public static String legge(String domain, String cookies) {
        // variabili e costanti locali di lavoro
        String testo
        URLConnection connection;
        InputStream input;
        InputStreamReader inputReader
        BufferedReader readBuffer
        StringBuffer textBuffer = new StringBuffer()
        String stringa

        // find the target
        connection = new URL(domain).openConnection()
        connection = this.regolaConnessione(connection, cookies)

        // regola l'entrata
        input = connection.getInputStream();
        inputReader = new InputStreamReader(input, 'UTF8');

        // legge la risposta
        readBuffer = new BufferedReader(inputReader)
        while ((stringa = readBuffer.readLine()) != null) { textBuffer.append(stringa) }

        // chiude
        readBuffer.close()
        inputReader.close()
        input.close()

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

    public static String leggeItWiki(String domain) {
        // variabili e costanti locali di lavoro
        String contenuto = ''
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

        if (domain) {
            domain = tagWiki + domain
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
            }// fine del blocco try-catch
        }// fine del blocco if

        // valore di ritorno
        return contenuto
    } // fine del metodo




    private static regolaConnessione = {connection, cookies ->
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

} //fine della classe
