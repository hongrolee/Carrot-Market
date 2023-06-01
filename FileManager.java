import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
	
	String filePath = null;
	
	public FileManager(String filePath) {
		this.filePath = filePath;
	}
	
	public void save(Object obj) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(obj);//파일에 ArrayList 저장
			oos.close();
		} catch (Exception ex) {}
	}
	
	public Object load() {
		Object data = null;
		try	{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filePath));
			data = ois.readObject();//파일에서 ArrayList읽기
			ois.close();
		} catch(Exception e) {}
		return data;
	}
}