import java.util.Scanner;

public class Goer implements Action {
	// declare instance variable
	private Game game;

	public Goer(Game game) {
		this.game = game;
	}


	public boolean execute() {
		System.out.println("Here are the rooms you can enter:");
		for (String roomName : game.getRooms().keySet()) {
			System.out.println('\t' + roomName);
		}

		String roomChosen = UI.promptLine("Select a room to enter:").trim().toLowerCase();

		while (!game.getRooms().keySet().contains(roomChosen)){
			System.out.println("Not a room. Enter another one.");
			roomChosen = UI.promptLine("Select a room to enter:").trim().toLowerCase();
		}

		if(roomChosen.equals("exit") && !game.getPlayer().checkPowerWeapon()){
			System.out.println("I don't think I should go here yet...\nMaybe once I have a more powerful weapon.");
			return false;
		}

		if (game.getCurrentRoom().getName().equals("exit")){
			System.out.println("I think I'm going to need to fight this monster before I get to the next floor...");
		}

		game.setCurrentRoom(game.getRooms().get(roomChosen));
		Monster monsterInRoom = game.getCurrentRoom().getMonster();


		if (monsterInRoom != null) {
			System.out.println("There is a " + monsterInRoom.getName() + " " + game.getCurrentRoom().getDescription());
			String outcome = Fight.fight(game.getPlayer(), game.getCurrentRoom());
			if (outcome.equals("dead")) {
				Game.setGameIsOver();

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
