public class Pet {
    private String name;
    private String type;
    private int hunger;
    private int energy;
    private int social;

    // ASCII ART ASSETS
    private static final String CAT_ART = 
        " ,_     _\n" + //
        " |\\____/|\n" + //
        " / _  _ |    ,--.\n" + //
        "(  @  @ )   / ,-'\n" + //
        " \\  _T_/-._( (\n" + //
        " /         `. \\\n" + //
        "|         _  \\ |\n" + //
        " \\ \\ ,  /      |\n" + //
        "  || |-_\\__   /\n" + //
        " ((_/`(____,-'";

    private static final String DOG_ART = 
        "         __\r\n" + //
        "        /  \\\r\n" + //
        "       / ..|\\\r\n" + //
        "      (_\\  |_)\r\n" + //
        "      /  \\@' \r\n" + //
        "     /     \\\r\n" + //
        "_   /  `   |\r\n" + //
        "\\\\/  \\  | _\\\r\n" + //
        " \\   /_ || \\\\_\r\n" + //
        "  \\____)|_) \\_)\r" + //
        "";

    //constructor
    public Pet(String name, String type) {
        if(name == null) throw new IllegalArgumentException("Name can't be empty!");
        if(type == null) throw new IllegalArgumentException("Type can't be empty!");
        this.name = name;
        this.type = type.toLowerCase();

        //what the pet stat start as
        this.hunger = 10;
        this.energy = 10;
        this.social = 10;
    }

    //getters only, don't need setters
    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public int getEnergy() { return energy; }
    public int getSocial() { return social; }

    public void printArtWork(){
        if(isCat()) System.out.print("\n" + CAT_ART);
        if(!isCat()) System.out.print("\n" + DOG_ART);
    }

    //actions in game
    public void play(){
        if(isCat()) System.out.println("\n" + name + " happily plays with a laser pointer!\n");
        else System.out.println("\n" + name + " happily plays with a tennis ball!\n");
        hunger -= 2;
        energy -= 2;
        social += 2;
        statsBoundaries();
    }

    public void eat(){
        if(isCat()) System.out.println("\n" + name + " is munching on some yummy kibble!\n");
        else System.out.println("\n" + name + " happily eats your shoes!\n");
        energy -= 1;
        if(hunger < 5){
            hunger += 3;
            System.out.println(name + " was starving!\n");
        } else {
            hunger += 1;
        }
        statsBoundaries();
    }

    public void sleep(){
        if(isCat()) System.out.println("\n" + name + " is peacefully sleeping in a cardboard box!\n");
        else System.out.println("\n" + name + " is peacefully sleeping on the couch!\n");
        hunger += 3;
        energy -= 2;
        social -= 1;
        statsBoundaries();
    }

    //utility methods
    private boolean isCat(){
        return type.equals("c") || type.equals("cat");
    }

    private void statsBoundaries(){
        //minimum boundaries
        if(hunger < 0) hunger = 0;
        if(energy < 0) energy = 0;
        if(social < 0) social = 0;
        //maximum boundaries
        if(hunger > 100) hunger = 100;
        if(energy > 100) energy = 100;
        if(social > 100) social = 100;
    }

    //game over
    public boolean GameOver(){
        return hunger == 0 || energy == 0 || social == 0;
    }
}

