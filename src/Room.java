import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

public class Room{
	// declare instance variables
	private String name;
	private Monster monster;
	private Item item;
	private int xCoord;
	private int yCoord;

	// consturctor 
	public Room(String name){
		this.name = name;}

	// create rooms 
	public static HashMap<String, Room> createRooms(Scanner in){

		// empty rooms hashmap
		HashMap<String, Room> rooms = new HashMap<String, Room>();

		while (in.hasNext()){
			String name = FileUtil.getNonCommentLine(in);
			String monsterName = FileUtil.getNonCommentLine(in);
			String itemName = FileUtil.getNonCommentLine(in);
			String x = FileUtil.getNonCommentLine(in);
			String y = FileUtil.getNonCommentLine(in);

			Room newRoom = new Room(name);
			newRoom.setName(name);
			newRoom.setMonster(monsterName);
			newRoom.setItem(itemName);
			newRoom.setXCoord(Integer.parseInt(x));
			newRoom.setYCoord(Integer.parseInt(y));}
		
		in.close();

		return rooms;}

	// setters
	public void setName(String name){
		this.name = name;}

	public void setMonster(String monsterName){
		this.monster = monsters.get(monsterName);}
	
	public void setItem(String itemName){
		this.item = items.get(itemName);}
	
	public void setXCoord(int xCoord){
		this.xCoord = xCoord;}

	public void setYCoord(int yCoord){
		this.yCoord = yCoord;}

	// getters 
	public String getName(){
		return name;}

	public String getMonster(){
		return monster;}

	public String getItem(){
		return item;}

	public int getXCoord(){
		return xCoord;}

	public int getYCoord(){
		return yCoord;}

	// maps
	public static ArrayList<ArrayList<Room>> buildMap(HashMap<String, Room> rooms){
		ArrayList<ArrayList<Room>> map = new ArrayList<>();

		for(int i = 0; i < 5; i++){
			map.add(new ArrayList<>(Arrays.asList(null, null, null, null, null)));
		}

		for(Map.Entry x: rooms.entrySet()){
			Room newRoom = (Room)x.getValue();
			int row = newRoom.getXCoord();
			int col = newRoom.getYCoord();
			map.get(row).set(col, newRoom);
		}

		return map;}

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
	
}