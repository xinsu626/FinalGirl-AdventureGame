import java.util.Scanner;

public class Goer implements Action {
	// declare instance variable
	private Game game;

	public Goer(Game game) {
		this.game = game;
	}


	public boolean execute() {
		/*if (tokens.length == 1)
		{
			System.out.println("Go where? Please enter: go roomName");
			return false;
		}*/

		//String roomName = tokens[1];
		//Room nextRoom = game.getNamedRoom(roomName);

		System.out.println("Select a room to enter:");
		for (String roomName : game.getRooms().keySet()) {
			System.out.println('\t' + roomName);
		}

		String roomChosen = UI.promptLine("Select a room to enter:").trim().toLowerCase();

		while (!game.getRooms().keySet().contains(roomChosen)){
			System.out.println("Not a room. Enter another one.");
			roomChosen = UI.promptLine("Select a room to enter:").trim().toLowerCase();
		}

		if(game.getCurrentRoom().getName().equals("exit") && !game.getPlayer().checkPowerWeapon()){
			System.out.println("I don't think I should go here yet...\nMaybe once I have a more powerful weapon.");
			return false;
		}

		game.setCurrentRoom(game.getRooms().get(roomChosen));
		Monster monsterInRoom = game.getCurrentRoom().getMonster();

		if (monsterInRoom != null) {
			System.out.println("There is a " + monsterInRoom.getName() + " " + game.getCurrentRoom().getDescription());
			String outcome = Fight.fight(game.getPlayer(), game.getCurrentRoom());
			if (outcome.equals("dead")) {
				return true;
			} else if (outcome.equals("fled")) {
				game.setCurrentRoom(game.getRooms().get("hallway"));
			}
		}
		return false;
	}

	public String getCommandName () {
		return "GO";
	}

	public String help () {
		return "Enter GO to see a list of rooms to enter.";
	}
}
