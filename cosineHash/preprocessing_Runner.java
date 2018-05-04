
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.*;
import java.util.ArrayList;

public class preprocessing_Runner {

    /**
     * Write obj to path specified
     * @param path path to write obj
     * @param obj object to be written
     */
    //private static Object kryo = new Kryo();

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
        //long startTime = System.nanoTime();
        for (int i = 0; i < SharedVariable.numberOfTables; i++) {
            ArrayList<double[]> bHashVectors = new ArrayList<>();
            for (int j = 0; j < SharedVariable.numberOfHashes; j++) {
                bHashVectors.add(CosineHashFamily.generateGaussianVector());
            }
            SharedVariable.collectionOfTables.add(new hashData(bHashVectors,new MultiValueMap()));
        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println(duration/1000000);
//        long hashTime = 0;
//        long toGrayTime = 0;
        /*
         * Read all images files from folder
         * hash each images and put them into the table;
         */
        File folder = new File(args[0]);
        //File image;
        File[] fileList = folder.listFiles();
        double[] imageVector;
        String image_Index = "";

        for (File image: fileList){
            if (image.getName().endsWith(".jpg") || image.getName().endsWith(".png")){
                //System.out.println(filename);
                //image = new File(a.getAbsolutePath());
                //long startGray = System.nanoTime();
                imageVector = img2vec.img2vec(image);
                //long endGray = System.nanoTime();
                //toGrayTime += endGray - startGray;
                for(hashData a: SharedVariable.collectionOfTables){
                    for (double[] r:a.getbHashVectors()) {
                        //long startHash = System.nanoTime();
                        image_Index += CosineHashFamily.hash(imageVector,r);
                        //long endHash = System.nanoTime();
                        //hashTime += endHash - startHash;
                    }
                    //System.out.println("image is " + image_Index);
                    a.getM().put(image_Index, image);
                    image_Index = "";
                }
            }
        }

        writeOutObjects(args[1],SharedVariable.collectionOfTables);

        System.out.println("Build done");
    }

}
