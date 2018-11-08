package lt.bta.valdas.uzrasai;

import java.io.Serializable;

public class Irasas implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pavadinimas;

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    @Override
    public String toString() {
        return "Irasas{" +
                "pavadinimas='" + pavadinimas + '\'' +
                '}';
    }
}
