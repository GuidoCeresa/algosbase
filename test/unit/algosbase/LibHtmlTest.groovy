package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 4-10-12
 * Time: 08:40
 * To change this template use File | Settings | File Templates.
 */
class LibHtmlTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }


    protected void tearDown() {
        super.tearDown()
    }

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
    void testSetTag() {
        String testo = 'testo qualsiasi'
        String tag = 'div'
        String attr = 'action=pippo'
        String richiesto = '<div>testo qualsiasi</div>'
        String richiestoDue = "<div $attr>testo qualsiasi</div>"
        def ottenuto

        ottenuto = Lib.Html.setTag(testo, tag)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Html.setTag(testo, tag, '')
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Html.setTag(testo, tag, attr)
        assert ottenuto in String
        assert ottenuto == richiestoDue

        ottenuto = Lib.Html.setTag(null, tag, attr)
        assert ottenuto == null

        ottenuto = Lib.Html.setTag(testo, null)
        assert ottenuto == testo

        ottenuto = Lib.Html.setTag(testo, '')
        assert ottenuto == testo

        ottenuto = Lib.Html.setTag(testo, 17)
        assert ottenuto == testo
    }// fine tests

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
    void testSetTagForm() {
        String testo = 'testo qualsiasi'
        String attr = 'action=pippo'
        String richiesto = "<form $attr>testo qualsiasi</form>"
        String richiestoDue = "<form>testo qualsiasi</form>"
        def ottenuto

        ottenuto = Lib.Html.setTagForm(testo, attr)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Html.setTagForm(null, attr)
        assert ottenuto == null

        ottenuto = Lib.Html.setTagForm(testo, null)
        assert ottenuto == richiestoDue

        ottenuto = Lib.Html.setTagForm(testo, '')
        assert ottenuto == richiestoDue

        ottenuto = Lib.Html.setTagForm(testo, 17)
        assert ottenuto == richiestoDue
    }// fine tests

    void testTags() {
        String testo = '<!DOCTYPE html PUBLIC><html lang="it"><head><title>'
        def ottenuto

        ottenuto = Lib.Html.getTagsHtml(testo)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto.size() == 4
        assert ottenuto[0] == '!DOCTYPE html PUBLIC'
        assert ottenuto[1] == 'html lang="it"'
        assert ottenuto[2] == 'head'
        assert ottenuto[3] == 'title'

    }// fine tests


}//fine della classe di test
