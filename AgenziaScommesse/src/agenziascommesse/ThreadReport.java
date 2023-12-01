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
public class ThreadReport extends Thread{
    ListaEventi L;
    public ThreadReport(ListaEventi L){
        this.L=L;
    }
    public void run(){
        try{
            while(true){
            ThreadReport.sleep(2000);
            L.ricavoTotale();
            //L.eventiScelti();
            L.totScommettitori();    
            }
            
        }catch(InterruptedException e){
            System.out.println("Errore nel thread di gestione");
            System.exit(-1);
        }  
    }  
}
