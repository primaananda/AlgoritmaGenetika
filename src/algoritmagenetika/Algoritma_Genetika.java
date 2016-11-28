/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmagenetika;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author PrimaAnanda-PC
 */
public class Algoritma_Genetika {
    //untuk menghasilkan nilai nomor random
    public static double randNumber(int maks, int min) {
        Random random = new Random();
        double jarak = maks - min;
        double skala = random.nextDouble() * jarak;
        double nilai = skala + min;
        return nilai;
    }
    
    //mengenerate kromosom
    public static ArrayList generateKromosom(){
        Random random = new Random();
        ArrayList nilai = new ArrayList();
        String alphabet = "ABCDEF";
        for (int i = 0; i < Individu.panjang_kromosom ; i++) {
            nilai.add(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return nilai;
    }
    
    //menggenerate karakter
    public static char generateChar(String c){
        Random random = new Random();
        String node = "ABCDEF".replace( c , "");
        return node.charAt(random.nextInt(node.length()));
    }
    
    //merubah nilai karakter menjadi int
    public static int charToint(Character karakter){
        int nilai = 0;
        if (karakter=='A') {
            nilai = 1;
        }else if(karakter=='B'){
            nilai = 2;
        }else if(karakter=='C'){
            nilai = 3;
        }else if(karakter=='D'){
            nilai = 4;
        }else if(karakter=='E'){
            nilai = 5;
        }else if(karakter=='F'){
            nilai = 6;
        }
        return nilai;
    }
    
    //nilai fitness
    public static double fitness(Individu ind){
        ArrayList kromosom = ind.kromosom;
        int posisi = 0;
        int jarakTempuh = 0;
        int[][] map = Data_Save.data_node;
        ArrayList Path = new ArrayList();
        Path.add('S');
        for (int i = 0; i < kromosom.size(); i++) {
            int next_posisi = charToint((Character) kromosom.get(i));
            
            if (map[posisi][next_posisi]!=0){
              
                if (posisi!=4 && posisi !=5 && posisi !=6){
                
                    if( ! Path.contains(next_posisi)){
                        jarakTempuh = jarakTempuh + map[posisi][next_posisi];
                        posisi=next_posisi;
                        Path.add(posisi);
                    } 
                } else {
                    break;
                }  
            }              
        }
        Path.add('G');
        return Double.valueOf(1) / (jarakTempuh+9);
    }
    
    //menampilkan mutasi
    public static ArrayList mutasi(Individu individu){
        Object[] kromosom = (Object[]) individu.kromosom.toArray();
        double nilai = (double) 1/individu.kromosom.size();
        for (int i = 0; i < kromosom.length; i++) {
           double x = randNumber(0,2);
            
           if (x<nilai){
               Object z = (Object) kromosom[i];
               kromosom[i] = generateChar(String.valueOf(z));
           }
        }
        return new ArrayList(Arrays.asList(kromosom));
    }
    
    //menghitung rekombinasi
    public static ArrayList<Individu> rekombinasi (Individu parent1, Individu parent2){
        Individu child1 = new Individu();
        Individu child2 = new Individu();
        
        ArrayList<Individu> children = new ArrayList();
        
        child1.kromosom.addAll(parent1.kromosom.subList(0, 21));
        child1.kromosom.addAll(parent2.kromosom.subList(21, 42));
        child2.kromosom.addAll(parent2.kromosom.subList(0, 21));
        child2.kromosom.addAll(parent1.kromosom.subList(21, 42));
        
        children.add(child1);
        children.add(child2);
        
        return children;
    }
    
    //seleksi orangtua
    public static Individu seleksiOrangTua (ArrayList<Individu> populasi){
        double jumFitness = 0;
        for (int i = 0; i < populasi.size(); i++) {
            jumFitness = (jumFitness + populasi.get(i).nilaiFitness);
        }
        double random = randNumber(0, (int) jumFitness);
        double nilai = 0;
        for (int i = 0; i < populasi.size(); i++) {
            nilai = nilai + populasi.get(i).nilaiFitness;
            if (nilai>random){
                return populasi.get(i);
            }
        }
        return null;
    }
    
    //menggenerate populasi
    public static ArrayList<Individu> generatePopulasi(int n){
        ArrayList<Individu> populasi = new ArrayList();
        
        for (int i = 0; i < n; i++) {
            Individu ind = new Individu();
            ind.kromosom=generateKromosom();
            populasi.add(ind);
        }
        return populasi;
    }
    
}
