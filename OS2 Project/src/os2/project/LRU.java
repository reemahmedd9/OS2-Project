/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2.project;

import java.util.LinkedList;


/**
 *
 * @author reema
 */
public class LRU {

    int min(LinkedList<Integer> LRU){
        int min_index = Integer.MAX_VALUE;
        int index =0;
        for(int num=0; num<LRU.size(); num++)
      {
          if(min_index > LRU.get(num))
          {
              min_index = LRU.get(num); 
              index = num;
          }
      
      }
    return index;
    }
    
    void LRU(int no_frames, int arr_pages[]) {
        
        // To represent set of current pages.
    LinkedList <Integer> Page_Table = new LinkedList<Integer>();
    
    //Store LRU index
    LinkedList <Integer> LRU_Index = new LinkedList<Integer>();
     
    int free_frames = no_frames;
    int no_of_hit=0;
    int no_of_miss=0;
    
     System.out.print("Elements of Page table: ");
          
            System.out.println(Page_Table);
        
   
    int LRU_count = 1;
    
    for(int i=0;free_frames>0 && i<arr_pages.length;i++){
        
         
        boolean hit = Page_Table.contains(arr_pages[i]);
        int index_of_page = Page_Table.indexOf(arr_pages[i]);
        
        if(hit == false){
           
    Page_Table.add(arr_pages[i]);
    LRU_Index.add(LRU_count);
    LRU_count++;
   
    
     System.out.print("Elements of Page table: ");
          
            System.out.print(Page_Table+"\t");
        
              System.out.println("Miss\n");
     
    no_of_miss++;
    free_frames--;
        }
    
    else {
            LRU_Index.set(index_of_page,LRU_count);
            LRU_count++;
            
            System.out.print("Elements of Page table: ");
               
            System.out.print(Page_Table+"\t");
        
              System.out.println("Hitt\n");
            no_of_hit++;
            
        }
    
    }
    
    int total_pages_so_far = no_of_hit+no_of_miss;
     
       
    for(int j = total_pages_so_far; j < arr_pages.length;j++){
        
         
         boolean hit = Page_Table.contains(arr_pages[j]);
         int index_of_page = Page_Table.indexOf(arr_pages[j]);
         
         if(hit == false){
             
             int page_to_remove = min(LRU_Index);
             Page_Table.set(page_to_remove,arr_pages[j]);
             LRU_Index.set(page_to_remove,LRU_count);
             LRU_count++;
             System.out.print("Elements of Page table: ");  
             System.out.print(Page_Table+"\t");
             System.out.println("Miss\n");
             
             no_of_miss++;
         }
         else {
             
             LRU_Index.set(index_of_page,LRU_count);
             LRU_count++;

             System.out.print("Elements of Page table: ");   
             System.out.print(Page_Table+"\t");
             System.out.println("Hitt\n");
             no_of_hit++;
             
         
         }
    }
    
     System.out.println("Total number of page faults:\t"+no_of_miss);
     System.out.println("Total number of page faults:\t"+no_of_hit);
     
    }
    
}
