package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame{

    JLabel message = new JLabel("Выберите режим игры");
    JLabel player1 = new JLabel("Игрок №1:");
    JLabel player2 = new JLabel("Игрок №2:");
    JComboBox<String> playerCase1 = new JComboBox<>();
    JComboBox<String> playerCase2 = new JComboBox<>();
    JTextField playerName1 = new JTextField("Игрок №1");
    JTextField playerName2 = new JTextField("Игрок №2");

    JButton acceptButton = new JButton("Играть");
    JButton exitButton = new JButton("Выход");

    public void init()
    {
        setTitle("Игра");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        try
        {
            if (Logic.players[0].name != null)
                playerName1.setText(Logic.players[0].name);
        }
        catch (NullPointerException e){}
        try
        {
            if (Logic.players[1].name != null)
                playerName2.setText(Logic.players[1].name);
        }
        catch (NullPointerException e){}


        playerCase1.addItem("Человек");
        playerCase1.addItem("Компьютер");
        playerCase2.addItem("Человек");
        playerCase2.addItem("Компьютер");

        exitButton.addActionListener(new ExitButtonActionListener());
        acceptButton.addActionListener(new AcceptButtonActionListener());

        add(message, new GridBagConstraints(0, 0, 3, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(player1, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(playerCase1, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(playerName1, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(player2, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(playerCase2, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(playerName2, new GridBagConstraints(2, 2, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(acceptButton, new GridBagConstraints(1,3,1,1,1,1,
                GridBagConstraints.SOUTH,GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2),0,0));

        add(exitButton, new GridBagConstraints(2,3,1,1,1,1,
                GridBagConstraints.SOUTH,GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2),0,0));

        setVisible(true);
        pack();
    }


    public class ExitButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
    }

    public class AcceptButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Logic.players[0] = Player.createPlayer(playerCase1.getSelectedItem().toString(), playerName1.getText());
            Logic.players[1] = Player.createPlayer(playerCase2.getSelectedItem().toString(), playerName2.getText());

            Game.launch();
            dispose();
        }
    }
}
