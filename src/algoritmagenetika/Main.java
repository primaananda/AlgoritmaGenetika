/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmagenetika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author PrimaAnanda-PC
 */
public class Main {
    public static void main(String[] args) {
        int totalpopulasi = 100;
        ArrayList<Individu> populasi = Algoritma_Genetika.generatePopulasi(totalpopulasi);
        ArrayList<Individu> populasiWfitness = new ArrayList<>();
        int maksgenerasi = 7;
        
        for (int i = 0; i < maksgenerasi ; i++) {
            populasiWfitness = new ArrayList<>();
            for (Individu individu : populasi) {
                //menset menambahkan individu fitness
                individu.nilaiFitness=Algoritma_Genetika.fitness(individu);
                populasiWfitness.add(individu);
            }

            //mensorting populasi berdasarkan nilaiFitness
            Collections.sort(populasiWfitness, new Comparator<Individu>() {
                @Override
                public int compare(Individu individu1, Individu individu2) {
                    return Double.compare(individu2.nilaiFitness, individu1.nilaiFitness);
                }
            });
            
            Individu individu1 = populasiWfitness.get(0);
            Individu individu2 = populasiWfitness.get(1);

            ArrayList<Individu> newGen = new ArrayList<>();
            newGen.add(individu1);
            newGen.add(individu2);

            for (int j = 0; j < (totalpopulasi/2) - 1; j++) {
                
                Individu parent1=Algoritma_Genetika.seleksiOrangTua(populasiWfitness);
                Individu parent2=Algoritma_Genetika.seleksiOrangTua(populasiWfitness);
                
                ArrayList<Individu> children = Algoritma_Genetika.rekombinasi(parent1, parent2);
                Individu children1 = new Individu();
                children1.kromosom = Algoritma_Genetika.mutasi(children.get(0));
                Individu children2 = new Individu();
                children2.kromosom = Algoritma_Genetika.mutasi(children.get(1));
                
                newGen.add(children1);
                newGen.add(children2); 
            }
            populasi = newGen;
            System.out.println("======================");
            System.out.println("generasi ke : "+(i+1));
            System.out.print("Jarak Tempuh : ");
            populasi.get(i).printJarakTempuh();
            System.out.print("Path : ");
            populasi.get(i).printPath();
            System.out.print("Fitness : ");
            populasi.get(i).printFitness();
            System.out.println("======================");
        }
        System.out.println("======================");
        System.out.print("Solusi yang ditawarkan/solusi terbaik : ");
        populasi.get(0).printPath();
        System.out.print("Nilai fitness");
        populasi.get(0).printFitness();
    }
}
