import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  This class is the main class of the "Exciting Campus" application.
 *  "Exciting Campus" is a very simple, text based adventure game.  Users
 *  can walk around some locations. That's all. It should really be extended
 *  to make it more interesting!  The original version was "World of Zuul".
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, a Game, and plays the Game.  The Game evaluates and
 *  executes the commands that the parser returns.
 *
 *  This version is modified by Andrew Harrington to use the UI and FileUtil
 *  utility classes.  Room data comes from a text file rather than being
 *  hard-coded into the program.  This implementation also allows all rooms
 *  to be accessed by name using the HashMap rooms in the Game class.
 *
 *  A main method is also provided in the Game class.
 *  All commands are executed by classes satisfying the Response interface,
 *  so the main class does not have the code for the commands.
 *  The CommandMapper class maps command words to Responses.
 *  The Parser and CommandMapper classes are static.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Game
{
    private Room currentRoom;
    private ArrayList<Room> rooms;
    private String welcomeString;
    private Room[] map;

    /** Make a Game playable from the command line.
     * @param args No commandline arguments needed
     */
    public static void main(String[] args) {
        Game game = new Game("startData.txt");
    }

    public ArrayList<ArrayList<Room>> buildMap(ArrayList<Room> rooms){
        ArrayList<Room> nullList = new ArrayList<>(Arrays.asList(null, null, null, null, null));
        ArrayList<Room> topRooms = new ArrayList<>(Arrays.asList(null, rooms.get(0), rooms.get(1), rooms.get(2), null));
        ArrayList<Room> hallway = new ArrayList<>(Arrays.asList(null, rooms.get(3), rooms.get(4), rooms.get(5), null));
        ArrayList<Room> bottomRooms = new ArrayList<>(Arrays.asList(null, rooms.get(6), rooms.get(7), rooms.get(8), null));

        ArrayList<ArrayList<Room>> map = new ArrayList<>();
        map.add(nullList);
        map.add(topRooms);
        map.add(hallway);
        map.add(bottomRooms);
        map.add(nullList);

//        for(int i = 0; i < map.size(); i++){
//            ArrayList<String> aList = new ArrayList<>();
//            for(int j = 0; j < map.get(i).size(); j++){
//                if(map.get(i).get(j) != null){
//                    aList.add(map.get(i).get(j).getName());
//                } else{
//                    aList.add("null");
//                }
//            }
//            System.out.println(aList);
//        }
        return map;
    }

    /**
     * Create the game and initialise its internal map
     * @param worldData World initialization data file name.
     */
    //constructor
    public Game(String worldData)
    {   // world data: starting room line,
        // welcome and help intro paragraphs, then Room data
        Scanner dataIn = ResourceUtil.openFileScanner(worldData);
        rooms = Room.createRooms(dataIn);
        buildMap(rooms);
    }
}


//**********************************
//*          *          *          *
//* Ballroom * Kitchen  *  Dining  *
//*          *          *          *
//**********************************
//*                                *
//* Hallway                        *  Stairs
//*                                *
//**********************************
//*          *          *          *
//* Billiard *  Lounge  * Library  *
//*          *          *          *
//**********************************


