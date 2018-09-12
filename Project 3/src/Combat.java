import java.lang.Math;
import java.util.Random;

    public class Combat {

        public Integer fight(Player player, Monster monster) {
            System.out.println("=====================");
            System.out.println("    COMBAT BEGINS!  ");
            System.out.println("=====================");
            int mHealth = monster.getmHealth();
            String name= monster.getName();
            int pHealth = player.getpHealth();
            int killed = 0;
            Random roll = new Random();
            while (player.getpHealth() > 0 && monster.getmHealth() > 0) {
                if (((roll.nextInt((20 - 1) - 1) + 1) + player.getToHit()) >= monster.getAC()) {
                    monster.setmHealth(mHealth -= player.getDamage());
                    System.out.printf("You hit! %s has %s health remaining!\n\n", name, mHealth);
                    wait(2);
                } else {
                    System.out.println("You missed!\n");
                    wait(2);
                }
                if (((roll.nextInt((20 - 1) - 1) + 1) + monster.getToHit()) > player.getAC()) {
                    player.setpHealth(pHealth -= monster.getDamage());
                    System.out.printf("The %s hit! You have %s health remaining\n\n",name, pHealth);
                    wait(2);
                } else {
                    System.out.printf("The %s missed!\n\n", name);
                    wait(2);
                }


                if (mHealth <= 0) {
                    System.out.println("The monster died!");
                    player.setpHealth(20);
                    killed = 1;
                    player.setpHealth(20);
                    break;
                } else if (pHealth <= 0) {
                    System.out.println("You died!");
                    killed = 2;
                    break;
                }
            }
            return killed;


        }


        private void wait(int numSeconds) {
            try {
                Thread.sleep(numSeconds * 1000);
            } catch (InterruptedException e) {
                // print out if needed
            }
        }
    }

