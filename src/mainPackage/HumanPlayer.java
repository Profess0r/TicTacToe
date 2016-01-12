package mainPackage;

import javax.swing.*;

public class HumanPlayer extends Player {

    HumanPlayer(String name, boolean type)
    {
        super(name, type);
    }

    public void makeTurn(){}

    public void makeTurn(int x, int y)
    {
        Logic.fieldArray[x][y] = Logic.playerTurn;
        int i = x + y + y * 2;

        if (Logic.playerTurn == 1)
            MainWindow.fields[i].setIcon(new ImageIcon(getClass().getResource("/mainPackage/icons/cross.png")));
        else
            MainWindow.fields[i].setIcon(new ImageIcon(getClass().getResource("/mainPackage/icons/circle.png")));
        Logic.check();
    }
}
