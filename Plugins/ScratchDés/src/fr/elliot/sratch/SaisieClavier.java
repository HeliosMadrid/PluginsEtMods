package fr.elliot.sratch;

import java.util.Scanner;

public class SaisieClavier
{
    Scanner saisieProf = new Scanner(System.in);
    public int ent;
    
    public void saisieProf(String demande)
    {
        System.out.println(demande);
        ent = saisieProf.nextInt();
    }

    public int getEnt()
    {
        return ent;
    }
}

