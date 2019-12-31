package main.java.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ImmediateModeMemoryWriter implements IMemoryWriter {
    private static final Logger LOGGER = LogManager.getLogger(ImmediateModeMemoryWriter.class);

    private Map<Long,Long> memory;

    public ImmediateModeMemoryWriter(Map<Long,Long> memory){
        this.memory = memory;
    }
    @Override
    public void set(Long offset, Long value){
        LOGGER.debug("Wrote {} to offset {}", value, offset);
        memory.put(offset, value);
    }
}