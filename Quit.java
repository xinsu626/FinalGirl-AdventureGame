public class Quit implements Action{

    /**
     * "quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
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
