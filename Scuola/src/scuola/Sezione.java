/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scuola;
import java.util.*;
/**
 *
 * @author claud
 */
public class Sezione {
    private char sezione;
    private int anno;
    private String posizione;
    private LinkedList<Alunno> listaAlunni;
    private int insufficienze;
    private int totAlunni;
    
    public Sezione(char sezione, int anno, String posizione){
        this.sezione=sezione;
        totAlunni=0;
        insufficienze=0;
        this.anno=anno;
        this.posizione=posizione;
        listaAlunni=new LinkedList<Alunno>();
    }
    
    public int getTotale(){
        return totAlunni;
    }
    
    public void setTotale(int tot){
        totAlunni=tot;
    }
    
    public String toString(){
        return("Sezione: "+sezione+" Anno: "+anno+" Posizione: "+posizione+" Alunni: "+listaAlunni);
    }
    
    public void setInsufficienze(int numero){
        insufficienze=numero;
    }
    
    public char getSezione(){
        return sezione;
    }
    
    public int getAnno(){
        return anno;
    }
    
    public LinkedList<Alunno> getAlunni(){
        return listaAlunni;
    }
}
