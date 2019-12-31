package main.java.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class RelativeModeMemoryReader implements IMemoryReader {

    private Map<Long, Long> memory;
    private Computer computer;
    private static final Logger LOGGER = LogManager.getLogger(RelativeModeMemoryReader.class);

    public RelativeModeMemoryReader(Map<Long, Long> memory, Computer computer) {

        this.memory = memory;
        this.computer = computer;
    }

    @Override
    public Long get(Long offset) {
        Long location1 = memory.get(offset);
        Long location2 = computer.getRelativeBase();
        Long locationTotal = location1 + location2;
        Long value = 0L;
        if (memory.containsKey(locationTotal)) {
            value = memory.get(locationTotal);
        }
        LOGGER.debug("Read {} from location {}+{}={} for offset {}",
                value, location1, location2, locationTotal, offset);
        return value;
    }
}