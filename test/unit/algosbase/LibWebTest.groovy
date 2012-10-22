package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 4-10-12
 * Time: 09:13
 * To change this template use File | Settings | File Templates.
 */
class LibWebTest extends GroovyTestCase {

    /**
     * Legge dal web una pagina.
     * Esegue solo se il domain è valido
     *
     * @param domain URL del sito (pagina)
     * @return testo html della pagina
     */
    void testLegge() {
        String domain = 'http://www.quattroprovince.it/'
        String primaParola = '<html>'
        String secondaParola = '<head>'
        String terzaParola = '<title>www.quattroprovince.it</title>'
        String quartaParola = '</head>'
        String testoPagina
        def ottenuto

        testoPagina = Lib.Web.legge(domain)
        ottenuto = Lib.Array.getWords(testoPagina)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto[0] == primaParola
        assert ottenuto[1] == secondaParola
        assert ottenuto[2] == terzaParola
        assert ottenuto[3] == quartaParola
    }// fine tests

    void testLegge2() {
        String domain = ''
        String testoPagina

        testoPagina = Lib.Web.legge(domain)
        assert testoPagina == ''
    }// fine tests

    void testLegge3() {
        String domain = 'http://it.wikipedia.org/wiki/Utente:Gac/Sandbox4'
        String testoPagina
        def ottenuto

        testoPagina = Lib.Web.legge(domain)
        ottenuto = Lib.Html.getTagsHtml(testoPagina)
        assert ottenuto != null
        assert ottenuto in ArrayList
        assert ottenuto[2] == 'head'
    }// fine tests

    /**
     * Legge una pagina wiki.
     *
     * Esegue solo se il titolo è valido
     *
     * @param titolo wiki della pagina
     * @return testo html della pagina
     */
    void testLeggeWiki() {
        String titolo = 'Utente:Gac/Sandbox4'
        String richiesto = 'venti riga'
        String ottenuto

        ottenuto = Lib.Web.leggeItWiki(titolo)
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Suddivide la lista in tre colonne.
     *
     * @param listaIn in ingresso
     * @return listaOut in uscita
     */
    void testListaTreColonne() {
        // variabili e costanti locali di lavoro
        String tagIni = '{{MultiCol}}'
        String tagColonna = '{{ColBreak}}'
        String tagEnd = '{{EndMultiCol}}'
        String uno = 'uno'
        String due = 'due'
        String tre = 'tre'
        String quattro = 'quattro'
        String cinque = 'cinque'
        String sei = 'sei'
        String sette = 'sette'
        ArrayList<String> lista
        ArrayList<String> ottenuto

        lista = new ArrayList<String>()
        lista.add(uno)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 1
        assert ottenuto[0] == uno

        lista = new ArrayList<String>()
        lista.add(uno)
        lista.add(due)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 5
        assert ottenuto[0] == tagIni
        assert ottenuto[1] == uno
        assert ottenuto[2] == tagColonna
        assert ottenuto[3] == due
        assert ottenuto[4] == tagEnd

        lista = new ArrayList<String>()
        lista.add(uno)
        lista.add(due)
        lista.add(tre)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 7
        assert ottenuto[0] == tagIni
        assert ottenuto[1] == uno
        assert ottenuto[2] == tagColonna
        assert ottenuto[3] == due
        assert ottenuto[4] == tagColonna
        assert ottenuto[5] == tre
        assert ottenuto[6] == tagEnd

        lista = new ArrayList<String>()
        lista.add(uno)
        lista.add(due)
        lista.add(tre)
        lista.add(quattro)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 8
        assert ottenuto[0] == tagIni
        assert ottenuto[1] == uno
        assert ottenuto[2] == due
        assert ottenuto[3] == tagColonna
        assert ottenuto[4] == tre
        assert ottenuto[5] == tagColonna
        assert ottenuto[6] == quattro
        assert ottenuto[7] == tagEnd

        lista = new ArrayList<String>()
        lista.add(uno)
        lista.add(due)
        lista.add(tre)
        lista.add(quattro)
        lista.add(cinque)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 9
        assert ottenuto[0] == tagIni
        assert ottenuto[1] == uno
        assert ottenuto[2] == due
        assert ottenuto[3] == tagColonna
        assert ottenuto[4] == tre
        assert ottenuto[5] == quattro
        assert ottenuto[6] == tagColonna
        assert ottenuto[7] == cinque
        assert ottenuto[8] == tagEnd

        lista = new ArrayList<String>()
        lista.add(uno)
        lista.add(due)
        lista.add(tre)
        lista.add(quattro)
        lista.add(cinque)
        lista.add(sei)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 10
        assert ottenuto[0] == tagIni
        assert ottenuto[1] == uno
        assert ottenuto[2] == due
        assert ottenuto[3] == tagColonna
        assert ottenuto[4] == tre
        assert ottenuto[5] == quattro
        assert ottenuto[6] == tagColonna
        assert ottenuto[7] == cinque
        assert ottenuto[8] == sei
        assert ottenuto[9] == tagEnd

        lista = new ArrayList<String>()
        lista.add(uno)
        lista.add(due)
        lista.add(tre)
        lista.add(quattro)
        lista.add(cinque)
        lista.add(sei)
        lista.add(sette)
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 11
        assert ottenuto[0] == tagIni
        assert ottenuto[1] == uno
        assert ottenuto[2] == due
        assert ottenuto[3] == tre
        assert ottenuto[4] == tagColonna
        assert ottenuto[5] == quattro
        assert ottenuto[6] == cinque
        assert ottenuto[7] == tagColonna
        assert ottenuto[8] == sei
        assert ottenuto[9] == sette
        assert ottenuto[10] == tagEnd

        lista = new ArrayList<String>()
        for (int k = 0; k < 49; k++) {
            lista.add(uno)
        } // fine del ciclo for
        ottenuto = LibWeb.listaTreColonne(lista)
        assert ottenuto.size() == 53
        assert ottenuto[0] == tagIni
        assert ottenuto[18] == tagColonna
    } // fine del metodo

} //fine della classe
