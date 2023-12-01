/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaviaggi;

/**
 *
 * @author claud
 */
public class AgenziaViaggi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaPacchetti L= new ListaPacchetti();
        ThreadGestore tg= new ThreadGestore(L);
        ThreadReport tr= new ThreadReport(L);
        
        tg.start();
        tr.start();
    }
    
}
