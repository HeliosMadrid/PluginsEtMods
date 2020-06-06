package fr.elliot.sratch;

import java.util.ArrayList;
import java.util.List;

public class Pourcentage
{
    public static float nombreDeCombinaisonBonnes;
    public static int issues;
    public static float nombreDeCombinaisonTotal;
    public static float pourcentage;
    public static float combinaison;
    public static float limit;
    public static int jomba;
    public static List<Integer> miss = new ArrayList<Integer>();
    
    public Pourcentage() {System.out.println("Voici toutes les issues: ");}

    public static int CalculDuPoucentage1(int faces1, int faces2, int result)
    {
        nombreDeCombinaisonBonnes = 0;
        limit = faces1 + faces2;
        miss.add(0, result);
        CalculDuPoucentage(faces1, faces1, result, false);

        for(int i = 1; i <= limit - result; i++)
        {
            int mist = result + i;
            miss.add(i , mist);
            
            for(int j = 1; j <= miss.size() - 1; j++)
            {
                CalculDuPoucentage(faces1, faces2, miss.get(j), false);
            }
        }
        
        return miss.size() + 1;
    }
    
    public static float CalculDuPoucentage(int faces1, int faces2, int result, boolean unoudeux)
    {
        nombreDeCombinaisonTotal = faces1 * faces2;
        nombreDeCombinaisonBonnes = 0;
        
        for(int i = 1; i <= faces1; i++)
        {
            for(int j = 1; j <= faces2; j++)
            {
                float com1 = faces1 - (faces1 - i);
                float com2 = faces2 - (faces2 - j);
                combinaison = com1 + com2;
                
                if(unoudeux == false)
                {
                    if(combinaison == result)
                    {
                        issues++;
                        nombreDeCombinaisonBonnes++;
                        System.out.println(com1 + " + " + com2 + " = " + combinaison);
                    }
                }
                else if(unoudeux == true)
                {
                    if(combinaison >= result)
                    {
                        issues++;
                        nombreDeCombinaisonBonnes++;
                        System.out.println(com1 + " + " + com2 + " = " + combinaison);
                    }
                }
            }
        }
        float div = nombreDeCombinaisonBonnes / nombreDeCombinaisonTotal;
        pourcentage = 100 * div;
        
        return pourcentage;
    } 
}
