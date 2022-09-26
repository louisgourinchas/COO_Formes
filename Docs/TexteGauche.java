public class TexteGauche extends Texte{
    TexteGauche(String t){
        super(t);
    }

    public String toString(){
        return this.texte + this.filler.repeat(this.largeur - this.texte.length()) + "\n";
    }
}
