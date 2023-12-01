/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;
import java.io.*;
/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread {
    private ListaClienti L;
    BufferedReader tastiera;
    public ThreadGestore(ListaClienti L){
        this.L=L;
        tastiera=new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void run(){
        try{
            L.caricaDati();
            L.riempiLista();
            int scelta;
            while(true){
                System.out.println("Inserisci:");
                System.out.println("1. Vendere un nuovo farmaco");
                System.out.println("2. Stampare i clienti che hanno comprato un determinato farmaco di una lista");
                System.out.println("3. Stampa report");
                System.out.println("4. Stampa database");
                scelta=Integer.parseInt(tastiera.readLine());
                switch(scelta){
                    case 1:
                        L.vendiFarmaco();
                        break;
                    case 2:
                        L.stampaClienti();
                        break;
                    case 3:
                        L.stampaReport();
                        break;
                    case 4:
                        L.stampa();
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
