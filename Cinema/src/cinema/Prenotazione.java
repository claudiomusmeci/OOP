/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

/**
 *
 * @author claud
 */
public class Prenotazione {
    private String nomeCliente;
    private int posto;
    
    public Prenotazione(String nomeCliente, int posto){
        this.nomeCliente=nomeCliente;
        this.posto=posto;
    }
    
    public String getCliente(){
        return nomeCliente;
    }
    
    public String toString(){
        return "Nome cliente "+nomeCliente+", posto "+posto;
    }
}
