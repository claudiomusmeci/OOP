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
public class Politica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaPartiti l= new ListaPartiti();
        
        ThreadGestore tg= new ThreadGestore(l);
        ThreadReport tr= new ThreadReport(l);
        
        tg.start();
        tr.start();
    }
    
}
