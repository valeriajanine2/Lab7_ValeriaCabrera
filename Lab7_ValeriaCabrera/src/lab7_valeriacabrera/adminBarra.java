/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_valeriacabrera;

import javax.swing.JProgressBar;

/**
 *
 * @author Usuario
 */
public class adminBarra extends Thread{
    
    private JProgressBar barra;
    private int limite;
    private boolean avanzar;
    private boolean vive;
    
    public adminBarra(JProgressBar barra) {
        this.barra = barra;
        avanzar=true;
        vive=true;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }


    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }


    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }
    
    @Override
    public void run(){
        while(vive){
            //si no quiero que avance la barra
            if(avanzar){
                barra.setValue(barra.getValue()+1);
                //validación para que termine el hilo
                if(barra.getValue()==limite){
                    vive=false;
                }                
            } //FIN IF
            
            try {
                Thread.sleep(20);//poner el descanso para que revise que haya algun cambio en los mutadores
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
