/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plmerp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
    public static Object[] enteteTableau = {"JOUR", "QUANTITE"};
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
    public void setVentes(String linkCSV){
        File file = new File(linkCSV);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(PageERP1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ventesSemaine.put(23);
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Une information importante");
            bw.close();
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}
