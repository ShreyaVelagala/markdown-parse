import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path testFile = Path.of("test-file.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of("https://something.com","some-page.html");
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks2() throws IOException {
        Path testFile = Path.of("lab.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path testFile = Path.of("labnew.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks02() throws IOException {
        Path testFile = Path.of("test-file2.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of("https://something.com","some-page.html");
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks03() throws IOException {
        Path testFile = Path.of("test-file3.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks04() throws IOException {
        Path testFile = Path.of("test-file4.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks05() throws IOException {
        Path testFile = Path.of("test-file5.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks06() throws IOException {
        Path testFile = Path.of("test-file6.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks07() throws IOException {
        Path testFile = Path.of("test-file7.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of();
        assertEquals(expectedList,newList);
    }

    @Test
    public void testGetLinks08() throws IOException {
        Path testFile = Path.of("test-file8.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of("a link on the first line");
        assertEquals(expectedList,newList);
    }

    @Test
    public void Snippet1() throws IOException {
        Path testFile = Path.of("Snippet1.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of("google.com", "google.com", "ucsd.edu");
        assertEquals(expectedList,newList);
    }

    @Test
    public void Snippet2() throws IOException {
        Path testFile = Path.of("Snippet2.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expectedList,newList);
    }

    @Test
    public void Snippet3() throws IOException {
        Path testFile = Path.of("Snippet3.md");
	    String readFile = Files.readString(testFile);
        ArrayList<String> newList = MarkdownParse.getLinks(readFile);
        List<String> expectedList = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(expectedList,newList);
    }
}