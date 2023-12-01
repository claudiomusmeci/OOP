/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politica;
import java.io.*;
import java.util.*;

/**
 *
 * @author claud
 */
public class ListaPartiti {
    int maggiore, votanti, maxVoti;
    
    private LinkedList<Risultato> lista;
    private LinkedList<Partito> listaPartiti;
    private BufferedReader tastiera;
    
    public ListaPartiti(){
        maggiore=0;
        votanti=0;
        maxVoti=0;
        lista= new LinkedList<Risultato>();
        listaPartiti= new LinkedList<Partito>();
        tastiera= new BufferedReader(new InputStreamReader(System.in));
    }
    
    public synchronized void stampaLista(){
        for(Partito partito: listaPartiti)
            System.out.println(partito);
    }
    
    public synchronized void caricaDati(){
        try{
            System.out.println("Inserisci il nome del file da cui caricare i partiti");
            String nomeFile;
            nomeFile=tastiera.readLine();
            BufferedReader filePartiti=new BufferedReader(new FileReader(nomeFile));
            String nome;
            nome=filePartiti.readLine();
            while(nome!=null){
                listaPartiti.add(new Partito(nome, filePartiti.readLine(), filePartiti.readLine(),Integer.parseInt(filePartiti.readLine())));
                nome=filePartiti.readLine();
            }
            System.out.println("Inserisci il nome del file da cui caricare i risultati");
            nomeFile=tastiera.readLine();
            BufferedReader fileRisultati= new BufferedReader(new FileReader(nomeFile));
            nome=fileRisultati.readLine();
            while(nome!=null){
                for(Partito partitoCorrente: listaPartiti){
                    if(nome.equalsIgnoreCase(partitoCorrente.getNome())){
                        (partitoCorrente.getLista()).add(new Risultato(nome,Integer.parseInt(fileRisultati.readLine()),Integer.parseInt(fileRisultati.readLine())));
                        break;
                    }
                }
                nome=fileRisultati.readLine();
            }
        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati da file");
            System.exit(-1);
        }
    }
    
    public synchronized void inserisciCircoscrizione(){
        try{
            System.out.println("Inserisci il nome del partito");
            String nome;
            nome=tastiera.readLine();
            System.out.println("Inserisci il numero della circoscrizione");
            int numero;
            numero=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci il numero di voti");
            int voti;
            voti=Integer.parseInt(tastiera.readLine());
            
            for(Partito partitoCorrente: listaPartiti){
                if(partitoCorrente.getNome().equalsIgnoreCase(nome)){
                    for(Risultato circoscrizioneCorrente: partitoCorrente.getLista()){
                        if(circoscrizioneCorrente.getNumero()==numero)
                            throw new Presente();
                    }
                    (partitoCorrente.getLista()).add(new Risultato(nome, numero, voti));
                    break;
                }
            }
        }catch(Presente p){
            System.out.println("Circoscrizione gia' presente");
            System.exit(-1);
        }catch(IOException e){
            System.out.println("Errore nell'inserimento");
            System.exit(-1);
        }
    }
    
    public synchronized void cancellaCircoscrizione(){
        try{
            System.out.println("Inserisci il numero della circoscrizione");
            int numero;
            numero= Integer.parseInt(tastiera.readLine());
            
            for(Partito p: listaPartiti){
                for(Risultato r: p.getLista()){
                    if(numero==r.getNumero()){
                        System.out.println("Rimuovo la circoscrizione "+r+"\n");
                        p.getLista().remove(r);
                    }
                        
                        
                }
                
            }
        }catch(IOException e){
            System.out.println("Errore nella rimozione");
        }
    }
    
    public synchronized void inserisciPartito(){
        try{
            System.out.println("Inserisci il nome del partito");
            String nome;
            nome=tastiera.readLine();
            System.out.println("Inserisci la sigla del partito");
            String sigla;
            sigla=tastiera.readLine();
            System.out.println("Inserisci il nome del segretario del partito");
            String segretario;
            segretario=tastiera.readLine();
            System.out.println("Inserisci il numero dei tesserati del partito");
            int numero;
            numero=Integer.parseInt(tastiera.readLine());
            
            listaPartiti.add(new Partito(nome, sigla, segretario, numero));
        }catch(IOException e){
            System.out.println("Errore nell'inserimento");
            System.exit(-1);
        }
    }
    
    public synchronized void trasferisci(){
        try{
            lista.clear();
            System.out.println("Inserisci il numero della circoscrizione");
            int numero;
            numero=Integer.parseInt(tastiera.readLine());
            for(Partito partito: listaPartiti){
                for(Risultato risultato: partito.getLista()){
                    if(numero==risultato.getNumero())
                        lista.add(risultato);
                }
            }
            
        }catch(IOException e){
            System.out.println("Errore nell'inserimento");
        }
    }
    
    public synchronized void totalePartito(){
        int n;
        for(Partito partitoCorrente: listaPartiti){
            n=0;
            for(Risultato circoscrizione: partitoCorrente.getLista()){
                n=n+circoscrizione.getVoti();
            }
            partitoCorrente.setTotale(n);
        }
    }
    
    public synchronized void maggioreVotanti(){
     
        int circo;
        int voti=0;
        int circoMax=-1;
        int votiMax=-1;
        
        
        for(Partito p: listaPartiti){
            for(Risultato r: p.getLista()){
                circo=r.getNumero();
                
                for(Partito par: listaPartiti){
                    for(Risultato ris: par.getLista()){
                        if(circo==ris.getNumero()){
                            voti=voti+ris.getVoti();
                        }
                    }
                }
                    
                if(voti>votiMax){
                    circoMax=circo;
                    votiMax=voti;
                }
                    
                voti=0;
            }
        }
        maggiore=circoMax;
        maxVoti=votiMax;
        
    }
    
    public synchronized void totaleVotanti(){
        int n=0;
        for(Partito partitoCorrente: listaPartiti){
            for(Risultato circoscrizione: partitoCorrente.getLista()){
                n=n+circoscrizione.getVoti();
            }
        }
        votanti=n;
    }
    
    public synchronized void stampaReport(){
        for(Partito p: listaPartiti)
            System.out.println(p.getNome()+" "+p.getTotale());
        System.out.println("La circoscrizione con più votanti e': "+maggiore+" con "+maxVoti);
        System.out.println("Il numero totale di votanti e': "+votanti);
    }
}
