/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenziaimmobiliare;

/**
 *
 * @author claud
 */
public abstract class UnitaImmobiliare {
    private String identificativo;
    private String descrizione;
    private String indirizzo;
    private String codiceFiscale;
    private float metri;
    private int vani;
    private float prezzo;
    
    public UnitaImmobiliare(String identificativo, String descrizione, String indirizzo, String codiceFiscale, float metri, int vani,float prezzo){
        this.identificativo=identificativo;
        this.descrizione=descrizione;
        this.indirizzo=indirizzo;
        this.codiceFiscale=codiceFiscale;
        this.metri=metri;
        this.vani=vani;
        this.prezzo=prezzo;
    }
    
    public String getIdentificativo(){
        return identificativo;
    }
    
    public float getPrezzo(){
        return prezzo;
    }
    
    public String getCodice(){
        return codiceFiscale;
    }
    
    public String toString(){
        return("Identificativo:"+identificativo+", Descrizione:"+descrizione+", Indirizzo:"+indirizzo+", CodiceFiscale:"+codiceFiscale+", Metri:"+metri+", Vani:"+vani+", Prezzo:"+prezzo);
    }
    
}
