public interface Action {

    /**
     * Execute a command.
     * @param  tokens  The token entered by the user.
     * @return true if the game is over; false otherwise
     */
    boolean execute(String[] tokens);

    /** @return the command name */
    String getCommandName();

    /** @return the help string */
    String help();

}


