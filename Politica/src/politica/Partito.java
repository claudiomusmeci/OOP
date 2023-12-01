/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politica;
import java.util.*;
/**
 *
 * @author claud
 */
public class Partito {
    private String nome;
    private String sigla;
    private String segretario;
    private int tesserati;
    private int totale;
    private LinkedList<Risultato> listaRisultato;
    
    public Partito(String nome, String sigla, String segretario, int tesserati){
        this.nome=nome;
        this.sigla=sigla;
        this.segretario=segretario;
        this.tesserati=tesserati;
        listaRisultato= new LinkedList<Risultato>();
        totale=0;
    }
    
    public String toString(){
        return (nome+" "+sigla+" "+segretario+" "+tesserati+" "+listaRisultato);
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getTotale(){
        return totale;
    }
    
    public void setTotale(int n){
        totale=n;
    }
    
    public LinkedList<Risultato> getLista(){
        return listaRisultato;
    }
}
