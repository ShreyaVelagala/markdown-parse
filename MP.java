// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MP {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        if (!markdown.contains("(") && !markdown.contains("[")) {
            if (!markdown.contains("(") || !markdown.contains("[")) {
                return toReturn;
            }

        
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            //we need to find a closing bracket follwed immediately by an opening paren
            //System.out.println(currentIndex); 
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen); //indexOf(")", openParen); 
            //int closeParen = markdown.lastIndexOf(")"); //indexOf(")", openParen);
            //above one is updated one 
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            //System.out.println(currentIndex); 
            currentIndex = closeParen + 1;
            //System.out.println(currentIndex); 
        }
        return toReturn;
        }
    }
    public static void main(String[] args) throws IOException {
        /*
        if(args.length == 0){
            System.out.println("no arguments"); 
            return; //solving empty .md file issue
        }
        */
		Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
       
            /*
            String[] arr = split(contents); 
            //split contents into string array
            //for loop: for ecah content check for "](" and "https://"
            for
            ArrayList<String> links = getLinks(contents);
            System.out.println(links);
            */
    }
}


/*
[Breaking Point?](website().html)
[Not breaking point](ucsd.edu)
*/
