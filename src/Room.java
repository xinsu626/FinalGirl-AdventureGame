import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class Room - a room in a haunted mansion.
 * A "Room" represents one location in the map of the game.
 */
public class Room
{
    private String name;
    private String description;
    private int mapRow;
    private int mapCol;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getMapRow(){
        return mapRow;
    }
    public void setMapRow(int mapRow){
        this.mapRow = mapRow;
    }
    public int getMapCol(){
        return mapCol;
    }
    public void setMapCol(int mapCol){
        this.mapCol = mapCol;
    }
    /**
     * Create rooms and their interconnections by taking room names, exit data
     * and descriptions from a file Scanner, and return a map of room names
     * to rooms.  File format for each room:  <br>
     * First line:  room name (one word) <br>
     * Second line: pairs of exit direction and neighbor room name  <br>
     * Remaining paragraph: room description, blank line terminated
     * @param in is the Scanner delivering all the room data
     * @return A map of room names to rooms
     */
    public static ArrayList<Room> createRooms(Scanner in)
    {
        // Map to return
        ArrayList<Room> rooms = new ArrayList<>();
        while (in.hasNext()) {
            String name = FileUtil.getNonCommentLine(in);
            String row = FileUtil.getNonCommentLine(in);
            String col = FileUtil.getNonCommentLine(in);
            String description = FileUtil.readParagraph(in);
            Room newRoom = new Room();
            newRoom.setName(name);
            newRoom.setDescription(description);
            newRoom.setMapRow(Integer.parseInt(row));
            newRoom.setMapCol(Integer.parseInt(col));
            rooms.add(newRoom);
        }
        in.close();
        return rooms;
    }
}