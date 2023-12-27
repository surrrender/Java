package Basic_FileIO_Homework;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * ReadAndWrite class for managing studentship ,reading and writing to a file.
 */
public class ControllerToReadAndWrite {
    //HashMap to store student records with their index as the key.
    HashMap<Integer,Record> hashMap = new HashMap<Integer, Record>();

    /**
     * Adds a student record to the HashMap.
     *
     * @param Index student's index
     * @param name student's name
     * @param score student's score
     */
    void addRecord(int Index,String name,double score){
        Record record = new Record(name,score);
        hashMap.put(Index,record);
    }

    /**
     * Display the contents of the file.
     *
     * @param file The File to display
     */
    void display(File file){
        System.out.printf("%-10s%-10s%-10s%n","学号","姓名","成绩");
        try( BufferedReader reader = new BufferedReader(new FileReader(file))){
            String message = reader.readLine();
            while(message!=null){
                System.out.println(message);
                message = reader.readLine();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Writes student records to the specified file.
     *
     * @param file The file to write records to
     */
    void writeToFile(File file) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
            //PrintWriter writer = new PrintWriter(file);
            hashMap.forEach((key, value) -> {
                try {
                    writer.write(String.format("%-10d %-10s %-10.2f%n",key,hashMap.get(key).student,hashMap.get(key).score));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        catch (IOException e){System.out.println(e.getMessage());}
    }
    /**
     * Main method for taking user input and managing student records.
     *
     * @param args Command-line arguments
     */
}
