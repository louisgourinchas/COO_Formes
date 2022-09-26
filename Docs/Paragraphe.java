import java.util.Arrays;

public class Paragraphe{

    protected int largeur = 100;
    protected String[] mots = new String[10];
    protected int occupied=0; 

    Paragraphe(){
    }

    //occcupied used as substitute for this.mots.length()
    //only because they are equal every time this is called.
    //probably bad practice to double the size of the array instead of adding X places. less new arrays tho.
    protected void doubleMots(){
        String[] nouveauMots = Arrays.copyOf(this.mots, this.mots.length*2);
        //String[] nouveauMots = new String[this.occupied*2];
        //System.arraycopy(this.mots, 0, nouveauMots, 0, this.occupied);
        this.mots=nouveauMots;
    }

    public void fixeLargeur(int l){
        this.largeur = l;
    }

    public void ajoute(String mot){
        if(mots.length==occupied){
            doubleMots();
        }

        this.mots[this.occupied]=mot;
        this.occupied++;
    }

    public int nbLignes(){
        //total number of lines filled
        int lignes = 0;
        //number of free characters on current line
        int current = this.largeur;
        for(int i=0 ; i<this.occupied ; i++){
            //number of chararcters left after adding the current word
            int tempcurr = current - this.mots[i].length();
            
            if (tempcurr<0){
                //not enough space on line to add word
                lignes++;
                current = this.largeur; //reset
                //adding the word to the new line
                current-=this.mots[i].length(); //does NOT account for the possibility of a word bigger than the line
            } else {
                //enough space on current line (-1 is to account for the space after the word)
                //if the word fills the line exactly, current becomes -1 and the next word will count towards next line.
                current = tempcurr-1;
            }
        }
        return lignes;
    }

    //TODO fix possible issue (test before fixing :) ) of pre-existing endOfLine characters messing with the "current" counter AKA skipping a line in an unrecorded manner
    @Override
    public String toString(){
        StringBuilder paragraph = new StringBuilder();
        
        int current = this.largeur;

        for(int i=0 ; i<this.occupied ; i++){
            int tempcurr = current - this.mots[i].length();
            
            if (tempcurr<0){//not enough space on line to add word

                //end current line
                paragraph.append("\n");
                current = this.largeur;
                //adding the word to the new line
                paragraph.append(mots[i]+" ");
                current = current - this.mots[i].length() -1; //does NOT account for the possibility of a word bigger than the line

            } else {//enough space on current line

                //add current word
                paragraph.append(mots[i]+" ");
                current = tempcurr-1;
                //possibility of having a space at position this.largeur+1 if the word fills the line exctly
                //fix: add different scenarios depending on whether current is 0 or not.
            }
        }
        return paragraph.toString();
    }
}