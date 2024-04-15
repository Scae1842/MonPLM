/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plmerp;

import interfacePackage.PageAccueil;

/**
 *
 * @author Pm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // declaration de variables
        PageERP1 monERP = new PageERP1();
        
        // procedure creer et lire un fichier localiser, puis montrrer deux fois un truc on dirait
//        ExcelManager Fichier1  = new ExcelManager();
//        Fichier1.createurFichier();
//        Fichier1.lecteurFichier("C:/Users/Pm/Desktop/Code/enregistremenExcel.xls");
//        String LienFichier = "C:/Users/Pm/Desktop/Code/enregistremenExcel.xls";
//        System.out.println(Fichier1.lecteurFichier(LienFichier));

        
        // procedure : montrer un contenu de dictionnaire        
//        monERP.setVentes();
        monERP.setVentes(monERP.lienDuCSV);
        monERP.shower();
        
//        
        //ouvre la page d'application
//        PageAccueil page1 = new PageAccueil();
//        page1.setVisible(true);

    }
    
}
