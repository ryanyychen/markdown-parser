//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        System.out.println("Length: " + markdown.length());
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

            if (currentIndex >= markdown.length()) break;

            // skip empty lines in the end of file
            while (Character.toString(markdown.charAt(currentIndex)).equals(System.getProperty("line.separator"))) {
                currentIndex++;
                if (currentIndex == markdown.length()) break;
            }
        }

        return toReturn;
    }

    public String read(String fileName) throws IOException {
        try {
            Path file = Path.of(fileName);
            String content = Files.readString(file);
            return content;
        } catch (IOException e) {
            throw new IOException("Invalid file");
        }
    }


    public static void main(String[] args) throws IOException {
        //Path fileName = Path.of(args[0]);
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
