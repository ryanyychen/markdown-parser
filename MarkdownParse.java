//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        // test-file5.md -- should not work for separated )[
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        System.out.println("Length: " + markdown.length());

        // search for each of the parentheses/brackets
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            currentIndex = closeParen + 1;

            // if any of the parentheses/brackets don't exist
            if (openBracket == -1 || closeBracket == -1
                    || openParen == -1 || closeParen == -1) break;

            // if '(' follows directly after ']'
            if (openParen != closeBracket + 1) continue;
            else toReturn.add(markdown.substring(openParen + 1, closeParen));

            // end of file
            if (currentIndex >= markdown.length()) break;
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        //Path fileName = Path.of(args[0]);
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
