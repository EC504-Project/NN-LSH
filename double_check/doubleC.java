/**
 * Created by gaocc on 2018/4/26.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.*;
public class doubleC {
    public static int[] doubleC(File f) throws IOException {

        BufferedImage img = null;

        try {
            //f = new File(imgpath);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        //int width = img1.getWidth();
        //int height = img1.getHeight();
        //int size = width * height;
        double[] myList = new double[1024];
        int sum1 = 0;
        int sum2 = 0;
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                int p = img.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                sum1 = sum1 + avg;
                // put the pixel to the list
                int index = 32 * y + x;
                myList[index] = avg;
            }
        }
        int average = sum1 / 1024;
        int[] hamming = new int[1024];
        for (int i = 0; i < 1024; i++) {
            if (myList[i] >= average) {
                hamming[i] = 1;
            } else {
                hamming[i] = 0;
            }
        }
        return hamming;
    }

    public static boolean similarityCheck(File f1, File f2) {
        try {
            // for using the gray version picture to test, change this path to a gray version image
            int[] l1 = doubleC(f1);
            int[] l2 = doubleC(f2);
            int count = 0;
            // to change the same number need to check, change threshold here
            int threshold = 800;
            for(int i =0;i<1024;i++){
                if(l1[i] == l2[i]){
                    count = count +1;
                }
            }
            //System.out.println(count);
            if(count >= threshold){
                //System.out.println(" This image is same with the goal image");
                return true;
            }else{
                //System.out.println(" This image is different with the goal image");
                return false;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }
    public static void main(String[] args) {
            // for using the gray version picture to test, change this path to a gray version image
            File f1 = new File("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\double_check\\image\\t1.png");
            File f2 = new File("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\double_check\\image\\t2.png");
            System.out.println(similarityCheck(f1,f2));
    }
}
