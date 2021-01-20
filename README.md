# Build Instructions
This program is built using Apache Ant (version 1.10.9)

**Commands**

```
ant build
```
This will only succeed if program passes all unit tests, allowing for a clean build. (Details in section "Testing")
```
ant run
```
This will run the program using file named "input.txt" within input folder.

**Ant Alternative**

I have provided a Main.jar file in the root of the directory for convenience if Apache Ant is not installed.
```
java -jar Main.jar |INPUTFILE.TXT|
```
This command will run the program in which "|INPUTFILE.TXT|" is the name of the specific input file you wish to run.

(i.e. java -jar Main.jar input.txt)

!! Input file must be located within folder ./input/ !!

# General Structure / Organization
 The core of my program was built around 3 core structures. "DriverDatabase" "Driver" and "Trip"
 - The DriverDatabase class is used to efficiently store all the Driver objects in a B-tree with fast and simple functionality for retrieving and editing the Driver objects within.
 - The Driver class is used to store information about a specific driver including all their trips, miles driven, and time on the road.
 - The Trip class is used to house information regarding a specific trip including start time, end time, and miles traveled.

 I chose this specific modular approach to my program structure as I feel it is the most logical way to provide data abstraction while placing the data in containers to make driver and data access most clear, provide simple compatibility for individual component testing, and improve code reusability.

 I chose to make these three objects classes with public accessor methods for private internals to provide simplicity, more organization, and to guarantee only friendly operations are performed on the internal structures (i.e. It's harder to accidently edit / alter drivers' data within the database).

I have overridden the default Object toString() method for each of the 3 classes allowing for easy printing to console and convenience for testing.
# Trip Class
 This class in the constructor takes in a start time, end time, and total miles.

Start time and end time are taken in and stored as MINUTES on a 24 hr clock (i.e. 6:01am start time is stored as 361). This was done for overall simplicity regarding MPH and duration calculations and to prevent either keeping track of individual hour and minute variables or storing the time as a string (i.e. "6:01").
# Driver Class
This class stores a driver's name in conjunction with all their trips, miles driven, and time on the road.

I chose to store a driver's trips in a list (ArrayList) as this will store and index them in the order in which they were added to the driver. This allows for constant time lookup by index and (mostly) constant time adding to the list.

A driver's total mileage and time on the road is updated as each new trip is added.
# DriverDatabase Class
This class stores driver objects.

I chose the underlying structure to store the drivers to be a Map that is backed by a B-Tree (TreeMap) for the following 2 main reasons and for its runtime benefits.
- The map like properties allows us to index the driver objects by their names. This allows for simple and convenient lookups searching for a driver by name.
- The B-tree properties are great for large storage systems as it sorts the drivers upon insertion and allows for fast lookups, insertions, and deletions.

Runtime Breakdown:
  - O(log(n)) lookups, insertions, and deletions
  - Although there is a O(log(n)) time complexity for most operations, I believe this structure is still optimal as it is sorted and memory efficient. I chose this over a hash table where you may have quicker O(1) operations but would lose the sorted property and have wasted memory. If the necessity for faster actions was greater than the expense of memory, I would consider using a hash table instead of a tree structure.

I chose to sort the drivers within the database by name since I believe it is the most practical way to organize a group of drivers, as drivers would most frequently be looked up by their name. Due to these reasons I also made the default print function for this class be in alphabetical order.

Since, however, this problem wanted the drivers to be outputted by miles driven I added another function, printByMileage(), which instead prints the drivers by their total mileage. However, since the drivers are sorted by name this operation takes O(nlog(n)) compared to the O(n) complexity printing alphabetically.
# Util Functions
There are thee helper functions which my code utilizes.

First, for each line of input a parser function is called. This function then passes on the input to one of the two corresponding command functions ("Driver" or "Trip") which either adds a new driver to the database or adds a new trip to a specified driver.

I chose this approach as it is very easy to add compatibility for new input commands.

I also had each helper function perform basic error checking to make sure arguments from the input file were correct.
# Testing
Testing was done using JUnit4.
I chose this testing framework, since in combination with Apache Ant, successfully passing the unit tests is a precondition for the program being built. This means the final product is guaranteed to be a clean build as a new version will not be created unless the tests are all passed.

Additionally I made test reports automatically generate as .txt files located in ./build/test-report for a comprehensive breakdown of the previously run tests.

I followed standard JUnit and BDD naming conventions for my classes and tests.

https://en.wikipedia.org/wiki/JUnit#Example_of_JUnit_test_fixture
# Conclusion
I chose to structure my program with 3 distinct classes, a parser reading the inputs, and JUnit testing framework for the following reasons.
- Input parser allows for easy addition of new commands from an input file and error checking.
- 3 class abstraction allows for a convenient human comprehensible way to efficiently access and change driver information.
- Modularity of the program's components allows for easy implementation for testing, readability, organization, and code reusability.
- Testing dependency for a new build provides assurance for the program's reliability and test reports provide a comprehensive outlook of the program's performance
