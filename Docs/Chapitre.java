import java.io.PrintStream;

public class Chapitre {
    
    private TexteCentre titre;
    private BlocDeTexte contenu;
    private int largeur = 100;

    Chapitre(String titre){
        this.titre = new TexteCentre("CHAPITRE " + titre);
        this.titre.fixeLargeur(this.largeur);
        this.contenu = new BlocDeTexte();
        //could force contenu's width to be the same as this but their default is already the same.
    }

    public void ajoute(Paragraphe p){
        this.contenu.ajoute(p);
    }

    public void fixeLargeur(int l){
        this.largeur = l;
        this.contenu.fixeLargeur(l);
    }

    public void ecris(PrintStream p){
        p.println(this.toString());
        this.contenu.ecris(p);
    }

    //this is so ugly.
    @Override
    public String toString(){
        return this.titre.toString();

    }
}
