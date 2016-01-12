package mainPackage;

public class WinChecker extends GameChecker {


    public boolean checkState()
    {
        if (Logic.fieldArray[0][0] != 0 && Logic.fieldArray[0][0] == Logic.fieldArray[0][1] && Logic.fieldArray[0][0] == Logic.fieldArray[0][2] ||
                Logic.fieldArray[1][0] != 0 && Logic.fieldArray[1][0] == Logic.fieldArray[1][1] && Logic.fieldArray[1][0] == Logic.fieldArray[1][2] ||
                Logic.fieldArray[2][0] != 0 && Logic.fieldArray[2][0] == Logic.fieldArray[2][1] && Logic.fieldArray[2][0] == Logic.fieldArray[2][2] ||
                Logic.fieldArray[0][0] != 0 && Logic.fieldArray[0][0] == Logic.fieldArray[1][0] && Logic.fieldArray[0][0] == Logic.fieldArray[2][0] ||
                Logic.fieldArray[0][1] != 0 && Logic.fieldArray[0][1] == Logic.fieldArray[1][1] && Logic.fieldArray[0][1] == Logic.fieldArray[2][1] ||
                Logic.fieldArray[0][2] != 0 && Logic.fieldArray[0][2] == Logic.fieldArray[1][2] && Logic.fieldArray[0][2] == Logic.fieldArray[2][2] ||
                Logic.fieldArray[0][0] != 0 && Logic.fieldArray[0][0] == Logic.fieldArray[1][1] && Logic.fieldArray[0][0] == Logic.fieldArray[2][2] ||
                Logic.fieldArray[0][2] != 0 && Logic.fieldArray[0][2] == Logic.fieldArray[1][1] && Logic.fieldArray[0][2] == Logic.fieldArray[2][0])
            return true;
        else
            return false;
    }

    public void conclusion()
    {
        Logic.winGame();
    }
}
