package HashMap_FileIO;
import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Random;

/**
 * The FileIO class handles the generation, writing, and reading of records using HashMap and File I/O operations.
 */
public class FileIO {
    HashMap<Integer, Record> hashMap = new HashMap<Integer,Record>();
    static double mean = 80;
    static double stdDev = 4.0;

    File file = new File("D:/text.dat");
    /**
     * Generates records with random names and scores and adds them to the HashMap.
     */
    void generateRecord(){
        String[] FIRST_NAMES = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry"};
        String[] LAST_NAMES = {"Anderson", "Brown", "Clark", "Davis", "Evans", "Fisher", "Garcia", "Hill"};
        Random random = new Random();
        int x = 71121100;
        for (;x<71122101;x++){
            String name = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)]+' '+LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            double score = mean + stdDev * random.nextGaussian();
            hashMap.put(x,new Record(x,name,score));
        }
    }
    /**
     * Writes records from the HashMap to a file using ObjectOutputStream.
     *
     * @param file The file to write records to.
     */
    void WriteFile(File file){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            hashMap.forEach((key,value)-> {
                try {
                    writer.writeObject(value);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
        }
        catch (IOException e){System.out.println(e.getMessage());}
    }
    /**
     * Reads records from a file using ObjectInputStream and displays them.
     *
     * @param file The file to read records from.
     */
    void ReadFile(File file){
        try {
            ObjectInputStream reader = new ObjectInputStream(Files.newInputStream(file.toPath()));
            System.out.printf("%-10s %-16s %-10s\n","学号","姓名","成绩");
            try {
                while(true)System.out.println(reader.readObject());
            }catch (EOFException e){System.out.println("已全部读出");}

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * The main method creates a FileIO object, generates records, writes them to a file, and then reads and displays them.
     *
     * @param args The command-line arguments (not used in this example).
     */
    public static void main(String[]args){
        FileIO IO = new FileIO();
        IO.generateRecord();
        IO.WriteFile(IO.file);
        IO.ReadFile(IO.file);
    }
}
