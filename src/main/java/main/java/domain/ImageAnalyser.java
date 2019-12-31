package main.java.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ImageAnalyser {

    private List<List<Integer>> subLists = new ArrayList<>();
    private Integer imageSize;
    private Integer xDim;

    public ImageAnalyser(List<Integer> digits,Integer xDim, Integer yDim) {
        imageSize = xDim*yDim;
        this.xDim = xDim;
        for(int i=0;i<digits.size();i=i+imageSize){
            subLists.add(digits.subList(i,i+imageSize));
        }

    }
    public Integer getOnesTimesTwosInLayerWithLeastZeros(){
        List<Integer> sublistWithLeastNumberOfZeros =
                subLists.stream().min(Comparator.comparingInt(s->s.stream().filter(x->x==0).mapToInt(i -> 1).sum())).orElse(null);
        Integer numberOfOnes = findNumberOfOccurrencesOf(sublistWithLeastNumberOfZeros,1);
        Integer numberOfTwos = findNumberOfOccurrencesOf(sublistWithLeastNumberOfZeros, 2);
        return numberOfOnes*numberOfTwos;
    }

    public List<List<Integer>> decryptMessage(){

        List<Integer>decrypted = new ArrayList<>(subLists.get(0));
        for(List<Integer> subList:subLists){
            for(Integer i=0;i<subList.size();i++){
                if(decrypted.get(i)==2){
                    decrypted.set(i,subList.get(i));
                }
            }
        }
        List<List<Integer>> subLists = new ArrayList<>();
        for(int i=0;i<decrypted.size();i=i+xDim){
            subLists.add(decrypted.subList(i,i+xDim));

        }
        return subLists;
    }

    private Integer findNumberOfOccurrencesOf(List<Integer>sublist, Integer n){
        return sublist.stream().filter(i->i==n).mapToInt(i -> 1).sum();
    }
}