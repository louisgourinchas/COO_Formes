package Formes;

public class FormePulsante extends Forme{

    protected int amplitude;
    protected int nbEtapes;
    protected int etapeActuelle = 0;
    protected int tailleBase;

    FormePulsante(MachineTrace mt){
        super(mt);
        this.tailleBase = this.taille;

    }

    protected void fixerAmplitude(int a){
        this.amplitude = a;
    }

    protected void fixerEtapes(int e){
        this.nbEtapes = e;
    }

    public void avancer(){
        int ajout = (int) (amplitude * (Math.sin(etapeActuelle * 2 * Math.PI / nbEtapes) + 1) / 2);
        this.etapeActuelle++;
        if (etapeActuelle == nbEtapes) {
            etapeActuelle = 0;
        }
        this.fixerTaille(this.tailleBase + ajout);
    }
}
