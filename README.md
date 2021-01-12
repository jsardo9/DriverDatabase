# General Structure / Organization
 The core of my program was built around 3 core structures. "DriverDatabase" "Driver" and "Trip"
 - The DriverDatabase class is used to efficiently store all the Driver objects in a B-tree with fast and simple functionality for retreving and editing the Driver objects within.
 - The Driver class is used to store infomation about a specific driver including all their trips, miles driven, and time on the road.
 - The Trip class is used to house infomation regarding a specific trip including start time, end time, and miles traveled.
 
 I chose this specific modular approach to my program structure as I feel it is the most logical way to provide data abstraction while placing the data in containers to make driver and data access most clear, provude simple compatability for individual component testing, and improve code reusability.
 
 I chose to make these three objects classes with public accessor methods for private internals to provide simplicity, more organization, and to garauntee only friendly operations are performed on the internal structures (i.e. It's harder to acccidently edit / alter drivers' data within the database).
 
I have overriden the default Object toString() method for each of the 3 classes allow for easy printing to console and convenience for testing.
# Trip Class
 This class in the constructor takes in a start time, end time, and total miles.

Start time and end time are taken in and stored as MINUTES on a 24 hr clock (i.e. 6:01am start time is stored as 361). This was done for overall simplicity regarding MPH and duration calculations and to prevent either keeping track of individual hour and minute variables or storing the time as a string (i.e. "6:01"). 
# Driver Class
This class stores a driver's name in conjunctioon with all their trips, miles driven, and time on the road.

I chose to store a driver's trips in an list (ArrayList) as this will store and index them in the order in which they were added to the driver. This allows for constant time lookup by index and (mostly) constant time adding to it.

A drivers total mileage and time on the road is updated as each new trip is added. (Efficient)
# DriverDatabase Class
The class stores driver obejcts.

I chose the underlying structure to store the drivers to be a Map that is backed by a B-Tree (Treemap) for the following 2 main reasons and for its runtime benifits.
- The map like properties allows us to index the driver objects by their names. This allows for simple and convenient lookups searching for a driver by name.
- The B-Tree properties are great for large storage systems as it sorts the drivers upon insertion and allows for fast lookups, insertions, and deletions.

Runtime Breakdown:
  - O(log(n)) lookups, insertions, and deletions
  - Although there is a O(log(n)) time complexity for inserting drivers resulting in O(nlog(n)) complexity for entirely populating the database I beleive this structure is still optimal as once drivers are inserted we can access them quickly from their sorted order as apposed to something like hashmap where you may have quicker operations you lose the sorted property and have wasted memory.
  
I chose to sort the drivers within the database by name since I beleive it is the most practical way to organize a group of drivers, and makes lookups by name much more efficient. Due to these reasons I also made the default print function for this class alphabetical order.

Since, however, this problem wanted the drivers to be outputted by miles driven I added another function printByMileage() which instead prints the drivers by their total mileage. However, since the drivers are sorted by name this operation takes O(nlog(n)) compared to the O(n) complexity printing alphabetically.
# Util Functions
There are thee helper functions which my code utilizes.
First for each line of input a parser function is called. This function then passes on the input to one of the two corresponding command functions("Driver" or "Trip").

I chose this approach as it is very easy to add compatability for new input commands (from within the parser function).
I also had each helper functions perform basic error checking to make sure arguemnts from the input file are correct.
# Conclusion
I chose to structure my program with 3 distinct classes and a parser reading the inputs for the following reasons.
- Input parser allows for easy addition of commands from an input file.
- 3 class abstraction allows for easy human comprehensible way to efficiently lookup and access driver information.
- Modularity of the program's components allows for easy implementation for testing, readability, organization, and code reusability.

# How Input File Is Read In
 - All input files must be placed within the ./input/ folder
 - Designate the specific input file you want to run using the command line (i.e. java Main [FILENAME])
