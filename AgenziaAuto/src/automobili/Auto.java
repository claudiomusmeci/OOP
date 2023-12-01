/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobili;
import java.util.*;
/**
 *
 * @author claud
 */
public class Auto {
    private String modello;
    private int codice;
    private String marca;
    private float prezzo;
    private LinkedList<Cliente> listaClienti;
    
    public Auto(String modello, int codice, String marca, float prezzo){
        this.modello=modello;
        this.codice=codice;
        this.marca=marca;
        this.prezzo=prezzo;
        listaClienti=new LinkedList<Cliente>();
    }
        @Override
    public String toString(){
        return (modello+" "+codice+" "+marca+" "+prezzo+" "+listaClienti);
    }
    
    public int getCodice(){
        return codice;
    }
    
    public String getModello(){
        return modello;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public float getPrezzo(){
        return prezzo;
    }
    
    public LinkedList<Cliente> getLista(){
        return listaClienti;
    }
}
