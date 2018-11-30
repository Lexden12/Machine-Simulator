# Machine-Simulator
CS 357 Theory of Computation Project. Turing Machine Simulator with graphical representation of the machine and animated simulation.

Welcome to Machine Simulator! This is a bare-bones Turing Machine Simulator written in Java.
This project was made in Netbeans, so project files can be found in the "nbproject" directory.

Otherwise, java source files are in "src/turing/machine" and example test files are in the "test" directory.

This project is designed for Windows systems but should be easily recompiled for Linux systems.
In order to easily input TMs into the program, use a spreadsheet processor such as Excel which allows easy management of csv files.

# Known Issues
Currently, transitions do not draw well and the rules for them do not draw well either.
In order to allow the Turing Machine to be parsed correctly, every state must have 3 consecutive columns in the transition table.
