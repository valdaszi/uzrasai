package lt.bta.valdas.uzrasai;

import java.util.ArrayList;
import java.util.List;

public final class Duomenys {

    private List<Irasas> sarasas;



    private static Duomenys duomenys;

    public static Duomenys getInstance() {
        if (duomenys == null) {
            duomenys = new Duomenys();
            duomenys.sarasas = new ArrayList<>();

            // Testas:
            Irasas irasas = new Irasas();
            irasas.setPavadinimas("Arbuzas");
            duomenys.sarasas.add(irasas);

            irasas = new Irasas();
            irasas.setPavadinimas("Zebras");
            duomenys.sarasas.add(irasas);
        }
        return duomenys;
    }

    public List<Irasas> getSarasas() {
        return sarasas;
    }
}
