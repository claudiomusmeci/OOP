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
public class Scuola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaSezioni L= new ListaSezioni();
        
        ThreadGestore tg= new ThreadGestore(L);
        ThreadReport tr= new ThreadReport(L);
        
        tg.start();
        tr.start();
        
        
        
    }
    
}
