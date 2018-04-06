package SerializeTest;

import java.io.*;

public class SerializeTest implements java.io.Serializable {
    public String name;
    public String address;

    public SerializeTest(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void output(){
        System.out.println(name + " "+ address);
    }

    public static void main(String[] args) {
        SerializeTest a = new SerializeTest("Ryan","TestAddress");
        SerializeTest b = new SerializeTest("Gary","Another Test");
        SerializeTest[] test = {a,b};
        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\src\\SerializeTest\\test.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
