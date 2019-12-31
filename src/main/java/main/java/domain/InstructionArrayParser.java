package main.java.domain;

import main.java.transform.CollectionTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstructionArrayParser {

    private List<Long> instructionArray;

    public InstructionArrayParser(Long instruction) {

        String instructionAsString = Long.toString(instruction);
        String reverse = new StringBuffer(instructionAsString).reverse().toString();
        instructionArray = CollectionTransformer.LongStringAsArray(reverse);
        if(instructionArray.size() == 1){
            //set 10s digit to zero
            instructionArray.add(0L);
        }
    }

   public Long getCode(){
       return instructionArray.get(0) + 10 * instructionArray.get(1);
    }


    public List<Long> getModes(int n){

        Map<Long,Long> requiredModes = new HashMap<>();
        //initialise to zero
        for (int i=2; i<n+2; i++) {
            requiredModes.put(new Long(i), 0L);
        }
        //overwrite with present values
        for (int j=2;j<instructionArray.size();++j){
            requiredModes.put(new Long(j), instructionArray.get(j));
        }
        return new ArrayList<>(requiredModes.values());
    }

    public Long getShortCode(){
        return getCode() % 100;
    }

}
