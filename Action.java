public interface Action
{
	boolean execute();
	String getCommandName();
	String help();
}
