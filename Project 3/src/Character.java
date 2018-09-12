import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private int AC;
    private int toHit;
    private int damage;
    private int BaseAC=10;
    private int BasetoHit=0;
    private int BaseDamage=1;

    public Character(String name,  int AC, int toHit, int damage){
        this.name= name;
        this.AC= AC;
        this.toHit= toHit;
        this.damage= damage;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getToHit() {
        return toHit;
    }

    public void setToHit(int toHit) {
        this.toHit = toHit;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBaseAC() {
        return 10;
    }

    public int getBasetoHit() {
        return 0;
    }

    public int getBaseDamage() {
        return 1;
    }
}
