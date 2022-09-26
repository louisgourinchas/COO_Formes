public class TexteCentre extends Texte{
    TexteCentre(String t){
        super(t);
    }
      
    public String toString(){

        int reste = (this.largeur - texte.length())/2;

        String space = this.filler.repeat(reste); 
        
        if(largeur%2==0){
            return space + this.texte + space;
        } else {
            return space + this.texte + space + this.filler;
        }
    }
}