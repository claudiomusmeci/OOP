/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaimmobiliare;

/**
 *
 * @author claud
 */
public class ThreadReport extends Thread{
    ListaImmobili L;
    
    public ThreadReport(ListaImmobili L){
        this.L=L;
    }
    
    public void run(){
        try{
            while(true){
                ThreadReport.sleep(2000);
                L.totaleImmobili();
                L.giroAgenzia();
                
            }
        }catch(InterruptedException e){
            System.out.println("Errore nel thread di report");
        }
    }
}
