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
public class Carros implements Serializable {
    
    private static final long SerialVersionUID=777L; //version
    
    private String placa;
    private String tam;
    private int puertas;
    private int sucio;

    public Carros() {
    }

    public Carros(String placa, String tam, int puertas, int sucio) {
        this.placa = placa;
        this.tam = tam;
        this.puertas = puertas;
        this.sucio = sucio;
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

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getSucio() {
        return sucio;
    }

    public void setSucio(int sucio) {
        this.sucio = sucio;
    }

    @Override
    public String toString() {
        return placa;
    }
    
    
    
}
