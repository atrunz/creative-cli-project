package org.codedifferently;

import java.util.Scanner;

public class UI {

    private BandGigManager bgm = new BandGigManager();
    private Scanner sc = new Scanner(System.in);
    Gig gig = new Gig();

    public void startProgram() {
        boolean running = true;

        while (running) {
            System.out.println("\n============= OPENING BAND GIG MANAGER =============");
            System.out.println("1. Gig Scheduling ");
            System.out.println("2. Band and Set Maintenance");
            System.out.println("7. Add Song/View Song Catalog");
            System.out.println("8. Generate Setlist");
            System.out.println("9. Calculate Total Earnings");
            System.out.println("10. Exit");
            System.out.println("====================================================");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clears leftover newline

            switch (choice) {
                case 1:
                    showGigMenu();
                    break;

                case 2:
                    showSongMenu();
                    break;

                case 3:
                    System.out.println("Total earnings: $" + bgm.calculateTotalEarnings());
                    break;

                case 4:
                    running = false;
                    System.out.println("Closing Band Gig Manager...");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
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
            System.out.println("");
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

    private void showGigMenu() {

        Boolean running = true;
        do {
            System.out.println("1. Create New Gigs");
            System.out.println("2. View Upcoming Gigs");
            System.out.println("3. View Completed Gigs");
            System.out.println("4. View All Gigs");
            System.out.println("5. Mark Gig Completed");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); //clear token
            {
                switch (choice) {
                    case 1:
                        bgm.addNewGig();
                        break;
                    case 2:
                        bgm.viewUpcomingGigs();
                        break;
                    case 3:
                        bgm.viewCompletedGigs();
                        break;
                    case 4:
                        bgm.viewAllGigs();
                        break;
                    case 5:
                        markGigComplete();
                     case 0:
                    running=false;
            }

        }
    }while (running) ;
}

    private void showSongMenu() {

        Boolean running = true;
        do {
            System.out.println("1. Add Song To Catalog");
            System.out.println("2. View Song Catalog");
            System.out.println("3. Adjust Band Lineup for a gig");
            System.out.println("4. Generate Setlist");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear token
            {
                switch (choice) {
                    case 1:
                        System.out.println("Enter name of song to add to catalog: ");
                        String song = sc.nextLine();
                        bgm.addSongToCatalog(song);
                        viewSongCatalog();
                        break;
                    case 2:
                        viewSongCatalog();
                        break;
                    case 3:
                        //adjust lineup
                        bgm.viewCompletedGigs();
                        break;
                    case 4:
                        generateSetlist();
                        break;
                        //add something to view setlists for a gig
                    case 0:
                        running=false;
                }

            }
        }while (running) ;
    }
    }