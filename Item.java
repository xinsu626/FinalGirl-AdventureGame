import java.util.HashMap;
import java.util.Scanner;

public class Item {
	// declare instance variable(for now there is no weight)
	public String name;
	public String category;
	public int attribute; //either increase health(potion) or increase strength(weapon)

	// constructor
	public Item(String name, String category, int attribute) {
		this.name = name;
		this.category = category;
		this.attribute = attribute;
	}

	// create items
	public static HashMap<String, Item> createItems(Scanner in) {
		// empty items HashMap
		HashMap<String, Item> items = new HashMap<String, Item>();


		while (true) {

		

			String name = FileUtil.getNonCommentLine(in);
			if(name.equals("****************************************")){
				break;
			}
			String category = FileUtil.getNonCommentLine(in);
			int attribute = FileUtil.getInt(in);

			Item newItem = new Item(name, category, attribute);
			items.put(name, newItem);
		}

		return items;
	}

	// setters 
	public void setName(String name){
		this.name = name;}

	public void setCategory(String category){
		this.category = category;}

	public void setAttribute(int attribute){
		this.attribute = attribute;
	}

	// getters 
	public String getName(){
		return name;}

	public String getCategory(){
		return category;}

	public int getAttribute(){
		return attribute;}		

}