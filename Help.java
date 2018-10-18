public class Help implements Action {

    public Help() {}

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
