

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

public class TestStreams {


    public static void main(String[] args) {
        partieStream();
    }

    private static void partieStream()
    {

        System.out.println("MainTest pour les Stream Java 8");

        initStreamMethod();
        actionSimpleStreamMethod();
        filterLimitSortedStreamMethod();
        parralStreamMethod();

        Integer value=IntStream.range(1,10).reduce((x,y)->x+y).getAsInt();
        System.out.println(value); //45
    }

    public static <T> void myPrint(T t)
    {
        System.out.println(t.toString());
    }


    private static void initStreamMethod()
    {
        //CODE 1

        Stream emptyStream = Stream.empty();

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOFromArray = collection.stream();

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOFromArray2 = Arrays.stream(arr);

        IntStream streamOfChars = "abc".chars();


        //StreamSupport

        Stream<String> genStream = Stream.generate(() -> "1");
        IntStream s=IntStream.range(1,10);
        Stream<String> iterateStream = Stream.iterate("thomas",(x) -> x.toUpperCase());

        Stream<String> phrase=Stream.<String>builder().add("Ceci ").add("est ").add("une ").add("phrase.").build();


    }

    private static void actionSimpleStreamMethod()
    {
        //CODE 2

        Collection<String> streamOFromArray = Arrays.asList("a", "b", "c");
        streamOFromArray.forEach(System.out::println);
        Stream<String> genStream = Stream.generate(() -> "1");
        Stream<String> iterateStream = Stream.iterate("thomas",(x) -> x.toUpperCase()).limit(2);
        iterateStream.forEach(System.out::println);
    }


    private static void filterLimitSortedStreamMethod()
    {
        //CODE 3
        System.out.println("Stream1");
        Stream<Integer> stream = Stream.iterate(0,(x)-> x+1 );
        stream.limit(10).filter((x) -> (x % 2) == 0).forEach(System.out::println);

        System.out.println("Stream2");
        Stream<Integer> stream2 = Stream.iterate(0,(x)-> x+1 );
        stream2.filter((x) -> (x % 2) == 0).limit(10).forEach(System.out::println);

        System.out.println("Stream3");
        IntStream stream3=new Random().ints(0,100);
        stream3.limit(10).filter((x) -> (x % 2) == 0).sorted().forEach(System.out::println);


        // for collect et sorted
        System.out.println("Stream4");
        Stream<Integer> stream4=new Random().ints(0,100).boxed();// on fait un boxed pour traduire de IntStream

        IntSummaryStatistics stats=stream4.mapToInt(x -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        System.out.println("Stream5");
        Stream<Integer> stream5=new Random().ints(0,100).boxed();// on fait un boxed pour traduire de IntStream
        Set<Integer> set2= stream5.filter((x) -> (x % 2) == 0).limit(10).sorted().collect(Collectors.toSet());

        for(Integer i:set2)
        {
            myPrint(i);
        }


    }


    private static void parralStreamMethod()
    {
        long tmp1=System.currentTimeMillis();
        Stream<Double> stream2= DoubleStream.iterate(0.00, x -> x + 1 ).boxed();
        Set<Double> s2=stream2.parallel().map(x -> 4*(x+Math.random())+3).limit(200000).collect(Collectors.toSet());

        long tmp2=System.currentTimeMillis();
        Stream<Double> stream= DoubleStream.iterate(0.00, x -> x + 1 ).boxed();
        Set<Double> s=stream.map(x -> 4*(x+Math.random())+3).limit(200000).collect(Collectors.toSet());
        long tmp3=System.currentTimeMillis();

        System.out.println(tmp2-tmp1);
        System.out.println(tmp3-tmp2);


    }
}
