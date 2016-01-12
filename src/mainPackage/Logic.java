package mainPackage;

public class Logic {

    public static int playerTurn = 1;
    static Player[] players = new Player[2];

    public static int[][] fieldArray = new int[3][3];

    static GameChecker checker, checker1;

    public void startGame()
    {
        playerTurn = 1;
        clearFieldArray();

        if (!players[0].type)
        {
            players[0].makeTurn();
        }
        else
        {
            waitTurn();
        }
    }

    public static void waitTurn()
    {
        MainWindow.listenerOn();
    }

    public static void check()
    {
        checker = new WinChecker();
        checker1 = checker.setNext(new DrawChecker());

        checker.check();
    }

    public static void winGame()
    {
        MainWindow.state.setText(players[playerTurn-1].name + " победил");
        MainWindow.listenerOff();
    }

    public static void continueGame()
    {
        MainWindow.listenerOff();

        if (playerTurn == 2)
            playerTurn = 1;
        else playerTurn = 2;

        MainWindow.state.setText("Ходит " + players[playerTurn-1].name);

        if (!players[playerTurn-1].type)
        {
            players[playerTurn-1].makeTurn();
        }
        else
        {
            waitTurn();
        }
    }

    public static void drawGame()
    {
        MainWindow.state.setText("Ничья");
    }

    public static boolean turnAvailable(int x, int y)
    {
        if (fieldArray[x][y] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clearFieldArray()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                fieldArray[i][j] = 0;
            }
        }
    }
}
