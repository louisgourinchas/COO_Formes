package Formes;

public class CarrePulsant extends FormePulsante{
    CarrePulsant(MachineTrace mt, int a, int e){
        super(mt);
        this.fixerAmplitude(a);
        this.fixerEtapes(e);
    }

    public void dessiner(){
        mt.lever();
        mt.placer(this.centre[0]+this.taille/2, this.centre[1]+this.taille/2);
        mt.baisser();
        for (int i = 0; i < 4; i++) {
            mt.avancer(this.taille);
            mt.tournerDroite(90);
        }
    }
}
