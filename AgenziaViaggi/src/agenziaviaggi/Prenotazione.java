/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaviaggi;

/**
 *
 * @author claud
 */
public class Prenotazione {
    private String nome;
    private String codice;
    public Prenotazione(String nome, String codice){
        this.nome=nome;
        this.codice=codice;
    }
        @Override
    public String toString(){
        return(nome+" "+codice);
    }
    
    public String getCodice(){
        return codice;
    }
}
