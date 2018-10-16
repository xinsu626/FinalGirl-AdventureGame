import java.util.*;

public class Game{

	public static void main(String[] args) {

		String[] itemDataList = {"level_1_master.txt", "level_2_master.txt", "level_3_master.txt"};
		Game game;

		String playerName = UI.promptLine("Enter a name for your player: ").trim();
		Item currentWeapon = new Item("slingshot", "weapon", 5);

		for (String dataFile: itemDataList){
			game = new Game(dataFile, playerName, currentWeapon);
			game.play();
			if (game.getPlayer().getHealth() <= 0){
				return;
			}
			currentWeapon = game.getPlayer().getCurrentWeapon();
		}

		System.out.println("Congratulations, you've escaped the haunted house!\n");
	}


	// declare instance variable
	private Room currentRoom;
	private HashMap<String, Room> rooms; // allow all rooms to be found by name
	private Item currentWeapon;
	private HashMap<String, Item> items; // allow all items to be found by name
	private Player currentPlayer;

	//private Scanner userInputScanner;
	private String welcomeString;
	private HashMap<String, Monster> monsters; // allow all monsters to be found by name

	// getters and setters for room
	public Room getCurrentRoom()
	{
		return currentRoom;
	}

	public void setCurrentRoom(Room newRoom)
	{
		this.currentRoom = newRoom;
	}

	public Player getPlayer(){
		return currentPlayer;
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
	public Game(String txt, String name, Item currentWeapon)
	{
		Scanner levelScanner = ResourceUtil.openFileScanner(txt);
		welcomeString = FileUtil.readParagraph(levelScanner);
		rooms = Room.createRooms(levelScanner);
		currentRoom = rooms.get("hallway");

		// player
		currentPlayer = Player.createPlayer(this, name, currentWeapon);

		CommandMapper.init(this);
	}

	private boolean processCommand()
	{
		String line = UI.promptLine("> ").trim().toUpperCase(); // get user input

		if (line.equals("quit")){
			return true;
		}

		if (line.length() == 0 || !CommandMapper.isCommand(line))
		{
			System.out.println("Pleas enter a command.");
			return false;
		}

		Action action = CommandMapper.getAction(line);
		return action.execute();
	}

	private void play()
	{
		System.out.println(welcomeString);
		System.out.println("You are " + currentRoom.getDescription());
//		ArrayList<ArrayList<Room>> map = Room.buildMap(rooms);
//		Room.viewMap(map);
		currentPlayer.checkStatus();
		System.out.println("Please select an action to take. [INSPECT, GO, HELP, QUIT]");

		while (!processCommand()) {
			System.out.println("Please select an action to take. [INSPECT, GO, HELP, QUIT]");
		}
		System.out.println("Thank you for playing our game. Bye!");
	}

	public HashMap<String,Room> getRooms(){
	    return rooms;
	}
}