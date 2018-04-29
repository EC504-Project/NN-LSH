import java.io.*;
import java.util.ArrayList;

public class readerTest {
    public static void main(String[] args) {
        ArrayList<hashData> a = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\cosineHash\\check.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            a = (ArrayList<hashData>)in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(hashData tmp: a){
            ArrayList<File> test = (ArrayList<File>)(tmp.getM().get("110010100111010"));
            if (test != null) {
                for (File ab : test) {
                    System.out.println(ab.getName());
                }
            }
        }
    }
}
