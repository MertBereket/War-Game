import java.util.Random;

public class Enemies implements Combat {

    Random enemyrnd = new Random();
    boolean isalive = true;
    boolean isblocking = true;
    String name;
    int maxhealt=100;
    int healt;
    int attackdamage;
    @Override
    public int Attack() {
        return enemyrnd.nextInt(attackdamage);
    }

    @Override
    public boolean Block() {
        if(enemyrnd.nextInt(2)==1)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }

    public Enemies(String name, int healt, int attackdamage)
    {
        this.name = name;
        this.healt = healt;
        this.attackdamage = attackdamage;
    }

    @Override
    public void PlayerChoice() {

    }

    @Override
    public String toString() {
        return "Knight " +
                "/ Healt=" + healt +
                "Maxhealt=" + maxhealt +
                "/ Attackdamage=" + attackdamage ;
    }
}
