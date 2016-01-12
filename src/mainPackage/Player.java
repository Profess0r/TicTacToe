package mainPackage;

public abstract class Player implements Turnable{
    boolean type;
    String name;

    Player(String name, boolean type)
    {
        this.name = name;
        this.type = type;
    }

    public static Player createPlayer(String type, String name)
    {
        if (type.equals("Человек"))
        {
            return new HumanPlayer(name, true);
        }
        else
        {
            return new GameAI(name, false);
        }
    }
}
