/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmagenetika;

/**
 *
 * @author PrimaAnanda-PC
 */
public class Data_Save {
    //menyimpan data untuk setiap node
    public static int[][] data_node = {
        {0,  6, 14, 10,  0,  0,  0, 0},   //untuk node s
        {6,  0,  6,  0, 24,  0,  0, 0},   //untuk node a
        {14,  6,  0,  4,  0, 15,  0, 0},  //untuk node b
        {10,  0,  4,  0,  0,  0, 18, 0},  //untuk node c
        {0, 24,  0,  0,  0,  4,  0, 9},   //untuk node d
        {0,  0, 15,  0,  4,  0,  4, 9},   //untuk node e
        {0,  0,  0, 18,  0,  4,  0, 9},   //untuk node f
        {0,  0,  0,  0,  9,  9,  9, 0}    //untuk node g
    };
}
