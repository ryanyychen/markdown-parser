//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://www.codegrepper.com/code-examples/java/how+to+check+new+line+character+in+java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next)
        System.out.println(markdown.length());
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

            // check for extra empty lines at the end of file.
            while (Character.toString(markdown.charAt(currentIndex)).equals(System.getProperty("line.separator"))) {
                currentIndex++;
                if (currentIndex == markdown.length()) {
                    break;
                }
            }
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        System.out.println(content);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
