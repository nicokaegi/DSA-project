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

		for (int pos = 0; pos <= intHolder; pos++)
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
				case 0:
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

				    break;
				case 3:
				    reEnterPlane(atc);
				    // atc.reEnterPlane(atc);
				    break;
				case 4:
				    openRunway(atc);
				    break;
				case 5:
				    closeRunway(atc);
				    break;
				case 6:
				    break;
				case 7:
				    break;
				case 8:
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

	    }// end openRunway

	private static void closeRunway(AirTrafficControl atc) throws IOException
	    {

	    }// end closeRunway
    }
