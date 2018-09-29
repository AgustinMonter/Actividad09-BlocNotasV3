/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import Views.ViewCifrador;


public class ModelsCifrador {
    
     ViewCifrador viewcifrador;
        boolean bandera = false;
       String cifrador = "";
       
       private String path;
       private String mensaje = "";
       

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getCaesar(){
        return cifrador;
    }
    
    public void setCaesar(String caesar){
        this.cifrador = cifrador;
    }
    
    public void openFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showOpenDialog(viewcifrador);
        File archivo = jfc.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            JOptionPane.showMessageDialog(viewcifrador, "Nombre del archvio incorrecto");
        }
        else
            path = archivo.getAbsolutePath();
    }
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        mensaje = mensaje + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewcifrador,"No se econtró el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewcifrador,"Error en I/O operación" + ex.getMessage());
        }
    }
    
     public void writeFile(){
             try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.print(mensaje);
                        printWriter.close();
                        
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewcifrador,"Error en I/O operación" + ex.getMessage());
                }
            }
     
     public void stringCifrado(){
        int ascii;
        for(int i=0; i < mensaje.length(); i++){
            if(mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z'){
                if((mensaje.charAt(i) + 1) > 'z'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii + 1 - 26;
                    cifrador= cifrador + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii + 1;
                    cifrador = cifrador + ((char)ascii);
                }
            }
            else if(mensaje.charAt(i)>= 'A' && mensaje.charAt(i) <='Z'){
                if((mensaje.charAt(i) + 1) > 'Z'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii + 1 - 26;
                    cifrador = cifrador + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii + 1;
                    cifrador = cifrador + ((char)ascii);
                }
            }
            
        }
    }
        
    public void Cifrado2String(){
        int ascii;
        for(int i=0; i < mensaje.length(); i++){
            if(mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z'){
                if((mensaje.charAt(i) - 1) < 'a'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii - 1 + 26;
                    cifrador = cifrador + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii - 1;
                    cifrador = cifrador + ((char)ascii);
                }
            }
            else if(mensaje.charAt(i)>= 'A' && mensaje.charAt(i) <='Z'){
                if((mensaje.charAt(i) - 1) < 'A'){
                    ascii = ((int)mensaje.charAt(i));
                    ascii = ascii - 1 + 26;
                    cifrador = cifrador + ((char)ascii);
                }else{
                    ascii =((int)mensaje.charAt(i));
                    ascii = ascii - 1;
                    cifrador = cifrador + ((char)ascii);
                }
            }
            
        }
    }
    
    
}
