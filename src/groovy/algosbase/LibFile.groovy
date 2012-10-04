package algosbase

import liquibase.util.csv.opencsv.CSVReader
import org.apache.commons.logging.LogFactory

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 09:04
 * To change this template use File | Settings | File Templates.
 */
class LibFile {

    private static final log = LogFactory.getLog(this)

    public static String dirPath = '/Users/Gac/Desktop/Botswana/'
    private static String txtSuffix = '.txt'
    private static String cvsSuffix = '.csv'

    public static String ast = '*'
    public static String pipe = '|'
    public static String spazio = ' '
    public static String aCapo = '\n'
    public static String par = '('

    /**
     * Legge un file formattato csv
     * Legge la prima riga dei titoli SOLO per creare le mappe
     * Crea una mappa (titolo=valore) per ogni riga (esclusi i titoli)
     * Titolo e valore sono SEMPRE stringhe
     * Restituisce, per ogni riga, una mappa con TUTTE le colonne
     * Eventualmente vuote
     *
     * @param filePath percorso completo del file da leggere
     * @return lista di righe ognuna formata da una mappa
     *
     */
    public static ArrayList leggeCvs(String filePath) {
        ArrayList righe = null
        def titoli = null
        LinkedHashMap mappa
        CSVReader reader
        List listaRighe = null
        def singolaRiga

        // Controllo suffisso
        if (!filePath.endsWith(cvsSuffix)) {
            filePath += cvsSuffix
        }// fine del blocco if

        try { // prova ad eseguire il codice
            reader = new CSVReader(new FileReader(filePath));
        } catch (Exception unErrore) { // intercetta l'errore
            //log.error 'Non ho trovato il file '+filePath
        }// fine del blocco try-catch

        if (reader) {
            titoli = reader.readNext()
            listaRighe = reader.readAll()
        }// fine del blocco if

        if (listaRighe) {
            righe = new ArrayList()
            listaRighe.each {
                singolaRiga = it
                mappa = new LinkedHashMap()
                for (int k = 0; k < titoli.length; k++) {
                    mappa.put(titoli[k], singolaRiga[k])
                } // fine del ciclo for
                righe.add(mappa)
            } // fine del ciclo each
        }// fine del blocco if

        // valore di ritorno
        return righe
    }// fine del metodo

    public ArrayList leggeRighe(String fileName) {
        ArrayList righe = null
        String filePath = dirPath + fileName + txtSuffix
        File file = new File(filePath)

        if (file.exists()) {
            righe = new ArrayList()
            file.eachLine {
                righe.add(it)
            }
        }// fine del blocco if

        // valore di ritorno
        return righe
    }// fine del metodo

    public String leggeFile(String fileName) {
        String testo = ''
        String filePath = dirPath + fileName + txtSuffix
        File file = new File(filePath)

        if (file.exists()) {
            file.eachLine {
                testo += it
            }
        }// fine del blocco if

        // valore di ritorno
        return testo
    }// fine del metodo

} //fine della classe statica
