package logger;
import java.io.File;
public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String fileName = "exam_scores.csv";
        ScoreFileWriter writer = new ScoreFileWriter(fileName, true);

        Thread t1 = new Thread(new StudentTask(writer, new Student("Joe", "101", 85)));
        Thread t2 = new Thread(new StudentTask(writer, new Student("Ben", "102", 90)));
        Thread t3 = new Thread(new StudentTask(writer, new Student("Doe", "103", 78)));
        Thread t4 = new Thread(new StudentTask(writer, new Student("Ian", "104", 92)));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        writer.close();
        System.out.println("✅ All scores saved successfully to " + new File(fileName).getAbsolutePath());
    }

	

}
