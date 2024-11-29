# Assignment-2-Searching-Text-String-Data
Version: Java 21

## Instructions 
Clone the repository and use ./build.sh to compile and run the application

## Uses
Efficiently search through a text of all states in the United States. 
1. Use the print button to see the searchable text
2. Use the search button to find the index your search term is located at
3. Use the exit button to exit the program (alternatively use the x button in the top right corner)

## Requirements
- The application uses the names of 50 states in the United States as the input text.
- It uses the bad character rule of the Boyer-Moore algorithm to search the pattern a user inputs via an interface.
- When a user runs the application, it displays a menu and prompts the user to select an option.
- The menu options are:
1. Display the text
2. Search
3. Exit program


1. When a user selects (1) Display the text, the application displays the content of the text (i.e. the names of 50 states in the United States).

2. When a user selects (2) Search, the application prompts the user to input a part of the name of a state as a pattern for search. The application searches for the pattern in the text using the bad character rule of the Boyer-Moore algorithm. Then, the application displays the indices of the matches (i.e. occurrences of the pattern in the text).

3. When a user selects (3) Exit program, the application ends.