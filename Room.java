import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;

public class Room{
	// declare instance variables
	private String name;
	private Item item;
	private String description;
    private Monster monster;

	// constructor
	public Room(String name, Item item, String description, Monster monster){
		this.name = name;
		this.item = item;
		this.description = description;
        this.monster = monster;
	}

	// create rooms
	public static HashMap<String, Room> createRooms(Scanner in){

		// empty rooms hashmap
		HashMap<String, Room> rooms = new HashMap<String, Room>();
		Scanner testScanner = ResourceUtil.openFileScanner("level_1_master.txt");
		HashMap<String, Monster> monsters = Monster.createMonsters(testScanner);
		HashMap<String, Item> items = Item.createItems(testScanner);
		// create HashMap of monsters

		HashMap<String, Monster> monsters = Monster.createMonsters(in);


		// create HashMap of items
		HashMap<String, Item> items = Item.createItems(in);

		while (true){
			String name = FileUtil.getNonCommentLine(in);
			if(name.equals("****************************************")){
				break;
			}
			String description = FileUtil.readParagraph(in);
			Monster monster;
			Item item;

			if(name.equals("exit")){
				monster = monsters.get("mummy");
			} else{
				monster = null;
			}

			item = null;

			Room newRoom = new Room(name, item, description, monster);
			rooms.put(name, newRoom);
		}*/
		rooms.put("closet", new Room("closet",items.get("potion"),"in closet", monsters.get("zombie")));
		in.close();

		// create ArrayList of room names
		Set<String> roomNameSet = rooms.keySet();
		String[] roomNameList = roomNameSet.toArray(new String[roomNameSet.size()]);
		ArrayList<String> roomNameArrayList = new ArrayList<String>();
		for(String roomName: roomNameList){
			roomNameArrayList.add(roomName);
		}

		roomNameArrayList.remove(roomNameArrayList.indexOf("hallway"));
		roomNameArrayList.remove(roomNameArrayList.indexOf("exit"));

		// create ArrayList of monster names
		Set<String> monsterNameSet = monsters.keySet();
		String[] monsterNameList = monsterNameSet.toArray(new String[monsterNameSet.size()]);
		ArrayList<String> monsterNameArrayList = new ArrayList<String>();
		for(String monsterName: monsterNameList){
			monsterNameArrayList.add(monsterName);
		}

		// create ArrayList of item names
		Set<String> itemNameSet = items.keySet();
		String[] itemNameList = itemNameSet.toArray(new String[itemNameSet.size()]);
		ArrayList<String> itemNameArrayList = new ArrayList<String>();
		for(String itemName: itemNameList){
			itemNameArrayList.add(itemName);
		}

		monsterNameArrayList.remove(monsterNameArrayList.indexOf("mummy"));

		Collections.shuffle(roomNameArrayList);

		assignMonsters(roomNameArrayList, monsterNameArrayList, rooms, monsters);
		assignItems(roomNameArrayList, itemNameArrayList, rooms, items);

		return rooms;
	}

	private static void assignMonsters(ArrayList<String> roomNameArrayList, ArrayList<String> monsterNameArrayList, HashMap<String, Room> rooms, HashMap<String, Monster> monsters){
		for(int i = 0; i < monsterNameArrayList.size(); i++){
			String roomName = roomNameArrayList.get(i);
			String monsterName = monsterNameArrayList.get(i);

			rooms.get(roomName).setMonster(monsters.get(monsterName));
		}
	}

	private static void assignItems(ArrayList<String> roomNameArrayList, ArrayList<String> itemNameArrayList, HashMap<String, Room> rooms, HashMap<String, Item> items){
		for(int i = 0; i < itemNameArrayList.size(); i++){
			String roomName = roomNameArrayList.get(i);
			String itemName = itemNameArrayList.get(i);

			rooms.get(roomName).setItem(items.get(itemName));
		}
	}


	public void killMonster(){
		monster = null;
	}

	public void killItem()
	{
		item =null;
	}

	// getters 
	public String getName(){
		return name;}

	public Monster getMonster(){
		return monster;}

	public Item getItem(){
		return item;}

	public String getDescription(){
		return description;
	}

	// setters
	private void setMonster(Monster monster){
		this.monster = monster;
	}

	private void setItem(Item item){
		this.item = item;
	}
}