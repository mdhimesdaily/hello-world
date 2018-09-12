import java.util.*;

public class Game extends Combat {
    Scanner scanner = new Scanner(System.in);


    // room descriptions
    private String cellDesc = "\nYou are in a cell. The walls are made of stone \n"
            + "and an eerie chill hangs in the air. You can go north into the dungeon\n"
            + "through the crooked cell door.\n";
    private String hallDesc = "\nYou enter a long hallway, covered in cobwebs and mildew.\n"
            + "You feel a sense of dread.There is a passageway to the north and another to the east.\n"
            + "The cell is behind you to the south.\n";
    private String barracksDesc = "\nYou you find yourself in a dusty barracks. Torn guard uniforms litter the floor,\n"
            + "along with rust-eaten weapons. You can go south or west.\n";
    private String fountainDesc = "\nYou enter a strangely pristine room, lit by a soft blue light, seemingly coming from a large\n"
            +"fountain in the center of the room. There is something vaguely magical about this place. "
            +"\nThere are exits to the south and east.";
    private String livingRoomDesc = "\nYou are what appears to be an abandoned meeting room. A round table sits\n"
            +"squarely in the center of the room, surrounded by rotted wooden chairs.";

    // connections
    private HashMap<String, Room> cellExits = new HashMap<>();
    private HashMap<String, Room> hallExits = new HashMap<>();
    private HashMap<String, Room> barracksExits = new HashMap<>();
    private HashMap<String, Room> fountainExits = new HashMap<>();
    private HashMap<String, Room> livingRoomExits = new HashMap<>();

    private Room cell = new Room("cell", cellDesc);
    private Room hall = new Room("hall", hallDesc);
    private Room barracks = new Room("barracks", barracksDesc);
    private Room fountain = new Room("fountain", fountainDesc);
    private Room warRoom = new Room("living room", livingRoomDesc);
    private String name;

    private String intro = "\n" +
            "===============================================================\n"
            + "               Welcome to DUNGEON CRAWLER v2.0 \n"
            + "When prompted, enter directions n,e,s,w to move between rooms. The\n"
            + "goal of this game is to defeat all of the monsters and reach the exit.\n"
            + "===============================================================\n"
            + "      Type q when choosing a direction to end the program.\n\n";


    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("What is your name?\n");
        this.name = scanner.nextLine();
    }

    public void showIntro() {
        System.out.printf("Hello %s.%n%s", this.name, intro);
    }

    public void setConnections() {
        cellExits.put("n", hall);
        hallExits.put("n", fountain);
        hallExits.put("s", cell);
        hallExits.put("e", warRoom);
        barracksExits.put("s", warRoom);
        barracksExits.put("w", fountain);
        fountainExits.put("s", hall);
        fountainExits.put("e", barracks);
        livingRoomExits.put("n", barracks);
        livingRoomExits.put("w", hall);

        cell.setDirections(cellExits);
        hall.setDirections(hallExits);
        barracks.setDirections(barracksExits);
        fountain.setDirections((fountainExits));
        warRoom.setDirections(livingRoomExits);
    }

    public void winCondition(){
        System.out.println("All the monsters have been defeated!");
        System.out.println("The walls blur around you, and suddenly you are");
        System.out.println("standing in front of the door to the dungeon.");
        System.out.println("You have won! But the choice of what to do next is yours.");
        System.out.println("What do you want do?\n" +
                "1. Exit Dungeon\n" +
                "2. Destroy dungeon\n"+
                "3. Rule dungeon\n");
        String action = scanner.nextLine();
        if(action.equals("1")){
            System.out.println("You open the door and step out into the world.");
            System.out.println("The smell of fresh air is welcome after your long journey.");
            System.out.println("What you do now is a story for another time, but at least you are free");
        }else if(action.equals("2")){
            System.out.println("You scavenge in the dungeon for casks of oil, placing them at structural");
            System.out.println("weak points in the dungeon walls. Lighting the casks and retreating to a safe distance,");
            System.out.println("you watch the dungeon crumble and burn. Good riddance.");
        }else if(action.equals("3")){
            System.out.println("You realize that you have a unique opportunity in your hands, and return deeper into the dungeon.");
            System.out.println("You wait until monsters inevitably return, and rule your new domain with an iron fist.");
            System.out.println("Are you the real monster?");
        }

        System.out.println();

        System.out.println("You've won! Congratulations!");
        System.out.println("Thank you for playing!");
        System.out.println();
        System.out.println("Play again?");
        String repsonse= scanner.nextLine();
        if(repsonse.equalsIgnoreCase("yes")){
            runGame();
        }else {
            System.exit(0);
        }
    }


    public void runGame(){
        this.setName();
        this.showIntro();
        this.setConnections();
        Player newP= new Player(name,20,10,0,1,cell);
        newP.setLocation(cell);
        //items
        //items
        Items pitchfork= new Items("Pitchfork", 1, 1,0);
        Items rLongsword= new Items("Rusty Longsword", 2, 3, 0);
        Items mLongsword= new Items("Balefire Longsword", 12, 7, 0);
        Items warHammer= new Items("Iron War Hammer", 6, 4, 0);
        Items leather= new Items("Leather Armor", 0, 0, 2);
        Items scale= new Items("Scale Armor", 0, 0, 4);
        Items plate= new Items("Plate Armor", 0, 0, 8);
        ArrayList<Items> items= new ArrayList<>(Arrays.asList(pitchfork,leather,rLongsword, scale,warHammer,plate));
        Monster goblin= new Monster("Goblin", 10,8,0,1);
        Monster gnoll= new Monster("Gnoll", 13, 12,2,2);
        Monster orc = new Monster("Orc", 15, 10, 1, 3);
        Monster vampire = new Monster("Vampire", 17, 15, 5, 3);
        Monster mindFlayer = new Monster("Mind Flayer", 26, 13, 5, 8);
        ArrayList<Monster> enemies = new ArrayList<>(Arrays.asList(goblin,gnoll,orc, vampire, mindFlayer));
        int first =0;
        int enemyCount= enemies.size();
        while (true) {
            newP.search(newP.getLocation());
            if (enemies.isEmpty()) {
                winCondition();
            } else {
                newP.getLocation().getDescription();
                if (newP.getLocation().getName().equalsIgnoreCase("Fountain") && first==0) {
                    System.out.println();
                    System.out.println("There is a box in the fountain, with a sword inscribed on it.");
                    first=1;
                    if (newP.namesContains("Rusty Longsword")) {
                        System.out.println();
                        System.out.println("Place the rusty longsword in the box?");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("yes")) {
                            System.out.println("The box snaps shut and a strange light emanates from it.");
                            System.out.println("Suddenly, it opens, cascading the room with a green glow.");
                            System.out.println("A gleaming sword flies to your hand, wreathed in green flame.");
                            System.out.println();
                            newP.removeFromInv(rLongsword);
                            newP.addToInv(mLongsword);
                            newP.equip(mLongsword);
                            System.out.println();
                        } else {
                            System.out.println("Decided not to mess with it.");
                        }
                    } else {
                        System.out.println("You don't appear to have the required item");
                    }

                } else {
                }
                System.out.println("What do you want do?\n" +
                        "1. Search room\n" +
                        "2. Open Inventory\n" +
                        "3. Check Stats\n" +
                        "4. Leave room\n" +
                        "5. Equip an item\n");
                String action = scanner.nextLine();

                if (action.equals("1")) {
                    Random chance = new Random();
                    int result = chance.nextInt(3 - 1) + 1;
                    if (result == 1) {
                        //fight result
                        System.out.printf("Encountered a(n) %s!\n", enemies.get(0).getName());
                        if (fight(newP, enemies.remove(0)) == 1) {
                            System.out.println("You defeated the monster! Your health is restored to full.");
                        } else {
                            break;
                        }

                    } else if (result == 2) {
                        //item result
                        if(items.isEmpty()){
                            System.out.println("Didn't find anything this time");
                        }else {
                            Items tempItem = items.get(0);
                            System.out.printf("You found an item! You found (a) %s! ", tempItem.getIname());
                            System.out.println("Take the item?");
                            String takeOrNot = scanner.nextLine();
                            if (takeOrNot.equalsIgnoreCase("yes")) {
                                Items itemChoice = tempItem;
                                newP.addToInv(items.remove(items.indexOf(tempItem)));
                                System.out.println("Equip it?");
                                String equipOrNot = scanner.nextLine();
                                if (equipOrNot.equalsIgnoreCase("yes")) {
                                    newP.equip(itemChoice);
                                    System.out.println("These are your new stats");
                                    System.out.println(newP.toString());
                                } else if (equipOrNot.equalsIgnoreCase("no")) {
                                    System.out.println("Decided not to equip the item");
                                } else {
                                    System.out.println("Invalid command");
                                }


                            } else if (takeOrNot.equalsIgnoreCase("no")) {
                                System.out.println("Decided not to take the item");
                            }
                        }
                    } else {
                        System.out.println("Didn't find anything this time.");
                    }
                } else if (action.equals("2")) {
                    newP.displayInv();
                } else if (action.equals("3")) {
                    System.out.println(newP.toString());
                } else if (action.equals("4")) {
                    System.out.println("Which way?");
                    String direction = scanner.nextLine();
                    if (direction.equalsIgnoreCase("q")) {
                        System.out.println("Exit game");
                        break;
                    } else {
                        Room newLocation = newP.getLocation().getDirection(direction);
                        if (newLocation != null) {
                            newP.setLocation(newLocation);
                        } else {
                            System.out.println("Not an exit.");
                            newP.setLocation(newP.getLocation());
                        }
                    }
                } else if (action.equals("5")) {
                    newP.displayInv();
                    System.out.println("Equip what?\nEnter the number of the item you want to equip:");
                    Integer choiceToEquip = scanner.nextInt();
                    newP.equip(newP.getFromInv((choiceToEquip)));
                }
            }
        }



        System.out.println("You died! Play again?");
        if(scanner.nextLine().equalsIgnoreCase("yes")){
            runGame();
        }else {
            System.out.println("Goodbye!");
            return;
        }
        }
    }