package logger;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
public class ScoreFileWriterTest {
	@Test
    public void testSingleWrite() throws Exception {
        File temp = File.createTempFile("testScores", ".csv");
        ScoreFileWriter writer = new ScoreFileWriter(temp.getAbsolutePath(), false);

        Student s = new Student("Joe", "101", 88);
        writer.writeScore(s);
        writer.close();

        List<String> lines = Files.readAllLines(temp.toPath());
        assertEquals(1, lines.size());
        assertEquals("Joe,101,88", lines.get(0));
    }

    @Test
    public void testMultiThreadedWrites() throws Exception {
        File temp = File.createTempFile("testMultiScores", ".csv");
        ScoreFileWriter writer = new ScoreFileWriter(temp.getAbsolutePath(), false);

        Thread t1 = new Thread(new StudentTask(writer, new Student("Ben", "102", 90)));
        Thread t2 = new Thread(new StudentTask(writer, new Student("Doe", "103", 76)));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        writer.close();

        List<String> lines = Files.readAllLines(temp.toPath());
        assertEquals(2, lines.size());
    }

}
