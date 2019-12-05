/**
 * Purpose: Data Structure and Algorithms Project
 * Status: Barely started
 * Last update: 12/03/19
 * Submitted: 12/05/19
 * Comment: test suite and sample run attached
 *
 * @author: Theresa Morris - Section 2
 *
 * @author: Nico Kaegi - Section 2
 *
 * @version: 2019.12.03 AirTrafficControl.java
 */

import java.io.*;

import dependencies.ListArrayBasedPlus;


public class Driver
{
    /** BufferedReader to intake our keyboard input **/
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        /** boolean for use of the menu - determines if we are done, or not **/
        Boolean quit = false;
        /** AirTrafficControl holds most of our control methods **/
        AirTrafficControl atc = new AirTrafficControl();
        /** String flightNumber used for creating new planes **/
        String flightNumber;
        /** String destination used for creating new planes **/
        String destination;
        /** String runway used for creating new planes **/
        String runway;
        /** Boolean determining if a plane is successfully added **/
        boolean succeful;
        /** integer holding our int from setting up initial runways **/
        int intHolder;
        /** String holding our initial runway names **/
        String stringHolder;
        /** Temporary plane used for creating new planes **/
        Plane planeHolder;


        System.out.println("Welcome to the Airport program!");
        //Initial runway setup
        System.out.print("Enter number of runways: ");

        intHolder = Integer.parseInt(stdin.readLine());
        System.out.println(intHolder);

        for (int pos = 1; pos <= intHolder; pos++)
        {

            System.out.print(pos + "Enter the name of runway number " + pos + ": ");

            stringHolder = stdin.readLine();

            System.out.println(stringHolder);

            if (atc.addRunWay(stringHolder))
            {
                //System.out.println("success");

            } else
            {
                System.out.println("Error, this name is not unique.");
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
                //Case 1:  Enter new plane into system
                System.out.print("Enter flight number: ");
                String newFlight = stdin.readLine();
                System.out.println(newFlight);
                System.out.print("Enter destination: ");
                String newDest = stdin.readLine();
                System.out.println(newDest);
                System.out.print("Enter runway: ");
                String newRunway = stdin.readLine();
                System.out.println(newRunway);

                while( atc.findRunway(newRunway) == null) {
                    System.out.println("No such runway!");
                    System.out.print("Enter runway: ");
                    newRunway = stdin.readLine();
                    System.out.println(newRunway);

                }

                atc.enterAirPlane(new Plane(newFlight, newDest, newRunway));
                System.out.println("Flight " + newFlight + " is now waiting for takeoff on runway " + newRunway + ".");

                break;
            case 2:
                //Case 2: Plane takes off in a round robin style
                planeHolder = atc.currentTakeOfPlane();

                if(planeHolder != null) {

                    System.out.println(
                        "Is Flight " + planeHolder.getFlightNumber() + "  cleared for take off (Y/N): ");

                    System.out.println();//remove this later.

                    stringHolder = stdin.readLine().toUpperCase();
                    System.out.println(stringHolder);

                    if (stringHolder.equals("Y"))
                    {

                        atc.takeOff(true);

                    } else
                    {

                        atc.takeOff(false);

                    }
                }
                else {

                    //incase there are no planes at a runways (the minus on is intentional since postion get updated even when currentTakeOfPlane() returns null)
                    //System.out.println("no planes at runway" + ( atc.getPosition() - 1 ) );
                    System.out.println("No plane on any runway!");
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
    /**
     * Calls the ATC to search through the clearance list, find the relevant plane, and put it back on its runway if it is now clear for takeoff
     *
     * @param atc
     *            the AirTrafficControl object
     */

    private static void reEnterPlane(AirTrafficControl atc) throws IOException
    {
        if(!atc.getClearance().isEmpty())
        {
            System.out.print("Enter flight number : ");
            String flight = stdin.readLine();
            System.out.println(flight);
            Plane searchPlane = new Plane(flight, "holderDest", "holderRunway");
            try
            {
                atc.reEnterRunway(searchPlane);
            }
            catch (Exception e)
            {
                System.out.println("Unable to re-queue plane to runway!");
            }
        }
        else
        {
            System.out.println("There are no planes waiting for clearance!");
        }
    }// end reEnterPlane
    /**
     * Calls the ATC to add a new runway
     *
     * @param atc
     *            the AirTrafficControl object
     */
    private static void openRunway(AirTrafficControl atc) throws IOException
    {
        System.out.print("Enter the name of the new runway : ");
        String newRunway = stdin.readLine();
        System.out.print(newRunway);

        while(!(atc.addRunWay(newRunway)))
        {
            System.out.println("Runway " + newRunway + " already exists please choose another name. ");

            System.out.print("Enter the name of the new runway : ");
            newRunway = stdin.readLine();
            System.out.print(newRunway);

        }
        System.out.println("Runway " + newRunway + " has opened.");
    }// end openRunway

    /**
     * Calls the ATC to first find the closing runway, and loop through it, putting all of its planes on new runways.  It then flattens the clearance list (temporarily), searches through it to find any planes from the closing runway, and reassign them to new runways, without re-enqueueing them.
     *
     * @param atc
     *            the AirTrafficControl object
     */
    private static void closeRunway(AirTrafficControl atc) throws IOException
    {

        System.out.print("Enter runway: ");
        String oldRunway = stdin.readLine();
        System.out.println(oldRunway);
        while(atc.findRunway(oldRunway) == null)
        {
            System.out.println("No such runway!");
            System.out.print("Enter runway: ");
            oldRunway = stdin.readLine();
            System.out.println(oldRunway);
        }
        atc.runwayLoop(oldRunway, stdin);      
            atc.clearanceLoop(oldRunway, stdin);
        
        System.out.println("Runway " + oldRunway + " has been closed.");
    }// end closeRunway
}
