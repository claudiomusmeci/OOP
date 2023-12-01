/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;
import java.util.*;
import java.io.*;
/**
 *
 * @author claud
 */
public class ListaClienti {
    private LinkedList<Cliente> listaClienti;
    private LinkedList<Cliente> listaClienti2;
    private LinkedList<Farmaco> listaFarmaci;
    BufferedReader tastiera;
    
    public ListaClienti(){
        listaClienti=new LinkedList<Cliente>();
        listaClienti2=new LinkedList<Cliente>();
        listaFarmaci=new LinkedList<Farmaco>();
        tastiera= new BufferedReader(new InputStreamReader(System.in));
        
    }
    
    public synchronized void riempiLista(){
        try{
            
            BufferedReader fileFarmaci;
            fileFarmaci=new BufferedReader(new FileReader("listafarmaci.txt"));
            String nome;
            nome=fileFarmaci.readLine();
            while(nome!=null){
                listaFarmaci.add( new Farmaco(nome, fileFarmaci.readLine(), Float.parseFloat(fileFarmaci.readLine()), fileFarmaci.readLine()));
                nome=fileFarmaci.readLine();
            }
            fileFarmaci.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public synchronized void stampa(){
        for(Cliente c: listaClienti)
            System.out.println(c);
    }
    
    public synchronized void caricaDati(){
        try{
            System.out.println("Inserisci il nome del file da cui caricare i clienti");
            String nomeFile;
            nomeFile=tastiera.readLine();
            BufferedReader fileClienti;
            fileClienti=new BufferedReader(new FileReader(nomeFile));
            String nome;
            nome=fileClienti.readLine();
            while(nome!=null){
                listaClienti.add(new Cliente(nome, fileClienti.readLine(), Float.parseFloat(fileClienti.readLine())));
                nome=fileClienti.readLine();
            }
            fileClienti.close();
            System.out.println("Inserisci il nome del file da cui caricare i farmaci");
            nomeFile=tastiera.readLine();
            BufferedReader fileFarmaci;
            fileFarmaci=new BufferedReader(new FileReader(nomeFile));
            String codice;
            codice=fileFarmaci.readLine();
            while(codice!=null){
                for(Cliente clienteCorrente: listaClienti){
                    if(codice.equals(clienteCorrente.getCodice())){
                        (clienteCorrente.getFarmaci()).add(new Farmaco(fileFarmaci.readLine(), fileFarmaci.readLine(), Float.parseFloat(fileFarmaci.readLine()), fileFarmaci.readLine()));
                        break;
                    }
                }
                codice=fileFarmaci.readLine();
            }
            fileFarmaci.close();
            
            
        }catch(IOException e){
            System.out.println(e);
            
        }
        
        
        
    }
    
    public synchronized void vendiFarmaco(){
        try{
           System.out.println("Inserisci il codice fiscale del cliente");
           String codiceCliente;
           codiceCliente=tastiera.readLine();
           System.out.println("Inserisci il nome del farmaco");
           String farmaco;
           farmaco=tastiera.readLine();
           System.out.println("Inserisci il codice del farmaco");
           String codiceFarmaco;
           codiceFarmaco=tastiera.readLine();
           System.out.println("Inserisci il costo del farmaco");
           float costo;
           costo=Float.parseFloat(tastiera.readLine());
           System.out.println("Inserisci la data di acquisto");
           String data;
           data=tastiera.readLine();
           float punti, tot;
           for(Cliente c: listaClienti){
               if(codiceCliente.equals(c.getCodice())){
                   (c.getFarmaci()).add(new Farmaco(farmaco, codiceFarmaco, costo, data));
                   punti=c.getPunti();
                   tot=punti+costo/2;
                   c.setPunti(tot);
                   break;
               }
           }
            
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
    
    public synchronized void stampaClienti(){
        boolean trovato=false;
        for(Cliente c: listaClienti){
            for(Farmaco farmacoCorrente: c.getFarmaci()){
                for(Farmaco farmacoLista: listaFarmaci){
                    if((farmacoCorrente.getCodice()).equals(farmacoLista.getCodice())){
                        System.out.println(c);
                        trovato=true;
                        break;
                    }
                }
                if(trovato==true)
                    break;
            }
            
            
        }
        
        
    }
    
    public synchronized void clientiShop(){
        listaClienti2.clear();
        int data;
        for(Cliente c: listaClienti){
            for(Farmaco f: c.getFarmaci()){
                data=Integer.parseInt(f.getData());
                if(data>=20200501){
                    listaClienti2.add(c);
                    break;
                }
            }
        }
    }
    
    public synchronized void stampaReport(){
        for(Cliente c: listaClienti2)
            System.out.println(c);
    }
}
