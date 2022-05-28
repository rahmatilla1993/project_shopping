/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private static String fileName = "C:\\Users\\Admin\\Documents\\"
            + "NetBeansProjects\\project_shopping\\src\\"
            + "project_shopping\\resource\\text.txt";
    
    public FileResource(){
        
    }
    
    public static void WriteUser(User user){
        try {
                file = new File(fileName);
                fileWriter = new FileWriter(file);
                fileReader = new FileReader(file);
                writer = new BufferedWriter(fileWriter);
                reader = new BufferedReader(fileReader);
                writer.write(user.getId_user().toString());
                writer.newLine();
                writer.write(user.getUsername());
                writer.newLine();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public boolean fileExists(){
        return file.exists();
    }
    
    public static void fileDelete(){
        try {
            fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Integer getUserId(){
        try {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (IOException ex) {
            Logger.getLogger(FileResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }
}
