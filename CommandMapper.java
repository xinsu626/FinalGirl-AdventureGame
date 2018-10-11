import java.util.HashMap;

public class CommandMapper
{
	private static HashMap<String, Response> responses;
	private static String allCmds;

	
	// class method for initializing responses hashmap and allCmds string
	public static void init(Game game, Room currentRoom, Player player) //also need to change in game
	{
		responses = new HashMap<String, Response>();
		Response[] responseArray = {new Goer(game), new Inspect(currentRoom, player), new Quitter()}; 
		allCmds = "Your command words are:";
		for (Response r: responseArray)
		{
			String name = r.getCommandName();
			allCmds += " " + name;
			responses.put(name, r);
		}
	}

	public static boolean isCommand(String aString)
	{
		return responses.get(aString) != null;
	}

	public static Response getResponse(String cmdWord)
	{
		return responses.get(cmdWord);
	}

	public static String allCommands()
	{
		return allCmds;
	}
}
