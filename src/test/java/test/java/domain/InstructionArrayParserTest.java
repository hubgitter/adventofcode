package test.java.domain;

import main.java.domain.InstructionArrayParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionArrayParserTest {

    @Test
    public void testParserSingular(){
        InstructionArrayParser instructionArrayParser = new InstructionArrayParser(2L);
        assertEquals(instructionArrayParser.getShortCode(),2L);
        assertEquals(instructionArrayParser.getModes(3), Arrays.asList(0L,0L,0L));
        assertEquals(instructionArrayParser.getCode(), 2L);

    }
    @Test
    public void testParserWithTopModeAbsent(){
        InstructionArrayParser instructionArrayParser = new InstructionArrayParser(1002L);
        assertEquals(instructionArrayParser.getShortCode(),2L);
        assertEquals(instructionArrayParser.getModes(3), Arrays.asList(0L,1L,0L));
    }

    @Test
    public void testParserWithTopModePresent(){
        InstructionArrayParser instructionArrayParser = new InstructionArrayParser(11002L);
        assertEquals(instructionArrayParser.getShortCode(),2L);
        assertEquals(instructionArrayParser.getModes(3), Arrays.asList(0L,1L,1L));

    }
}
