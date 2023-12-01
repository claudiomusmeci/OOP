/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.*;

/**
 *
 * @author claud
 */
public class Sala {
    private String nomeSala;
    private int capienza;
    private float tariffaGiornaliera;
    private LinkedList<Prenotazione> listaPrenotazioni;
    
    public Sala( String nome, int  posti, float  prezzo){
        nomeSala=nome;
        capienza=posti;
        tariffaGiornaliera=prezzo;
        listaPrenotazioni= new LinkedList<Prenotazione>();
    }
    
    public String toString(){
        return "Nome Sala "+nomeSala+" di capienza "+capienza+ "tariffa "+ tariffaGiornaliera+ "prenotati "+ listaPrenotazioni;
    }
    
    public String getSala(){
        return nomeSala;
    }
    
    public float getTariffa(){
        return tariffaGiornaliera;
    }
    
    public LinkedList getListaPrenotazioni(){
        return listaPrenotazioni;
    }
    
    public void addPrenotazione(Prenotazione a){
        listaPrenotazioni.add(a);
    }
    
    public int getPostiLiberi(){
        return capienza - listaPrenotazioni.size();
    }
}
