package SerializeTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeSertest {
    public static void main(String[] args) {
        ArrayList<File> a = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\src\\SerializeTest\\test.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            a = (ArrayList<File>)in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < a.size(); i++) {
                Scanner scan = new Scanner(a.get(i));
                while(scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
