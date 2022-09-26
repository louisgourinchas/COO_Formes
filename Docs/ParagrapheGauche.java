public class ParagrapheGauche extends Paragraphe{
    
    public String toString(){
        String text = "";
        String[] lignes = super.toString().split("\n");
        for (int i = 0; i < lignes.length; i++) {
            String temp = lignes[i].trim();
            int sizeDiff = this.largeur-lignes[i].length();
            if (sizeDiff > 0) {
                temp = temp + (" ".repeat(this.largeur-lignes[i].length())); 
            }
            temp = temp + "\n";
            lignes[i]=temp;
            text = text + lignes[i];
        }
        return text;
    }
}
