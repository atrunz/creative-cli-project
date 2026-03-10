package org.codedifferently;

import java.util.ArrayList;

public class Gig {
    //used private fields to limit accessibility as much as possible
    //fulfilling encapsulation principles
    private String date;
    private Venue venue;
    private double payment;
    private boolean completed;
    private ArrayList<String> lineup;
    private ArrayList<String> setlist;

    //constructor no arguments
    public Gig() {
        lineup = new ArrayList<>();
        setlist = new ArrayList<>();
        completed = false; //completed defaults to false, gig has to be manually logged as complete
    }

    //alternate constructor
    public Gig(String date, Venue venue, double payment) {
        this.date = date;
        this.venue = venue;
        this.payment = payment;
        this.completed = false;
        this.lineup = new ArrayList<>();
        this.setlist = new ArrayList<>();
    }

    //getter
    public String getDate() {
        return date;
    }

    //setter
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


    //add to arraylist
    public void addBandMember(String member) {
        lineup.add(member);
    }

    //remove from arraylist
    public void removeBandMember(String member) {
        lineup.remove(member);
    }

    public void addSong(String song) {
        setlist.add(song);
    }

    //remove all from setlist arraylist
    public void clearSetlist() {
        setlist.clear();
    }

    //update completed boolean to true
    public void markCompleted() {
        completed = true;
    }

    //tells us whether completed boolean is true or false
    public String getStatus() {
        if (completed) {
            return "Completed";
        }
        return "Scheduled";
    }

    //update index of lineup arraylist
    public void swapBandMember(String oldMember, String newMember) {
        int index = lineup.indexOf(oldMember);

        if (index != -1) {
            lineup.set(index, newMember);
        }
    }

    //remove item at index in setlist arraylist
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