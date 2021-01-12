# General Structure / Organization
 The core of my program was built around 3 core structures. "DriverDatabase" "Driver" "Trip"
 - The DriverDatabase class is used to efficiently store all the Driver objects in a B-tree with fast and simple functionality for retreving and editing the Driver objects within.
 - The Driver class is used to store infomation about a specific driver including all their trips, miles driven, and time on the road.
 - The Trip class is used to house infomation regarding a specific trip including start time, end time, and miles traveled.
 
 I chose this specific modular approach to my program structure as I feel it is the most logical way to provide data abstraction while placing the data in containers which make driver and data access most clear, simple compatability for individual component testing, and improving code reusability.
 
 I chose to make these three objects classes with public accessor methods for private internals to provide simplicity, more organization, and to garauntee only friendly operations are performed on the internal structures (i.e. It's harder to acccidently edit / alter drivers' data within the database).
 
# Trip Class
 This class in the constructor takes in a start time, end time, and total miles.
 Start time and end time are taken in and stored as MINUTES on a 24 hr clock (i.e 6:01am start time is stored as 361). This was done for overall simplicity regarding MPH and duration calculations and to prevent either keeping track of individual hour and minute variables or storing the time as a string (i.e "6:01").
# Driver Class

# DriverDatabase Class

# Util Functions

# Overall Flow
