package main.java.io;

public class ResourceLocator {
    private static final String EXERCISE_FILE_DIRECTORY = "src/main/resources/input/";

    public static String getExerciseInputFile(Class<?> clazz){
        return String.format("%s%s.csv", EXERCISE_FILE_DIRECTORY, clazz.getSimpleName());
    }
}
