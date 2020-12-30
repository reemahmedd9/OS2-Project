/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2.project;

/**
 *
 * @author reema
 */
import java.util.LinkedList; 
import java.util.Queue; 

public class FIFO {
    
    void FIFO(int no_frames, int arr_pages[]){
    
    Queue<Integer> Page_Table = new LinkedList<>();
    int free_frames = no_frames;
    int no_of_hit=0;
    int no_of_miss=0;
    int[] array_OutPut = new int[no_frames];
     
    //Goz2 lw lesa fe frames fadya 
    System.out.print("Elements of Page table: ");
          for (int element: array_OutPut) {
            System.out.print(element+"\t");
        }
          System.out.println("");
          
    int count=0;
    
   for(int i=0;free_frames>0 && i<arr_pages.length;i++){
        
         
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
    // Goz2 el replacement 
    int total_pages_so_far = no_of_hit+no_of_miss;
     
       
    for(int j = total_pages_so_far; j < arr_pages.length;j++){
        
         
         boolean hit = Page_Table.contains(arr_pages[j]);
         
          if(hit == false){
              
              
          int replace = Page_Table.remove();
          for(int i=0;i<no_frames;i++){
          if(array_OutPut[i]==replace){
          array_OutPut[i]=arr_pages[j];
          }
          }
          System.out.print("Elements of Page table: ");
          for (int element: array_OutPut) {
            System.out.print(element+"\t");
        }
              System.out.print("Miss\n");
          Page_Table.add(arr_pages[j]);
          no_of_miss++;
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
    
        System.out.println("Total number of page faults:\t"+no_of_miss);
    
    }
    
}
