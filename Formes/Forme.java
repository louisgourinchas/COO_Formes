package Formes;

public class Forme {

    protected int[] centre = {0,0};
    protected int taille = 25;
    protected MachineTrace mt;

    //bad. ugly. check back later.
    Forme(){   
    }

    Forme (MachineTrace machine){
        this.mt = machine;
    }

    //Détermine la position à laquelle la forme devra être dessinée (centre) ;
    public void fixerPosition(int x, int y){
        this.centre[0] = x;
        this.centre[1] = y;      
    };

    //Détermine la taille (coté) d'un carré contenant la forme ;
    public void fixerTaille(int t){
        this.taille = t;
    };
    
    public void dessiner(){
        return;
    };

    public void avancer(){
        return;
    }
}
