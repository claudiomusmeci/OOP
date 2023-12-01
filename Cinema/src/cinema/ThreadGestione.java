/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;
import java.io.*;
import java.util.*;

/**
 *
 * @author claud
 */
public class ThreadGestione extends Thread{
    private ListaSale listaSale;
    private BufferedReader tast= new BufferedReader(new InputStreamReader(System.in));
    private int running;
    public ThreadGestione(ListaSale listaSale){
        this.listaSale=listaSale;
    }
    
    public void run(){
        listaSale.CaricaDati();
        
        while(running==0){
                System.out.println("---------------------------------------------------------------");
                System.out.println("Inserisci:");
                System.out.println("1)Per inserire una nuova prenotazione:");
                System.out.println("2)Per cancellare una prenotazione dato il nome del cliente");
                System.out.println("3)Per aggiungere una sala");
                System.out.println("4)Per eliminare una sala");
                System.out.println("5)Per stampare il report");
                System.out.println("Inserisci qualsiasi altro numero per uscire");
                System.out.println("---------------------------------------------------------------");
               int scelta=0;
               try{
                    scelta=Integer.parseInt(tast.readLine());
                }catch(IOException e){
                    System.out.println("Errore "+e);
                    System.exit(-1);
                }
               switch(scelta){
                   case 1:
                       listaSale.AggiungiPrenotazione();
                       break;
                   case 2:
                       listaSale.EliminaPrenotazione();
                       break;
                   case 3:
                       listaSale.AggiungiSala();
                       break;
                   case 4:
                       listaSale.EliminaSala();
                       break;
                   case 5: 
                       listaSale.StampaReport();
                       break;
                   default:
                       System.out.println("Scelta non valida");
                       running=1;
                       break;
               }
               System.out.println("\n");      
        }
    }    
}
