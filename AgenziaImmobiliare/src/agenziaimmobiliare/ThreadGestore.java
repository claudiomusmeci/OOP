/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaimmobiliare;
import java.io.*;
/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread{
    
    ListaImmobili L;
    BufferedReader tastiera;
    
    public ThreadGestore(ListaImmobili L){
        this.L=L;
        tastiera=new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void run(){
        try{
            L.caricaDati();
            String scelta;
            while(true){
                System.out.println("Inserisci");
                System.out.println("1. Per aggiungere un nuovo immobile");
                System.out.println("2. Per stampare a schermo gli immobili di una persona");
                System.out.println("3. Per stampare il report");
                System.out.println("4. Per stampare il database");
                scelta=tastiera.readLine();
                switch(Integer.parseInt(scelta)){
                    case 1:
                        L.inserisciImmobile();
                        break;
                    case 2:
                        L.immobiliPersona();
                        break;
                    case 3:
                        L.stampaReport();
                        break;
                    case 4:
                        L.stampa();
                        break;
                    default:
                        System.out.println("Ripeti la scelta, scelta non valida");
                        break;
                }
            }
        }catch(IOException e){
            System.out.println("Errore nel thread di gestione");
        }
    }
}
