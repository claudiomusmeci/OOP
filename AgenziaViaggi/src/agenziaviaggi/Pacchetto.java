/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaviaggi;
import java.util.*;
/**
 *
 * @author claud
 */
public class Pacchetto {
    private String identificativo;
    private String descrizione;
    private float costo;
    private int numeroMax;
    private float ricavo;
    private LinkedList<Prenotazione> listaPrenotazioni;
    
    public Pacchetto(String identificativo, String descrizione, float costo, int numeroMax){
        this.identificativo=identificativo;
        this.descrizione=descrizione;
        this.costo=costo;
        this.numeroMax=numeroMax;
        listaPrenotazioni=new LinkedList<Prenotazione>();
        ricavo=0.0F;
    }
    
        @Override
    public String toString(){
        return(identificativo+" "+descrizione+" "+costo+" "+numeroMax+" "+listaPrenotazioni);
    }
    
    public void setRicavo(float ricavo){
        this.ricavo=ricavo;
    }
    public float getRicavo(){
        return ricavo;
    }
    
    public float getCosto(){
        return costo;
    }
    
    public int getMax(){
        return numeroMax;
    }
    
    public String getIdentificativo(){
        return identificativo;
    }
    
    public LinkedList<Prenotazione> getLista(){
        return listaPrenotazioni;
    }
}
