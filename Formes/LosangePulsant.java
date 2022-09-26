package Formes;

public class LosangePulsant extends FormePulsante{
    LosangePulsant(MachineTrace mt, int a, int e){
        super(mt);
        this.fixerAmplitude(a);
        this.fixerEtapes(e);
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
