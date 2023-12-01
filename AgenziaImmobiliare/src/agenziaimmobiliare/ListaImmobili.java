/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaimmobiliare;
import java.util.*;
import java.io.*;
/**
 *
 * @author claud
 */
public class ListaImmobili {
    private LinkedList<UnitaImmobiliare> listaImmobili;
    BufferedReader tastiera;
    int totaleImmobili;
    float guadagno;
    
    public ListaImmobili(){
        listaImmobili= new LinkedList<UnitaImmobiliare>();
        totaleImmobili=0;
        guadagno= 0.0F;
        tastiera= new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void stampa(){
        for(UnitaImmobiliare unitaCorrente: listaImmobili)
            System.out.println(unitaCorrente);
    }
    
    public synchronized void caricaDati(){
        try{
            String nomeFile;
            System.out.println("Inserisci il nome del file da cui caricare gli immobili");
            nomeFile=tastiera.readLine();
            BufferedReader fileImmobili;
            fileImmobili= new BufferedReader(new FileReader(nomeFile));
            String identificativo;
            identificativo=fileImmobili.readLine();
            //0 per Appartamento
            //1 per VillaSchiera
            //2 per VillaSingola
            while(identificativo!=null){
                switch(Integer.parseInt(identificativo)){
                case 0:
                    listaImmobili.add(new Appartamento(fileImmobili.readLine(), fileImmobili.readLine(), fileImmobili.readLine(), fileImmobili.readLine(), Float.parseFloat(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine()),Float.parseFloat(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine())));
                    break;
                case 1:
                    listaImmobili.add(new VillaSchiera(fileImmobili.readLine(), fileImmobili.readLine(), fileImmobili.readLine(), fileImmobili.readLine(), Float.parseFloat(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine()),Float.parseFloat(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine()), Float.parseFloat(fileImmobili.readLine())));
                    break;
                case 2:
                    listaImmobili.add(new VillaSingola(fileImmobili.readLine(), fileImmobili.readLine(), fileImmobili.readLine(), fileImmobili.readLine(), Float.parseFloat(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine()),Float.parseFloat(fileImmobili.readLine()), Integer.parseInt(fileImmobili.readLine()), Float.parseFloat(fileImmobili.readLine()), Boolean.parseBoolean(fileImmobili.readLine())));
                    break; 
                }
                
                identificativo=fileImmobili.readLine();
            }
        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati");
            System.exit(-1);
        }
    }
    
    public synchronized void inserisciImmobile(){
        try{
            String tipo, identificativo, descrizione, indirizzo, codiceFiscale;
            float metri, prezzo, giardino;
            int vani, piano, auto, livelli;
            boolean piscina;
            System.out.println("Inserisci il tipo di immobile da aggiungere");
            tipo=tastiera.readLine();
            System.out.println("Inserisci l'identificativo dell'immobile da aggiungere");
            identificativo=tastiera.readLine();
            for(UnitaImmobiliare u: listaImmobili){
                if(identificativo.equals(u.getIdentificativo()))
                    throw new ImmobilePresente();
            }
            System.out.println("Inserisci la descrizione dell'immobile da aggiungere");
            descrizione=tastiera.readLine();
            System.out.println("Inserisci l'indirizzo dell'immobile da aggiungere");
            indirizzo=tastiera.readLine();
            System.out.println("Inserisci il codice fiscale del proprietario dell'immobile da aggiungere");
            codiceFiscale=tastiera.readLine();
            System.out.println("Inserisci i metri dell'immobile da aggiungere");
            metri=Float.parseFloat(tastiera.readLine());
            System.out.println("Inserisci il numero di vani dell'immobile da aggiungere");
            vani=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci il prezzo dell'immobile da aggiungere");
            prezzo=Float.parseFloat(tastiera.readLine());
            switch(Integer.parseInt(tipo)){
                case 0:
                    System.out.println("Inserisci il piano dell'immobile da aggiungere");
                    piano=Integer.parseInt(tastiera.readLine());
                    System.out.println("Inserisci i posti auto dell'immobile da aggiungere");
                    auto=Integer.parseInt(tastiera.readLine());
                    listaImmobili.add(new Appartamento(identificativo, descrizione, indirizzo, codiceFiscale, metri, vani, prezzo, piano, auto));
                    break;
                case 1:
                    System.out.println("Inserisci i livelli dell'immobile da aggiungere");
                    livelli=Integer.parseInt(tastiera.readLine());
                    System.out.println("Inserisci i metri quadrati del giardino dell'immobile da aggiungere");
                    giardino=Float.parseFloat(tastiera.readLine());
                    listaImmobili.add(new VillaSchiera(identificativo, descrizione, indirizzo, codiceFiscale, metri, vani, prezzo, livelli, giardino));
                    break;
                case 2:
                    System.out.println("Inserisci i livelli dell'immobile da aggiungere");
                    livelli=Integer.parseInt(tastiera.readLine());
                    System.out.println("Inserisci i metri quadrati del giardino dell'immobile da aggiungere");
                    giardino=Float.parseFloat(tastiera.readLine());
                    System.out.println("Inserisci true se la piscina e' presente, false se assente");
                    piscina=Boolean.parseBoolean(tastiera.readLine());
                    listaImmobili.add(new VillaSingola(identificativo, descrizione, indirizzo, codiceFiscale, metri, vani, prezzo, livelli, giardino, piscina));
                    break;
            }
            
            
        }catch(IOException e){
            System.out.println("Errore nella lettura dei dati");
            System.exit(-1);
            
        }catch(ImmobilePresente a){
            System.out.println("Immobile già presente");
            System.exit(-1);
        }
    }
    
    public synchronized void immobiliPersona(){
        try{
            String codiceFiscale;
            System.out.println("Inserisci il codice fiscale della persona");
            codiceFiscale=tastiera.readLine();
            for(UnitaImmobiliare u: listaImmobili){
                if(codiceFiscale.equals(u.getCodice()))
                    System.out.println(u);
            }
        }catch(IOException e){
            System.out.println("Errore nell'I/O");
        }
    }
    
    public synchronized void totaleImmobili(){
        totaleImmobili=0;
        totaleImmobili=listaImmobili.size();
    }
    
    public synchronized void giroAgenzia(){
        guadagno=0.0F;
        for(UnitaImmobiliare u: listaImmobili)
            guadagno=guadagno+u.getPrezzo();  
    }
    
    public synchronized void stampaReport(){
        System.out.println("Il numero totale di immobili e':"+totaleImmobili+", il ricavo dell'agenzia e':"+guadagno);
    }
    
}
