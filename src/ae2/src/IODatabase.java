package ae2.src;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IODatabase {
	public static void write(Database db) throws IOException {
		try(FileOutputStream fos = new FileOutputStream("out.tmp");
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(db);
		}
	}
	
	public static Database read() throws FileNotFoundException, IOException, ClassNotFoundException {
		try(FileInputStream fis = new FileInputStream("out.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			Database db = (Database) ois.readObject();
			return db;
		}
	}
}
