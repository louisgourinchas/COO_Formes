package Formes;

public class CerclePulsant extends FormePulsante{
    CerclePulsant(MachineTrace mt, int a, int e){
        super(mt);
        this.fixerAmplitude(a);
        this.fixerEtapes(e);
    }

    public void dessiner(){
        mt.lever();
        mt.placer(this.centre[0], this.centre[1]);
        mt.avancer(this.taille/2);
        mt.baisser();
        double perimetre = java.lang.Math.PI * 2 * (this.taille/2);
        double side = perimetre/180;
        for (int i = 0; i < 180; i++) {
            mt.avancer(side);
            mt.tournerGauche(2);
        }
    }
}
