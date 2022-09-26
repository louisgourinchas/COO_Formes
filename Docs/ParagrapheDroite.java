
public class ParagrapheDroite extends Paragraphe{

    public String toStringOne(){
        String text = "";
        String[] lignes = super.toString().split("\n");
        for (int i = 0; i < lignes.length; i++) {
            String temp = lignes[i].trim();
            temp =(" ".repeat(this.largeur-lignes[i].length())) + temp + "\n";
            lignes[i]=temp;
            text = text + lignes[i];
        }
        return text;
    }

    //actual remake of the original toString, less "cheating" but also breaks from the idea of using a StringBuilder.
    public String toString(){
        StringBuilder paragraph = new StringBuilder();
        
        int current = this.largeur;
        String currentString = "";

        for(int i=0 ; i<this.occupied ; i++){
            int tempcurr = current - this.mots[i].length();
            //System.out.println("checking out the word:" + this.mots[i] + "\n tempcurr = " + Integer.toString(tempcurr));
            
            if (tempcurr<0){//not enough space on line to add word

                //end current line
                currentString = " ".repeat(this.largeur - currentString.length()) + currentString.trim() + "\n";
                paragraph.append(currentString);
                current = this.largeur;
                currentString = "";
                //adding the word to the new line
                currentString += this.mots[i]+" ";
                current = current - this.mots[i].length(); //does NOT account for the possibility of a word bigger than the line

            } else {//enough space on current line

                //add current word
                currentString += this.mots[i]+" ";
                current = tempcurr-1;
                //possibility of having a space at position this.largeur+1 if the word fills the line exctly
                //fix: add different scenarios depending on whether current is 0 or not.
            }
        }
        currentString = " ".repeat(this.largeur - currentString.length()) + currentString.trim() + "\n";
        paragraph.append(currentString);

        return paragraph.toString();
    }
}