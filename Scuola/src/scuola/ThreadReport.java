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
public class ThreadReport extends Thread{
    
    private ListaSezioni L;
    
    public ThreadReport(ListaSezioni L){
        this.L=L;
    }
    
    public void run(){
        try{
            while(true){
                ThreadReport.sleep(1000);
                L.totaleStudenti();
                L.sezionePeggiore();
                L.studentiInsufficienti();
            }
            
        }catch(InterruptedException e){
            System.out.println(e);
        }
        
    }
    
}
