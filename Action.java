public interface Action
{
	boolean execute(String[] tokens); //method 1
	String getCommandName();	//method 2
	String help();
}
