/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plmerp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Pm
 */

public class PageERP1 {
    public static void PageERP1(){
    
    }
    
    private HashMap<String, Integer> ventesSemaine = new HashMap<>();
    public static Object[][] ventesTableau = {{"Mardi", 56},{"Mercredi", 90},{"Jeudi", 14}};
    public static String[] enteteTableau = {"JOUR", "QUANTITE"};
    
    public String lienDuCSV = "C:/Users/Pm/Desktop/Code/Java/VentesduJour.csv";
    
    public void shower(){
        for (Object e : ventesSemaine.keySet()){
            var f = ventesSemaine.get(e);
            System.out.println("le jour "+e+", il a ete vendu tant: "+f);
        }
        
        System.out.println("Souhaitez-vous exporter sous excel?");
        Scanner inputUser = new Scanner(System.in);
        String answer = inputUser.nextLine();
        if ("ui".equals(answer)){
            System.out.println("Ca roule");
            createReport(ventesTableau, enteteTableau);
        } else { 
            System.out.println("Ben va chier");
        }
        
    }
    public static void createReport(Object[][] tableau, Object[] entete){
        // ingérer les données
        // creer le fichier excel qui fait le report
        //
        XSSFWorkbook libreFile = new XSSFWorkbook();
        XSSFSheet onglet = libreFile.createSheet();
        
        Row lignes = onglet.createRow(0);
        Cell cel;
        int enteteColonne = 0;
        for (Object e : entete){
            cel = lignes.createCell(enteteColonne);
            cel.setCellValue((String) e);
            ++enteteColonne;
        }
        int ligneCompteur = 1;
        for(Object[] booka : tableau){
            lignes = onglet.createRow(ligneCompteur);
            int colonneCompteur = 0;
            
            for(Object cellule : booka){
                cel = lignes.createCell(colonneCompteur);
                if(cellule instanceof String){
                    cel.setCellValue((String) cellule);  
                }
                else if(cellule instanceof Integer){
                    cel.setCellValue((Integer) cellule);
                }
            ++colonneCompteur;    
            }
        ++ligneCompteur; 
        }
        try {
            FileOutputStream f0 = new FileOutputStream("C:/Users/Pm/Desktop/Code/Java/VentesduJour.xls");
            libreFile.write(f0);
            libreFile.close();
            f0.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setVentes(){
        ventesSemaine.put("Mardi", 56);
        ventesSemaine.put("Mercredi", 90);
        ventesSemaine.put("Jeudi", 14);
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<ArrayList<String>> getVentes(String linkCSV){
        var tokenligne = new ArrayList<ArrayList<String>>();
        try {
            FileReader file = new FileReader(linkCSV);
            try (BufferedReader reader = new BufferedReader(file)) {
                String ligne = reader.readLine();
                while(ligne!=null){
                    ArrayList intermediaire = new ArrayList<String>();
                    for(int i = 0; i < ligne.split(",").length; i++){
                        intermediaire.add(ligne.split(",")[i]);
                    }
                    //System.out.println(intermediaire);
                    tokenligne.add(intermediaire);
                    //System.out.println(tokenligne);
                    ligne = reader.readLine();
                }
            }
        } catch(IOException e) {
        }
        return tokenligne;
    }

    public void createUnReport(ArrayList<ArrayList<String>> tableau){
        XSSFWorkbook libreFile = new XSSFWorkbook();
        XSSFSheet onglet = libreFile.createSheet();
        
        Row lignes;
        Cell cel;
        for(int i = 0; i < tableau.size(); i++){
            lignes = onglet.createRow(i);            
            for(int j = 0; j < (tableau.get(0)).size(); j++){
                cel = lignes.createCell(j);
                if((tableau.get(i)).get(j) instanceof String){
                    cel.setCellValue((String) (tableau.get(i)).get(j));  
                }
            }
        }
        try {
            FileOutputStream f0 = new FileOutputStream("C:/Users/Pm/Desktop/Code/Java/VentesduJour2.xls");
            libreFile.write(f0);
            libreFile.close();
            f0.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
