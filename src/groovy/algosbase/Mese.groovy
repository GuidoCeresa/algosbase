package algosbase

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 3-10-12
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
public enum Mese {

    gennaio('gen', 'gennaio'),
    febbraio('feb', 'febbraio'),
    marzo('mar', 'marzo'),
    aprile('apr', 'aprile'),
    maggio('mag', 'maggio'),
    giugno('giu', 'giugno'),
    luglio('lug', 'luglio'),
    agosto('ago', 'agosto'),
    settembre('set', 'settembre'),
    ottobre('ott', 'ottobre'),
    novembre('nov', 'novembre'),
    dicembre('dic', 'dicembre')

    String breve
    String lungo


    Mese(String breve, String lungo) {
        this.breve = breve
        this.lungo = lungo
    }// fine del metodo costruttore

    // l'anno parte da gennaio che è il numero 1
    private static String getMese(int ord, boolean flagBreve) {
        String nome = ''
        ord = ord - 1

        Mese.values()?.each {
            if (it.ordinal() == ord) {
                if (flagBreve) {
                    nome = it.breve
                } else {
                    nome = it.lungo
                }// fine del blocco if-else
            }// fine del blocco if
        }// fine del ciclo each

        return nome
    }// fine del metodo statico


    public static String getShort(int ord) {
        return getMese(ord, true)
    }// fine del metodo statico


    public static String getLong(int ord) {
        return getMese(ord, false)
    }// fine del metodo statico


    public static String getAllShortString() {
        String stringa = ''
        String sep = ', '

        Mese.values()?.each {
            stringa += it.getBreve()
            stringa += sep
        }// fine del ciclo each
        stringa = Lib.Txt.levaCoda(stringa, sep)

        return stringa
    }// fine del metodo statico


    public static String getAllLongString() {
        String stringa = ''
        String sep = ', '

        Mese.values()?.each {
            stringa += it.getLungo()
            stringa += sep
        }// fine del ciclo each
        stringa = Lib.Txt.levaCoda(stringa, sep)

        return stringa
    }// fine del metodo statico


    public static ArrayList getAllShortList() {
        ArrayList lista = new ArrayList()

        Mese.values()?.each {
            lista.add(it.getBreve())
        }// fine del ciclo each

        return lista
    }// fine del metodo statico


    public static ArrayList getAllLongList() {
        ArrayList lista = new ArrayList()

        Mese.values()?.each {
            lista.add(it.getLungo())
        }// fine del ciclo each

        return lista
    }// fine del metodo statico


    public int getOrd() {
        return this.ordinal() + 1
    }// fine del metodo

}// fine della classe Enumeration
