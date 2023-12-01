/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palestra;

/**
 *
 * @author claud
 */
public class ThreadReport extends Thread{
    private ListaCorsi L;
    public ThreadReport(ListaCorsi L){
        this.L=L;
    }
    
    public void run(){
        while(true){
            try{
                ThreadReport.sleep(2000);
                L.totalePrenotazioni();
                L.postiDisponibili();
                L.ricavoComplessivo();
            
            }catch(InterruptedException e){
                System.out.println("Errore nel thread di report");
                System.exit(-1);
            }
            
        }    
    }
}
