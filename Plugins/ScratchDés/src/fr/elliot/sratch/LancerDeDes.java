package fr.elliot.sratch;

import java.util.Random;

public class LancerDeDes
{
    public static int nombreDeLancerDeDes;
    public static int nombreDeFacesDuDes1;
    public static int nombreDeFacesDuDes2;
    public static int resultatAttendu1;
    public static int resultatAttendu2;
    public static int nombreDeResultat1 = 0;
    public static int nombreDeResultat2 = 0;
    public static Random rand = new Random();
    public static int result1;
    public static int result2;
    public static int somme;
    
    public static void lanceLesDes(String nombreDeLancer, String nombreDeFacesDuDe1, String nombreDeFacesDuDe2, String resultatAttendue1, String resultatAttendue2)
    {
        nombreDeLancerDeDes = Integer.valueOf(nombreDeLancer);
        nombreDeFacesDuDes1 = Integer.valueOf(nombreDeFacesDuDe1);
        nombreDeFacesDuDes2 = Integer.valueOf(nombreDeFacesDuDe2);
        resultatAttendu1 = Integer.valueOf(resultatAttendue1);
        resultatAttendu2 = Integer.valueOf(resultatAttendue2);
        System.out.println("vous effectuer " + nombreDeLancerDeDes + " lancer de dés");

            for(int i = 1; i <= nombreDeLancerDeDes; i++)
            {
                result1 = rand.nextInt(nombreDeFacesDuDes1);
                result2 = rand.nextInt(nombreDeFacesDuDes2);
                result1++;
                result2++;
                somme = result1 + result2;
                if(somme == resultatAttendu1)
                {
                    nombreDeResultat1++;
                    System.out.println(i + ": Bravo vous avez fait un lancer qui a une somme de " + somme);
                }
                else if(somme >= resultatAttendu2)
                {
                    nombreDeResultat2++;
                    System.out.println(i + ": Bravo vous avez fait un lancer qui a une somme de " + resultatAttendue2 + " ou +, elle est de " + somme);
                }
                else
                {
                    System.out.println(i +": Pas de chance vous avez fait un lancer qui a une somme de " + somme);
                }
            }
    }
}
