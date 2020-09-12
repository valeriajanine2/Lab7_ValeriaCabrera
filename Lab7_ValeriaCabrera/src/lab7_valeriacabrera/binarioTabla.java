/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_valeriacabrera;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class binarioTabla implements Serializable{
    
    private ArrayList<ObjetoTabla> obj = new ArrayList();
    private File archivo = null;

    public binarioTabla(String path) {
        archivo = new File(path);
    }

    public ArrayList<ObjetoTabla> getObj() {
        return obj;
    }

    public void setObj(ArrayList<ObjetoTabla> obj) {
        this.obj = obj;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "Tabla=" + obj;
    }
    
    //extra mutador
    public void setTabla(ObjetoTabla p) {
        this.obj.add(p);
    }

    public void cargarArchivo() {
        try {            
            obj = new ArrayList();//limpiar el arraylist
            ObjetoTabla temp;
            if (archivo.exists()) {//para evitar exception
                  FileInputStream entrada = new FileInputStream(archivo); //apuntar al archivo
                ObjectInputStream objeto = new ObjectInputStream(entrada);//apuntando hacia el canal
                try {
                    //leyendo de objeto en objeto
                    while ((temp = (ObjetoTabla) objeto.readObject()) != null) {//iterar lo que esta en el buffer
                        obj.add(temp);//se agrega cada objeto al arraylist
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();//cerrar el canal
                entrada.close();//cerrar el objeto
            } //fin if           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);//apuntando hacia el archivo
            bw = new ObjectOutputStream(fw);//apuntando hacia el canal
            //sobreescribir sobre el archivo
            for (ObjetoTabla t : obj) {
                bw.writeObject(t);//escribiendo objetos
            }
            //cada nodo del arraylist se escribe
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
}
