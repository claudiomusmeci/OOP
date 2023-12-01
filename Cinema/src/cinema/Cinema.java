/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.io.*;
import java.util.*;

/**
 *
 * @author claud
 */
public class Cinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
       ListaSale listaSale= new ListaSale();
       ThreadGestione threadAttivo= new ThreadGestione(listaSale);
       ThreadReport threadPassivo= new ThreadReport(listaSale);
       
       threadAttivo.start();
       threadPassivo.start();
    }
  
}
