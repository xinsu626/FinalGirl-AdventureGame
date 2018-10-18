/**
 * Initializes "quit" and confirms that the player wishes
 * to end their game session
 */
public class Quit implements Action{
    
    public boolean execute()
    {
        Game.setGameIsOver();
        return UI.agree("Leaving so soon! Do you really want to quit? ");
    }

    public String getCommandName()
    {
        return "QUIT";
    }

    public String help()
    {
        return "Enter QUIT to quit the game.";
    }

    public Quit() { }

}
