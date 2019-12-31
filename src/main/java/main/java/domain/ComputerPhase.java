package main.java.domain;

import java.util.Arrays;
import java.util.List;

public class ComputerPhase {
    private Long result;

    public ComputerPhase(List<Long> codes, List<Long> phaseSetting){
        Computer computer0 = new Computer(codes, Arrays.asList(phaseSetting.get(0), 0L));
        computer0.addInput(0L);
        Computer computer1 =  new Computer(codes, Arrays.asList(phaseSetting.get(1)));
        Long x0 = computer0.execute();
        computer1.addInput(x0);
        Long x1 = computer1.execute();
        Long x2 = new Computer(codes, Arrays.asList(phaseSetting.get(2), x1)).execute();
        Long x3 = new Computer(codes, Arrays.asList(phaseSetting.get(3), x2)).execute();
        Long x4 = new Computer(codes, Arrays.asList(phaseSetting.get(4), x3)).execute();
        this.result = x4;
    }

    public Long getResult() {
        return result;
    }
}
