Team Alex, Fred, and Henrietta


# BandGigManager:
Bands struggle to track gigs, payments, players, setlists and venues, this application allows them to easily track everything in one spot.

## THE PLAN

Our 3 sprints took place over 1 day, March 9th. 
During sprint planning, we divided responsibilities as follows:

Alex was responsible for initial app setup with classes and core methods.
Fred was responsible for input handling and user interfaces(menus) nd README.md .
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


## THE BUILD:

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

## THE REFLECTION
-Our program is robust and has many capabilities not really necessary given scope of project. We did not need to use Abstraction 
since no classes extended parent classes in this program, and no interfaces were needed. Encapsulation is used on Gig, Venue, and BandGigManager
classes with private fields being accessed by getters and setters.

This program reinforced concepts we've previously implemented.