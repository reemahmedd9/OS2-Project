/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2.project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author reema
 */
public class LRU {

    void LRU(int no_frames, int arr_pages[]) {
        
        // To represent set of current pages.
    HashSet<Integer> Page_Table = new HashSet<>(no_frames); 
    //Store LRU index
    HashMap<Integer, Integer> indexes = new HashMap<>(); 
     
    int free_frames = no_frames;
    int no_of_hit=0;
    int no_of_miss=0;
    int[] array_OutPut = new int[no_frames];
    
     System.out.print("Elements of Page table: ");
          for (int element: array_OutPut) {
            System.out.print(element+"\t");
        }
          System.out.println("");
          
    int count=0;
    
    for(int i=0;free_frames>0;i++){
        
         
        boolean hit = Page_Table.contains(arr_pages[i]);
        
        if(hit == false){
           
    Page_Table.add(arr_pages[i]);
    array_OutPut[count]=arr_pages[i];
    count++;
    
     System.out.print("Elements of Page table: ");
          for (int element: array_OutPut) {
            System.out.print(element+"\t");
        }
              System.out.print("Miss\n");
     
    no_of_miss++;
    free_frames--;
        }
    
    else {
            
            System.out.print("Elements of Page table: ");
               for (int element: array_OutPut) {
            System.out.print(element+"\t");
        }
              System.out.print("Hitt\n");
            no_of_hit++;
        }
    
    }
    
    int total_pages_so_far = no_of_hit+no_of_miss;
     
       
    for(int j = total_pages_so_far; j < arr_pages.length;j++){
        
         
         boolean hit = Page_Table.contains(arr_pages[j]);
         if(hit == false){
         
         }
    }
    }
    
}
