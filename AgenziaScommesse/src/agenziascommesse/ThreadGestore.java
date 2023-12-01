/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziascommesse;
import java.io.*;

/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread {
    ListaEventi L;
    BufferedReader tastiera = new BufferedReader( new InputStreamReader(System.in));
    
    public ThreadGestore(ListaEventi L){
        this.L=L;
    }
    
    public void run(){
        try{
            L.caricaDati();
            while(true){
                int scelta=0;
                System.out.println("Inserisci la tua scelta");
                System.out.println("1)Inserire un nuovo evento sportivo");
                System.out.println("2)Inserire una nuova scommessa");
                System.out.println("3)Dato un evento sportivo, calcolare l'importo da pagare");
                System.out.println("4)Data una persona, stampare su file gli eventi su cui ha scommesso");
                System.out.println("5)Stampare il report");
                System.out.println("6)Stampare il database");
                scelta=Integer.parseInt(tastiera.readLine());
                switch(scelta){
                   case 1:
                      L.inserisciTipoScommessa();
                      break;
                  case 2:
                      L.inserisciGiocata();
                      break;
                  case 3:
                      L.calcoloPagamenti();
                      break;
                  case 4:
                      L.salvaFile();
                      break;
                  case 5:
                      L.eventiScelti();
                      L.Stampa2();
                      L.rimuoviScelti();
                      L.stampaReport();
                      break;
                  case 6:
                      L.Stampa();
                      break;
                  default:
                      System.out.println("Scelta non valida, riprova");
                      break;
            }    
        }         
        }catch(IOException e){
            System.out.println("Errore nella gestione del thread principale");
            System.exit(-1);
        }
    }
}
