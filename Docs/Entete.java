import java.text.SimpleDateFormat;
import java.util.Date;
public class Entete{
    private String titre;
    private String auteur;
    private Date date;
    private int largeur = 40;

    //originally build the class using a LocalDate d in constructor, switched because of TestDocument
    Entete(String t, String a, Date d){
        this.titre = t;
        this.auteur = a;
        this.date = d;
    }

    Entete(String t, String a){
        this(t, a, new Date());
    }

    public void fixeLargeur(int l){
        this.largeur=l;
    }

    @Override
    public String toString(){

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

        TexteCentre a = new TexteCentre(this.titre);
        a.fixeLargeur(this.largeur);
        TexteCentre b = new TexteCentre(this.auteur);
        b.fixeLargeur(this.largeur);
        TexteCentre c = new TexteCentre(formater.format(this.date));
        c.fixeLargeur(this.largeur);
      
        return a.toString()+"\n"+b.toString()+"\n"+c.toString();
    }

    public static void main(String[] args){

        Entete one = new Entete("Fight Club", "David Fincher",new Date(99, 10, 10));

        Entete two = new Entete("Pulp fiction", "Quentin tarantino");

        Entete three = new Entete("Interstellar", "Christopher nolan", new Date(114, 10, 5));
        three.fixeLargeur(75);

        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());

    }
}