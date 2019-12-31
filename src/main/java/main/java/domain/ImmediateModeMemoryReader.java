package main.java.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ImmediateModeMemoryReader implements IMemoryReader {

    private Map<Long,Long> memory;
    private static final Logger LOGGER = LogManager.getLogger(ImmediateModeMemoryReader.class);

    public ImmediateModeMemoryReader(Map<Long,Long> memory){
        this.memory = memory;
    }
    @Override
    public Long get(Long offset){
        Long value = 0L;
        if (memory.containsKey(offset)) {
            value = memory.get(offset);
        }
        LOGGER.debug("Read {} at offset {}", value, offset);
        return value;
    }




}
