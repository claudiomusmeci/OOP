/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author claud
 */
public class ThreadReport extends Thread{
    private ListaClienti L;
    
    public ThreadReport(ListaClienti L){
        this.L=L;
    }
    
    public void run(){
        try{
            ThreadReport.sleep(4000);
            L.clientiShop();
            
        }catch(InterruptedException e){
            System.out.println("Errore nel thread di gestione");
        }
    }
    
    
}
