import java.util.HashMap;
import java.util.Scanner;

/**
 * Creates a HashMap of items and sets its attributes,
 * such as its category and strength.
 */
public class Item {
	private String name;
	private String category;
	private int attribute; //either change health(potion) or increase strength(weapon)

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

	public String getName(){
		return name;}

	public String getCategory(){
		return category;}

	public int getAttribute(){
		return attribute;}		

}
