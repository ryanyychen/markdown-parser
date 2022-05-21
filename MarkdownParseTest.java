import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {

   private MarkdownParse parser;
   private ArrayList<String> expected;
   private ArrayList<String> URLs;
   private Path file;
   private String content;

   @Before
   public void setup() {
      parser = new MarkdownParse();
      expected = new ArrayList<String>();
      URLs = new ArrayList<String>();
   }

   @Test
   public void testfile1() throws IOException{
      expected.add("https://something.com");
      expected.add("some-thing.html");

      file = Path.of("test-file.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile2() throws IOException{
      expected.add("https://something.com");
      expected.add("some-page.html");

      file = Path.of("test-file2.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile3() throws IOException{
      //expected should be empty
      file = Path.of("test-file3.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile4() throws IOException {
      //expected should be empty
      file = Path.of("test-file4.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile5() throws IOException{
      //expected should be empty
      file = Path.of("test-file5.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile6() throws IOException{
      expected.add("page.com");

      file = Path.of("test-file6.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile7() throws IOException{
      //expected should be empty
      file = Path.of("test-file7.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testfile8() throws IOException{
      expected.add("a link on the first line");

      file = Path.of("test-file8.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testSnippet1() throws IOException {
      expected.add("'google.com");
      expected.add("google.com");
      expected.add("ucsd.edu");

      file = Path.of("snippet1.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testSnippet2() throws IOException {
      expected.add("a.com");
      expected.add("a.com(())");
      expected.add("example.com");

      file = Path.of("snippet2.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }

   @Test
   public void testSnippet3() throws IOException {
      expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");

      file = Path.of("snippet3.md");
      content = Files.readString(file);
      URLs = parser.getLinks(content);
      assertEquals(expected.toString(), URLs.toString());
   }
}

