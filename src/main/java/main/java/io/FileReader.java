package main.java.io;

import java.io.EOFException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {


    public static List<String> getLines(String filename) throws Exception {
        try( Stream<String> lines = Files.lines(Paths.get(filename))){
            return lines.collect(Collectors.toList());
        }
    }
}
