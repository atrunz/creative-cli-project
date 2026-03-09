package org.codedifferently;

import java.util.Scanner;

public class Venue {
        private String name;
        private String city;
        private int capacity;
        private String contactName;
        private String contactEmail;

        Scanner sc = new Scanner(System.in);

        public Venue() {
        }

        public Venue(String name, String city, int capacity, String contactName, String contactEmail) {
            this.name = name;
            this.city = city;
            this.capacity = capacity;
            this.contactName = contactName;
            this.contactEmail = contactEmail;
        }
        public Venue promptNewVenue(){
            System.out.println("Enter name of gig venue: ");
            String venueName = sc.nextLine();

            System.out.println("Enter name of city/state of venue: ");
            String city = sc.nextLine();

            System.out.println("Enter venue capacity: ");
            int capacity = sc.nextInt();
            sc.nextLine(); // CLEAR NEWLINE

            System.out.println("Enter the first and last name of this venue's contact: ");
            String contactName = sc.nextLine();

            System.out.println("Enter the email address of this venue's contact: ");
            String contactEmail = sc.nextLine();
            return new Venue(venueName,city,capacity,contactName,contactEmail);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        @Override
        public String toString() {
            return name + " - " + city + " | Capacity: " + capacity +
                    " | Contact: " + contactName + " | Email: " + contactEmail;
        }
    }

