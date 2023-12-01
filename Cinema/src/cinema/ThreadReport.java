/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;
import java.util.*;
import java.io.*;

/**
 *
 * @author claud
 */
public class ThreadReport extends Thread{
    private ListaSale listaSale;
    
    public ThreadReport(ListaSale listaSale){
        this.listaSale=listaSale;
    }
 
    public void run(){
        while(true){
            try{
            ThreadReport.sleep(5000);
            listaSale.TotalePrenotazioni();
            listaSale.RicavoComplessivo();
            }catch(InterruptedException e){
                System.out.println("Errore nel thread di gestione");
            }
        }
    }
}
    
    
    

