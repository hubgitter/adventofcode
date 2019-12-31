package test.java.exercises;

import main.java.domain.Computer;
import main.java.domain.ImageAnalyser;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8SpaceImageFormat {

    private static final Logger LOGGER = LogManager.getLogger(Day8SpaceImageFormat.class);

    @Test
    public void part1() throws Exception {
        List<Integer> digits = getDigits();
        ImageAnalyser imageAnalyser = new ImageAnalyser(digits,25,6) ;
        Integer multiple = imageAnalyser.getOnesTimesTwosInLayerWithLeastZeros();
        assertEquals(2080, multiple);

    }

    @Test
    public void part2() throws Exception{
        List<Integer> digits = getDigits();
        ImageAnalyser imageAnalyser = new ImageAnalyser(digits,25,6) ;
        List<List<Integer>> decryptedMessage = imageAnalyser.decryptMessage();
        assertEquals(
                Arrays.asList(
                    Arrays.asList(0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1),
                    Arrays.asList(1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1),
                    Arrays.asList(1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0),
                    Arrays.asList(1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                    Arrays.asList(1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0),
                    Arrays.asList(1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0)),
                decryptedMessage);
        if (false){
            renderMessage(decryptedMessage);
        }

    }

    private List<Integer> getDigits() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day8SpaceImageFormat.class);
        final String delimiter = "";
        List<String> lines = FileReader.getLines(exerciseInput);
        List<String> lineItems = Arrays.asList(lines.get(0).split(delimiter));
        return lineItems.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void renderMessage(List<List<Integer>> decryptedMessage){
        //AURCY
        LOGGER.debug(decryptedMessage);
        for (List<Integer> l: decryptedMessage){
            for(Integer i: l){
                if(i == 1){
                    LOGGER.debug('.');
                }
                else {
                    LOGGER.debug(' ');
                }
            }
            LOGGER.debug("");
        }
    }

}
