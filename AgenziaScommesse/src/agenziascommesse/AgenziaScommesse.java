/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziascommesse;
/**
 *
 * @author claud
 */
public class AgenziaScommesse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEventi L= new ListaEventi();
        
        ThreadGestore gestore = new ThreadGestore(L);
        ThreadReport report = new ThreadReport(L);
        
        gestore.start();
        report.start();
    }
    
}
