// Tag per commentare le righe di header aggiunte ai file
enum AlgosTag {

    groovy('/* ', ' */'),
    css('/* ', ' */'),
    gsp('<%--', '--%>'),
    scaffolding('<!--', '-->'),
    template('<%/* ',' */%>'),
    virgola('', ';'),
    freccia('', '>'),
    vuoto('','')


    public final String ini
    private final String end


    AlgosTag(String ini, String end) {
        this.ini = ini
        this.end = end
    }


    public static ArrayList<String> getAllEnd() {
        ArrayList<String> lista = new ArrayList<String>()

        AlgosTag.each {
            lista.add(it.end)
        }

        return lista
    }
}
