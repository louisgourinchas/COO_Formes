package Formes;
import java.util.Random;

/**
 * Programme de base fournit pour le TP, se référer au TP pour les détails.
 * @author Guillaume Huard
 */
public class FormesPulsantes {
	final static int nbFormes = 8;
	final static int nbObjets = 10;
	final static int etapesPulsations = 20;
	final static int amplitudePulsation = 20;
	final static int delai = 100;

	static Forme creerForme(int type, MachineTrace m) {
		switch (type) {
		case 0:
			return new CarreStatique(m);
		case 1:
			return new TriangleStatique(m);
		case 2:
			return new LosangeStatique(m);
		case 3:
			return new CercleStatique(m);
		case 4:
			return new CarrePulsant(m,amplitudePulsation, etapesPulsations);
		case 5:
			return new TrianglePulsant(m, amplitudePulsation, etapesPulsations);
		case 6:
			return new LosangePulsant(m, amplitudePulsation, etapesPulsations);
		case 7:
			return new CerclePulsant(m, amplitudePulsation, etapesPulsations);
		default:
			throw new RuntimeException("Forme Inconnue");
		}
	}

	public static void main(String[] args) {
		MachineTrace m;
		Forme[] f;
		//int[] tailles;
		Random r;

		m = new MachineTrace(1200, 600);
		m.masquerPointeur();
		m.rafraichissementAutomatique(false);

		f = new Forme[nbObjets];
		//tailles = new int[f.length];
		r = new Random();
		for (int i = 0; i < f.length; i++) {
			f[i] = creerForme(r.nextInt(nbFormes), m);
			f[i].fixerPosition(r.nextInt(200) - 100, r.nextInt(200) - 100);
			//tailles[i] = r.nextInt(20) + 5;
		}

		while (true) {
			/* 
			for (int j = 0; j <= etapesPulsations; j++) {
				m.effacerTout();
				int ajout = (int) (amplitudePulsation * (Math.sin(j * 2 * Math.PI / etapesPulsations) + 1) / 2);
				for (int i = 0; i < f.length; i++) {
					f[i].fixerTaille(tailles[i] + ajout);
					f[i].dessiner();
				}
				m.rafraichir();
				m.attendre(delai);
			}
			*/
			m.effacerTout();
			for (int i = 0; i < f.length; i++) {
				f[i].avancer();
				f[i].dessiner();
			}
			m.rafraichir();
			m.attendre(delai);
		}
	}
}
