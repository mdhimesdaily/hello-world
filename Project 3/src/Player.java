import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private int pHealth;
    private Room location;
    private static List<Items> inv= new ArrayList<>();
    private static List<Object> equipped= new ArrayList<>();
    private static List<String> names= new ArrayList<>();

    public Player(String name, int pHealth, int AC, int toHit, int damage, Room location){
        super(name, AC, toHit, damage);
        this.pHealth= pHealth;
        this.location= location;
    }

    public static void displayInv(){
        int j=0;
        System.out.println("======INVENTORY======");
        for(int i= 0; i<inv.size(); i++ ){
            System.out.printf("%d. %s\n",j, inv.get(i).getIname());
            j++;
        }
        System.out.println("=====================");
    }
    public void addToInv(Items item){
        inv.add(item);
        names.add(item.Iname);
    }

    public Items getFromInv(int index){
        return inv.get(index);
    }

    public void removeFromInv(Items item){
        inv.remove(item.Iname);
    }

    public static Boolean invContains(String item){
        if(inv.contains(item)){
            return true;
        }else{
            return false;
        }
    }

    public int getpHealth(){
        return pHealth;
    }

    public void equip(Items item) {
        if (names.contains(item.getIname())) {
            System.out.printf("Equipped %s\n", item.getIname());
            equipped.add(item);
            setDamage(getDamage()+item.getIdamage());
            setToHit(getToHit()+item.getItoHit());
            setAC(getAC()+item.getiAC());
        } else {
            System.out.println();
            System.out.println("You can't equip that.");
        }
    }
    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public void search(Room location) {
        System.out.println(location.getDescription());
    }

    public void setpHealth(int pHealth) {
        this.pHealth = pHealth;
    }

    public static boolean namesContains(String itemname) {
        if(names.contains(itemname)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        super.toString();
        return String.format("=========STATS==========%nName: %s%nHealth: %s%nArmor Class: %s%nBonus to Hit: %s%nDamage: %s%n========================%n", getName(), getpHealth(), getAC(), "+" +getToHit(), getDamage());
    }

}
