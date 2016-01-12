package mainPackage;

public class DrawChecker extends GameChecker {

    public boolean checkState()
    {
        boolean draw = true;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(Logic.fieldArray[i][j] != 0)
                    continue;
                else draw = false;
            }
        }
        return draw;
    }

    public void conclusion()
    {
        Logic.drawGame();
    }
}
