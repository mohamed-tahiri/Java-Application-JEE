package beans;

/**
 *
 * @author Tahiri
 */
public class Section {
    private int id;
    private String nom;
    private int id_etage;
    private int id_parking;
    private int nbr_place;
    
    
    // Constructeur
    public Section( int id, String nom, int id_etage, int id_parking) {
        this.id         = id;
        this.nom        = nom;
        this.id_etage   = id_etage;
        this.id_parking = id_parking;
    }
    
    public Section( String nom, int id_etage, int id_parking) {
        this.nom        = nom;
        this.id_etage   = id_etage;
        this.id_parking = id_parking;
    }
    
    public Section( int id, String nom, int nbr_place, int id_etage, int id_parking) {
        this.id         = id;
        this.nom        = nom;
        this.nbr_place  = nbr_place;
        this.id_etage   = id_etage;
        this.id_parking = id_parking;
    }
    
    // Getter and Setter

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

    public int getIdEtage() {
        return id_etage;
    }

    public int getIdParking() {
        return id_parking;
    }    

    public int getNbrPlace(){
        return nbr_place;
    }
    
    public void setNbrPlace(int nbr_place){
        this.nbr_place = nbr_place;
    }

    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", nom=" + nom + ", id_etage=" + id_etage + ", id_parking=" + id_parking + ", nbr_place=" + nbr_place + '}';
    }
    
}
