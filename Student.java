package logger;

public class Student {
	private final String name;
    private final String rollNo;
    private final int marks;

    public Student(String name, String rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getMarks() {
        return marks;
    }

    // Converts the student's data into a CSV line
    public String toCSV() {
        return name + "," + rollNo + "," + marks;
    }

}
