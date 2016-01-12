package mainPackage;

public abstract class GameChecker {

    GameChecker next;

    public GameChecker setNext(GameChecker checker)
    {
        next = checker;
        return checker;
    }

    public abstract boolean checkState();

    public abstract void conclusion();

    public void check()
    {
        if (checkState())
            conclusion();
        else if (next != null)
            next.check();
        else
            Logic.continueGame();
    }
}
