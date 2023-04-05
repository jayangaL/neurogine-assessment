import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStreamsAndCollectors {

    public static void main(String[] args) {
        String sample = "Transform this text         using map streams and collectors";
        System.out.println("----------String Transform------------");
        System.out.println(transform(sample));
        System.out.println("");

        List<String> sampleList = Arrays.asList("abc" , "an" , "" , "apple" , "bcd" , "" , "jk");
        System.out.println("-----------String Word Counts-------------");
        System.out.println(countStringsStartWithA(sampleList));
        System.out.println(countEmptyStrings(sampleList));
    }

    // Converts String to UpperCase and joins them with a comma
    public static String transform(String text){
        return Stream.of(text.replaceAll("\\s+"," ").split(" ")).map(String::toUpperCase).collect(Collectors.joining(","));
    }

    // Counts Number Strings start with A
    public static long countStringsStartWithA(List<String> list){
        return list.stream().filter(text->text.startsWith("a")).count();
    }

    // Counts empty strings only 
    public static long countEmptyStrings(List<String> list){
        return list.stream().filter(String::isBlank).count();
    }
}
