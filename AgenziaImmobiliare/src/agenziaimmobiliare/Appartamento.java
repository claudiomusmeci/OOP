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
public class Appartamento extends UnitaImmobiliare {
    int piano;
    int postiAuto;
    
    public Appartamento(String identificativo, String descrizione, String indirizzo, String codiceFiscale, float metri, int vani,float prezzo, int piano, int postiAuto){
        super(identificativo, descrizione, indirizzo, codiceFiscale, metri, vani, prezzo);
        this.piano=piano;
        this.postiAuto=postiAuto;
    }
    public String toString(){
        return (super.toString()+", Piano:"+piano+", Posti auto:"+postiAuto);
    }
}
