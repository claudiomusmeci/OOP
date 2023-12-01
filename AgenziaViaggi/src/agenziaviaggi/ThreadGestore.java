/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaviaggi;
import java.io.*;
/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread{
    private ListaPacchetti L;
    private BufferedReader tastiera;
    public ThreadGestore(ListaPacchetti L){
        this.L=L;
        tastiera= new BufferedReader(new InputStreamReader(System.in));
    }
        @Override
    public void run(){
        L.caricaDati();
        int scelta;
        try{
            while(true){
                System.out.println("Inserisci:");
                System.out.println("1. Inserire una nuova prenotazione");
                System.out.println("2. Cancellare una prenotazione");
                System.out.println("3. Inserire un nuovo viaggio");
                System.out.println("4. Trasferire tutti i viaggi di una persona in una lista");
                System.out.println("5. Stampare il report");
                System.out.println("6. Stampare il database");
                scelta=Integer.parseInt(tastiera.readLine());
                switch(scelta){
                    case 1:
                        L.inserisciPrenotazione();
                        break;
                    case 2:
                        L.cancellaPrenotazione();
                        break;
                    case 3:
                        L.inserisciViaggio();
                        break;
                    case 4:
                        L.trasferisciPersona();
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
            System.out.println("Errore nel thread di gestione");
        }
        
        
        
        
    }
}
