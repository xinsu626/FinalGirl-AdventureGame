import java.util.Scanner;
import java.io.InputStream;

/**
 *Allows data within a file to be accessed
 */
public class ResourceUtil{
	
	// read files from filesystem or jar
	public static InputStream openBundledFile(String fileName){
		return ResourceUtil.class.getClassLoader().getResourceAsStream(fileName);
	}

	// read txt file in, return a scanner object
	public static Scanner openFileScanner(String fileName){
		InputStream stream = openBundledFile(fileName);

		if (stream == null){
			System.out.println("File not found: " + fileName);
			return null;
		}

		return new Scanner(stream);
	}
}
