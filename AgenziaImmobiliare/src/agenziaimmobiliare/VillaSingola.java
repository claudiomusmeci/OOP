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
public class VillaSingola extends UnitaImmobiliare {
    private int livelli;
    private float giardino;
    private boolean piscina;
    public VillaSingola(String identificativo, String descrizione, String indirizzo, String codiceFiscale, float metri, int vani,float prezzo, int livelli, float giardino, boolean piscina){
        super(identificativo, descrizione, indirizzo, codiceFiscale, metri, vani, prezzo);
        this.livelli=livelli;
        this.giardino=giardino;
        this.piscina=piscina;
    }
    
    public String toString(){
        return (super.toString()+", Livelli:"+livelli+", Giardino:"+giardino+", Piscina:"+piscina);
    }
    
}
