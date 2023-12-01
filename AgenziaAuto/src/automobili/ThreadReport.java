/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobili;

/**
 *
 * @author claud
 */
public class ThreadReport extends Thread{
    private ListaAuto L;
    
    public ThreadReport(ListaAuto L){
        this.L=L;
    }
    
        @Override
    public void run(){
        try{
            while(true){
                ThreadReport.sleep(2000);
                L.scontoMax();
            }
        }catch(InterruptedException e){
            System.out.println("Errore nel thread di report");
        }
    }
}
