/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziascommesse;
import java.io.*;
import java.util.*;

/**
 *
 * @author claud
 */
public class Scommessa {
    private String tipoScommessa;
    private String descrizione;
    private String data;
    private float importoMinimo;
    private float quotazione;
    LinkedList<Evento> listaEventi;
    
    public Scommessa(String tipoScommessa, String descrizione, String data, float importoMinimo, float quotazione){
        
        this.tipoScommessa=tipoScommessa;
        this.descrizione=descrizione;
        this.data=data;
        this.importoMinimo=importoMinimo;
        this.quotazione=quotazione;
        listaEventi=new LinkedList<Evento>();
    }
    
    public String getTipo(){
        return tipoScommessa;
    }
    
    public float getPuntataMinima(){
        return importoMinimo;
    }
    
    public float getQuotazione(){
        return quotazione;
    }
    
    public LinkedList getGiocate(){
        return listaEventi;
    }
    
    public String toString(){
        return("Evento: "+ tipoScommessa+ " Descrizione: "+ descrizione+ " Data: "+ data+ " Importo minimo: "+ importoMinimo+ " Quotazione: "+ quotazione+ " Lista scommettitori: "+ listaEventi);
    }
    
    public String getEvento(){
        return (tipoScommessa + " "+ descrizione+ " "+ data);
    }
    
  
}
