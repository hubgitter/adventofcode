package main.java.domain;

import main.java.transform.CollectionTransformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import static java.lang.Math.pow;

public class NumberChecker {

    public List<List<Long>> getCodes(Long minDigit, Long maxDigit, Long width){
        List<List<Long>> results = new ArrayList<>();
        for (Long i=new Long(minDigit); i<=maxDigit*pow(10,width);++i){
            List<Long> iAsArray = getLongAsArray(i);
            if (    isUniqueDigits(iAsArray)&&
                    digitsInRange(iAsArray,minDigit,maxDigit)&&
                    iAsArray.size() == width)

            {
                results.add(iAsArray);
            }
        }
        return results;
    }

    private boolean digitsInRange(List<Long> intArray, Long minDigit, Long maxDigit){
        if (intArray.stream().allMatch(i->i>=minDigit && i<=maxDigit)){
            return true;
        }
        return false;
    }

    private List<Long> getLongAsArray(Long i){
        String codeAsString = String.valueOf(i);
        return CollectionTransformer.LongStringAsArray(codeAsString);
    }

    private boolean isUniqueDigits(List<Long> intArray){
        LinkedHashSet<Integer> hashSet = new LinkedHashSet(intArray);
        if (hashSet.size() == intArray.size()){
            return true;
        }
        return false;
    }

    public boolean isValidPassword(Long code, boolean requireExactlyTwoOfOneNumber){
        List<Long> codeAsArray = getLongAsArray(code);
        if (isUniqueDigits(codeAsArray)){
            return false;
        }
        Long secondLastPosition = new Long(codeAsArray.size() - 1);
        Long current = codeAsArray.get(0);
        for (int i = 0; i<secondLastPosition; ++i){
            Long next = codeAsArray.get(i+1);
            if (next < current){
                return false;
            }
            current = next;
        }
        if (requireExactlyTwoOfOneNumber) {
            List<Integer> counts = new ArrayList<>();
            for (Long i : new LinkedHashSet<>(codeAsArray)) {
                int icount = Collections.frequency(codeAsArray, i);
                counts.add(icount);
            }
            if (!counts.contains(2)) {
                return false;
            }
        }

        return true;
    }

}
