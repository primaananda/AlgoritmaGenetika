/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmagenetika;

import java.util.ArrayList;
import static algoritmagenetika.Algoritma_Genetika.charToint;


/**
 *
 * @author PrimaAnanda-PC
 */
public class Individu {
    public ArrayList kromosom = new ArrayList();
    public static int  panjang_kromosom = 6 * 7;
    double nilaiFitness = 0;
    
    //menampilkan kromosom
    public void printKromosom(){
        System.out.println(kromosom);
    }
    
    //menampilkan nilai fitness
    public void printFitness(){
        System.out.println(nilaiFitness);
    }
    
    //menampilkan jarak tempuh
    public void printJarakTempuh(){
        int posisi = 0;
        int jarakTempuh = 0;
        int[][] map = Data_Save.data_node;
        ArrayList Path = new ArrayList();
        
        ArrayList pathPrint = new ArrayList();
        pathPrint.add('S');
        for (int i = 0; i < kromosom.size(); i++) {
            int next_posisi = charToint((Character) kromosom.get(i));
            
            if (map[posisi][next_posisi]!=0){
                if (posisi!=4 && posisi !=5 && posisi !=6){
                    if( ! Path.contains(next_posisi)){
                        jarakTempuh = jarakTempuh + map[posisi][next_posisi];
                        posisi=next_posisi;
                        Path.add(next_posisi);
                        pathPrint.add((Character) kromosom.get(i));
                    } 
                } else {
                    break;
                }  
            }             
        }
        pathPrint.add('G');
        System.out.println(jarakTempuh); 
    }
    
    //menampilkan path
    public void printPath(){
        int position = 0;
        int jarakTempuh = 0;
        int[][] map = Data_Save.data_node;
        ArrayList Path = new ArrayList();
        
        ArrayList pathPrint = new ArrayList();
        pathPrint.add('S');
        for (int i = 0; i < kromosom.size(); i++) {
            int next_position = charToint((Character) kromosom.get(i));
            
            if (map[position][next_position]!=0){
              
                if (position!=4 && position !=5 && position !=6){
                
                    if( ! Path.contains(next_position)){
                        jarakTempuh = jarakTempuh + map[position][next_position];
                        position=next_position;
                        Path.add(next_position);
                        pathPrint.add((Character) kromosom.get(i));
                    } 
                } else {
                    break;
                }  
            }
                           
        }
        pathPrint.add('G');
        System.out.println(pathPrint);

    }
}
