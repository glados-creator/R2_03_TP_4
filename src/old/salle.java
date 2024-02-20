import java.util.ArrayList;
import java.util.List;

/**class salle */
public class salle {
    /** globalSalles */
    private static List<salle> globalSalles = new ArrayList<>();
    
    /** nom */
    private String nom;
    /** list_place */
    private List<Object> list_place;
    // user ->.place(box)

    /**
     * salle
     * @param nom String
     */
    public salle(String nom) {
        this.nom = nom;
        globalSalles.add(this);
        this.list_place = new ArrayList<>();
    }

    /**
     * getNom 
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * place in salle
     * @param user utilisateur
     * @param b Box
     */
    public void place(utilisateur user,Box b){
        List<Object> tmp = new ArrayList<>();
        this.list_place.add(tmp);
        tmp.add(user);
        tmp.add(b);
    }

    /**
     * find
     * @param nom String
     * @return new salle
     */
    public static salle find(String nom){
        for (salle i : globalSalles) {
            if (i.getNom().equals(nom)) return i;
        }
        return null;
    }
    // -> json & yaml
}
