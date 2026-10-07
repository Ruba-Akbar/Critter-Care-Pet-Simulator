# Critter Care: Interactive Pet Simulator

---
## Overview
### Critter Care is a console-based virtual pet simulator built in Java using Object Oriented Programming principles to simulate the virtual pet's stats such as hunger, energy, social. User can pick between a cat or a dog!
---
## Features
 - **Pet Variety:** Each pet has their own ASCII art work which is decided based on user's choose of either a cat or dog.
 - **Validation:** Used (`equalsIgnoreCase`) to handle uppercase/lowercase input from the user and explicitly structured the loop to filter out invalid inputs.
 - **Stat Boundaries:** Prevents the stats from infinity decreasing or infinity increasing by enforcing boundaries on pet values of hunger, energy, and social (`[0, 100]`).
 ---
 ## Technical Concepts
 ### 1. Data Encapsulation and Object Oriented Programming (OOP)
 Instead of having all the logic isn't `main` function, which isn't secure. The data structures (`hunger`, `energy`, `social`) are declared `private` inside `Pet.java`, making them secure because they can not be modified or corrupted from external scripts. They can only be modified thorugh specific behavior methods (`.play()`, `.eat()`,`.sleep()`).

 ### 2. Complex Conditional Logic and inversion checkers
 The core runtime loop uses a compound negative boolean structure:
 ```java
 while(!action.equalsIgnoreCase("q") && !action.equalsIgnoreCase("quit"))
 ```
 This demonstrates an understanding of programming specific logic inversion because `||` operators in negative conditions results in infinite trap.
 ---
 ## How to Play the Game Loally
 1. Have the **Jave Development Kit (JDK)** installed on your device.
 2. Download `PetSim.java` and `Pet.java` into the same directory.
 3. Open your terminal or command prompt in that directory and compile the files:
 ```bash 
 javac PetSim.java Pet.java
 ```
 4. Run the compiled application:
 ```bash 
 java PetSim
 ```
 5. Enjoy!
