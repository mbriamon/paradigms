import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FileParserTask implements Runnable {
    private final File file;
    private final Map<String, AtomicInteger> namesCount;
    private final Map<String, AtomicInteger> occupationsCount;

    public FileParserTask(File file, Map<String, AtomicInteger> namesCount, Map<String, AtomicInteger> occupationsCount) {
        this.file = file;
        this.namesCount = namesCount;
        this.occupationsCount = occupationsCount;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Skip header
            reader.readLine(); 

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length < 5) continue;

                String firstName = fields[3].trim();  // Corrected index
                String occupation = fields[1].trim(); // Corrected index

                namesCount.computeIfAbsent(firstName, k -> new AtomicInteger(0)).incrementAndGet();
                occupationsCount.computeIfAbsent(occupation, k -> new AtomicInteger(0)).incrementAndGet();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
    }
}

