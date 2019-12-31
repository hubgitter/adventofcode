package main.java.transform;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTransformer {
    public static Integer addIntegers(List<Integer> l){
        return l.stream().reduce(0, Integer::sum);
    }

    public static Long addLongs(List<Long> l){
        return l.stream().reduce(0l, Long::sum);
    }

    public static Stream<Long> stringStreamToLongStream(Stream<String> stringStream){
        return stringStream.map(Long::parseLong);
    }
    public static Stream<Integer> stringStreamToIntegerStream(Stream<String> stringStream){
        return stringStream.map(Integer::parseInt);
    }

    public static List<Long> LongStringAsArray(String s) {
        return Arrays.asList(s.split("")).stream().map(Long::parseLong).collect(Collectors.toList());
    }
    public static List<Integer> IntegerStringAsArray(String s) {
        return Arrays.asList(s.split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
