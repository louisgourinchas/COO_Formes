package Formes;

public class TrianglePulsant extends FormePulsante{
    TrianglePulsant(MachineTrace mt, int a, int e){
        super(mt);
        this.fixerAmplitude(a);
        this.fixerEtapes(e);
    }

    //racine de 3, divisé par 3, fois a
    public void dessiner(){
        mt.lever();
        mt.placer(this.centre[0], this.centre[1]);
        //distance centre/sommet
        mt.avancer((java.lang.Math.sqrt(3)/3)*this.taille);
        mt.baisser();
        for (int i = 0; i < 3; i++) {
            mt.avancer(this.taille);
            mt.tournerGauche(120);
        }
    }
}
