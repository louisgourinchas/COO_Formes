public class test {

    public static void testParagrapheGD(){
        Paragraphe p = new ParagrapheDroite();
        p.fixeLargeur(10);
        p.ajoute("voici");
        p.ajoute("un");
        p.ajoute("test");
        p.ajoute("1234567");
        p.ajoute("123456789");
        System.out.println(p.toString());
        Paragraphe p2 = new ParagrapheGauche();
        p2.fixeLargeur(10);
        p2.ajoute("voici");
        p2.ajoute("un");
        p2.ajoute("autre");
        p2.ajoute("test");
        p2.ajoute("1234567");
        p2.ajoute("123456789");
        System.out.println(p2.toString());
        
    }

    public static void testTexte(){
        Texte test = new TexteCentre("TITRE CENTRE");
        test.fixeLargeur(50);
        test.setFiller("-");
        System.out.println(test.toString());
        Texte testGauche = new TexteGauche("TITRE GAUCHE");
        testGauche.fixeLargeur(50);
        testGauche.setFiller("-");
        System.out.println(testGauche.toString());
        Texte testDroite = new TexteDroite("TITRE DROITE");
        testDroite.fixeLargeur(50);
        testDroite.setFiller("-");
        System.out.println(testDroite.toString());

        Texte haha = new Texte("sus");
        TexteCentre oui = (TexteCentre) haha;

    }
    public static void main(String[] args) {
       testParagrapheGD();
       testTexte();
    }
}
/*
 * 1.Quelle(s) partie(s) de votre programme faut-il modifier pour changer l'alignement
 * (c'est-à-dire pour utiliser la bonne variante de Texte dans l'entête et les titres de chapitres) ?
 * 
 * "duplique" toutes les classes qui utilisent texte/paragraphe et passer les attributs au bon type. --> bcp de classes.
 * Ajouter un attribut alignement dans les classes qui utilisent texte/paragraphe et utiliser des attribus du bon type pour avoir les toString adaptés. (ajout méthodes de tranfser de type ? ex: TexteCentre.toTexteDroite())
 * 
 * 
 * 2.Est-il possible d'écrire un seul programme qui affiche deux fois une texte donné, 
 * d'abord avec les titres centrés et ensuite avec les titres alignés à droite ? 
 * 
 * oui, si il a acces a un objet de type Texte pour cast into TexteCentre/TexteDroite.
 * 
 * 
 * 3. Si quelqu'un souhaite écrire un nouveau type de texte qui s'affiche entouré d'étoiles (mise en valeur) et centré. 
 * Peut-il le faire et utiliser sa solution sans modifier votre code source (excepté le programme principal) ? 
 * 
 * il peut en utilisant un objet de type TexteCentre et en changent le filler en "*".
 */