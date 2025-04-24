import java.io.File;
import java.util.Map;
import java.util.concurrent.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;

public class FileParserMain {
    public static void main(String[] args) throws InterruptedException {
        // key = First Name, value = total count
        Map<String, AtomicInteger> namesCount = new ConcurrentHashMap<>();
        // key = Occupation, value = total count
        Map<String, AtomicInteger> occupationsCount = new ConcurrentHashMap<>();

        // execute the tasks with an ExecutorService
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            String filename = String.format("ExportCSV_%d.csv", i);
            Runnable task = new FileParserTask(new File(filename), namesCount, occupationsCount);
            executor.execute(task);
        }

        // initiate shutdown
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);

        // prints the computed metrics (DO NOT CHANGE THE LINES BELOW)
        System.out.println("First Name\tTotal");
        namesCount.forEach((name, count) -> System.out.println(name + "\t" + count));

        System.out.println("Ocupation\tTotal");
        occupationsCount.forEach((occupation, count) -> System.out.println(occupation + "\t" + count));
    }
}
