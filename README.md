## XMLwriter 
## Overview

This Java program reads data from a text file (`log.txt`) and generates an XML file (`dependencies.xml`) based on the provided data.

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- IDE (IntelliJ IDEA)
  
## Setup and Run

1. **Clone the Repository** (if applicable):

    git clone <repository-url>
    cd <repository-directory>

2. **Prepare the Input File**:

    Create a file named `log.txt` in the project directory with the following content:

    1.groupld=org.projectlombok;
    1.artifactid=Lombok;
    1.version=1.5;

    2.groupld=com.google.api-client;
    2.artifactid=google-api-client;
    2.version=1.30.9;

3. **Compile the Program**:

    Open the project using IDE and compile the code.

4. **Run the Program**:

    Using the IDE run the `XMLWriterExample` class. 

5. **Check the Output**:

    The program will generate an `dependencies.xml` file in the project directory with the XML content based on the data from `log.txt`.

