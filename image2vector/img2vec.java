/**
 * Created by gaocc on 2018/4/8.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.*;

public class img2vec {
    public static double [] img2vec(String imgpath) throws IOException {
        File f = null;
        BufferedImage img = null;
        //double[] myList = null;
        try {
            f = new File(imgpath);
            img = ImageIO.read(f);
        }catch (IOException e) {
            System.out.println(e);
        }
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //System.out.println(width);
        //System.out.println(height);
        int size = width * height;
        double[] myList = new double[size];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                // put the pixel to the list
                int index = 32*y +x;
                myList[index] = avg;
                
                //gray version
                //int p = img.getRGB(x, y);
                //int index = 32*y +x;
                //myList[index] = p;
            }
            }
        return myList;
    }
// main function is used to test whether the output is right or not
    public static void main(String[] args) {
        try {
            // for using the gray version picture to test, change this path to a gray version image
            double[] l = img2vec("/Users/gaocc/IdeaProjects/lsh/image/5_15989.jpg");
            for(int i =0;i<1024;i++){
                System.out.println(l[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        //System.out.println("ok");
    }
}
