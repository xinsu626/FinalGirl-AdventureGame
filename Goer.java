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

		System.out.println("The rooms you can enter are:");
		for (String roomName : game.getRooms().keySet()) {
			System.out.println(roomName);
		}

		//add loop to check for bad input
		String roomChosen = UI.promptLine("Which room do you want to enter?").trim().toLowerCase();

		game.setCurrentRoom(game.getRooms().get(roomChosen));
		Monster monsterInRoom = game.getCurrentRoom().getMonster();
		if(monsterInRoom != null) {
			System.out.println("There is a " + monsterInRoom.getName() + " " + game.getCurrentRoom().getDescription());
			if(Fight.fight(game.getPlayer(), game.getCurrentRoom())) {
				return true;
			}
		}
		return false;
	}

	public String getCommandName() {
		return "go";
	}

	public String help() {
		return "Please enter: go roomName";
	}
}
