/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scuola;
import java.io.*;
/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread{
    private ListaSezioni L;
    private BufferedReader tastiera;
    public ThreadGestore(ListaSezioni L){
        this.L=L;
        tastiera=new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void run(){
        try{
            L.caricaDati();
            while(true){
                System.out.println("Inserisci:");
                System.out.println("1. Per eliminare una sezione e spostare gli alunni in un'altra");
                System.out.println("2. Per Aggiungere una nuova sezione");
                System.out.println("3. Per eliminare un alunno data sezione, nome e cognome");
                System.out.println("4. Per eliminare un alunno dati nome e cognome");
                System.out.println("5. Stampare il report del programma");
                System.out.println("6. Stampare il database");
                int scelta;
                scelta=Integer.parseInt(tastiera.readLine());
                switch(scelta){
                    case 1:
                        L.eliminaSezione();
                        break;
                    case 2:
                        L.aggiungiSezione();
                        break;
                    case 3:
                        L.eliminaAlunnoSez();
                        break;
                    case 4:
                        L.eliminaAlunno();
                        break;
                    case 5:
                        L.stampaReport();
                        break;
                    case 6:
                        L.StampaLista();
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
