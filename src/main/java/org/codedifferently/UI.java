package org.codedifferently;

import java.util.Scanner;

public class UI {

    BandGigManager bgm = new BandGigManager();
    Gig gig = new Gig();
    Scanner sc = new Scanner(System.in);
    Venue venue = new Venue();
    public void startProgram() {
        while (true) {
            System.out.println("=============OPENING BAND GIG MANAGER===============");
            System.out.println("1. Add New Gig");
            System.out.println("2. View Venue Information");
            System.out.println("3. Mark Gig as Complete");
            System.out.println("4. View Upcoming Gigs");
            System.out.println("5. View Completed Gigs");
            System.out.println("6. View All Gigs");
            System.out.println("7. View Song Catalog");
            System.out.println("8. Generate Setlist");
            System.out.println("9. Calculate Total Earnings");
            System.out.println("====================================================");

            System.out.println("Select option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Venue venue = venue.promptNewVenue();
                    System.out.println("Enter date of gig: ");
                    String date= sc.nextLine();
                    System.out.println("How much is gig paying? ");
                    double payment = sc.nextDouble();
                    Gig newGig = new Gig(date,venue,payment);
                    break;
                case 2:
                    bgm;
                    break;
                case 3:
                    bgm.
                case 4:
                    bgm.viewUpcomingGigs();
                    break;
                case 5:
                    bgm.viewCompletedGigs();
                    break;
                case 6: bgm.viewAllGigs();
                break;
                case7: bgm.getSongCatalog();
                break;
                case 9:
                    bgm.calculateTotalEarnings();
                case 9:
                    bgm.calculateTotalEarnings();
                default:
                    System.out.println("Invalid Selection. Please try again");
            }
        }
    }
}

