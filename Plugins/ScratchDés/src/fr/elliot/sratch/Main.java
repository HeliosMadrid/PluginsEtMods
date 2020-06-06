package fr.elliot.sratch;


public class Main
{
    private static SaisieClavier saisieClavier = new SaisieClavier();
    
    public static void main(String[] args)
    {
        System.out.println("Bonjour Monsieur Cherry ce programme est très basique car je suis à mes débuts dans le domaine de la programmation mais il simule correctement des lancer de dés");
        
        if(args.length >= 1)
        {
            saisieClavier.saisieProf("Combien de lancer voulez vous effectuer ?");
            String nombreDeLanceer = String.valueOf(saisieClavier.getEnt());
            saisieClavier.saisieProf("Combien de face voulez-vous pour votre premier dé ?");
            String nombreDeFacesPourLeDe1 = String.valueOf(saisieClavier.getEnt());
            saisieClavier.saisieProf("Combien de face voulez-vous pour votre deuxième dé ?");
            String nombreDeFacesPourLeDe2 = String.valueOf(saisieClavier.getEnt());
            saisieClavier.saisieProf("Quelle est le résultat que vous souhaiter vérifier en égaliter parfaite ?");
            String resultat1 = String.valueOf(saisieClavier.getEnt());
            saisieClavier.saisieProf("Quelle est le résultat que vous souhaiter vérifier en supérieur ou égale à ?");
            String resultat2 = String.valueOf(saisieClavier.getEnt());
            LancerDeDes.lanceLesDes(nombreDeLanceer, nombreDeFacesPourLeDe1, nombreDeFacesPourLeDe2, resultat1, resultat2);
            System.out.println("Voici toute les issues : ");
            float simul1 = Pourcentage.CalculDuPoucentage(Integer.valueOf(nombreDeFacesPourLeDe1), Integer.valueOf(nombreDeFacesPourLeDe2), Integer.valueOf(resultat1), false);
            float simul2 = Pourcentage.CalculDuPoucentage(Integer.valueOf(nombreDeFacesPourLeDe1), Integer.valueOf(nombreDeFacesPourLeDe2), Integer.valueOf(resultat2), true);
            System.out.println("Pour ces lancer il y avait " + Pourcentage.CalculDuPoucentage1(Integer.valueOf(nombreDeFacesPourLeDe1), Integer.valueOf(nombreDeFacesPourLeDe2), Integer.valueOf(resultat2)) + " évènements que vous désirais et " + Pourcentage.issues + " d'issues qui faisait ces évènements le pourcentage d'obtenir " + resultat1 + " était de " + simul1 + "% et le pourcentage de chance d'obtenir " + resultat2 + " ou plus était de " + simul2 + "% et vous avez fait " + LancerDeDes.nombreDeResultat2 + " de " + resultat2 + " ou +, et " + LancerDeDes.nombreDeResultat1 + " lancer qui on eu comme somme " + resultat1 + " pour un total de " + LancerDeDes.nombreDeLancerDeDes + " lancer de dés");
        }
        
        else
        {
            System.out.println("la syntaxe est: java -Xms24M - Xmx24M - jar scratch.jar <nombre de lancer des dés>");
        }
    }
}
