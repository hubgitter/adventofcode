package test.java.exercises;

import main.java.domain.NumberChecker;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day4SecureContainer {

    @Test
    public void part1() throws Exception {
        String[] lineArray = splitFileInputs();
        Long lower = Long.parseLong(lineArray[0]);
        Long upper = Long.parseLong(lineArray[1]);
        long totalPart1 = 0;
        for (long i= lower; i<= upper; ++i ) {
            NumberChecker numberChecker = new NumberChecker();
            if (numberChecker.isValidPassword(i,false)) {
                totalPart1++;
            }

        }
        assertEquals(1033, totalPart1);

    }
    @Test
    public void part2() throws Exception {
        String[] lineArray = splitFileInputs();
        Long lower = Long.parseLong(lineArray[0]);
        Long upper = Long.parseLong(lineArray[1]);
        int totalPart2 = 0;
        for (long i= lower; i<= upper; ++i ) {
            NumberChecker numberChecker = new NumberChecker();
            if (numberChecker.isValidPassword(i,true)){
                totalPart2++;
            }
        }
        assertEquals(670, totalPart2);

    }
    private String[] splitFileInputs() throws Exception {
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day4SecureContainer.class);
        String line = FileReader.getLines(exerciseInput).get(0);
        return line.split("-");
    }
}
