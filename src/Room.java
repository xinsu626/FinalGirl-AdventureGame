import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room
 * stores a reference to the neighboring room.
 *
 * @author  Michael Kolling and David J. Barnes
 * modified by Andrew Harrington to use FileUtil and ResourceUtil,
 * and to take all data from a file.
 * @version 2018.09.20
 */

public class Room
{
    private String name;
    private Boolean locked;
    private String description;
    private int xCoord;
    private int yCoord;

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean getLocked(){
        return locked;
    }

    public void setLocked(Boolean locked){
        this.locked = locked;
    }

    public int getXCoord(){
        return xCoord;
    }

    public void setXCoord(int xCoord){
        this.xCoord = xCoord;
    }

    public int getYCoord(){
        return yCoord;
    }

    public void setYCoord(int yCoord){
        this.yCoord = yCoord;
    }

    /**
     * Create a room, given its description. Initially, it has
     * no exits. Description is something like "a kitchen" or
     * "an open court yard\nwith flowers all around".
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
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
    public static HashMap<String, Room> createRooms(Scanner in)
    {
        // Map to return
        HashMap<String, Room> rooms = new HashMap<String, Room>();

        while (in.hasNext()) {
            String name = FileUtil.getNonCommentLine(in);
            Boolean locked = Boolean.parseBoolean(FileUtil.getNonCommentLine(in));
            String x = FileUtil.getNonCommentLine(in);
            String y = FileUtil.getNonCommentLine(in);
            String description = FileUtil.readParagraph(in);

            Room newRoom = new Room(description);
            newRoom.setName(name);
            newRoom.setLocked(locked);
            newRoom.setXCoord(Integer.parseInt(x));
            newRoom.setYCoord(Integer.parseInt(y));

            rooms.put(name, newRoom);
        }
        in.close();

        return rooms;
    }
}