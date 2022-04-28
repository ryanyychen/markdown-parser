import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {

   private MarkdownParse parser;
   private ArrayList<String> expected;
   private ArrayList<String> URLs;
   private String content;

   @Before
   public void setup() {
      //initialize new MarkdownParse object
      parser = new MarkdownParse();

      expected = new ArrayList<String>();
      URLs = new ArrayList<String>();
      content = "empty";
   }

   @Test
   public void testfile1() {
      //set up expected string from first test file
      expected.add("https://something.com");
      expected.add("some-thing.html");

      //get contents of first test file
      try {
         Path file = Path.of("test-file.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile2() {
      //set up expected string from first test file
      expected.add("https://something.com");
      expected.add("some-page.html");

      //get contents of first test file
      try {
         Path file = Path.of("test-file2.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile3() {
      //expected should be empty
      //get contents of first test file
      try {
         Path file = Path.of("test-file3.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile4() {
      //expected should be empty
      //get contents of first test file
      try {
         Path file = Path.of("test-file4.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile5() {
      //expected should be empty
      //get contents of first test file
      try {
         Path file = Path.of("test-file5.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile6() {
      //set up expected string from first test file
      expected.add("page.com");

      //get contents of first test file
      try {
         Path file = Path.of("test-file6.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile7() {
      //expected should be empty
      //get contents of first test file
      try {
         Path file = Path.of("test-file7.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile8() {
      //set up expected string from first test file
      expected.add("a link on the first line");

      //get contents of first test file
      try {
         Path file = Path.of("test-file8.md");
         content = Files.readString(file);
      } catch (Exception e) {
         System.out.println("Invalid File");
      }

      //call getLinks
      try {
         URLs = parser.getLinks(content);
      } catch (Exception e) {
         System.out.println(URLs);
         System.out.println(e.getMessage());
         fail();
      }

      //check that expected equals actual
      assertEquals(expected.toString(), URLs.toString());
   }
}