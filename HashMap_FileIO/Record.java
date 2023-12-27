package HashMap_FileIO;

import java.io.Serializable;

/**
 * The Record class represents a student record with a name and a score.
 */
public class Record implements Serializable {
    // Fields
    int index;
    String student; // Student's name
    double score;   // Student's score

    /**
     * Constructor for creating a Record object.
     *
     * @param name  Student's name
     * @param score Student's score
     * @param index Student's index
     */
    public Record(int index,String name, double score) {
        this.index = index;
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

    /**
     * Override the toString function for this class
     * @return the format string that is used to record the information of the students
     */
    @Override
    public String toString() {
        return String.format("%-10d %-16s %-10.2f",index,student,score);
    }
}
