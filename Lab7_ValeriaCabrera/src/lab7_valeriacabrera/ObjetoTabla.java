/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_valeriacabrera;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class ObjetoTabla implements Serializable{
    
    private String placa;
    private String tam;
    private int sucio;
    private int limite;
    
    private static final long SerialVersionUID=999L;

    public ObjetoTabla() {
    }

    public ObjetoTabla(String placa, String tam, int sucio, int limite) {
        this.placa = placa;
        this.tam = tam;
        this.sucio = sucio;
        this.limite = limite;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public int getSucio() {
        return sucio;
    }

    public void setSucio(int sucio) {
        this.sucio = sucio;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return placa;
    }
    
    
    
}
