package main.java.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class RelativeModeMemoryWriter implements IMemoryWriter {

    private Map<Long,Long> memory;
    private Computer computer;
    private static final Logger LOGGER = LogManager.getLogger(RelativeModeMemoryWriter.class);

    public RelativeModeMemoryWriter(Map<Long,Long> memory,Computer computer){

        this.memory = memory;
        this.computer = computer;
    }
    @Override
    public void set(Long offset, Long value){
        Long location1 = memory.get(offset);
        Long location2 = computer.getRelativeBase();
        Long locationTotal = location1 + location2;
        memory.put(locationTotal, value);
        LOGGER.debug(String.format("Wrote %s to location %s found at offset %s", value, locationTotal, offset));
    }




}