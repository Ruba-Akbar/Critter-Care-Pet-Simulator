import java.util.Scanner;

public class PetSim {
  public static void main(String[] args) {
  Scanner myScanner = new Scanner(System.in);
  System.out.print("\n" +
"|============================================|\n" +
"|          WELCOME TO CRITTER CARE           |\n" +
"|               PET SIMULATOR                |\n" +
"|============================================|\n" +
"|    ,_     _                       __       |\n" +
"|    |\\____/|                      /  \\      |\n" +
"|    / _  _ |    ,--.             / ..|\\     |\n" +
"|   (  @  @ )   / ,-'            (_\\  |_)    |\n" +
"|    \\  _T_/-._( (                /  \\@'     |\n" +
"|    /         `. \\              /     \\     |\n" +
"|   |         _  \\ |        _   /  `   |     |\n" +
"|   \\ \\ ,  /      |        \\\\/  \\  | _\\      |\n" +
"|    || |-_\\__   /          \\   /_ || \\\\_    |\n" +
"|   ((_/`(____,-'            \\____)|_) \\_)   |\n" +
"|============================================|\n");


    String type = "";

    //loop until user inputs a vaild choice
    while(true) {
      System.out.print("\nTime To Choose Your Pet!!!\n C: Cat\n D: Dog\n Enter: ");
      type = myScanner.nextLine().trim().toLowerCase();
      if(type.equals("c") || type.equals("cat") || type.equals("d") || type.equals("dog")) {
        break;
      } 
      System.out.println("Invalid option, please try again!");
    }

    System.out.println();
    System.out.print("What is the name of the sim: ");
    String name = myScanner.nextLine().trim();
    System.out.println();

    Pet myPet = new Pet(name, type);
    myPet.printArtWork();
    System.out.println();
    
    String action = "";
    // keep going if action is not q and not not quit
    while(!action.equalsIgnoreCase("q") && !action.equalsIgnoreCase("quit")) {
      System.out.println("\n=========================");
      System.out.println("~~STARTING STATS~~");
      System.out.println("~~Range:   0-100~~");
      System.out.println("Hunger: " + myPet.getHunger());
      System.out.println("Energy: " + myPet.getEnergy());
      System.out.println("Social: " + myPet.getSocial());
      System.out.println("Q to quit");
      System.out.println("=========================");
      System.out.println("\nWhat is your next action?\n P: Play\n E: Eat\n S: sleep");
      System.out.print("Enter: ");
      action = myScanner.nextLine().trim();

      if (action.equalsIgnoreCase("p") || action.equalsIgnoreCase("play")) {
        if(myPet.getHunger() == 0 || myPet.getEnergy() == 0) {
          System.out.println("Sorry can't play because at least one of " + name + "'s stats is 0");
        } else {
          myPet.play();
        }
      } else if (action.equalsIgnoreCase("e") || action.equalsIgnoreCase("eat")) {
        if(myPet.getSocial() == 0 || myPet.getEnergy() == 0) {
          System.out.println("Sorry can't play because at least one of " + name + "'s stats is 0");
        } else {
          myPet.eat();
        }
      } else if (action.equalsIgnoreCase("s") || action.equalsIgnoreCase("sleep")) {
        if(myPet.getHunger() == 0 || myPet.getSocial() == 0) {
          System.out.println("Sorry can't play because at least one of " + name + "'s stats is 0");
        } else {
          myPet.sleep();
        }
      } else if (action.equalsIgnoreCase("q") || action.equalsIgnoreCase("quit")) {
        System.out.println("\nThank you for playing! \nGoodbye!\n");
        break;
      } else {
        System.out.println("Invalid action! Try P, E, S, or Q\n");
        continue;
      }

      if(myPet.GameOver()) {
        System.out.println("\n~~~GAME OVER~~~");
        System.out.println("One of " + myPet.getName() + "'s stats reached 0! :(");
        break;
      }

      System.out.println("~~UPDATED STATS~~");
      System.out.println("~~Range:  0-100~~");
      System.out.println("Hunger: " + myPet.getHunger());
      System.out.println("Energy: " + myPet.getEnergy());
      System.out.println("Social: " + myPet.getSocial());
      System.out.println("Q to quit");
    }
    myScanner.close();
  }
}
