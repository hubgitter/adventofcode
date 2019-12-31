package test.java.domain;

import main.java.domain.ImageAnalyser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageAnalyserTest {
    private static final Logger LOGGER = LogManager.getLogger(ImageAnalyserTest.class);

    @Test
    public void imageAnalyserTest() throws Exception {
        ImageAnalyser imageAnalyser = new ImageAnalyser(Arrays.asList(0,0,1,2, 0,1,1,2, 1,1,1,2),1,2) ;
        Integer multiple = imageAnalyser.getOnesTimesTwosInLayerWithLeastZeros();
        assertEquals(1, multiple);
    }

    @Test
    public void decryptMessageTest(){
        ImageAnalyser imageAnalyser = new ImageAnalyser(Arrays.asList(0,0,1,2, 0,1,1,2, 1,1,1,1),1,2) ;
        List<List<Integer>> decryptedMessage = imageAnalyser.decryptMessage();
        LOGGER.debug(decryptedMessage);

    }
}
