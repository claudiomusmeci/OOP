/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scuola;
import java.util.*;
import java.io.*;

/**
 *
 * @author claud
 */
public class ListaSezioni {
    private int aSezPeggiore;
    private char nSezPeggiore;
    private LinkedList<Sezione> listaSezioni;
    private LinkedList<Alunno> listaAlunniIns;
    BufferedReader tastiera;
    
    public ListaSezioni(){
        aSezPeggiore=0;
        nSezPeggiore='.';
        listaAlunniIns=new LinkedList<Alunno>();
        listaSezioni= new LinkedList<Sezione>();
        tastiera= new BufferedReader(new InputStreamReader(System.in));
    }
    
    public LinkedList<Alunno> getListaAlunniIns(){
        return listaAlunniIns;
    }
    
    public synchronized void StampaLista(){
        for(Sezione sezioneCorrente: listaSezioni)
            System.out.println(sezioneCorrente);
    }
    
    public synchronized void caricaDati(){
        try{
            System.out.println("Inserisci il nome del file da cui caricare le sezioni");
            String nomeFile;
            nomeFile=tastiera.readLine();
            BufferedReader fileSezioni;
            fileSezioni=new BufferedReader(new FileReader(nomeFile));
            String stringa;
            char nomeSezione;
            stringa=(fileSezioni.readLine());
            while(stringa!=null){
                nomeSezione=stringa.charAt(0);
                listaSezioni.add(new Sezione(nomeSezione, Integer.parseInt(fileSezioni.readLine()), fileSezioni.readLine()));
                stringa=(fileSezioni.readLine());
            }
            fileSezioni.close();
            
            System.out.println("Inserisci il nome del file da cui caricare gli alunni");
            nomeFile=tastiera.readLine();
            BufferedReader fileAlunni;
            fileAlunni=new BufferedReader(new FileReader(nomeFile));
            int annoSezione;
            stringa=fileAlunni.readLine();
            annoSezione=Integer.parseInt(fileAlunni.readLine());
            while(stringa!=null){
                nomeSezione=stringa.charAt(0);
                for(Sezione sezioneCorrente: listaSezioni){
                    if((sezioneCorrente.getSezione()==nomeSezione)&&(sezioneCorrente.getAnno()==annoSezione)){
                        (sezioneCorrente.getAlunni()).add(new Alunno(fileAlunni.readLine(), fileAlunni.readLine(), Integer.parseInt(fileAlunni.readLine())));
                        break;
                    }
                }
                stringa=fileAlunni.readLine();
                if(stringa==null)
                    break;
                annoSezione=Integer.parseInt(fileAlunni.readLine());
            }
            fileAlunni.close();
        }catch(IOException e){
            System.out.println("Errore nel caricamento dei dati da file");
            System.exit(-1);
        }
        
        
        
    }
    
    public synchronized void eliminaSezione(){
        try{
            System.out.println("Inserisci la sezione della classe che vuoi spostare");
            String nomeMittente;
            String nomeDestinatario;
            int numeroMittente;
            int numeroDestinatario;
            String nome;
            String data;
            int debiti;
                                
            nomeMittente=tastiera.readLine();
            System.out.println("Inserisci l'anno della classe che vuoi spostare");
            numeroMittente=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci la sezione della classe dove aggiungere gli alunni");
            nomeDestinatario=tastiera.readLine();
            numeroDestinatario= numeroMittente;
            for(Sezione sezioneCorrente: listaSezioni){
                if((sezioneCorrente.getSezione()==nomeMittente.charAt(0))&&(sezioneCorrente.getAnno()==numeroMittente)){
                    for(Sezione sezioneRichiesta: listaSezioni){
                        if((sezioneRichiesta.getSezione()==nomeDestinatario.charAt(0))&&(sezioneRichiesta.getAnno()==numeroDestinatario)){
                            for(Alunno alunnoCorrente: sezioneCorrente.getAlunni()){
                                nome=alunnoCorrente.getNome();
                                data=alunnoCorrente.getData();
                                debiti=alunnoCorrente.getDebiti();
                                
                                (sezioneRichiesta.getAlunni()).add(new Alunno(nome, data, debiti));
                            }
                        } 
                    }
                    break;
                }
            }
            for(Sezione sezioneCorrente: listaSezioni){
                if((sezioneCorrente.getSezione()==nomeMittente.charAt(0))&&(sezioneCorrente.getAnno()==numeroMittente)){
                    listaSezioni.remove(sezioneCorrente);
                    break;
                }
            }
            
        }catch(IOException e){
            System.out.println("Errore nello spostamento degli alunni");
        }
    }
    
    public synchronized void aggiungiSezione(){
        try{
            String nomeSez, posizioneSez;
            int annoSez;
            System.out.println("Inserisci il nome della sezione da aggiungere");
            nomeSez=tastiera.readLine();
            System.out.println("Inserisci l'anno della sezione da aggiungere");
            annoSez=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci la posizone della sezione da aggiungere");
            posizioneSez=tastiera.readLine();
            listaSezioni.add(new Sezione(nomeSez.charAt(0), annoSez, posizioneSez));
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        
        
        
        
    }
    
    public synchronized void eliminaAlunnoSez(){
        try{
            String nomeAlunno;
            String nomeSez;
            boolean trovato= false;
            int annoSez;
            System.out.println("Inserisci il nome della sezione");
            nomeSez=tastiera.readLine();
            System.out.println("Inserisci l'anno della sezione");
            annoSez=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci il nome e il cognome dell'alunno");
            nomeAlunno=tastiera.readLine();
            
            for(Sezione sezioneCorrente: listaSezioni){
                if((sezioneCorrente.getSezione()==nomeSez.charAt(0))&&(sezioneCorrente.getAnno()==annoSez)){
                    for(Alunno alunnoCorrente: sezioneCorrente.getAlunni()){
                        if(alunnoCorrente.getNome().equals(nomeAlunno)){
                            (sezioneCorrente.getAlunni()).remove(alunnoCorrente);
                            trovato=true;
                            break;
                        }
                            
                        else
                            throw new AlunnoNonPresente();
                    }
                    
                }
                if(trovato=true)
                        break;
            }
        }catch(AlunnoNonPresente e){
            System.out.println(e);
        }catch(IOException a){
            System.out.println(a);
        }
        
        
    }
    
    public synchronized void eliminaAlunno(){
        try{
            String nomeAlunno;
            boolean trovato = false;
            System.out.println("Inserisci il nome e il cognome dell'alunno");
            nomeAlunno=tastiera.readLine();
            for(Sezione sezioneCorrente: listaSezioni){
                for(Alunno alunnoCorrente: sezioneCorrente.getAlunni()){
                    if((alunnoCorrente.getNome()).equals(nomeAlunno)){
                        (sezioneCorrente.getAlunni()).remove(alunnoCorrente);
                        trovato=true;
                        break;
                    }
                }
                if(trovato==true)
                    break;
            }
            
        }catch(IOException a){
            System.out.println(a);
        }
    }
    
    public synchronized void totaleStudenti(){
        int studenti;
        for(Sezione sezioneCorrente: listaSezioni){
            studenti=0;
            studenti=studenti+ (sezioneCorrente.getAlunni()).size();
            sezioneCorrente.setTotale(studenti);
        }
    }
    
    public synchronized void sezionePeggiore(){
        int counter=0;
        int record=0;
        for(Sezione sezioneCorrente: listaSezioni){
            for(Alunno alunnoCorrente: sezioneCorrente.getAlunni()){
                counter=counter+alunnoCorrente.getDebiti();
            }
         sezioneCorrente.setInsufficienze(counter);
         if(counter>record){
             record=counter;
             nSezPeggiore=sezioneCorrente.getSezione();
             aSezPeggiore=sezioneCorrente.getAnno();
         }
         counter=0;
        }
    }
    
    public synchronized void studentiInsufficienti(){
        listaAlunniIns.clear();
        for(Sezione sezioneCorrente: listaSezioni){
            for(Alunno alunnoCorrente: sezioneCorrente.getAlunni()){
                if(alunnoCorrente.getDebiti()>0){
                    listaAlunniIns.add(new Alunno(alunnoCorrente.getNome(), alunnoCorrente.getData(), alunnoCorrente.getDebiti()));
                }
            }
        }
    }
    
    public synchronized void stampaReport(){
        for(Sezione sezioneCorrente: listaSezioni)
            System.out.println("Classe "+sezioneCorrente.getAnno()+sezioneCorrente.getSezione()+ " numero di studenti: "+sezioneCorrente.getTotale());
        System.out.println("La sezione con il maggior numero di insufficienze e': "+aSezPeggiore+nSezPeggiore);
        System.out.println("Alunni insufficienti: "+listaAlunniIns);
    }
    
        
        
    
    
}
