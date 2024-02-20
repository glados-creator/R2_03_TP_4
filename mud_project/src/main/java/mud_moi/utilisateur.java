package mud_moi;


/**class utilisateur */
public class utilisateur {
    /** nom */
    private String nom;
    /** prenom */
    private String prenom;
    /** id */
    private int id;

    /**
     * utilisateur
     * @param nom String
     * @param prenom String
     * @param id int
     */
    public utilisateur(String nom, String prenom, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    /**
     * getNom
     * @return String
     */ 
    public String getNom() {
        return this.nom;
    }

    /**
     * setNom
     * @param nom String
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getPrenom
     * @return String
     */ 
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * setPrenom
     * @param prenom String
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getId
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * equals
     * @param o obj
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof utilisateur)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members 
        utilisateur c = (utilisateur) o;
        // Compare the data members and return accordingly 
        return this.id == c.getId();
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            "}";
    }

}
