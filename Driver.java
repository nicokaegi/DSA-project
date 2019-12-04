/*
 * Purpose: Data Structure and Algorithms Project
 * Status: Barely started
 * Last update: 11/21/19
 * Submitted: 12/05/19
 * Comment: test suite and sample run attached
 *
 * @author: Theresa Morris - Section 2
 *
 * @author: Nico Kaegi - Section 2
 *
 * @version: 2019.11.21 AirTrafficControl.java
 */

import java.io.*;

import dependencies.ListArrayBasedPlus;

/**
 * @author thersa moris
 * @author nico kaegi
 */
public class Driver
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException
    {
        Boolean quit = false;
        AirTrafficControl atc = new AirTrafficControl();

        String flightNumber;

        String destination;

        String runway;

        boolean succeful;

        int intHolder;

        String stringHolder;

        System.out.println("how many runways ?");

        intHolder = Integer.parseInt(stdin.readLine());

        Plane planeHolder;

        for (int pos = 1; pos <= intHolder; pos++)
        {

            System.out.println(pos + " runway name ?");

            stringHolder = stdin.readLine();

            if (atc.addRunWay(stringHolder))
            {
                System.out.println("success");

            } else
            {
                System.out.println("error not unique name please try again");
                intHolder++;
            }
        }

        // Initial menu list
        System.out.println("Select from the following menu: ");
        System.out.println("\t0. End the program");
        System.out.println("\t1. Plane enters the system.");
        System.out.println("\t2. Plane takes off.");
        System.out.println("\t3. Plane is allowed to re-enter a runway.");
        System.out.println("\t4. Runway opens.");
        System.out.println("\t5. Runway closes.");
        System.out.println("\t6. Display info about planes waiting to take off.");
        System.out.println("\t7. Display info about planes waiting to be allowed to re-enter a runway.");
        System.out.println("\t8. Display number of planes who have taken off.");

        while (!quit)
        {
            System.out.print("\n\tEnter your selection now : ");
            int menu = Integer.parseInt(stdin.readLine());
            System.out.println(menu);

            switch (menu)
            {
            case  0:
                quit = true;
                break;
            case 1:

                System.out.println(
                    "1 : plane entering system please enter flight number, destination, and take off run way");

                succeful = atc.enterAirPlane(
                               new Plane(stdin.readLine(), stdin.readLine(), stdin.readLine()));

                break;
            case 2:


                planeHolder = atc.currentTakeOfPlane();

		if(planeHolder != null){

                	System.out.println(
                    		"is " + planeHolder.getFlightNumber() + "  cleared for take off Y/N");

                	stringHolder = stdin.readLine();

                	if (stringHolder.equals('y') || stringHolder.equals('Y'))
                	{

                    	atc.takeOff(true);

                	} else
                	{

                    	atc.takeOff(false);
			
			}
                }
		else{
			
			//incase there are no planes at a runways (the minus on is intentional since postion get updated even when currentTakeOfPlane() returns null)
			System.out.println("no planes at runway" + ( atc.getPosition() - 1 ) );
	
		}

                break;
            case 3:
                reEnterPlane(atc);
                break;
            case 4:
                openRunway(atc);
                break;
            case 5:
                closeRunway(atc);
                break;
            case 6:
            	atc.printRunways();
                break;
            case 7:
            	atc.printClearance();
                break;
            case 8:
            	atc.printCount();
                break;
            default:
                System.out.println("\n\tInvalid input - Make your menu selection now : ");
            }// end switch
            if (quit)
            {
                System.out.println("The Airport is closing : Bye Bye....");
                System.exit(0);
            }
        }// end while

    }// End main

    private static void reEnterPlane(AirTrafficControl atc) throws IOException
    {
        System.out.print("Enter flight number : ");
        String flight = stdin.readLine();
        System.out.println(flight);
        try
        {
            atc.reEnterRunway(flight);
        }
        catch (Exception e)
        {
            System.out.println("Unable to re-queue plane to runway!");
        }
    }// end reEnterPlane

    private static void openRunway(AirTrafficControl atc) throws IOException
    {
    	System.out.print("Enter the name of the new runway : ");
    	String newRunway = stdin.readLine();
    	System.out.print(newRunway);
    	
    	if(atc.addRunWay(newRunway))
    	{
    		System.out.println("Runway " + newRunway + " has opened.");
    	}
    	else
    	{
    		System.out.println("Runway " + newRunway + " already existsm please choose another name.");
    	}

    }// end openRunway

    private static void closeRunway(AirTrafficControl atc) throws IOException
    {
    	System.out.print("Enter runway: ");
    	String oldRunway = stdin.readLine();
    	System.out.println(oldRunway);
    	
    	atc.runwayLoop(oldRunway, stdin);
       	atc.clearanceLoop(oldRunway, stdin);

       	System.out.println("Runway " + oldRunway + " has been closed.");
    }// end closeRunway
}
