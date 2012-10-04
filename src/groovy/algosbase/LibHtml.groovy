package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 4-10-12
 * Time: 08:39
 * To change this template use File | Settings | File Templates.
 */
class LibHtml {
    /**
     * Inserisce tag in testa e coda della stringa.
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se il tag è nullo o vuoto o non stringa, restituisce il testo
     * Elimina spazi vuoti iniziali e finali
     *
     * @param String : stringaIn  in ingresso
     * @param String : tag da aggiungere in testa ed in coda alla stringa
     * @param String : attr attributo da aggiungere dopo l'apertura del tag
     * @return stringa coi tag aggiunti
     */
    public static String setTag(String stringaIn, tag, attr) {
        // variabili e costanti locali di lavoro
        String stringaOut = stringaIn
        String spazio = ' '
        String apre = '<'
        String chiude = '>'
        String slash = '/'

        if (stringaIn && stringaIn) {
            stringaOut = stringaOut.trim()
            if (tag && tag in String) {

                stringaOut = apre + tag
                if (attr && attr in String) {
                    stringaOut += spazio + attr
                }// fine del blocco if
                stringaOut += chiude
                stringaOut += stringaIn
                stringaOut += apre
                stringaOut += slash
                stringaOut += tag
                stringaOut += chiude
            }// fine del blocco if

        }// fine del blocco if

        // valore di ritorno
        return stringaOut
    } // fine del metodo

    /**
     * Inserisce tag in testa e coda della stringa.
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se il tag è nullo o vuoto o non stringa, restituisce il testo
     * Elimina spazi vuoti iniziali e finali
     *
     * @param String : stringaIn  in ingresso
     * @param String : tag da aggiungere in testa ed in coda alla stringa
     * @return stringa coi tag aggiunti
     */
    public static setTag(String stringaIn, tag) {
        return LibHtml.setTag(stringaIn, tag, '')
    } // fine del metodo

    /**
     * Inserisce tag form in testa e coda della stringa.
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se il tag è nullo o vuoto o non stringa, restituisce il testo
     * Elimina spazi vuoti iniziali e finali
     *
     * @param String : stringaIn  in ingresso
     * @param String : attr attributo da aggiungere dopo l'apertura del tag
     * @return stringa coi tag aggiunti
     */
    public static setTagForm(String stringaIn, attr) {
        return LibHtml.setTag(stringaIn, 'form', attr)
    } // fine del metodo

    // Estrae dei blocchi di testo separati dai tags
    public static ArrayList<String> getTagsHtml(String testo) {
        // variabili e costanti locali di lavoro
        return LibHtml.getTags(testo, '<', '>')
    } // fine del metodo

    // Estrae dei blocchi di testo separati dai tags
    public static ArrayList<String> getTags(String testo, String tagIni, String tagEnd) {
        // variabili e costanti locali di lavoro
        ArrayList<String> blocchi = null
        String sep
        int pos

        if (testo && tagIni && tagEnd) {
            sep = tagEnd + tagIni
            blocchi = Lib.Array.getBlocchi(testo, sep)
            pos = blocchi.size() - 1
            if (blocchi && blocchi in ArrayList && pos >= 0) {
                blocchi[0] = Lib.Txt.levaTesta(blocchi[0], tagIni)
                blocchi[pos] = Lib.Txt.levaCoda(blocchi[pos], tagEnd)
            }// fine del blocco if
        }// fine del blocco if

        // valore di ritorno
        return blocchi
    } // fine del metodo

}// fine della classe