package beans;

/**
 *
 * @author Tahiri
 */
public class Etage {
    private int id;
    private int numero;
    private int nbr_section;
    private int id_parking;
 
    // Constructor
    public Etage( int id, int numero, int nbr_section, int id_parking) {
        this.id          = id;
        this.nbr_section = nbr_section;
        this.numero      = numero;
        this.id_parking  = id_parking;
    }
    
    public Etage( int numero , int nbr_section, int id_parking) {
        this.nbr_section = nbr_section;
        this.numero      = numero;
        this.id_parking  = id_parking;
    }

    // Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNbr_section() {
        return nbr_section;
    }

    public void setNbr_section(int nbr_section) {
        this.nbr_section = nbr_section;
    }
    
    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking ;
    }
    
    // To string
    @Override
    public String toString() {
        return "Etage{" + "id=" + id + ", numero=" + numero + '}';
    }
    
}
