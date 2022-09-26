import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Document {
    
    private Entete entete;
    private BlocDeTexte prologue = new BlocDeTexte();
    private Chapitre[] chapitres = new Chapitre[10];
    private int largeur = 100;
    private int countChapitres = 0;

    Document(Entete e, InputStream input){
        //the easy part.
        this.entete = e;

        //the other part.
        Scanner in = new Scanner(input);
        boolean isPrologue = true;
        //declared to have it's exitense outside while loop. title is irrelevant as currentChapitre is replace before being used.
        Chapitre currentChapitre = new Chapitre("Placeholder");
        Paragraphe currentParagraphe = new Paragraphe();
        //continue reading till you die little scanner.
        while(in.hasNextLine()){
            String currentLine = in.nextLine().trim();

            //empty line marks the start of a new paragraph.
            if(currentLine.isEmpty()){

                //have we started chapters or are we still in paragraphs.
                if(isPrologue){
                    this.prologue.ajoute(currentParagraphe);
                } else {
                    currentChapitre.ajoute(currentParagraphe);
                }

                currentParagraphe = new Paragraphe();
            }

            //start of a new chapter.
            if(currentLine.startsWith("CHAPITRE")){

                if (isPrologue){
                    //simply state we aren't in prologue anymore.
                    isPrologue = false;
                } else {
                    //no need to bother with paragraphs, it's handled on the previous line (empty one).
                    ajouteChapitre(currentChapitre);
                }

                //title is the current line without the "CHAPITRE" text.
                currentChapitre = new Chapitre(currentLine.substring(9));       
            }

            //regular line 
            //condition here is bad, other solution include a boolean specifying the type of line and a switch/case, OR using elif statements.
            if(!currentLine.isEmpty() && !currentLine.startsWith("CHAPITRE")){

                String[] mots = currentLine.split(" ");
                for(int i=0;i<mots.length;i++){
                    currentParagraphe.ajoute(mots[i]);
                }
            }
        }
        in.close();
    }

    private void doubleChapitres(){
        Chapitre[] r = Arrays.copyOf(this.chapitres, this.chapitres.length*2);
        this.chapitres = r;
    }
    
    private void ajouteChapitre(Chapitre c) {
        if(this.countChapitres==this.chapitres.length){
            doubleChapitres();
        }
        this.chapitres[countChapitres]=c;
        this.countChapitres++;
    }

    public void fixeLargeur(int l){ 
        this.largeur = l;
        this.entete.fixeLargeur(l);
        this.prologue.fixeLargeur(l);
        for(int i=0;i<countChapitres;i++){
            this.chapitres[i].fixeLargeur(l);
        }
    }

    public void ecris(PrintStream p){
        //TODO
        p.println(this.entete.toString());
        this.prologue.ecris(p);
        for(int i=0;i<countChapitres;i++){
            this.chapitres[i].ecris(p);
        }
    }

}
