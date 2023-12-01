/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palestra;
import java.util.*;
/**
 *
 * @author claud
 */
public class Corsi {
    private String nomeCorso;
    private String nomeIstruttore;
    private int capienza;
    private float costo;
    private int postiLiberi;
    private LinkedList<Prenotazione> listaPrenotazioni;
    
    public Corsi(String nomeCorso, String nomeIstruttore, int capienza, float costo){
        this.nomeCorso=nomeCorso;
        this.nomeIstruttore=nomeIstruttore;
        this.capienza=capienza;
        this.costo=costo;
        postiLiberi=0;
        listaPrenotazioni=new LinkedList<Prenotazione>();
    }
    
    public String toString(){
        return (nomeCorso+" "+nomeIstruttore+" "+capienza+" "+costo+" "+listaPrenotazioni);  
    }
    
    public LinkedList<Prenotazione> getPrenotazioni(){
        return listaPrenotazioni;
    }
    
    public String getCorso(){
        return nomeCorso;
    }
    
    public int getCapienza(){
        return capienza;
    }
    
    public float getTariffa(){
        return costo;
    }
    
    public int getPostiLiberi(){
        return postiLiberi;
    }
    
    public void setPostiLiberi(int postiLiberi){
        this.postiLiberi=postiLiberi;
    }
}

