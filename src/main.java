import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class main
{

    public static void EnemyIdle() throws FileNotFoundException
    {
        File enemyidle = new File("out/Knightidle.txt");
        Scanner sc = new Scanner(enemyidle);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
        }

    public static void EnemyimageAttack() throws FileNotFoundException
    {
        File enemyattack = new File("out/Knightidle.txt");
        Scanner sc = new Scanner(enemyattack);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }

    public static void EnemyimageBlock() throws FileNotFoundException
    {
        File enemyattack = new File("out/Knightidle.txt");
        Scanner sc = new Scanner(enemyattack);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }

    public static void main(String[] args) throws IOException , InterruptedException
    {
        boolean playing = true;
        int chohise;
        int playerattack;
        int enemyattack;
        Random rnd = new Random();
        Player user = new Player("Mert",100);
        Enemies knihgt = new Enemies("Knight",100,rnd.nextInt(20));
        System.out.println(user);
        while (knihgt.isalive && user.healt >0)
        {
            EnemyIdle();
            if (knihgt.Block())
            {
                knihgt.isblocking = true;
            }
            System.out.println(knihgt);
            user.PlayerChoice();
            String chooise;
            Scanner scn = new Scanner(System.in);
            chooise = scn.next();
            int choise = Integer.parseInt(chooise);

            switch (choise)
            {
                case 1:

                    System.out.println("You try to attack !");

                    if (knihgt.isblocking)
                    {
                        EnemyimageBlock();
                        knihgt.isblocking = false;
                        Thread.sleep(1000);
                    }
                    else
                        {
                        playerattack = user.Attack();
                        knihgt.healt = knihgt.healt - playerattack;
                        System.out.println("You attacked for " + playerattack+" damage!");
                        if (knihgt.healt <= 0)
                        {
                            knihgt.isalive = false;
                            System.out.println("Enemy is dead. You win!");
                            playing = false;
                            Thread.sleep(1000);
                        }
                    }
                    break;
                case 2:
                    System.out.println("You try to block !");
                    if (user.Block()) {
                        user.isblocking = true;
                        Thread.sleep(1000);
                    }
                    break;
                default:
                    System.out.println("You'r choise is not available!");
                    Thread.sleep(1000);
                    break;
            }
            if (knihgt.isalive)
            {
                if (user.healt <= 0)
                {
                    System.out.println("You are dead !");
                    playing = false;
                    knihgt.isalive = false;
                    Thread.sleep(1000);
                }
                else
                    {
                    if (user.isblocking)
                    {
                        System.out.println("You blocked !");
                        user.isblocking = false;
                        Thread.sleep(1000);
                    }
                    else
                        {
                            enemyattack = knihgt.Attack();
                            EnemyimageAttack();
                            user.healt = user.healt - enemyattack;
                            System.out.println("Enemy attacked for "+ enemyattack+ " damage!");
                            Thread.sleep(1000);
                        }
                    System.out.println(user);
                }

            }

        }
    }

}
