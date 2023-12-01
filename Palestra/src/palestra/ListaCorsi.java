/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palestra;
import java.util.*;
import java.io.*;

/**
 *
 * @author claud
 */
public class ListaCorsi {
    private LinkedList<Corsi> listaCorsi;
    private BufferedReader tastiera;
    private int prenotazioniTOT;
    private float ricavo;
    
    public ListaCorsi(){
        ricavo=0.0F;
        prenotazioniTOT=0;
        listaCorsi=new LinkedList<Corsi>();
        tastiera= new BufferedReader( new InputStreamReader(System.in));
    }
    
    public void stampaLista(){
        for(Corsi corsoCorrente: listaCorsi)
            System.out.println(corsoCorrente);
    }
    
    public synchronized void caricaDati(){
        try{
            System.out.println("Inserisci il nome del file da cui caricare i dati");
            String nomeFile;
            nomeFile=tastiera.readLine();
            BufferedReader fileCorsi;
            fileCorsi=new BufferedReader(new FileReader(nomeFile));
            String nomeCorso;
            nomeCorso=fileCorsi.readLine();
            while(nomeCorso!=null){
                listaCorsi.add(new Corsi(nomeCorso, fileCorsi.readLine(), Integer.parseInt(fileCorsi.readLine()), Float.parseFloat(fileCorsi.readLine())));
                nomeCorso=fileCorsi.readLine();
            }
            fileCorsi.close();
            System.out.println("Inserisci il nome del file da cui caricare le prenotazioni");
            nomeFile=tastiera.readLine();
            BufferedReader filePrenotazioni;
            filePrenotazioni=new BufferedReader(new FileReader(nomeFile));
            String nomeCliente;
            nomeCliente=filePrenotazioni.readLine();
            while(nomeCliente!=null){
                nomeCorso=filePrenotazioni.readLine();
                for(Corsi corsoCorrente: listaCorsi){
                    if(nomeCorso.equalsIgnoreCase(corsoCorrente.getCorso())){
                        (corsoCorrente.getPrenotazioni()).add(new Prenotazione(nomeCliente, filePrenotazioni.readLine()));
                        break;
                    }
                }
                nomeCliente=filePrenotazioni.readLine();
            }
            filePrenotazioni.close();
            
            
        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati");
            System.exit(-1);
            
        }
        
        
        
        
        
    }
    
    public synchronized void eliminaCorso(){
        try{
            System.out.println("Inserisci il nome del corso che vuoi eliminare");
            String nomeCorso;
            nomeCorso=tastiera.readLine();
            for(Corsi corsoCorrente: listaCorsi){
                if(nomeCorso.equalsIgnoreCase(corsoCorrente.getCorso())){
                    listaCorsi.remove(corsoCorrente);
                    break;
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
        
        
    }
    
    public synchronized void aggiungiCorso(){
        try{
            String nomeCorso;
            String nomeIstruttore;
            int capienza;
            float tariffa;
            System.out.println("Inserisci il nome del corso da aggiungiere");
            nomeCorso=tastiera.readLine();
            System.out.println("Inserisci il nome dell'istruttore");
            nomeIstruttore=tastiera.readLine();
            System.out.println("Inserisci la capienza");
            capienza=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci la tariffa");
            tariffa=Float.parseFloat(tastiera.readLine());
            
            listaCorsi.add(new Corsi(nomeCorso, nomeIstruttore, capienza, tariffa));
        }catch(IOException e){
            System.out.println(e);
        }
        
        
    }
    
    public synchronized void aggiungiPrenotazione(){
        try{
            System.out.println("Inserisci il nome del corso");
            String nomeCorso;
            nomeCorso=tastiera.readLine();
            System.out.println("Inserisci il nome del cliente");
            String nomeCliente;
            nomeCliente=tastiera.readLine();
            System.out.println("Inserisci la data");
            String data;
            data=tastiera.readLine();
            
            for(Corsi corsoCorrente: listaCorsi){
                if(nomeCorso.equalsIgnoreCase(corsoCorrente.getCorso())){
                    if(corsoCorrente.getCapienza()>(corsoCorrente.getPrenotazioni()).size()){
                        (corsoCorrente.getPrenotazioni()).add(new Prenotazione(nomeCliente, data));
                    }
                    else
                        throw new PostiOccupati();
                    
                    break;
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }catch(PostiOccupati p){
            System.out.println("Non ci sono posti liberi per questo corso");
            System.exit(-1);
        }
        
        
    }
    
    public synchronized void cancellaPrenotazione(){
        try{
            System.out.println("Inserisci il nome del cliente");
            String nomeCliente;
            boolean x = false;
            nomeCliente=tastiera.readLine();   
            for(Corsi corsoCorrente: listaCorsi){
                for(Prenotazione prenotazioneCorrente: corsoCorrente.getPrenotazioni()){
                    if(nomeCliente.equalsIgnoreCase(prenotazioneCorrente.getCliente())){
                        (corsoCorrente.getPrenotazioni()).remove(prenotazioneCorrente);
                        x = true;
                        break;
                    }
                }
                if(x==true)
                    break;
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
    
    public synchronized void totalePrenotazioni(){
        prenotazioniTOT=0;
        for(Corsi corsoCorrente: listaCorsi){
            prenotazioniTOT=prenotazioniTOT+(corsoCorrente.getPrenotazioni()).size();
        }
        
    }
    
    public synchronized void postiDisponibili(){
        int x;
        for(Corsi corsoCorrente: listaCorsi){
            x=corsoCorrente.getCapienza()-(((corsoCorrente.getPrenotazioni()).size()));
            corsoCorrente.setPostiLiberi(x);
        }
    }
    
    public synchronized void ricavoComplessivo(){
        ricavo=0.0F;
        for(Corsi corsoCorrente: listaCorsi){
            ricavo= ricavo +(corsoCorrente.getTariffa()*(corsoCorrente.getPrenotazioni()).size());
        }
    }
    
    public synchronized void stampaReport(){
        System.out.println("Prenotazioni totali:"+prenotazioniTOT+" ricavo complessivo:"+ ricavo);
        for(Corsi corsoCorrente: listaCorsi)
            System.out.println("Corso: "+ corsoCorrente.getCorso()+ " posti liberi "+ corsoCorrente.getPostiLiberi());
        
    }
}
