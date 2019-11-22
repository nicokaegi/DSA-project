/*
 * Purpose: Data Structure and Algorithms Project
 * Status: Barely started
 * Last update: 11/21/19
 * Submitted:  12/05/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @author: Nico Kaegi - Section 2
 * @version: 2019.11.21
 */

import java.io.*;

public class Driver
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        //line here to declare data structure
        Boolean quit = false;

        //Initial menu list
        System.out.println("Select from the following menu: ");
        System.out.println("\t1. ");
        System.out.println("\t2. ");
        System.out.println("\t3. ");
        System.out.println("\t4. ");
        System.out.println("\t5. ");
        System.out.println("\t6. ");
        System.out.println("\t7. ");
        System.out.println("\t8. ");

        while (!quit)
        {
            System.out.print("\n\tEnter your selection now : ");
            int menu = Integer.parseInt(stdin.readLine());
            System.out.println(menu);

            switch(menu)
            {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                System.out.println("\n\tInvalid input - Make your menu selection now : ");
            }//end switch
            if (quit)
            {
                System.out.println("Exiting program... Good Bye.");
                System.exit(0);
            }
        }//end while

    }// End main
}
