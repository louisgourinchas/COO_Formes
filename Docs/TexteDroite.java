public class TexteDroite extends Texte{
    TexteDroite(String t){
        super(t);
    }

    public String toString(){
        return this.filler.repeat(this.largeur - this.texte.length()) + this.texte + "\n";
    }
}
