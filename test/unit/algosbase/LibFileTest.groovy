package algosbase

import java.util.concurrent.LinkedBlockingDeque

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 09:05
 * To change this template use File | Settings | File Templates.
 */
class LibFileTest extends GroovyTestCase {
    void setUp() {

    }

    void tearDown() {

    }

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
    void testLeggeCvs() {
        String pathFile = 'test/unit/algosbase/CvsData'
        ArrayList ottenuto
        String campoUno = 'nome'
        String campoDue = 'cognome'
        String campoTre = 'titolo'
        LinkedHashMap mappaUno = new LinkedHashMap()
        LinkedHashMap mappaDue = new LinkedHashMap()
        ArrayList richiesto = new ArrayList()
        mappaUno.put(campoUno, 'mario')
        mappaUno.put(campoDue, 'rossi')
        mappaUno.put(campoTre, 'dottore')
        richiesto.add(mappaUno)
        mappaDue.put(campoUno, 'franca')
        mappaDue.put(campoDue, 'brigatti')
        mappaDue.put(campoTre, 'casalinga')
        richiesto.add(mappaDue)

        ottenuto = Lib.File.leggeCvs(pathFile)
        assert ottenuto.size() == richiesto.size()
        assert ottenuto instanceof ArrayList
        def secondaRiga = ottenuto.get(1)
        assert secondaRiga instanceof LinkedHashMap
        secondaRiga = (LinkedHashMap)secondaRiga
        assert secondaRiga.size() == mappaDue.size()
        def a= secondaRiga
        def b= secondaRiga[1]
        def stop
    } // fine del test

} //fine della classe
