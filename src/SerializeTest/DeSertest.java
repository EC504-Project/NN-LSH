package SerializeTest;

import java.io.*;

public class DeSertest {
    public static void main(String[] args) {
        SerializeTest[]a = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\src\\SerializeTest\\test.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            a = (SerializeTest[])in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        a[0].output();
        a[1].output();
    }
}
