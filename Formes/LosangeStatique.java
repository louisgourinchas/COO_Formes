package Formes;

public class LosangeStatique extends Forme{
    LosangeStatique(MachineTrace mt){
        super(mt);
    }

    public void dessiner(){
        mt.lever();
        mt.placer(this.centre[0], this.centre[1]);
        mt.avancer(2*this.taille/3);
        mt.baisser();
        for (int i = 0; i < 2; i++) {
            mt.avancer(this.taille);
            mt.tournerDroite(60);
            mt.avancer(this.taille);
            mt.tournerDroite(120);
        }
    }
}
