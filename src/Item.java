import java.util.HashMap;
import java.util.Scanner;

public class Item{
	// declare instance variable(for now there is no weight)
	public String name;
	public String category;
	public String attribute; //ethier incease health(potion) or increase strength(weapon)

	// consturctor
	public Item(String name){
		this.name = name;}

	// create items
	public static HashMap<String, Item> createItems(Scanner in){
		// empty items hashmap
		HashMap<String, Item> items = new HashMap<String, Item>();

		while (in.hasNext()){
			String name = FileUtil.getNonCommentLine(in);
			String category = FileUtil.getNonCommentLine(in);
			String attribute = FileUtil.getNonCommentLine(in);

			Item newItem = new Item(name);
			newItem.setName(name);
			newItem.setCategory(category);
			newItem.setAttibute(attribute);}

		in.close();		
		return items;}

	// setters 
	public void setName(String name){
		this.name = name;}

	public void setCategory(String category){
		this.category = category;}

	public void setAttibute(String attribute){
		this.attribute = attribute;}

	// getters 
	public String getName(){
		return name;}

	public String getCategory(){
		return category;}

	public String getAttribute(){
		return attribute;}		

}