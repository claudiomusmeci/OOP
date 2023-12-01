/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;
import java.util.*;

/**
 *
 * @author claud
 */
public class Cliente {
    private String nome;
    private String codice;
    private float punti;
    private LinkedList<Farmaco> listaFarmaci;
    
    public Cliente(String nome, String codice, float punti){
        this.nome=nome;
        this.codice=codice;
        this.punti=punti;
        listaFarmaci=new LinkedList<Farmaco>();
    }
    
    public String toString(){
        return(nome+" "+codice+" "+punti+" "+listaFarmaci);
    }
    
    public float getPunti(){
        return punti;
    }
    
    public void setPunti(float newPunti){
        punti=newPunti;
    }
    
    public String getCodice(){
        return codice;
    }
    
    public LinkedList<Farmaco> getFarmaci(){
        return listaFarmaci;
    }
}
