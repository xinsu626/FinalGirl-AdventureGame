import java.util.Scanner;
import java.io.InputStream;

public class ResourceUtil{
	
	// read files from filesystem or jar
	public static InputStream OpenBundleFile(String fileName){
		return ResourceUtil.class.getClassLoader().getResourceAsStream(fileName);
	}

	// read txt file in, return a scanner object
	public static Scanner openFileScanner(String fileName){
		InputStream stream = openBundledFile(fileName);

		if (stream == null){
			System.out.println("File not found: " + fileName);
			return null；}

		return new Scanner(stream);
	}
}