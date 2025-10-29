package logger;

public class StudentTask implements Runnable{
	private final ScoreFileWriter writer;
    private final Student student;

    public StudentTask(ScoreFileWriter writer, Student student) {
        this.writer = writer;
        this.student = student;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 200));
            writer.writeScore(student);
            System.out.println(Thread.currentThread().getName() + " wrote: " + student.getName());
        } catch (Exception e) {
            System.err.println("Error while writing: " + e.getMessage());
        }
    }

}
