public class Monster extends Character{
    private String weakness;
    private int mHealth;

    public Monster(String name, int mHealth, int AC, int toHit, int damage){
        super(name,AC,toHit,damage);
        this.mHealth= mHealth;
        this.weakness= weakness;

        if(name.equalsIgnoreCase("Vampire")){
            weakness= "Garlic";}
        else if(name.equalsIgnoreCase("Minotaur")){
            weakness= "Greek Fire";}
        else if(name.equalsIgnoreCase("Orc")){
            weakness= null;}
        else if(name.equalsIgnoreCase("Mind Flayer")){
            weakness= "Rune";}
        else{
            weakness= null;

        }
    }

    public int getmHealth() {
        return mHealth;
    }

    public void setmHealth(int mHealth) {
        this.mHealth = mHealth;
    }
}
