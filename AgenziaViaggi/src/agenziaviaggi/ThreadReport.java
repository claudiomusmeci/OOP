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
public class ThreadReport extends Thread {
    private ListaPacchetti L;
    
    public ThreadReport(ListaPacchetti L){
        this.L=L;
    }
        @Override
    public void run(){
        try{
            while(true){
                ThreadReport.sleep(2000);
                L.totaleViaggi();
                L.listaViaggiLiberi();
                L.totalePersone();
            }
           
        }catch(InterruptedException e){
            System.out.println("Erroe nel thread di gestione");
        }
    }
    
}
