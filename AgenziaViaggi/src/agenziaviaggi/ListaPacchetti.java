/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaviaggi;
import java.util.*;
import java.io.*;
/**
 *
 * @author claud
 */
public class ListaPacchetti {
    private LinkedList<Pacchetto> viaggiLiberi;
    private LinkedList<Pacchetto> viaggiPersona;
    private LinkedList<Pacchetto> listaPacchetti;
    private BufferedReader tastiera;
    private int totale;
    
    public ListaPacchetti(){
        totale=0;
        viaggiLiberi= new LinkedList<Pacchetto>();
        viaggiPersona= new LinkedList<Pacchetto>();
        listaPacchetti=new LinkedList<Pacchetto>();
        tastiera= new BufferedReader( new InputStreamReader(System.in));
    }
    
    public synchronized void stampaLista(){
        for(Pacchetto p: listaPacchetti)
            System.out.println(p);
    }
    
    public synchronized void caricaDati(){
        try{
            System.out.println("Inserisci il nome del file da cui caricare i pacchetti");
            String nomeFile;
            nomeFile=tastiera.readLine();
            BufferedReader filePacchetti= new BufferedReader( new FileReader(nomeFile));
            String identificativo;
            identificativo=filePacchetti.readLine();
            while(identificativo!=null){
                listaPacchetti.add(new Pacchetto(identificativo, filePacchetti.readLine(), Float.parseFloat(filePacchetti.readLine()), Integer.parseInt(filePacchetti.readLine())));
                identificativo=filePacchetti.readLine();
            }
            filePacchetti.close();
            System.out.println("Inserisci il nome del file da cui caricare le prenotazioni");
            nomeFile=tastiera.readLine();
            BufferedReader filePrenotazioni= new BufferedReader( new FileReader(nomeFile));
            identificativo=filePrenotazioni.readLine();
            while(identificativo!= null){
                for(Pacchetto pacchettoCorrente: listaPacchetti){
                    if(pacchettoCorrente.getIdentificativo().equalsIgnoreCase(identificativo)){
                        (pacchettoCorrente.getLista()).add(new Prenotazione(filePrenotazioni.readLine(), filePrenotazioni.readLine()));
                        break;
                    }
                }
                identificativo=filePrenotazioni.readLine();
            }
            filePrenotazioni.close();   
        }catch(IOException e){
            System.out.println("Errore nell'IO");
        }
    }
    
    public synchronized void inserisciPrenotazione(){
        try{
            System.out.println("Inserisci l'identificativo del viaggio");
            String identificativo;
            identificativo=tastiera.readLine();
            System.out.println("Inserisci il nome del cliente");
            String nome;
            nome=tastiera.readLine();
            System.out.println("Inserisci il codice fiscale del cliente");
            String codice;
            codice=tastiera.readLine();
            for(Pacchetto pacchettoCorrente: listaPacchetti){
                if(identificativo.equalsIgnoreCase(pacchettoCorrente.getIdentificativo())){
                    if((pacchettoCorrente.getLista().size()>= pacchettoCorrente.getMax()))
                            throw new NumeroMassimo();
                    for(Prenotazione prenotazioneCorrente: pacchettoCorrente.getLista()){
                        if(codice.equalsIgnoreCase(prenotazioneCorrente.getCodice())){
                            throw new GiaPresente();
                        } 
                    }
                    (pacchettoCorrente.getLista()).add(new Prenotazione(nome, codice));
                    break;
                }
            }
            
        }catch(GiaPresente a){
            System.out.println("La persona e' gia presente");
        }catch(NumeroMassimo n){
            System.out.println("Numero massimo raggiunto");
        }catch(IOException e){
            System.out.println("Errore nell'aggiungere la prenotazione");
        }
    }
    
    public synchronized void cancellaPrenotazione(){
        try{
            System.out.println("Inserisci l'identificativo del viaggio");
            String identificativo;
            identificativo=tastiera.readLine();
            System.out.println("Inserisci il codice fiscale del cliente");
            String codice;
            codice=tastiera.readLine();
            boolean eliminato=false;
            for(Pacchetto p: listaPacchetti){
                if(p.getIdentificativo().equalsIgnoreCase(identificativo)){
                    for(Prenotazione prenotazioneCorrente: p.getLista() ){
                        if(prenotazioneCorrente.getCodice().equalsIgnoreCase(codice)){
                            (p.getLista()).remove(prenotazioneCorrente);
                            eliminato=true;
                            break;
                        }
                    }
                }
                if(eliminato==true)
                    break;
            }
        }catch(IOException e){
            System.out.println("Errore nella cancellazione della prenotazione");
        }
    }
    
    public synchronized void inserisciViaggio(){
        try{
            System.out.println("Inserisci l'identificativo del viaggio");
            String identificativo;
            identificativo=tastiera.readLine();
            System.out.println("Inserisci la descrizione");
            String descrizione;
            descrizione=tastiera.readLine();
            System.out.println("Inserisci il costo a persona");
            float costo;
            costo=Float.parseFloat(tastiera.readLine());
            System.out.println("Inserisci il numero massimo di persone");
            int max;
            max=Integer.parseInt(tastiera.readLine());
            listaPacchetti.add(new Pacchetto(identificativo, descrizione, costo, max));
        }catch(IOException e){
            System.out.println("Errore nell'inserimento del viaggio");
        }
    }
    
    public synchronized void trasferisciPersona(){
        viaggiPersona.clear();
        try{
            System.out.println("Inserisci il codice fiscale della persona");
            String codice;
            codice=tastiera.readLine();
            for(Pacchetto pacchettoCorrente:listaPacchetti){
                for(Prenotazione prenotazioneCorrente: pacchettoCorrente.getLista()){
                    if(codice.equalsIgnoreCase(prenotazioneCorrente.getCodice())){
                        viaggiPersona.add(pacchettoCorrente);
                    }
                }
                
            }
            for(Pacchetto pacchettoCorrente: viaggiPersona)
                System.out.println(pacchettoCorrente);
            
        }catch(IOException e){
            System.out.println("Errore nella creazione della lista");
        }
        
        
    }
    
    public synchronized void totalePersone(){
        totale=0;
        for(Pacchetto pacchettoCorrente: listaPacchetti){
            totale=totale+(pacchettoCorrente.getLista()).size(); 
        }
    }
    
    public synchronized void totaleViaggi(){
        float TOT;
        for(Pacchetto pacchettoCorrente: listaPacchetti){
            TOT=0.0F;
            TOT= ((pacchettoCorrente.getCosto())*(pacchettoCorrente.getLista()).size());
            pacchettoCorrente.setRicavo(TOT);
        }  
    }
    
    public synchronized void listaViaggiLiberi(){
        viaggiLiberi.clear();
        for(Pacchetto pacchettoCorrente: listaPacchetti){
            if(((pacchettoCorrente.getLista()).size())<pacchettoCorrente.getMax())
                viaggiLiberi.add(pacchettoCorrente);
        }
    }
    
    public synchronized void stampaReport(){
        System.out.println("Totale ricavi singoli viaggi");
        for(Pacchetto pacchettoCorrente: listaPacchetti)
            System.out.println("Identificativo pacchetto: "+pacchettoCorrente.getIdentificativo()+", ricavo: "+ pacchettoCorrente.getRicavo());
        
        System.out.println("Lista viaggi con posti disponibili");
        for(Pacchetto pacchettoCorrente: viaggiLiberi)
            System.out.println(pacchettoCorrente);
        System.out.println("Totale persone prenotate");
        System.out.println(totale);
        
    }
    
}
