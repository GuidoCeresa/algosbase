package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 4-10-12
 * Time: 09:13
 * To change this template use File | Settings | File Templates.
 */
class LibWebTest extends GroovyTestCase {
    void testLegge() {
        String pagina = 'http://www.quattroprovince.it/'
        String primaParola = '<html>'
        String secondaParola = '<head>'
        String terzaParola = '<title>www.quattroprovince.it</title>'
        String quartaParola = '</head>'
        String testoPagina
        def ottenuto

        testoPagina = Lib.Web.legge(pagina)
        ottenuto = Lib.Array.getWords(testoPagina)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto[0] == primaParola
        assert ottenuto[1] == secondaParola
        assert ottenuto[2] == terzaParola
        assert ottenuto[3] == quartaParola

    }// fine tests


    void testLegge2() {
        String pagina = 'http://it.wikipedia.org/wiki/Utente:Gac/Sandbox4'
        String testoPagina
        def ottenuto

        testoPagina = Lib.Web.legge(pagina)
        ottenuto = Lib.Html.getTagsHtml(testoPagina)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto[2] == 'head'
    }// fine tests

    void testLeggeWiki() {
        String titolo = 'Utente:Gac/Sandbox4'
        String richiesto ='venti riga'
        String ottenuto

        ottenuto = Lib.Web.leggeItWiki(titolo)
        assert ottenuto ==richiesto
    }// fine tests

} //fine della classe
