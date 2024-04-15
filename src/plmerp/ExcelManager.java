/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plmerp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


// en gros, on définit les objets sans rien. Puis dès qu'on manipule des 
// clauses qui nécessite un genre de manipulation terminal, il faut encadrer
// le truc avec les clauses d'erreur possible

public class ExcelManager {
    public static void ExcelManager(){};
    
    public static void createurFichier(){
        
        XSSFWorkbook libreFile = new XSSFWorkbook();
        XSSFSheet onglet = libreFile.createSheet();
        
        Object[][] donne = {
            {"Java", "sfzefzef", "87"},
            {"Java", "sfzefzef", "87"},
            {"Java", "sfzefzef", "87"},
            {"Java", "sfzefzef", "87"},
            {"Java", "sfzefzef", "87"},
            {"Java", "sfzefzef", "87"},
        };
        
        int ligneCompteur = 0;
        for(Object[] booka : donne){
            Row lignes = onglet.createRow(ligneCompteur);
            int colonneCompteur = 0;
            Cell cel;
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
            FileOutputStream f0 = new FileOutputStream("C:/Users/Pm/Desktop/Code/enregistremenExcel2.xls");
            libreFile.write(f0);
            libreFile.close();
            f0.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static ArrayList lecteurFichier(String lienFichierExcel){ // on attend une valeur de type : "C:/Users/Pm/Desktop/Code/enregistremenExcel.xls"
        ArrayList contentFichier = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(new File(lienFichierExcel));
            XSSFWorkbook fichier1 = new XSSFWorkbook(fis);
            XSSFSheet onglet1 = fichier1.getSheetAt(0);
            XSSFRow ligne1;
            Cell cell1;
            for(Iterator ligneIt=onglet1.iterator();ligneIt.hasNext();){
                ligne1=(XSSFRow)ligneIt.next();
                
                for(Iterator CellIt=ligne1.iterator(); CellIt.hasNext();){
                    cell1 = (Cell)CellIt.next();
                    //System.out.println(cell1+" de type "+cell1.getCellType());
                    contentFichier.add(cell1);
                }
            }   
        } catch (IOException ex){
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contentFichier;
    }
    
}
