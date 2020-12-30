/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2.project;

import java.util.LinkedList;


public class Optimal {

    // function to find the optimal page to replace
    int predict(int pages_arr[], LinkedList<Integer> opt_page, int no_pages, int page_index) {
        // Store the index of pages which are going
        // to be used recently in future
        int res = -1, farthest = page_index;
        for (int i = 0; i < no_pages; i++) {
            int j;
            for (j = page_index; j < pages_arr.length; j++) {
                if (opt_page.get(i) == pages_arr[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }

            // If a page is never referenced in future,
            // return it.
            if (j == pages_arr.length)
                return i;
        }

        // If all of the frames were not in future,
        // return any of them, we return 0. Otherwise
        // we return res.
        return (res == -1) ? 0 : res;
    }



    void Optimal(int no_frames, int arr_pages[]) {

        // To represent set of current pages.
        LinkedList <Integer> Page_Table = new LinkedList<Integer>();


        int free_frames = no_frames;
        int no_of_hit=0;
        int no_of_miss=0;

        System.out.print("Elements of Page table: ");

        System.out.println(Page_Table);


        for(int i=0;free_frames>0 && i<arr_pages.length;i++){


            boolean hit = Page_Table.contains(arr_pages[i]);
            
            if(hit == false){

                Page_Table.add(arr_pages[i]);


                System.out.print("Elements of Page table: ");

                System.out.print(Page_Table+"\t");

                System.out.println("Miss\n");

                no_of_miss++;
                free_frames--;
            }

            else {

                System.out.print("Elements of Page table: ");

                System.out.print(Page_Table+"\t");

                System.out.println("Hitt\n");
                no_of_hit++;
            }

        }

        int total_pages_so_far = no_of_hit+no_of_miss;


        for(int j = total_pages_so_far; j < arr_pages.length;j++){


            boolean hit = Page_Table.contains(arr_pages[j]);
           

            if(hit == false){

                int page_to_remove = predict(arr_pages,Page_Table,no_frames,j);
                Page_Table.set(page_to_remove,arr_pages[j]);

                System.out.print("Elements of Page table: ");
                System.out.print(Page_Table+"\t");
                System.out.println("Miss\n");

                no_of_miss++;
            }
            else {

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