Welcome to Turing Machine Simulator!
This is a Java program which simulates Turing Machines. NOTE: this program only supports single-tape, deterministic Turing Machines currently.
Since this is running on Java, this jar is ready to run on any computer with Java installed.

You can provide your own Turing Machine using a csv (comma separated value) file. (this is most easily done in a spreadsheet editor such as Excel)
You can also specify the input string by typing it in directly or by providing a text file.
Samples of Turing Machines in csv form and inputs in text files can be found in the "testFiles" folder.

Expected Turing Machine input format:
The file will be a comma separated value file (.csv) with lines as follows:
	1. List of states (first state listed is start state and last state is the accepting state)
	2. Tape alphabet (all the characters either read from or written to the tape (a blank is "_")
	3. Start of transition table. Can list the states or leave blank. If listing states, leave the first column blank and then put the next state in every third column.
	4a. Put the tape character read
	4b. For each state, put the tape character written, the direction to move the head of the tape (R or L), and the state in the TM to move to.
	4bb. NOTE: if there is no transition on the given character, make sure there are 3 empty spots in its place (in csv, that is ",,,,").
	5. Repeat step 4 for each character in the tape.

For sample files, look in the "testFiles" folder.

Turing Machines in testFiles:
1. Accepts strings of the form w#w, where w is a string.
2. Accepts strings of the form a^nb^nc^n, where n > 0.
3. Accepts strings of the form a^ib^jc^k, where k = i * j and i, j > 0.