/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scuola;

/**
 *
 * @author claud
 */
public class Alunno {
    private String nomeAlunno;
    private String dataNascita;
    private int nDebiti;
    private char sezione;
    private int anno;
    
    public Alunno(String nomeAlunno, String dataNascita, int nDebiti){
        this.nomeAlunno=nomeAlunno;
        this.dataNascita=dataNascita;
        this.nDebiti=nDebiti;
    }
    
    public String toString(){
        return (nomeAlunno+" "+dataNascita+" "+nDebiti);
    }
    
    public char getSezione(){
        return sezione;
    }
    
    public int getAnno(){
        return anno;
    }
    
    public String getNome(){
        return nomeAlunno;
    }
    
    public String getData(){
        return dataNascita;
    }
    public int getDebiti(){
        return nDebiti;
    }
    
}
