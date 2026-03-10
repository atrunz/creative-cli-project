Team Alex, Fred, and Henrietta


# BandGigManager:
Bands struggle to track gigs, payments, players, setlists and venues, this application allows them to easily track everything in one spot.

## THE PLAN

Our 3 sprints took place over 1 day, March 9th. 
During sprint planning, we divided responsibilities as follows:

Alex was responsible for initial app setup with classes and core methods.
Fred was responsible for input handling and user interfaces(menus) and README.md .
Henrietta assisted with leaving code comments explaining logic and other discretionary touch-ups.

We plan to allow users to do the following:
- Add a new gig
- Store and view venue information
- Track payment for each gig
- Mark a gig as completed
- View upcoming gigs
- View total earnings from completed gigs
- Adjust the lineup for a specific gig
- Add songs to a gig’s setlist
- Generate a setlist for a gig from a song catalog
- View full gig details, including venue, status, lineup, and setlist


## THE PLAN:

- Venue
This class will store information about a venue.
Expected fields:
venue name
city
capacity
contact name
contact email 
 

- Gig
This class will represent one performance.
Expected fields:
gig ID
event name
date
venue
payment
completion status
lineup
setlist

- BandGigManager
This class will manage the overall system.
Expected responsibilities:
store all gigs
add gigs
search for a gig
display upcoming gigs
calculate total earnings
store default band members
store a song catalog
generate setlists for gigs

- UI()
This class handles menus and user prompts with Scanner to keep Main method clean.
This class will run the command-line interface.+
Show the menu
Get user input with Scanner
Call methods from BandGigManager
Keep the program running until the user exits

- Main()
Call UI to run program.

## THE BUILD
-Venue
This class does store information about venues, but we simplified it and removed fields
like contact name and contact email. It wasn't helpful for our MVP.

-Gig
This class successfully stores info about gigs, but we cut down on some of the fields for simplicity.
We were not able to implement gigID or eventName. This is something we can look at implementing in our next iteration,
as we still think these are important identifiers to have.

-BandGigManager
We managed to essentially accomplish everything we set out to do with this class. We were
also able to incorporate features like band lineup adjustment. One thing that we missed which we could improve,
pertaining to the bandGigManager and Gig is using actual date/times for tracking gigs. We could have
displayed these to the user in chronological order (instead of order of first insertion), but this is 
something we could accomplish with more time. 

-UI
Completely implemented, handles all user input and runs main program loop. We ran into issues with menu complexity,
we tried to resolve this by creating submenus with similar options grouped together, rather than one giant menu.


We consistently had issues with using nextInt in our scanner, as well as trying to refactor the code
to be robust against bad input. The nextInt thing was a token issue where it would skip our next input, so we just added 
an extra nextLine() wherever that appeared. For input handling, we imported helper functions from another project and 
incorporated them into our code. 

## THE REFLECTION
-Our program is a complete MVP, functionally accomplishing everything that we wanted to. The code and structure is pretty
well organized, however we can incorporate more detailed comments. There are also leftover getter/setter methods that were 
never actually used in the project, that are still hanging around. These could be removed or given a use in the program.
We used a lot of Encapsulation throughout the project, included in Gig, Venue, and BandGigManager
classes which have private fields being accessed by getters and setters. There was polymorphism used, with multiple overloaded functions.
Abstraction was used in a conceptual sense with class design, but not implemented with abstract classes or interfaces.
Inheritance wasn't directly used, there are no subclasses extending parent classes. 

This program reinforced concepts we've previously implemented and really helped with the process of designing software from scratch,
rather than following a pre-scripted scenario.