/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobili;

/**
 *
 * @author claud
 */
public class Cliente {
    private int codice;
    private String cFiscale;
    private String nome;
    private String data;
    private float sconto;
    
    public Cliente(int codice, String cFiscale, String nome, String data, float sconto){
        this.codice=codice;
        this.cFiscale=cFiscale;
        this.nome=nome;
        this.data=data;
        this.sconto=sconto;
    }
        @Override
    public String toString(){
        return(cFiscale+" "+nome+" "+data+" "+sconto);
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getFiscale(){
        return cFiscale;
    }
    
    public float getSconto(){
        return sconto;
    }
}
