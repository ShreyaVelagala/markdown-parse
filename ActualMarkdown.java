// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ActualMarkdown {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
/*
            if(nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1){
            }
                         
            System.out.println(markdown); 
            System.out.print("openbracket: ");
            System.out.println(nextOpenBracket);             
            System.out.print("Closeparen: ");
            System.out.println(closeParen); 
*/          
            //working code for image, multiple parantheses at end, missing brackets/paranthases
            if(nextOpenBracket == 0 && (nextOpenBracket < nextCloseBracket) && (nextCloseBracket < openParen) && (openParen < closeParen)){
                toReturn.add(markdown.substring(openParen + 1, closeParen)); 
                currentIndex = 0; 
                markdown = markdown.substring(closeParen + 1).trim() ;
            }
            else if(closeParen != -1){
                currentIndex = 0;  
                markdown = markdown.substring(closeParen + 1).trim();
            }
            //working code for file with no links 
            /*
            else {
                currentIndex = markdown.length(); 
                System.out.println("here"); 
            }
            */
            /*
            else if(nextOpenBracket > 0){
                currentIndex = closeParen + 1;  
                System.out.println(closeParen);
            }
            */
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}