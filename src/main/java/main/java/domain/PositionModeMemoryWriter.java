package main.java.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PositionModeMemoryWriter implements IMemoryWriter {

    private Map<Long,Long> memory;
    private static final Logger LOGGER = LogManager.getLogger(PositionModeMemoryWriter.class);

    public PositionModeMemoryWriter(Map<Long,Long> memory){
        this.memory = memory;
    }
    @Override
    public void set(Long offset, Long value){
        Long location = memory.get(offset);
        memory.put(location, value);
        LOGGER.debug(String.format("Wrote %s to location %s found at offset %s", value, location, offset));
    }




}