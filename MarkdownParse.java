//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        // test-file3.md -- no full sets
        // test-file4.md -- no full sets
        // test-file5.md -- should not work for separated )[
        // test-file7.md -- no full sets
        // test-file8.md -- has extra [ but nothing else... infiinite loop
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
            if (markdown.indexOf("[", currentIndex) == -1) {
                break;
            }

            // skip empty lines in the end of file
            // while (Character.toString(markdown.charAt(currentIndex)).equals(System.getProperty("line.separator"))) {
            //     currentIndex++;
            //     if (currentIndex == markdown.length()) break;
            // }
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        //Path fileName = Path.of(args[0]);
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
