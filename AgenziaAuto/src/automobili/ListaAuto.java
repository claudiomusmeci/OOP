/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobili;
import java.io.*;
import java.util.*;

/**
 *
 * @author claud
 */
public class ListaAuto {
    private LinkedList<Auto> listaAuto;
    private BufferedReader tastiera;
    private float scontoMassimo;
    private String nome;
    private String fiscale;
    
    public ListaAuto(){
        scontoMassimo=0.0F;
        nome=" ";
        fiscale= " ";
        listaAuto=new LinkedList<Auto>();
        tastiera= new BufferedReader( new InputStreamReader(System.in));
    }
    
    public void stampaLista(){
        for(Auto a: listaAuto)
            System.out.println(a);
            
    }
    
    public synchronized void caricaDati(){
        try{
            String nomeFile, modello;
            System.out.println("Inserisci il nome del file da cui caricare le auto (auto.txt)");
            nomeFile=tastiera.readLine();
            BufferedReader fileAuto;
            fileAuto = new BufferedReader(new FileReader(nomeFile));
            modello=fileAuto.readLine();
            while(modello!=null){
                listaAuto.add(new Auto(modello, Integer.parseInt(fileAuto.readLine()),fileAuto.readLine(), Float.parseFloat(fileAuto.readLine())));
                modello=fileAuto.readLine();
            }
            fileAuto.close();
            System.out.println("Inserisci il nome del file da cui caricare gli acquisti dei clienti (clienti.txt)");
            nomeFile=tastiera.readLine();
            BufferedReader fileClienti;
            fileClienti = new BufferedReader(new FileReader(nomeFile));
            String letto;
            letto=fileClienti.readLine();
            while(letto!=null){
                for(Auto autoCorrente: listaAuto){
                    if((Integer.parseInt(letto))==autoCorrente.getCodice()){
                        (autoCorrente.getLista()).add(new Cliente(Integer.parseInt(letto), fileClienti.readLine(), fileClienti.readLine(), fileClienti.readLine(), Float.parseFloat(fileClienti.readLine())));
                        break;
                    }
                }
                letto=fileClienti.readLine();
            }
            fileClienti.close();
        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati da file "+e);
        }
        
        
        
        
    }
    
    public synchronized void inserisciCliente(){
        try{
            System.out.println("Inserisci il codice del modello");
            int codice;
            codice=Integer.parseInt(tastiera.readLine());
            //Utilizzo un booleano per stabilire la presenza o meno del modello
            boolean trovato=false;
            for(Auto autoCorrente: listaAuto){
                if(codice== autoCorrente.getCodice()){
                    System.out.println("Inserisci il codice fiscale del cliente");
                    String cFiscale;
                    cFiscale=tastiera.readLine();
                    System.out.println("Inserisci il nome del cliente");
                    String cliente;
                    cliente=tastiera.readLine();
                    System.out.println("Inserisci l'anno di acquisto");
                    String anno;
                    anno=tastiera.readLine();
                    System.out.println("Inserisci il suo sconto personale");
                    float sconto;
                    sconto=Float.parseFloat(tastiera.readLine());
                    (autoCorrente.getLista()).add(new Cliente(codice, cFiscale, cliente, anno, sconto));
                    trovato=true;
                    break;
                }
            }
            if(trovato==false)
                throw new Assente();
            
            
            
        }catch(Assente a){
            System.out.println("L'auto inserita non esiste nel database");
        }catch(IOException e){
            System.out.println("Errore nell'inserimento "+e);
        }
        
        
    }
    
    public synchronized void stampaAcquisti(){
        try{
            float tot=0.0F;
            System.out.println("Inserisci il codice fiscale del cliente");
            String cFiscale;
            cFiscale=tastiera.readLine();
            for(Auto a: listaAuto){
                for(Cliente c: a.getLista()){
                    if(cFiscale.equalsIgnoreCase(c.getFiscale())){
                        System.out.println(a.getModello()+" "+a.getCodice()+" "+a.getMarca()+" "+a.getPrezzo());
                        tot=tot+(a.getPrezzo()-(a.getPrezzo()*(c.getSconto()/100)));
                    }
                }
            }
            System.out.println("Il cliente ha speso in totale con i propri sconti: "+tot+" euro");
        }catch(IOException e){
            System.out.println("Errore nella stampa "+e);
        }
        
    }
    
    public synchronized void scontoMax(){
        //Stampo il valore massimo di percentuale e il relativo possessore 
        float sconto=-1.0F;
        String nomeCliente=" ";
        String codice=" ";
        for(Auto a : listaAuto){
            for(Cliente c: a.getLista()){
                if(c.getSconto()>sconto){
                    sconto=c.getSconto();
                    nomeCliente=c.getNome();
                    codice=c.getFiscale();
                }
            }
        }
        nome=nomeCliente;
        fiscale=codice;
        scontoMassimo=sconto;
        
    }
    
    public synchronized void stampaReport(){
        System.out.println("Il cliente che ha ricevuto lo sconto maggiore e': "+nome+" "+fiscale+" "+ scontoMassimo+"%");
    }
}
