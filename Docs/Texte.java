public class Texte {
    protected String texte;
    protected int largeur;
    protected String filler = " ";
    
    Texte(String t){
        this.texte = t;
        this.largeur = 20;
    }

    public void fixeLargeur(int l){
        this.largeur = l;
    }

    public String getTexte(){
        return this.texte;
    }

    //should check for filler to be one character long
    //pour compter
    public void setFiller(String f){
        this.filler=f;
    }
    
    //"fuck you"
    @Override
    public String toString(){

        return this.texte;
    }
}
