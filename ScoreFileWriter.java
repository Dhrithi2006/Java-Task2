package logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class ScoreFileWriter {
	private final BufferedWriter writer;
	
    public ScoreFileWriter(String filePath, boolean includeHeader) throws IOException {
        writer = new BufferedWriter(new FileWriter(filePath, true));

        if (includeHeader) {
            synchronized (this) {
                writer.write("Name,Roll Number,Marks");
                writer.newLine();
                writer.flush();
            }
        }
    }

    public synchronized void writeScore(Student student) throws IOException {
        writer.write(student.toCSV());
        writer.newLine();
        writer.flush();
    }

    public synchronized void close() throws IOException {
        writer.close();
    }

}
