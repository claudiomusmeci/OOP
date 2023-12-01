/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;
import java.io.*;
import java.util.*;
/**
 *
 * @author claud
 */
public class Farmaco {
   
    private String nome;
    private String codiceFarmaco;
    private float costo;
    private String data;
   
    public Farmaco(String nome, String codiceFarmaco, float costo, String data){this.nome=nome;
        this.codiceFarmaco=codiceFarmaco;
        this.costo=costo;
        this.data=data;
    }
    
  
    public String toString(){
        return nome+" "+codiceFarmaco+" "+costo+" "+data;
    }
   
    public String getData(){
        return data;
    }
    
    public String getCodice(){
        return codiceFarmaco;
    }
}
