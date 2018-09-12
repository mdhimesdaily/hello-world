import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Room {
    Random rand = new Random();
    // itemsList is same for all rooms, so we make it static
    private String name;
    private String description;
    private HashMap<String, Room> connections = new HashMap<>();
    private Monster enemy;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        //this.getEnemy(enemies);
    }


    public Monster getEnemy(ArrayList<Monster> enemies)
    {
        Monster enemy = enemies.get(0);
        this.enemy= enemy;
        return enemy;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public Room getDirection(String direction) {
        return connections.get(direction);
    }

    public void setDirections(HashMap<String, Room> connections) {
        this.connections = connections;
    }


    public String getEnemy() {
        return this.enemy.getName();
    }
}
