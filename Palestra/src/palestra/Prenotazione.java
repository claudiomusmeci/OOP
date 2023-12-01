/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palestra;

/**
 *
 * @author claud
 */
public class Prenotazione {
    private String nomeCliente;
    private String data;
    
    public Prenotazione(String nomeCliente, String data){
        this.nomeCliente=nomeCliente;
        this.data=data;
    }
    
    public String getCliente(){
        return nomeCliente;
    }
    
    
    public String toString(){
        return(nomeCliente+" "+ data);
    }
    
}
