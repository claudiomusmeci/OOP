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
public class VillaSchiera extends UnitaImmobiliare{
    private int livelli;
    private float giardino;
    
    public VillaSchiera(String identificativo, String descrizione, String indirizzo, String codiceFiscale, float metri, int vani,float prezzo, int livelli, float giardino){
        super(identificativo, descrizione, indirizzo, codiceFiscale, metri, vani, prezzo);
        this.livelli=livelli;
        this.giardino=giardino;
    }
    public String toString(){
        return (super.toString()+", Livelli:"+livelli+", Giardino:"+giardino);
    }
}
