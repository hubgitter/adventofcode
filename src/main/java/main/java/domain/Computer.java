package main.java.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static main.java.domain.Computer.STATE.HALTED;
import static main.java.domain.Computer.STATE.RUNNING;
import static main.java.domain.Computer.STATE.WAITING;

public class Computer {
    private static final Logger LOGGER = LogManager.getLogger(Computer.class);

    public Long getRelativeBase() {
        return relativeBase;
    }

    public Long relativeBase = 0L;
    public enum STATE{
        WAITING,RUNNING,HALTED
    }
    public List<Long> getMemoryAsList() {
        return memory.values().stream()
                .collect(Collectors.toList());
    }
    public Map<Long, Long> getMemoryAsMap() {
        return memory;
    }
    public void addInput(Long l){
        input.add(l);
    }
    public Computer (List<Long> memoryAsList, List<Long> input){
        Long key =0L;
        for (Long i : memoryAsList) {
            memory.put(key++,i);
        }
        this.immediateModeMemoryReader = new ImmediateModeMemoryReader(memory);
        this.positionModeMemoryWriter = new PositionModeMemoryWriter(memory);
        this.immediateModeMemoryWriter = new ImmediateModeMemoryWriter(memory);
        this.base = 0L;
        this.input = new ArrayList(input);
        readers.put(0L,new PositionModeMemoryReader(memory));
        readers.put(1L, new ImmediateModeMemoryReader(memory));
        readers.put(2L, new RelativeModeMemoryReader(memory, this));
        writers.put(0L,new PositionModeMemoryWriter(memory));
        writers.put(1L, new ImmediateModeMemoryWriter(memory));
        writers.put(2L, new RelativeModeMemoryWriter(memory, this));
    };

    public void setNounAndVerb(Long noun, Long verb){
        immediateModeMemoryWriter.set(1L, noun);
        immediateModeMemoryWriter.set(2L, verb);

    }

    public Boolean isHalted() {
        return state == HALTED;
    }
    public void tick() {

        LOGGER.debug("\r\n\r\n**tick {}:{} ***",base);

        Long code = immediateModeMemoryReader.get(base);

        InstructionArrayParser parser = new InstructionArrayParser(code);
        Long shortCode = parser.getShortCode();
        List<Long> modes = parser.getModes(3);
        IMemoryReader reader0 = readers.get(modes.get(0));
        IMemoryReader reader1 = readers.get(modes.get(1));



        switch(shortCode.intValue()) {
            case 1: {
                Long p1 = reader0.get(base + 1L);
                Long p2 = reader1.get(base + 2L);
                writers.get(modes.get(2)).set(base + 3L, p1 + p2);
                LOGGER.debug("1.add {} {} to value at offset {}",p1,p2, base +3L);
                base +=4;
                break;
            }
            case 2: {
                Long p1 = reader0.get(base + 1L);
                Long p2 = reader1.get(base + 2L);
                writers.get(modes.get(2)).set(base + 3L, p1 * p2);
                LOGGER.debug("2.multiply {} {} to value at offset {}",p1,p2, base +3L);
                base +=4;
                break;
            }
            case 3: {
                if(input.size() == 0){
                    state = WAITING;
                    LOGGER.debug("3.input. waiting");

                }
                else {
                    Long first = input.get(0);
                    input.remove(0);
                    writers.get(modes.get(0)).set(base + 1L, first);
                    LOGGER.debug("3.input ",first);
                    base += 2;

                }
                break;
            }
            case 4: {
                Long p1 = reader0.get(base + 1L);
                output.add(p1);
                LOGGER.debug("4. output {}", p1);
                base +=2;

                break;
            }
            case 5: {
                Long p1 = reader0.get(base + 1L);
                Long p2 = reader1.get(base + 2L);
                if(p1 != 0){
                    LOGGER.debug("5. jump-if-true. p1!=0, value at offset {} set to {}",base,p2);
                    base = p2;
                }
                else{
                    LOGGER.debug("5. jump-if-true. p1==0, do nothing, move 3");
                    base +=3L;

                }
                break;
            }
            case 6: {
                Long p1 = reader0.get(base + 1L);
                Long p2 = reader1.get(base + 2L);
                if(p1 == 0){
                    LOGGER.debug("6. jump-if-false. p1==0. value at offset {} set to {}",base,p2);
                    base = p2;

                }
                else{
                    LOGGER.debug("6. jump-if-false. p1!=0.do nothing, move 3");
                    base +=3L;

                }

                break;
            }
            case 7: {
                Long p1 = reader0.get(base + 1L);
                Long p2 = reader1.get(base + 2L);

                if(p1 < p2){
                    writers.get(modes.get(2)).set(base + 3, 1L);
                    LOGGER.debug("7.less than.p1<p2 value at offset {} set to 1L",base + 3L);
                }
                else{
                    writers.get(modes.get(2)).set(base + 3, 0L);
                    LOGGER.debug("7.less than.p1>=p2 value at offset {} set to 0L",base + 3L);

                }
                base +=4;

                break;
            }
            case 8: {
                Long p1 = reader0.get(base + 1L);
                Long p2 = reader1.get(base + 2L);

                if(p1.equals(p2)){
                    writers.get(modes.get(2)).set(base + 3L, 1L);
                    LOGGER.debug("8.equals. p1==p2, value at {} set to 1L",base + 3L);

                }
                else{
                    writers.get(modes.get(2)).set(base + 3L, 0L);
                    LOGGER.debug("8.equals. p1!=p2, value at {} set to 0L",base + 3L);

                }
                base +=4;
                break;
            }
            case 9: {
                Long p1 = reader0.get(base + 1L);
                relativeBase = relativeBase + p1;
                LOGGER.debug("9. relative base increased by {} to {}",p1,relativeBase);
                base += 2;

                break;
            }
            case 99: {
                LOGGER.debug("99. halted");
                state = HALTED;

                break;
            }
            default:{
                state = HALTED;
                LOGGER.debug("failed");
                throw new RuntimeException("invalid code:"+code);
            }

        }
    }
    public Long execute(){
        state = RUNNING;
        try {
            while (state!=HALTED && state != WAITING ) {
                tick();
            }
        }
        catch (Exception e){
            state = HALTED;
        }
        if (output.size() == 0) {
            return 0L;
        }
        return output.get(output.size() - 1);
    }

    public List<Long> getOutput() {
        return output;
    }

    private List<Long> output = new ArrayList<>();

    public Long getPosition0(){
        return memory.get(0L);
    }

    public Long getNoun(){
        return memory.get(1L);
    }


    public Long getVerb(){
        return memory.get(2L);
    }
    private Map<Long,Long> memory = new HashMap<>();

    public Long getBase() {
        return base;
    }

    private Long base;

    private IMemoryReader immediateModeMemoryReader;

    private IMemoryWriter positionModeMemoryWriter;

    private IMemoryWriter immediateModeMemoryWriter;

    private List<Long> input;

    private Map<Long, IMemoryReader> readers = new HashMap<>();
    private Map<Long, IMemoryWriter> writers = new HashMap<>();


    private STATE state;


}
