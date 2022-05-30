/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project_shopping.models.User;

/**
 *
 * @author Admin
 */
public class FileResource {
    private static File file;
    private static FileWriter fileWriter;
    private static BufferedWriter writer;
    private static FileReader fileReader;
    private static BufferedReader reader;
    private final static String fileName = "C:\\Users\\Admin\\Documents\\"
            + "NetBeansProjects\\project_shopping\\src\\"
            + "project_shopping\\resource\\text.txt";
    
    public FileResource(){
        
    }
    
    public static void WriteUser(User user){
        try {
                file = new File(fileName);
                createWriteBuffer();
                writer.write(user.getId_user().toString());
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private static void createReadBuffer(){
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void createWriteBuffer(){
        try {
            fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static boolean existsProductId(Integer id_prod){
        try {
            createReadBuffer();
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null){
                if(Integer.parseInt(line) == id_prod){
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void WriteProductId(Integer id_prod){
        if(!existsProductId(id_prod)){
            try {
            writer.write(id_prod.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public static boolean fileExists(){
        return file != null;
    }
    
    public static void fileDelete(){
        createWriteBuffer();
    }
    
    public static List<Integer> getProductIds(){
        List<Integer> ids = new ArrayList<>();
        try {
            String line;
            while((line = reader.readLine()) != null){
                ids.add(Integer.parseInt(line));
            }
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ids;
    }
    
    public static Integer getUserId(){
        try {
            createReadBuffer();
            String line = reader.readLine();
            if(line != null){
                return Integer.parseInt(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
}
