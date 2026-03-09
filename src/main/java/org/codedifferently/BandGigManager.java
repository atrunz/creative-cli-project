package org.codedifferently;

import java.util.ArrayList;
import java.util.Collections;

public class BandGigManager {
    private ArrayList<Gig> gigs;
    private ArrayList<String> songCatalog;
    private ArrayList<String> defaultBandMembers;

    public BandGigManager() {
        gigs = new ArrayList<>();
        songCatalog = new ArrayList<>();
        defaultBandMembers = new ArrayList<>();
    }

    public void addGig(Gig gig) {
        gigs.add(gig);
    }

    public ArrayList<Gig> getGigs() {
        return gigs;
    }

    public Gig findGigByIndex(int index) {
        if (index >= 0 && index < gigs.size()) {
            return gigs.get(index);
        }
        return null;
    }

    public void viewAllGigs() {
        if (gigs.isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        for (int i = 0; i < gigs.size(); i++) {
            System.out.println((i + 1) + ". " + gigs.get(i));
            System.out.println();
        }
    }

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

    public double calculateTotalEarnings() {
        double total = 0;

        for (Gig gig : gigs) {
            if (gig.isCompleted()) {
                total += gig.getPayment();
            }
        }

        return total;
    }

    public void addSongToCatalog(String song) {
        songCatalog.add(song);
    }

    public ArrayList<String> getSongCatalog() {
        return songCatalog;
    }

    public void addDefaultBandMember(String member) {
        defaultBandMembers.add(member);
    }

    public ArrayList<String> getDefaultBandMembers() {
        return defaultBandMembers;
    }

    public void applyDefaultLineup(Gig gig) {
        gig.getLineup().clear();
        gig.getLineup().addAll(defaultBandMembers);
    }

    public void generateSetlistForGig(Gig gig, int numberOfSongs) {
        if (songCatalog.isEmpty()) {
            System.out.println("Song catalog is empty.");
            return;
        }

        ArrayList<String> tempSongs = new ArrayList<>(songCatalog);
        Collections.shuffle(tempSongs);

        gig.clearSetlist();

        for (int i = 0; i < numberOfSongs && i < tempSongs.size(); i++) {
            gig.addSong(tempSongs.get(i));
        }
    }

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
