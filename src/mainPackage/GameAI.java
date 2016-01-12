package mainPackage;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameAI extends Player {

    GameAI(String name, boolean type)
    {
        super(name, type);
    }

    public void makeTurn(int x, int y) {  }

    public void makeTurn()
    {
        int x = 0, y = 0;
        do
        {
            x = ThreadLocalRandom.current().nextInt(0, 3);
            y = ThreadLocalRandom.current().nextInt(0, 3);
        }
        while(!Logic.turnAvailable(x, y));

        Logic.fieldArray[x][y] = Logic.playerTurn;
        int i = x + y + y * 2;

        if (Logic.playerTurn == 1)
            MainWindow.fields[i].setIcon(new ImageIcon(getClass().getResource("/mainPackage/icons/cross.png")));
        else
            MainWindow.fields[i].setIcon(new ImageIcon(getClass().getResource("/mainPackage/icons/circle.png")));
        Logic.check();
    }
}
