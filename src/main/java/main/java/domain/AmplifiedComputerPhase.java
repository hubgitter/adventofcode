package main.java.domain;


import java.util.*;

public class AmplifiedComputerPhase {
    private Long result = 0L;

    public AmplifiedComputerPhase(List<Long> codes, List<Long> phaseSetting) {

        Map<Computer,Computer>map = new HashMap<>();
        Computer computer0 = new Computer(codes,Arrays.asList(phaseSetting.get(0)));
        Computer computer1 = new Computer(codes,Arrays.asList(phaseSetting.get(1)));
        Computer computer2 = new Computer(codes,Arrays.asList(phaseSetting.get(2)));
        Computer computer3 = new Computer(codes,Arrays.asList(phaseSetting.get(3)));
        Computer computer4 = new Computer(codes,Arrays.asList(phaseSetting.get(4)));
        map.put(computer0,computer1);
        map.put(computer1,computer2);
        map.put(computer2,computer3);
        map.put(computer3,computer4);
        map.put(computer4,computer0);
        Computer current = computer0;
        while(!current.isHalted()){
            current.addInput(result);
            result = current.execute();
            current = map.get(current);
        }
    }

    public Long getResult() {
        return result;
    }
}
