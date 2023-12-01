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
public class ListaSale {
    private LinkedList<Sala> listaSale;
    private BufferedReader tastiera;
    float ricavoTOT;
    int totPrenotazioni;
    public ListaSale(){
        ricavoTOT=0.0F;
        totPrenotazioni=0;
        listaSale = new LinkedList<Sala>();
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void Stampa(){
        for(Sala lista: listaSale)
            System.out.println(lista);
    }
     
    public synchronized void CaricaDati(){
        String nomeFile;
        BufferedReader fileSale;
        BufferedReader filePrenotazioni;
        try{
            System.out.println("Inserisci il nome del file da cui caricare le sale");
            nomeFile=tastiera.readLine();
            fileSale= new BufferedReader(new FileReader(nomeFile));
            String sala;
            sala=fileSale.readLine();
            while(sala!=null){
                listaSale.add(new Sala(sala, Integer.parseInt(fileSale.readLine()),Float.parseFloat(fileSale.readLine())));
                sala=fileSale.readLine();
            }
            fileSale.close();
            System.out.println("Inserisci il nome del file prenotazioni");
            nomeFile=tastiera.readLine();
            filePrenotazioni=new BufferedReader(new FileReader(nomeFile));
            String nome;
            String nomeSala;
            int posto;
            nome=filePrenotazioni.readLine();
            while(nome!=null){
                nomeSala=filePrenotazioni.readLine();
                posto=Integer.parseInt(filePrenotazioni.readLine());
                for(Sala salaCorretta: listaSale){
                    if(nomeSala.equals(salaCorretta.getSala())){
                       salaCorretta.addPrenotazione(new Prenotazione(nome, posto));
                       break;
                    }
                    
                }
                nome=filePrenotazioni.readLine();
            }
            filePrenotazioni.close();

        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati da file");
            System.exit(-1);
        }
        
        
        
    }
    
    public synchronized void AggiungiPrenotazione(){
        String nome;
        String sala;
        int posto;
        try{
            System.out.println("Inserisci il nome del cliente");
            nome=tastiera.readLine();
            System.out.println("Inserisci il nome della sala");
            sala=tastiera.readLine();
            System.out.println("Inserisci il posto del cliente");
            posto=Integer.parseInt(tastiera.readLine());
            for(Sala salaCorretta: listaSale){
                if((salaCorretta.getSala()).equals(sala)){   
                    if(salaCorretta.getPostiLiberi()>0){
                        salaCorretta.addPrenotazione(new Prenotazione(nome, posto));
                        break;
                    }
                    else throw new MyException("Non ci sono posti liberi");
                }
                    
            }
        }catch(IOException e){
            System.out.println(e); 
        }catch(MyException errore){
            System.out.println("Errore");
        }
    }
    
    public synchronized void EliminaPrenotazione(){
        try{
            System.out.println("Inserisci il nome del cliente di cui vuoi eliminare la prenotazione");
            String nome;
            nome=tastiera.readLine();
            for(Sala salaCorrente: listaSale){
                LinkedList <Prenotazione> listap = salaCorrente.getListaPrenotazioni();
                for(Prenotazione prenotazioneCorrente: listap){
                    if((prenotazioneCorrente.getCliente()).equals(nome)){
                        listap.remove(prenotazioneCorrente);
                        break;
                    }
                } 
            }
        }catch(IOException e){
            System.out.println("Errore");
            System.exit(-1);
        } 
    }
    
    public synchronized void EliminaSala(){
        try{
            System.out.println("Inserisci il nome della sala che vuoi eliminare");
            String nome;
            nome=tastiera.readLine();
            for(Sala salaCorrente: listaSale){
                if((salaCorrente.getSala()).equals(nome)){
                    listaSale.remove(salaCorrente);
                    break;
                }
            }
        }catch(IOException e){
            System.out.println(e);
            System.exit(-1);
        }
        
    }
    
    public synchronized void AggiungiSala(){
        try{
            System.out.println("Inserisci il nome della sala che vuoi aggiungere");
            String nome;
            nome=tastiera.readLine();
            System.out.println("Inserisci la capienza della sala che vuoi aggiungere");
            int capienza;
            capienza= Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci la tariffa della sala che vuoi aggiungere");
            Float tariffa;
            tariffa=Float.parseFloat(tastiera.readLine());
            listaSale.add(new Sala(nome, capienza, tariffa));
        }catch(IOException e){
            System.out.println(e);
            System.exit(-1);
        }
    }
    
    public synchronized int TotalePrenotazioni(){
        totPrenotazioni=0;
        for(Sala salaCorrente: listaSale){
               LinkedList <Prenotazione> listap = salaCorrente.getListaPrenotazioni();
               totPrenotazioni=totPrenotazioni+listap.size();
            }
        return totPrenotazioni;  
    }
     
    public synchronized float RicavoComplessivo(){
        ricavoTOT=0;
        for(Sala salaCorrente: listaSale){
            LinkedList <Prenotazione> listap = salaCorrente.getListaPrenotazioni();
            ricavoTOT= ricavoTOT+(salaCorrente.getTariffa()*listap.size());
        }
        return ricavoTOT;
    }
    
    public synchronized void StampaReport(){
        System.out.println("Le prenotazioni totali sono: "+ totPrenotazioni+ ", i ricavi totali sono "+ ricavoTOT);
    }
}
