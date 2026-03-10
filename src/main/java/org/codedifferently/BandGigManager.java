package org.codedifferently;

import java.util.ArrayList;
import java.util.Collections;

//stores main abstraction of modifier methods we call when we want to update/view/adjust fields in the program
public class BandGigManager {

    //arraylists used because we need a collection to store objects that is not fixed in size
    //needed to be able to easily add and remove objects from list, and access them with indexing
    //for this reason ArrayList was a good choice
    private final ArrayList<Gig> gigs;
    private final ArrayList<String> songCatalog;
    private final ArrayList<String> defaultBandMembers;

    //constructor, no paramaters needed
    public BandGigManager() {
        gigs = new ArrayList<>();
        songCatalog = new ArrayList<>();
        defaultBandMembers = new ArrayList<>();
        defaultBandMembers.add("Alex");
        defaultBandMembers.add("Jonny");
        defaultBandMembers.add("Bailey");
        defaultBandMembers.add("Matty");
    }

    //add gig to ArrayList
    public void addGig(Gig gig) {
        gigs.add(gig);
    }

    //getter to return list of gigs
    public ArrayList<Gig> getGigs() {
        return gigs;
    }

    //find gig at index in ArrayList
    public Gig findGigByIndex(int index) {
        if (index >= 0 && index < gigs.size()) {
            return gigs.get(index);
        }
        return null;
    }

    //update gig complete boolean
    public boolean markGigCompleteByIndex(int index) {
        Gig gig = findGigByIndex(index);

        if (gig == null) {
            return false;
        }

        gig.markCompleted();
        return true;
    }

    //display all gigs in array list
    public void viewAllGigs() {
        if (gigs.isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        //for loops are going to allow us to iterate through the list
        for (int i = 0; i < gigs.size(); i++) {
            System.out.println((i + 1) + ". " + gigs.get(i));
            System.out.println();
        }
    }

    //display all gigs that aren't completed
    public void viewUpcomingGigs() {
        boolean found = false;

        for (int i = 0; i < gigs.size(); i++) {
            if (!gigs.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + gigs.get(i));
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No upcoming gigs.");
        }
    }

    //display all gigs that are completed
    public void viewCompletedGigs() {
        boolean found = false;

        for (int i = 0; i < gigs.size(); i++) {
            if (gigs.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + gigs.get(i));
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No completed gigs.");
        }
    }

    //sum payments of the gigs
    public double calculateTotalEarnings() {
        double total = 0.0;

        //enhanced for loop to iterate through list, only add to sum if gig is completed
        for (Gig gig : gigs) {
            if (gig.isCompleted()) {
                total += gig.getPayment();
            }
        }

        return total;
    }

    //add song to catalog list
    public void addSongToCatalog(String song) {
        songCatalog.add(song);
    }

    //get entire song catalog list object
    public ArrayList<String> getSongCatalog() {
        return songCatalog;
    }

    //not used
    public void addDefaultBandMember(String member) {
        defaultBandMembers.add(member);
    }

    //not used, getter
    public ArrayList<String> getDefaultBandMembers() {
        return defaultBandMembers;
    }

    //clear lineup and add members in defaultBandMembers to gig lineup
    public void applyDefaultLineup(Gig gig) {
        gig.getLineup().clear();
        gig.getLineup().addAll(defaultBandMembers);
    }


    public void generateSetlistForGig(Gig gig, int numberOfSongs) {
        if (songCatalog.isEmpty()) {
            return;
        }

        ArrayList<String> tempSongs = new ArrayList<>(songCatalog);

        //randomly reorder elements in collection tempSongs
        Collections.shuffle(tempSongs);

        gig.clearSetlist();

        for (int i = 0; i < numberOfSongs && i < tempSongs.size(); i++) {
            gig.addSong(tempSongs.get(i));
        }
    }

    //takes gig index to add generated setlist to specific gig
    public boolean generateSetlistForGigByIndex(int index, int numberOfSongs) {
        Gig gig = findGigByIndex(index);

        if (gig == null || gig.isCompleted() || songCatalog.isEmpty()) {
            return false;
        }

        generateSetlistForGig(gig, numberOfSongs);
        return true;
    }

    //add song to setlist array list, if/else locks out gig if completed
    public boolean addSongToGigSetlist(int gigIndex, String song) {
        Gig gig = findGigByIndex(gigIndex);

        if (gig == null || gig.isCompleted()) {
            return false;
        }

        gig.addSong(song);
        return true;
    }

    //remove song from setlist array list in gig, if/else locks out gig if completed
    public String removeSongFromGigSetlist(int gigIndex, int songIndex) {
        Gig gig = findGigByIndex(gigIndex);

        if (gig == null || gig.isCompleted()) {
            return null;
        }

        return gig.removeSongAtIndex(songIndex);
    }

    //display gig info, lineup and setlist for a gig
    public void viewGigDetails(int index) {
        Gig gig = findGigByIndex(index);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        System.out.println(gig);
        System.out.println("Lineup: " + gig.getLineup());
        System.out.println("Setlist: " + gig.getSetlist());
    }
}