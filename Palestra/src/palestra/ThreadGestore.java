/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palestra;
import java.io.*;
/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread{
    private ListaCorsi L;
    private BufferedReader tastiera;
    public ThreadGestore(ListaCorsi L){
        this.L=L;
        tastiera= new BufferedReader(new InputStreamReader(System.in));
    }
     public void run(){
         try{
             L.caricaDati();
             int scelta;
             while(true){
                 System.out.println("Inserisci la tua scelta");
                 System.out.println("1. Eliminare un corso");
                 System.out.println("2. Aggiungere un corso");
                 System.out.println("3. Inserire una nuova prenotazione");
                 System.out.println("4. Cancellare una prenotazione");
                 System.out.println("5. Stampare il report");
                 System.out.println("6. Stampare il database");
                 scelta=Integer.parseInt(tastiera.readLine());
                 switch(scelta){
                     case 1:
                         L.eliminaCorso();
                         break;
                     case 2:
                         L.aggiungiCorso();
                         break;
                     case 3:
                         L.aggiungiPrenotazione();
                         break;
                     case 4:
                         L.cancellaPrenotazione();
                         break;
                     case 5:
                         L.stampaReport();
                         break;
                     case 6:
                         L.stampaLista();
                         break;
                     default:
                         System.out.println("Scelta non valida, riprova");
                         break;
                 }   
             }
         }catch(IOException e){
             System.out.println(e);
         }  
     }
}
