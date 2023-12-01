/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziascommesse;
import java.io.*;
import java.util.*;
/**
 *
 * @author claud
 */
public class ListaEventi {
    private LinkedList<Scommessa> listaScommesse2;
    private float ricavo;
    private int numeroScommesse;
    private LinkedList<Scommessa> listaScommesse;
    private BufferedReader tastiera;
    public ListaEventi(){
        ricavo=0.0F;
        numeroScommesse=0;
        listaScommesse2= new LinkedList<Scommessa>();
        listaScommesse= new LinkedList<Scommessa>();
        tastiera= new BufferedReader( new InputStreamReader(System.in));
    }
    
    public synchronized void Stampa(){
        for(Scommessa scommessaCorrente: listaScommesse){
            System.out.println(scommessaCorrente);
        }
    }
    
    public synchronized void Stampa2(){
        for(Scommessa scommessaCorrente: listaScommesse2){
            System.out.println(scommessaCorrente);
        }
    }
    
    public synchronized void caricaDati(){
        try{
            String nomeFile;
            String evento;
            BufferedReader fileScommesse;
            BufferedReader fileEventi;
            System.out.println("Inserisci il nome del file da cui caricare gli eventi");
            nomeFile=tastiera.readLine();
            fileScommesse=new BufferedReader( new FileReader(nomeFile));
            //Leggo i diversi tipi di scommessa dal file scommesse
            evento=fileScommesse.readLine();
            while(evento!=null){
                listaScommesse.add(new Scommessa(evento, fileScommesse.readLine(), fileScommesse.readLine(), Float.parseFloat(fileScommesse.readLine()),Float.parseFloat(fileScommesse.readLine())));
                evento=fileScommesse.readLine();
            }
            fileScommesse.close();
            //Leggo i diversi tipi di eventi e li sistemo nelle relative liste
            System.out.println("Inserisci il nome del file da cui caricare le scommesse effettuate");
            nomeFile=tastiera.readLine();
            fileEventi=new BufferedReader( new FileReader(nomeFile));
            evento=fileEventi.readLine();
            while(evento!=null){
                for(Scommessa scommessaCorrente: listaScommesse){
                    if(evento.equals(scommessaCorrente.getTipo())){
                        (scommessaCorrente.getGiocate()).add(new Evento(fileEventi.readLine(), fileEventi.readLine(), Float.parseFloat(fileEventi.readLine())));
                        break;
                    }
                }
                evento=fileEventi.readLine();
            }
            fileEventi.close();
           
        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati "+ e);
            System.exit(-1);
            }
        
        
        
        
    }
    
    public synchronized void inserisciTipoScommessa(){
        try{
            String nomeEvento;
            System.out.println("Inserisci il nome del nuovo evento sportivo");
            nomeEvento=tastiera.readLine();
            for(Scommessa scommessaCorrente: listaScommesse){
                if(nomeEvento.equals(scommessaCorrente.getTipo()))
                    throw new TipoPresente();
            }
            String descEvento;
            System.out.println("Inserisci la descrizione del nuovo evento sportivo");
            descEvento=tastiera.readLine();
            String dataEvento;
            System.out.println("Inserisci la data del nuovo evento sportivo");
            dataEvento=tastiera.readLine();
            float minimoEvento;
            System.out.println("Inserisci la scommessa minima del nuovo evento sportivo");
            minimoEvento=Float.parseFloat(tastiera.readLine());
            float quotEvento;
            System.out.println("Inserisci la quotazione del nuovo evento sportivo");
            quotEvento=Float.parseFloat(tastiera.readLine());
            listaScommesse.add(new Scommessa(nomeEvento, descEvento, dataEvento, minimoEvento, quotEvento));
        }catch(TipoPresente e){
            System.exit(-1);
        }catch(IOException e){
            System.exit(-1);
        }
    }
    
    public synchronized void inserisciGiocata(){
        try{
            String nomeGiocata;
            System.out.println("Inserisci il nome dell'evento sportivo");
            nomeGiocata=tastiera.readLine();
            
            String personaGiocata;
            System.out.println("Inserisci il nome della persona");
            personaGiocata=tastiera.readLine();
            
            String codiceGiocata;
            System.out.println("Inserisci il codice fiscale della persona");
            codiceGiocata=tastiera.readLine();
            
            float puntataGiocata=0.0F;
            System.out.println("Inserisci la scommessa ");
            puntataGiocata=Float.parseFloat(tastiera.readLine());
            
            for(Scommessa scommessaCorrente: listaScommesse){
                if(nomeGiocata.equals(scommessaCorrente.getTipo())){
                    if(puntataGiocata<scommessaCorrente.getPuntataMinima()){
                        throw new PuntataBassa();
                    }
                    (scommessaCorrente.getGiocate()).add(new Evento(personaGiocata, codiceGiocata, puntataGiocata));
                    break;
                }
                    
            }
        }catch(IOException e){
            System.out.println("Errore nella ricezione dei dati");
            System.exit(-1);
        }catch(PuntataBassa e){
            System.exit(-1);
        }
    }
    
    public synchronized void calcoloPagamenti(){
         try{
            float pagamento=0.0F;
            String nomeEvento;
            System.out.println("Inserisci il nome del nuovo evento sportivo");
            nomeEvento=tastiera.readLine();
            for(Scommessa scommessaCorrente: listaScommesse){
                if(nomeEvento.equals(scommessaCorrente.getTipo())){
                    for(Evento eventoCorrente: scommessaCorrente.listaEventi){
                        pagamento=pagamento+((eventoCorrente.getImporto())*scommessaCorrente.getQuotazione());
                    }
                    break;
                }     
            }
            System.out.println("L'importo da pagare e': "+pagamento);
         
        }catch(IOException e){
            System.exit(-1);
        }   
        
        
    }
    
    public synchronized void salvaFile(){
        try{
            BufferedWriter scrittore;
            String codice;
            System.out.println("Inserisci il codice fiscale della persona");
            codice=tastiera.readLine();
            scrittore=new BufferedWriter( new FileWriter("prova.txt"));
            for(Scommessa scommessaCorrente: listaScommesse){
                for(Evento eventoCorrente: scommessaCorrente.listaEventi){
                    if(codice.equals(eventoCorrente.getCodice())){
                        scrittore.write(scommessaCorrente.getEvento()+"\n");
                    }
                }
            }
            
            scrittore.close();
        }catch(IOException e){
            System.exit(-1);
        }
        
        
    }
    
    public synchronized float ricavoTotale(){
        ricavo=0;
        for(Scommessa scommessaCorrente: listaScommesse){
            for(Evento eventoCorrente: scommessaCorrente.listaEventi){
                ricavo=ricavo+eventoCorrente.getImporto();
            }
        }
        return ricavo;
    }
    
    public synchronized LinkedList eventiScelti(){
        try{
            Float soglia;
            System.out.println("Inserisci una soglia");
            soglia=Float.parseFloat(tastiera.readLine());
            for(Scommessa scommessaCorrente: listaScommesse){
                if(scommessaCorrente.getPuntataMinima()>= soglia){
                    listaScommesse2.add(scommessaCorrente);
                }
            }   
        }catch(IOException e){
            System.exit(-1);
        }
        return listaScommesse2;
    }
    
    public synchronized int totScommettitori(){
        numeroScommesse=0;
        for(Scommessa scommessaCorrente: listaScommesse){
            numeroScommesse=numeroScommesse+(scommessaCorrente.getGiocate()).size();
        }
        return numeroScommesse;
    }
    
    public synchronized void rimuoviScelti(){
        if(listaScommesse2.size()!=0){
            listaScommesse2.clear();
        }
    }
    
    public synchronized void stampaReport(){
        System.out.println("Il ricavo e':"+ricavo+ ", il numero di persone che hanno scommesso e': "+numeroScommesse);
    }
    
}
