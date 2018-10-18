/**
 *An interface that describes a given action in the game.
 */
public interface Action
{
	boolean execute();
	String getCommandName();
	String help();
}
