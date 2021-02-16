import java.util.Random;

public class Player implements Combat {

    Random playerrnd = new Random();
    boolean isblocking = false;
    String name;
    int healt;
    int maxhealt = 100;
    int attackdamage = 10;
    int mindodgechange = 10;

    public Player(String name, int healt){
        this.name = name;
        this.healt = healt;
    }
    @Override
    public int Attack() {
        return playerrnd.nextInt(attackdamage);
    }

    @Override
    public boolean Block() {
        if(playerrnd.nextInt(2)==1)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }

    @Override
    public void PlayerChoice() {
        System.out.println("1.Attack");
        System.out.println("2.Block");
    }

    @Override
    public String toString() {
        return "Name= " +
                  name + "\n" +
                "Healt=" + healt +"/"+
                "Maxhealt=" + maxhealt ;
    }
}
