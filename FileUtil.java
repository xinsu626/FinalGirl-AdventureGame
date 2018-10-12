import java.util.Scanner;

public class FileUtil{
	
	public static String getNonCommentLine(Scanner in){
		String line = in.nextLine(); // read first line of string in scanner object
		while (line != null && line.startsWith("#")){
			line = in.nextLine(); // read non comment line
		}

		return line;
	}

	public static int getInt(Scanner in){
	    return Integer.parseInt(getNonCommentLine(in));
	}

	public static String wordWrap(String s, int columns) 
    {
        String wrapped = "";
        s = s.trim();
        while (s.length() > columns) {
            int i = s.lastIndexOf(" ", columns);
            if (i == -1) i = columns;
            wrapped += s.substring(0, i).trim();
            s = s.substring(i).trim();
            if (s.length() > 0)
                wrapped += "\n";
        }
        if (s.length() > 0) 
            wrapped += s;
        return wrapped;        
    }



	public static String lineWrap(Scanner in){
		String line = getNonCommentLine(in); // read first non comment line 
		if (line == null){
			return null;
		}

		return wordWrap(line, 79);
	}

	 public static String readParagraph(Scanner in)
    {
        String para = "";
        String line = lineWrap(in);
        while (line != null && line.trim().length() > 0) {
            para += line + "\n";
            line = lineWrap(in);
        }
        return para;
    }
}