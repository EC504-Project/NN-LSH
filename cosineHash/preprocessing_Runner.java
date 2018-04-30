
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.*;
import java.util.ArrayList;

public class preprocessing_Runner {

    /**
     * Write obj to path specified
     * @param path path to write obj
     * @param obj object to be written
     */
    private static Object kryo = new Kryo();

    public static void writeOutObjects(String path, Object obj){
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            FileOutputStream fileOut = new FileOutputStream(raf.getFD());
            BufferedOutputStream buf = new BufferedOutputStream(fileOut);
            ObjectOutputStream out = new ObjectOutputStream(buf);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            raf.close();
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Output output = null;
//        try {
//            RandomAccessFile raf = new RandomAccessFile(path, "rw");
//            output = new Output(new FileOutputStream(raf.getFD()));
//            kryo.writeObject(output, obj);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (output != null) {
//                output.close();
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        /*
         * Create L hash table, each with b hash vectors
         */
        long startTime = System.nanoTime();
        for (int i = 0; i < SharedVariable.numberOfTables; i++) {
            ArrayList<double[]> bHashVectors = new ArrayList<>();
            for (int j = 0; j < SharedVariable.numberOfHashes; j++) {
                bHashVectors.add(CosineHashFamily.generateGaussianVector());
            }
            SharedVariable.collectionOfTables.add(new hashData(bHashVectors,new MultiValueMap()));
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration/1000000);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println(duration/1000000);
        /*
         * Read all images files from folder
         * hash each images and put them into the table;
         */
        File folder = new File(args[0]);
        File image;
        String[] fileList = folder.list();
        double[] imageVector;
        String image_Index = "";
        for (String filename: fileList){
            if (filename.endsWith(".jpg") || filename.endsWith(".png")){
                //System.out.println(filename);
                image = new File(folder.getAbsolutePath() + "\\" + filename);
                imageVector = img2vec.img2vec(image);
                for(hashData a: SharedVariable.collectionOfTables){
                    for (double[] r:a.getbHashVectors()) {
                        image_Index += CosineHashFamily.hash(imageVector,r);
                    }
                    //System.out.println("image is " + image_Index);
                    a.getM().put(image_Index, image);
                    image_Index = "";
                }
            }
        }
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime);
        System.out.println(duration1/1000000);
        writeOutObjects(args[1],SharedVariable.collectionOfTables);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime);
        System.out.println(duration2/1000000);
    }

}
