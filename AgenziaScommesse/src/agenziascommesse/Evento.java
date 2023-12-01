/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziascommesse;

/**
 *
 * @author claud
 */
public class Evento {
    private String nomeCliente;
    private String codiceFiscale;
    private float importo;
    
    public Evento( String nomeCliente, String codiceFiscale, float importo){
        this.nomeCliente=nomeCliente;
        this.codiceFiscale=codiceFiscale;
        this.importo=importo;
    }
    
    public String getCodice(){
        return codiceFiscale;
    }
    
    public float getImporto(){
        return importo;
    }
    
    public String toString(){
        return ("Nome cliente: "+nomeCliente+" Codice fiscale: "+codiceFiscale+ " Ha scommesso: "+importo );
    }
    
}
