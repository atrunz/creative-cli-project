package org.codedifferently;

import java.util.ArrayList;

public class Gig {
    private String date;
    private Venue venue;
    private double payment;
    private boolean completed;
    private ArrayList<String> lineup;
    private ArrayList<String> setlist;

    public Gig() {
        lineup = new ArrayList<>();
        setlist = new ArrayList<>();
        completed = false;
    }

    public Gig(String date, Venue venue, double payment) {
        this.date = date;
        this.venue = venue;
        this.payment = payment;
        this.completed = false;
        this.lineup = new ArrayList<>();
        this.setlist = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<String> getLineup() {
        return lineup;
    }

    public void setLineup(ArrayList<String> lineup) {
        this.lineup = lineup;
    }

    public ArrayList<String> getSetlist() {
        return setlist;
    }

    public void setSetlist(ArrayList<String> setlist) {
        this.setlist = setlist;
    }


    public void addBandMember(String member) {
        lineup.add(member);
    }

    public void removeBandMember(String member) {
        lineup.remove(member);
    }

    public void addSong(String song) {
        setlist.add(song);
    }

    public void clearSetlist() {
        setlist.clear();
    }

    public void markCompleted() {
        completed = true;
    }

    public String getStatus() {
        if (completed) {
            return "Completed";
        }
        return "Scheduled";
    }

    public void swapBandMember(String oldMember, String newMember) {
        int index = lineup.indexOf(oldMember);

        if (index != -1) {
            lineup.set(index, newMember);
        }
    }

    public String removeSongAtIndex(int index) {
        if (index >= 0 && index < setlist.size()) {
            return setlist.remove(index);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Date: " + date +
                "\nVenue: " + venue.getName() +
                "\nCity: " + venue.getCity() +
                "\nPayment: $" + payment +
                "\nStatus: " + getStatus();
    }
}
//