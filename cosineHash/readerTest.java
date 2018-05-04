import java.io.*;
import java.util.ArrayList;

public class readerTest {
    public static void main(String[] args) throws IOException {
       File test1 = new File("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\dataset\\testImage\\0_3.jpg");
       File test2 = new File("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\dataset\\train\\0_37867.jpg");
       double[] t1 = img2vec.img2vec(test1);
       double[] t2 = img2vec.img2vec(test2);
       String index1 = "";
       String index2 = "";
       ArrayList<double[]> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(CosineHashFamily.generateGaussianVector());
        }
        for (int i = 0; i < 30; i++) {
            index1 += CosineHashFamily.hash(t1,list.get(i));
            index2 += CosineHashFamily.hash(t2,list.get(i));
        }
//        for (int i = 0; i < 100; i++) {
//            index2 += CosineHashFamily.hash(t2,list.get(i));
//        }
       System.out.println(index1);
        System.out.println(index2);
    }
}
