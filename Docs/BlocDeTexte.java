import java.io.PrintStream;
import java.util.Arrays;

public class BlocDeTexte {
    
    private Paragraphe[] paragraphes = new Paragraphe[10];
    private int largeur = 100;
    private int occupied = 0;

    BlocDeTexte(){
        //?
    }

    private void doubleParagraphes(){
        Paragraphe[] r = Arrays.copyOf(this.paragraphes, this.paragraphes.length*2);
        this.paragraphes = r;
    }

    public void ajoute(Paragraphe p){
        if (this.occupied==this.paragraphes.length) {
            doubleParagraphes();
        }
        p.fixeLargeur(this.largeur);
        this.paragraphes[this.occupied] = p;
        this.occupied++;
    }

    public void fixeLargeur(int l){
        this.largeur = l;
    }

    public void ecris(PrintStream p){
        for(int i=0;i<this.occupied;i++){
            p.println(this.paragraphes[i].toString());
        }
    }

    //use of TexteCentre might be overkill, normal version preserved.
    @Override
    public String toString(){
        //return "Bloc de texte contenant " + Integer.toString(this.occupied) + " paragraphes.";
        TexteCentre r = new TexteCentre("Bloc de texte contenant " + Integer.toString(this.occupied) + " paragraphe(s).");
        r.fixeLargeur(this.largeur);
        return r.toString();
    }
    
    public static void main(String[] args){
        BlocDeTexte b = new BlocDeTexte();
        Paragraphe p = new Paragraphe();
        p.ajoute("test");
        b.ajoute(p);
        System.out.println(b.toString());
    }

}
