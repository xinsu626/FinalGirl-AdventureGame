import java.util.HashMap;

public class Help implements Action {

    private HashMap<String, Action> responses;
    private String helpIntro;
    private Game game;

    public Help(Game game)
    {
        this.responses = responses;
        //helpIntro = helpStr;
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words or more specific help given a command name.
     */
    public boolean execute()
    {
        String command = UI.promptLine("What command would you like help on?").toUpperCase();

        if (CommandMapper.getAction(command) == null) {
            System.out.println("Not a command!");
        }
        else{
            System.out.println(CommandMapper.getAction(command).help());
        }

        return false;
    }

    public String help()
    {
        return "Enter HELP command for help on the command. "+
                CommandMapper.allCommands();
    }

    public String getCommandName()
    {
        return "HELP";
    }


}
