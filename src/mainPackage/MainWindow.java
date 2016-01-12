package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame{

        JPanel panel = new JPanel();
        static JLabel[] fields = new JLabel[9];
        static FieldClickMouseListener[] fieldClickMouseListener = new FieldClickMouseListener[9];
        JButton restartButton = new JButton("Перезапуск");
        JButton returnButton = new JButton("Вернуться в меню");
        JButton exitButton = new JButton("Выход");

        static JLabel state = new JLabel("Ходит " + Logic.players[Logic.playerTurn-1].name);

        public void init() {

                setTitle("Игра");
                setSize(600, 400);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setLayout(new GridBagLayout());
                setLocationRelativeTo(null);
                setResizable(false);

                exitButton.addActionListener(new ExitButtonActionListener());
                restartButton.addActionListener(new RestartButtonActionListener());
                returnButton.addActionListener(new ReturnButtonActionListener());

                panel.setBackground(Color.BLACK);
                panel.setLayout(new GridBagLayout());

            for (int i = 0; i < fields.length; i++)
            {
                int x = i;
                int y = 0;
                if (i > 2)
                {
                    x = i%3;
                    y = i/3;
                }
                fields[i] = new JLabel();
                fieldClickMouseListener[i] = new FieldClickMouseListener();
                panel.add(fields[i], new GridBagConstraints(x, y, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2),0,0));
            }

            clearField();

                add(panel, new GridBagConstraints(0,0,1,4,1,1,
                        GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2),0,0));

                add(state, new GridBagConstraints(1,0,1,1,1,1,
                        GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                        new Insets(2, 2, 2, 2),30,0));

                add(restartButton, new GridBagConstraints(1,1,1,1,1,1,
                    GridBagConstraints.SOUTH,GridBagConstraints.HORIZONTAL,
                    new Insets(2, 2, 2, 2),0,0));

                add(returnButton, new GridBagConstraints(1,2,1,1,1,1,
                    GridBagConstraints.SOUTH,GridBagConstraints.HORIZONTAL,
                    new Insets(2, 2, 2, 2),0,0));

                add(exitButton, new GridBagConstraints(1,3,1,1,1,1,
                        GridBagConstraints.SOUTH,GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2),0,0));

                setVisible(true);
                pack();
        }

    public static void listenerOn()
    {
        for (int i = 0; i < 9; i++)
            fields[i].addMouseListener(fieldClickMouseListener[i]);
    }

    public static void listenerOff()
    {
        for (int i = 0; i < 9; i++)
            fields[i].removeMouseListener(fieldClickMouseListener[i]);
    }

    public void clearField()
    {
        for (int i = 0; i < fields.length; i++)
        {
            fields[i].setIcon(new ImageIcon(getClass().getResource("/mainPackage/icons/empty.png")));
        }

        state.setText("Ходит " + Logic.players[Logic.playerTurn-1].name);
    }

        public class ExitButtonActionListener implements ActionListener
        {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        dispose();
                }
        }

        public class RestartButtonActionListener implements ActionListener
        {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Game.launch();
                    dispose();
                }
        }

    public class ReturnButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Game.goToMenu();
            dispose();
        }
    }

    public class FieldClickMouseListener extends MouseAdapter {

                @Override
                public void mouseClicked(MouseEvent e)
                {
                    int x = (int)((JLabel)e.getSource()).getLocation().getX()/50;
                    int y = (int)((JLabel)e.getSource()).getLocation().getY()/50;

                    if(Logic.turnAvailable(x, y))
                    {
                        Logic.players[Logic.playerTurn - 1].makeTurn(x, y);
                    }
                }
        }
}
