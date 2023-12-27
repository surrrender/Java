package Basic_FileIO_Homework;

/**
 * The Record class represents a student record with a name and a score.
 */
public class Record {
    // Fields
    String student; // Student's name
    double score;   // Student's score

    /**
     * Constructor for creating a Record object.
     *
     * @param name  Student's name
     * @param score Student's score
     */
    public Record(String name, double score) {
        this.student = name;
        this.score = score;
    }

    /**
     * Gets the student's name.
     *
     * @return The student's name
     */
    public String getStudent() {
        return student;
    }

    /**
     * Gets the student's score.
     *
     * @return The student's score
     */
    public double getScore() {
        return score;
    }
}
