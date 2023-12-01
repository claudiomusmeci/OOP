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
public class ThreadReport extends Thread{
    private ListaPartiti L;
    
    public ThreadReport(ListaPartiti L){
        this.L=L;
    }
    
    public void run(){
        try{
            while(true){
                ThreadGestore.sleep(2000);
                L.totalePartito();
                L.maggioreVotanti();
                L.totaleVotanti();
            }
        }catch(InterruptedException e){
            System.out.println("Errore nel thread report");
        }
        
        
        
    }
}
