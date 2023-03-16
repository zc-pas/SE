package groupwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * IODatabase class is used to read objects from the database
 * and write objects in database
 *
 * @author Mingqi Zhang 2810329Z
 */
public class IODatabase {

    /**
     * write Database db to out.tmp file
     *
     * @param db current database
     * @throws IOException
     */
    public static void write(Database db) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("out.tmp");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(db);
        }
    }

    /**
     * read Database objects from out.tmp file and return
     * the Database objects
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Database read() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("out.tmp");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Database db = (Database) ois.readObject();
            return db;
        }
    }
}
