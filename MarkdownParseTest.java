import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List; 


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinksTest1() throws IOException {
        List<String> expected = List.of("some-page.html");
        String contents = Files.readString(Path.of("test-file.md"));
        //assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks("test-file.md"));
       assertEquals(expected , ActualMarkdown.getLinks(contents));
    }
    @Test
    public void getLinksTest2() throws IOException {
        List<String> expected = List.of();
        String contents = Files.readString(Path.of("TestFile1.md"));
       assertEquals(expected , ActualMarkdown.getLinks(contents));
    }
    @Test
    public void getLinksTest3() throws IOException {
        List<String> expected = List.of("something.com", "hello.com");
        String contents = Files.readString(Path.of("TestFile2.md"));
       assertEquals(expected , ActualMarkdown.getLinks(contents));
    }

}


/*
javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar ActualMarkdown.java MarkdownParseTest.java

java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
*/
