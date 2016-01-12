package mainPackage;

public class Game {

    public static MainWindow mainWindow;
    public static MenuWindow menuWindow;

    public static void main(String[] args)
    {
        goToMenu();
    }

    public static void launch()
    {
        mainWindow = new MainWindow();
        mainWindow.init();
        Logic logic = new Logic();
        logic.startGame();
    }

    public static void goToMenu()
    {
        menuWindow = new MenuWindow();
        menuWindow.init();
    }

}
