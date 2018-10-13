import java.util.HashMap;
import java.util.Scanner;
//import java.util.ArrayList;

public class Room{
	// declare instance variables
	private String name;
	private Monster monster;
	private Item item;
	private int xCoord;
	private int yCoord;
	private String description;

	// constructor
	public Room(String name, Monster monster, Item item, int x, int y, String description){
		this.name = name;
		this.monster = monster;
		this.item = item;
		this.xCoord = x;
		this.yCoord = y;
		this.description = description;
	}


	// create rooms
	public static HashMap<String, Room> createRooms(Scanner in){

		// empty rooms hashmap
		HashMap<String, Room> rooms = new HashMap<String, Room>();

		// create HashMap of monsters
		Scanner monsterScanner = ResourceUtil.openFileScanner("monster_data.txt");
		HashMap<String, Monster> monsters = Monster.createMonsters(monsterScanner);

		// create HashMap of items
		Scanner itemScanner = ResourceUtil.openFileScanner("item_data.txt");
		HashMap<String, Item> items = Item.createItems(itemScanner);

		while (in.hasNext()){
			String name = FileUtil.getNonCommentLine(in);
			String monsterName = FileUtil.getNonCommentLine(in);
			String itemName = FileUtil.getNonCommentLine(in);
			int x = FileUtil.getInt(in);
			int y = FileUtil.getInt(in);
			String description = FileUtil.readParagraph(in);
			Monster monster;
			Item item;

			if (!monsterName.equals("null")){
				monster = monsters.get(monsterName);
			}
			else{
				monster = null;
			}

			if (!itemName.equals("null")){
				item = items.get(itemName);
			}
			else{
				item = null;
			}

			Room newRoom = new Room(name, monster, item, x, y, description);
			rooms.put(name, newRoom);
		}

		in.close();

		return rooms;
	}

	// setters
	//public void setName(String name){
	//	this.name = name;}

	public void killMonster(){
		monster = null;
	}
	
	//public void setItem(String itemName){
	//	this.item = items.get(itemName);}
	
	//public void setXCoord(int xCoord){
	//	this.xCoord = xCoord;}

	//public void setYCoord(int yCoord){
	//	this.yCoord = yCoord;}

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

	//public int getXCoord(){
	//	return xCoord;}

	//public int getYCoord(){
	//	return yCoord;}

	// maps
	/*
	public static ArrayList<ArrayList<Room>> buildMap(HashMap<String, Room> rooms){
		ArrayList<ArrayList<Room>> map = new ArrayList<>();

		for(int i = 0; i < 5; i++){
			map.add(new ArrayList<>(ArrayList.asList(null, null, null, null, null)));
		}

		for(Map.Entry x: rooms.entrySet()){
			Room newRoom = (Room)x.getValue();
			int row = newRoom.getXCoord();
			int col = newRoom.getYCoord();
			map.get(row).set(col, newRoom);
		}

		return map;
	}

	// generate map view 
	public static void viewMap(ArrayList<ArrayList<Room>> map){
		String lineString = "*************************************************";
		String dashString = "|               |               |               |";
		String hallString = "| Hallway                                       | Stairs";

		for(int i = 0; i < 11; i++){
			if(i == 0 || i == 4 || i == 6 || i == 10){;}
			else if (i == 2){
				System.out.println(lineString);}
			else if (i == 5){
				 System.out.println(Room.roomsForMap(map, 1));}
			else if (i == 8){
				System.out.println(hallString);}
			else{
				System.out.println(Room.roomsForMap(map, 3));}}

		System.out.println();
		System.out.println("You are " + currentRoom.getDescription());}

	// rooms for map
	public static String roomsForMap(ArrayList<ArrayList<Room>> map, int row){
		String roomLine = "| ";
		for(int i = 1; i < 4; i++){
			String roomName = map.get(row).get(i).getName();
			while(roomName.length() < 14){
				roomName += " ";}

			roomLine += roomName + "| ";}

		return roomLine;}
	*/
}