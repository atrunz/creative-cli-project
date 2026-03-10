package org.codedifferently;

import org.codedifferently.helpers.InputHandler;

import java.util.Scanner;

//houses all user input logic + helper functions for updating gig info
public class UI {

    private final BandGigManager bgm = new BandGigManager();
    private final Scanner sc = new Scanner(System.in);

    //loop to ask for and collect user input, loop used so it keeps program running until user quits
    public void startProgram() {
        boolean running = true;

        while (running) {
            System.out.println("\n============= BAND GIG MANAGER =============");
            System.out.println("1. Gig Scheduling");
            System.out.println("2. Song and Setlist Maintenance");
            System.out.println("3. Band Lineup");
            System.out.println("4. Calculate Total Earnings");
            System.out.println("0. Exit");
            System.out.println("====================================================");
            System.out.print("Select option: ");

            //uses helper functions in InputHandler to validate user input
            int choice = InputHandler.handleIntegerInput(sc);

            switch (choice) {
                case 1:
                    showGigMenu();
                    break;
                case 2:
                    showSongMenu();
                    break;
                case 3:
                    adjustGigLineupMenu();
                    break;
                case 4:
                    System.out.println("Total earnings: $" + bgm.calculateTotalEarnings());
                    break;
                case 0:
                    running = false;
                    System.out.println("Closing Band Gig Manager...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    //subdivision to help make menus cleaner
    private void showGigMenu() {
        boolean running = true;

        do {
            System.out.println("\n============== GIG MENU ==============");
            System.out.println("1. Create New Gig");
            System.out.println("2. View Upcoming Gigs");
            System.out.println("3. View Completed Gigs");
            System.out.println("4. View All Gigs");
            System.out.println("5. View Gig Details");
            System.out.println("6. Mark Gig Completed");
            System.out.println("0. Exit");
            System.out.println("======================================");
            System.out.print("Select option: ");

            int choice = InputHandler.handleIntegerInput(sc);

            switch (choice) {
                case 1:
                    addNewGig();
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
                    viewGigDetails();
                    break;
                case 6:
                    markGigComplete();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (running);
    }

    //subdivision to help make menus cleaner
    private void showSongMenu() {
        boolean running = true;

        do {
            System.out.println("\n========== SONG / SETLIST MENU ==========");
            System.out.println("1. Add Song To Catalog");
            System.out.println("2. View Song Catalog");
            System.out.println("3. Generate Setlist For A Gig");
            System.out.println("4. View Setlist For A Gig");
            System.out.println("5. Add Song Manually To A Gig Setlist");
            System.out.println("6. Remove Song From A Gig Setlist");
            System.out.println("0. Exit");
            System.out.println("=========================================");
            System.out.print("Select option: ");

            int choice = InputHandler.handleIntegerInput(sc);

            switch (choice) {
                case 1:
                    addSongToCatalog();
                    break;
                case 2:
                    viewSongCatalog();
                    break;
                case 3:
                    generateSetlist();
                    break;
                case 4:
                    viewGigSetlist();
                    break;
                case 5:
                    addSongToGigSetlist();
                    break;
                case 6:
                    removeSongFromGigSetlist();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (running);
    }

    //subdivision to help make menus cleaner
    private void adjustGigLineupMenu() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to adjust lineup for:");
        bgm.viewAllGigs();

        int gigIndex = promptForGigIndex("Enter gig number: ");
        if (gigIndex == -1) {
            return;
        }

        Gig gig = bgm.findGigByIndex(gigIndex);

        if (gig.isCompleted()) {
            System.out.println("Cannot adjust lineup for a completed gig.");
            return;
        }

        boolean editing = true;

        while (editing) {
            System.out.println("\n===== LINEUP MENU =====");
            System.out.println("Gig: " + gig.getDate() + " at " + gig.getVenue().getName());
            System.out.println("Current Lineup: " + gig.getLineup());
            System.out.println("1. Apply Default Lineup");
            System.out.println("2. Add Band Member");
            System.out.println("3. Remove Band Member");
            System.out.println("4. Swap Band Member");
            System.out.println("0. Return to Main Menu");
            System.out.print("Select option: ");

            int choice = InputHandler.handleIntegerInput(sc);

            switch (choice) {
                case 1:
                    bgm.applyDefaultLineup(gig);
                    System.out.println("Default lineup applied to this gig.");
                    break;
                case 2:
                    System.out.print("Enter member to add: ");
                    String memberToAdd = InputHandler.handleStringInput(sc);
                    gig.addBandMember(memberToAdd);
                    System.out.println("Band member added to this gig.");
                    break;
                case 3:
                    System.out.print("Enter member to remove: ");
                    String memberToRemove = InputHandler.handleStringInput(sc);
                    gig.removeBandMember(memberToRemove);
                    System.out.println("Band member removed from this gig.");
                    break;
                case 4:
                    System.out.print("Enter member to replace: ");
                    String oldMember = InputHandler.handleStringInput(sc);

                    System.out.print("Enter new member: ");
                    String newMember = InputHandler.handleStringInput(sc);

                    gig.swapBandMember(oldMember, newMember);
                    System.out.println("Band member swapped for this gig.");
                    break;
                case 0:
                    editing = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
//helper function to get gig being referenced by user
    private int promptForGigIndex(String prompt) {
        System.out.print(prompt);
        int gigNumber = InputHandler.handleIntegerInput(sc);

        Gig gig = bgm.findGigByIndex(gigNumber - 1);
        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return -1;
        }

        return gigNumber - 1;
    }

//function to collect user input needed to create a new gig
    private void addNewGig() {
        System.out.print("Enter name of gig venue: ");
        String venueName = InputHandler.handleStringInput(sc);

        System.out.print("Enter city/state of venue: ");
        String city = InputHandler.handleStringInput(sc);

        System.out.print("Enter venue capacity: ");
        int capacity = InputHandler.handleIntegerInput(sc);

        Venue venue = new Venue(venueName, city, capacity);

        System.out.print("Enter date of gig: ");
        String date = InputHandler.handleStringInput(sc);

        System.out.print("How much is the gig paying? ");
        double payment = InputHandler.handleDoubleInput(sc);

        Gig newGig = new Gig(date, venue, payment);
        bgm.addGig(newGig);

        System.out.println("Gig added successfully.");
    }

    //unused in current implementation, can display info about a venue
    private void viewVenueInformation() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        int gigIndex = promptForGigIndex("Enter gig number to view venue information: ");
        if (gigIndex == -1) {
            return;
        }

        Gig gig = bgm.findGigByIndex(gigIndex);
        System.out.println(gig.getVenue());
    }

    //calls helper to figure out which gig is being referenced and marks it as complete
    private void markGigComplete() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        int gigIndex = promptForGigIndex("Enter gig number to mark as completed: ");
        if (gigIndex == -1) {
            return;
        }

        boolean success = bgm.markGigCompleteByIndex(gigIndex);

        if (success) {
            System.out.println("Gig marked as completed.");
        } else {
            System.out.println("Invalid gig selection.");
        }
    }

    //collects user input for which song to use as an argument for bgm.addSongToCatalog
    private void addSongToCatalog() {
        System.out.print("Enter name of song to add to catalog: ");
        String song = InputHandler.handleStringInput(sc);
        bgm.addSongToCatalog(song);
        System.out.println("Song added to catalog.");
    }

    //loops through each song in bgm and prints them
    private void viewSongCatalog() {
        if (bgm.getSongCatalog().isEmpty()) {
            System.out.println("Song catalog is empty.");
            return;
        }

        System.out.println("Song Catalog:");
        for (int i = 0; i < bgm.getSongCatalog().size(); i++) {
            System.out.println((i + 1) + ". " + bgm.getSongCatalog().get(i));
        }
    }

    //collects user input on which gig to generate a setlist for, generates setlist using bgm method
    // based on user input for set length, as well as songs in catalog
    private void generateSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        if (bgm.getSongCatalog().isEmpty()) {
            System.out.println("Song catalog is empty.");
            return;
        }

        System.out.println("Select a gig to generate a setlist for:");
        bgm.viewAllGigs();

        int gigIndex = promptForGigIndex("Enter gig number: ");
        if (gigIndex == -1) {
            return;
        }

        System.out.print("How many songs should be in the setlist? ");
        int numberOfSongs = InputHandler.handleIntegerInput(sc);

        boolean success = bgm.generateSetlistForGigByIndex(gigIndex, numberOfSongs);

        if (!success) {
            System.out.println("Could not generate setlist. The gig may be invalid or already completed.");
            return;
        }

        Gig gig = bgm.findGigByIndex(gigIndex);
        System.out.println("Setlist generated for this gig.");
        System.out.println("Setlist: " + gig.getSetlist());
    }

    //takes user input to use for displaying setlist info about a particular gig
    private void viewGigSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to view its setlist:");
        bgm.viewAllGigs();

        int gigIndex = promptForGigIndex("Enter gig number: ");
        if (gigIndex == -1) {
            return;
        }



        Gig gig = bgm.findGigByIndex(gigIndex);

        if (gig.getSetlist().isEmpty()) {
            System.out.println("This gig does not have a setlist yet.");
            return;
        }

        System.out.println("\nSetlist for " + gig.getDate() + " at " + gig.getVenue().getName() + ":");
        for (int i = 0; i < gig.getSetlist().size(); i++) {
            System.out.println((i + 1) + ". " + gig.getSetlist().get(i));
        }
    }

    //takes user input to use for displaying  info about a particular gig
    private void viewGigDetails() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to view details:");
        bgm.viewAllGigs();

        int gigIndex = promptForGigIndex("Enter gig number: ");
        if (gigIndex == -1) {
            return;
        }

        bgm.viewGigDetails(gigIndex);
    }

    //takes user input to use in bgm method to manually add a song to a setlist
    private void addSongToGigSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to add a song to:");
        bgm.viewAllGigs();

        int gigIndex = promptForGigIndex("Enter gig number: ");
        if (gigIndex == -1) {
            return;
        }

        System.out.print("Enter song name to add to this gig's setlist: ");
        String song = InputHandler.handleStringInput(sc);

        boolean success = bgm.addSongToGigSetlist(gigIndex, song);

        if (success) {
            System.out.println("Song added to this gig's setlist.");
        } else {
            System.out.println("Cannot modify the setlist of a completed or invalid gig.");
        }
    }

    //takes user input to use in bgm method to manually remove a song from a setlist
    private void removeSongFromGigSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to remove a song from:");
        bgm.viewAllGigs();

        int gigIndex = promptForGigIndex("Enter gig number: ");
        if (gigIndex == -1) {
            return;
        }

        Gig gig = bgm.findGigByIndex(gigIndex);

        if (gig.getSetlist().isEmpty()) {
            System.out.println("This gig does not have a setlist yet.");
            return;
        }

        System.out.println("Current setlist:");
        for (int i = 0; i < gig.getSetlist().size(); i++) {
            System.out.println((i + 1) + ". " + gig.getSetlist().get(i));
        }

        System.out.print("Enter the number of the song to remove: ");
        int songIndex = InputHandler.handleIntegerInput(sc);

        String removedSong = bgm.removeSongFromGigSetlist(gigIndex, songIndex - 1);

        if (removedSong == null) {
            System.out.println("Could not remove song. The gig may be completed or the selection was invalid.");
        } else {
            System.out.println("Removed song: " + removedSong);
        }
    }
}