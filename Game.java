import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game{

	public static void main(String[] args) {
		Game game = new Game("startData.txt", "level_01.txt", "item_data.txt");
		game.play();
	}


	// declare instance variable
	private Room currentRoom;
	private HashMap<String, Room> rooms; // allow all rooms to be found by name
	private Item currentWeapon;
	private HashMap<String, Item> items; // allow all items to be found by name
	private Player currentPlayer;
	private Scanner userInputScanner;

	// getters and settes for room


	public Room getCurrentRoom()
	{
		return currentRoom;
	}

	public void setCurrentRoom(Room newRoom)
	{
		this.currentRoom = newRoom;
	}

	// getters and setters for weapon
	public Item getCurrentWeapon()
	{
		return currentWeapon;
	}

	public void setCurrentWeapon(Item newWeapon)
	{
		this.currentWeapon = newWeapon;
	}

	// constructor
	public Game(String weclomeTxt, String level01Txt, String itemTxt)
	{
		// welcome 
		Scanner worldDataScanner = ResourceUtil.openFileScanner(weclomeTxt); // create a scanner object, read txt file in
		String welcomeString = FileUtil.readParagraph(worldDataScanner);   

		// rooms
		Scanner levelScanner = ResourceUtil.openFileScanner(level01Txt);
		rooms = Room.createRooms(levelScanner);
		String startingRoom = "hallway01";
		currentRoom = rooms.get(startingRoom);

		// items
		Scanner itemScanner = ResourceUtil.openFileScanner(itemTxt);
		items = Item.createItems(itemScanner);

		// player
		currentPlayer = Player.createPlayer();

		// user input scanner 
		userInputScanner = new Scanner(System.in);
		// initialize command mapper
		CommandMapper.init(this);	// get rid of helpintro here
	}

	private boolean processCommand()
	{
		String line = UI.promptLine("> "); // get user input
		String[] tokens = line.trim().split("\\s+"); // split user input to tokens in a list
		
		if ((tokens.length == 0) || !CommandMapper.isCommand(tokens[0]))
		{
			System.out.println("I don't know what you mean...");
			return false;
		}

		Response action = CommandMapper.getResponse(tokens[0]); // the response here is any "object" implement response interface
		return action.execute(tokens);
	}

	private void play()
	{
		System.out.println(welcomeString);
		System.out.println("You are in " + currentRoom.getName());
		ArrayList<ArrayList<Room>> map = Room.buildMap(rooms);
		Room.viewMap(map);
		currentPlayer.checkStatus();
		System.out.println("What would you like to do?");
		System.out.println("inspect");
		System.out.println("Go to other places. If so, please enter room name.");
		System.out.println("quit");

		while (! processCommand())
			;
		System.out.println("Thank you for playing our game. Bye")
	}
}