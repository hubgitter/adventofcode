package main.java.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class PositionModeMemoryReader implements IMemoryReader {

    private Map<Long, Long> memory;

    public PositionModeMemoryReader(Map<Long, Long> memory) {
        this.memory = memory;
    }
    private static final Logger LOGGER = LogManager.getLogger(PositionModeMemoryReader.class);

    @Override
    public Long get(Long offset) {
        Long location = memory.get(offset);
        Long value = 0L;
        if (memory.containsKey(location)) {
            value = memory.get(location);
        }
        LOGGER.debug("Read {} from location {} for offset {}", value, location, offset);
        return value;
    }


}