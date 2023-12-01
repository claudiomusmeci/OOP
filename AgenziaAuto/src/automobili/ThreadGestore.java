/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobili;
import java.io.*;
/**
 *
 * @author claud
 */
public class ThreadGestore extends Thread{
    private ListaAuto L;
    private BufferedReader tastiera;
    
    public ThreadGestore(ListaAuto L){
        this.L=L;
        tastiera= new BufferedReader(new InputStreamReader(System.in));
    }
        
        @Override
    public void run(){
        L.caricaDati();
        try{
            while(true){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Inserisci");
                System.out.println("1. Per vendere un'auto ad un cliente");
                System.out.println("2. Per stampare a video le spese di un cliente");
                System.out.println("3. Per stampare il report");
                System.out.println("4. Per stampare il database");
                String scelta;
                scelta=tastiera.readLine();
                switch(Integer.parseInt(scelta)){
                    case 1:
                        L.inserisciCliente();
                        break;
                    case 2:
                        L.stampaAcquisti();
                        break;
                    case 3:
                        L.stampaReport();
                        break;
                    case 4:
                        L.stampaLista();
                        break;
                    default:
                        System.out.println("Scelta non valida, riprova");
                        break;
                }
            }
        }catch(IOException e){
            System.out.println("Errore nel thread di gestione "+e);
        }
    }
}
