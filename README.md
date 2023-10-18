# Java-OOP-Advanced

Amusement Park Rides Management

This Java program serves as an efficient tool for managing and analyzing data related to amusement park rides. It leverages a custom Manege class to represent the characteristics of each ride and is integrated with a data structure called Signature to facilitate data storage and retrieval. The program supports various functionalities, such as reading ride data from a text file, categorizing rides by the park they belong to, and displaying information about rides within a specific park. It also demonstrates the usage of Java's Swing library for graphical user interfaces, showing ride details using a pop-up window. Additionally, the program calculates and displays a frequency table of rides and their occurrences in different parks, and it provides functionality to search for rides by name. This program showcases object-oriented principles in Java and can be a practical tool for amusement park management and ride data analysis.


Database Class for Amusement Park Rides

This Java program serves as a database for managing and organizing data related to amusement park rides. It implements the Signature interface and utilizes two maps to achieve this. The first map, parcs, records parks along with their associated lists of rides. The second map, manegeToParcs, maintains each ride's associations with a list of parks where it can be found. The class offers several functionalities, including adding a ride to a park, retrieving a list of rides within a specific park, finding the parks where a particular ride is located, searching for a specific ride, and calculating the frequency of ride occurrences within the database. Additionally, the toString method allows for the creation of a formatted string representation of the database, making it a convenient tool for managing and analyzing amusement park ride data in a structured and organized manner.


Class for Amusement Park Rides

The Manege class in this Java program serves as a blueprint for representing amusement park rides. It includes fields for the ride's name, height, and speed. The class provides multiple constructors for creating ride objects, as well as accessor methods for retrieving information about the ride. The class implements the Comparable interface to enable ride comparison based on their names. It also overrides the equals method to determine if two rides are equal (having the same name), and the hashCode method to generate a unique hash code for each ride based on its name. The toString method allows for creating a formatted string representation of a ride, making it a versatile and essential component for managing and working with amusement park ride data.


Interface for Managing Amusement Park Ride Data

The Signature interface in this Java program defines a set of methods for managing and querying data related to amusement park rides. It outlines methods for adding a ride to a specific park, retrieving a list of rides in a given park, finding the locations (parks) where a particular ride is available, searching for a specific ride, and calculating the frequency of ride appearances. This interface acts as a contract to ensure that classes implementing it provide the specified functionality for managing amusement park ride information. The methods are designed to work with the Manege class and allow for efficient storage, retrieval, and analysis of ride data.
