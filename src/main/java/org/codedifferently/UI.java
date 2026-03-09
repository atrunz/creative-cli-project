package org.codedifferently;

import java.util.Scanner;

public class UI {

    private BandGigManager bgm = new BandGigManager();
    private Scanner sc = new Scanner(System.in);

    public void startProgram() {
        boolean running = true;

        while (running) {
            System.out.println("\n============= OPENING BAND GIG MANAGER =============");
            System.out.println("1. Add New Gig");
            System.out.println("2. View Venue Information");
            System.out.println("3. Mark Gig as Complete");
            System.out.println("4. View Upcoming Gigs");
            System.out.println("5. View Completed Gigs");
            System.out.println("6. View All Gigs");
            System.out.println("7. View Song Catalog");
            System.out.println("8. Generate Setlist");
            System.out.println("9. Calculate Total Earnings");
            System.out.println("10. Exit");
            System.out.println("====================================================");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clears leftover newline

            switch (choice) {
                case 1:
                    addNewGig();
                    break;

                case 2:
                    viewVenueInformation();
                    break;

                case 3:
                    markGigComplete();
                    break;

                case 4:
                    bgm.viewUpcomingGigs();
                    break;

                case 5:
                    bgm.viewCompletedGigs();
                    break;

                case 6:
                    bgm.viewAllGigs();
                    break;

                case 7:
                    viewSongCatalog();
                    break;

                case 8:
                    generateSetlist();
                    break;

                case 9:
                    System.out.println("Total earnings: $" + bgm.calculateTotalEarnings());
                    break;

                case 10:
                    running = false;
                    System.out.println("Closing Band Gig Manager...");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void addNewGig() {
        // Assumes your Venue class has a method like promptNewVenue()
        Venue venue = new Venue().promptNewVenue();


        System.out.print("Enter date of gig: ");
        String date = sc.nextLine();

        System.out.print("How much is the gig paying? ");
        double payment = sc.nextDouble();
        sc.nextLine(); // clear newline

        Gig newGig = new Gig(date, venue, payment);
        bgm.addGig(newGig);

        System.out.println("Gig added successfully.");
    }

    private void viewVenueInformation() {
        System.out.print("Enter gig number to view venue information: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig != null) {
            System.out.println(gig.getVenue());
        } else {
            System.out.println("Invalid gig selection.");
        }
    }

    private void markGigComplete() {
        System.out.print("Enter gig number to mark as completed: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig != null) {
            gig.markCompleted();
            System.out.println("Gig marked as completed.");
        } else {
            System.out.println("Invalid gig selection.");
        }
    }

    private void viewSongCatalog() {
        if (bgm.getSongCatalog().isEmpty()) {
            System.out.println("Song catalog is empty.");
        } else {
            System.out.println("Song Catalog:");
            for (int i = 0; i < bgm.getSongCatalog().size(); i++) {
                System.out.println((i + 1) + ". " + bgm.getSongCatalog().get(i));
            }
        }
    }

    private void generateSetlist() {
        System.out.print("Enter gig number to generate a setlist for: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        System.out.print("How many songs should be in the setlist? ");
        int numberOfSongs = sc.nextInt();
        sc.nextLine();

        bgm.generateSetlistForGig(gig, numberOfSongs);
        System.out.println("Setlist generated successfully.");
    }
}