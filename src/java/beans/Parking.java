package beans;

/**
 *
 * @author Tahiri
 */
public class Parking {
    private int id;
    private String nom;
    private String address;

    // Constructeur
    public Parking( int id, String nom, String address) {
        this.id = id;
        this.nom = nom;
        this.address = address;
    }
    
    public Parking( String nom, String address) {
        this.nom = nom;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // to string

    @Override
    public String toString() {
        return "Parking{" + "id=" + id + ", nom=" + nom + ", address=" + address + "}";
    }
    
    
}
