/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2.project;

import java.util.Scanner;

/**
 *
 * @author reema
 */
public class OS2Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.print("Enter number of initially free frames:\t");
       Scanner input = new Scanner(System.in);
       int no_of_frames;
       no_of_frames = input.nextInt();
       System.out.print("Enter no. of page reference you want:\t");
       int no_of_pages;
        no_of_pages = input.nextInt();
        int page_sequence[] = new int[no_of_pages];
        System.out.println("Enter page reference sequence:");
        for(int i = 0; i < no_of_pages; i++)
        {
            page_sequence[i] = input.nextInt();
           
        }
        System.out.println();
        int choice;
        System.out.println("Choose the replacement algorithm");
        System.out.println("Enter 1 for FIFO");
        System.out.println("Enter 2 for LRU");
        System.out.println("Enter 3 for Optimal");
       choice = input.nextInt();
       System.out.println();
       System.out.println();
        switch(choice) {
   case 1:
    FIFO fifo = new FIFO();
    fifo.FIFO(no_of_frames, page_sequence);
    break;
  
   case 2:
    
    LRU lru = new LRU();
    lru.LRU(no_of_frames, page_sequence);
    break;
    
   case 3:
    
    Optimal opt = new Optimal();
    opt.Optimal(no_of_frames, page_sequence);
    break;

   default:
      System.err.println("Enter correct choice");
}
   
       
    }
    
}
