import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {

   private MarkdownParse parser;

   @Before
   public void setup() {
      //initialize new MarkdownParse object
      parser = new MarkdownParse();
   }

   @Test
   public void addition() {
      assertEquals(2, 1 + 1);
   }

   @Test
   public void testfile1() {
      //set up expected string from first test file
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("https://something.com");
      expected.add("some-thing.html");

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("https://google.com");

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      //set up expected string from first test file
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("www.URL.com");
      expected.add("URL2");

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      //set up expected string from first test file
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("URL1");
      expected.add("URL2");
      expected.add("URL3");
      expected.add("URL4");

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      //set up expected string from first test file
      ArrayList<String> expected = new ArrayList<String>();

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("page.com");

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      //set up expected string from first test file
      ArrayList<String> expected = new ArrayList<String>();

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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
      ArrayList<String> expected = new ArrayList<String>();
      expected.add("a link on the first line");

      String content = "empty";
      ArrayList<String> URLs = new ArrayList<String>();

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