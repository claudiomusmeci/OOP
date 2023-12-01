/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politica;

/**
 *
 * @author claud
 */
public class Risultato {
    private String nome;
    private int numero;
    private int voti;
    
    public Risultato(String nome, int numero, int voti){
        this.nome=nome;
        this.numero=numero;
        this.voti=voti;
    }
    
    public String toString(){
        return nome+" "+numero+" "+voti;
    }
    
    public int getVoti(){
        return voti;
    }
    
    public int getNumero(){
        return numero;
    }
}
