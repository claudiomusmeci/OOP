/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politica;

import java.io.*;

/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread{
    private ListaPartiti L;
    private BufferedReader tastiera;
    public ThreadGestore(ListaPartiti L){
        this.L=L;
        tastiera=new BufferedReader(new InputStreamReader(System.in));
    }
        @Override
    public void run(){
        try{
            L.caricaDati();
            while(true){
                System.out.println("Inserisci:");
                System.out.println("1. Inserire una nuova circoscrizione");
                System.out.println("2. Cancellare una circoscrizione");
                System.out.println("3. Inserire un nuovo partito");
                System.out.println("4. Trasferire in una lista i voti presi in una circoscrizione");
                System.out.println("5. Stampare il report del programma");
                System.out.println("6. Stampare il database");
                int scelta;
                scelta=Integer.parseInt(tastiera.readLine());
                switch(scelta){
                    case 1:
                        L.inserisciCircoscrizione();
                        break;
                    case 2:
                        L.cancellaCircoscrizione();
                        break;
                    case 3:
                        L.inserisciPartito();
                        break;
                    case 4:
                        L.trasferisci();
                        break;
                    case 5:
                        L.stampaReport();
                        break;
                    case 6:
                        L.stampaLista();
                        break;
                    default:
                        System.out.println("Riprova, scelta non valida");
                        break;
                }
            }
            
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

