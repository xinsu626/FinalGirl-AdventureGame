import java.util.HashMap;

/**
 *Assigns command phrases to the appropriate user input.
 */
public class CommandMapper
{
	private static HashMap<String, Action> actions;
	private static String allCmds;

	// class method for initializing responses hashmap and allCmds string
	public static void init(Game game)
	{
		actions = new HashMap<>();
		Action[] actionArray = {new Goer(game), new Inspect(game), new Help(), new Quit()};
		allCmds = "Your command words are:";
		for (Action r: actionArray)
		{
			String name = r.getCommandName();
			allCmds += " " + name;
			actions.put(name, r);
		}
	}

	public static boolean isCommand(String aString)
	{
		return actions.get(aString) != null;
	}

	public static Action getAction(String cmdWord)
	{
		return actions.get(cmdWord);
	}

	public static String allCommands()
	{
		return allCmds;
	}
}
