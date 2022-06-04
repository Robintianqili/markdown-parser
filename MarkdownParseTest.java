import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("Snippet1.md"));
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expect,MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("Snippet2.md"));
        List<String> expect = List.of("a.com(())", "example.com");
        assertEquals(expect,MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSingleImage() throws IOException {
        String contents= Files.readString(Path.of("Snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
         "https://cse.ucsd.edu/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}