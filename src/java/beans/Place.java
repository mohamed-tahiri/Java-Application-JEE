package beans;

/**
 *
 * @author Tahiri
 */
public class Place {

    private int id;
    private String nom;
    private boolean etat;
    private String section;
    private int etage;
    private int parking;

    // Constructeur
    public Place(int id, String nom, boolean etat, String section, int etage, int parking) {
        this.id = id;
        this.nom = nom;
        this.etat = etat;
        this.section = section;
        this.etage = etage;
        this.parking = parking;
    }

    public Place(String nom, boolean etat, String section, int etage, int parking) {
        this.nom = nom;
        this.etat = etat;
        this.section = section;
        this.etage = etage;
        this.parking = parking;
    }

    // Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", nom=" + nom + ", etat=" + etat + ", section=" + section + ", etage=" + etage + ", parking=" + parking + '}';
    }


    
}
