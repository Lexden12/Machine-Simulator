# Machine-Simulator
CS 357 Theory of Computation Project. Turing Machine Simulator with graphical representation of the machine and animated simulation.

Welcome to Machine Simulator! This is a bare-bones Turing Machine Simulator written in Java.
This project was made in Netbeans, so project files can be found in the "nbproject" directory.

Otherwise, java source files are in "src/turing/machine" and the actual distribution software is available in "Turing Machine Simulator". This folder includes everything you should need with test files and a readme. All that is required to run the jar files is the JRE (Java Runtime Environment), available from Oracle.

This project is designed for Windows systems but should be able to run on all systems running a Java VM.
In order to easily input TMs into the program, use a spreadsheet processor such as Excel which allows easy management of csv files.

# Known Issues
Currently, transitions do not draw well and the rules for them do not draw well either.
In order to allow the Turing Machine to be parsed correctly, every state must have 3 consecutive columns in the transition table.
