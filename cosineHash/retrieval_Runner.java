import java.io.*;
import java.util.ArrayList;

public class retrieval_Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //long startTime = System.nanoTime();
        File input_Image = new File(args[0]);

        FileInputStream fileIn = new FileInputStream(args[1]);
        BufferedInputStream buf = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(buf);
        ArrayList<hashData> collectionOfHashTables = (ArrayList<hashData>)in.readObject();
        fileIn.close();
        in.close();
        //long endTime = System.nanoTime();
        //long duration = (endTime - startTime);
        //System.out.println(duration/1000000);
        ArrayList<String> collectionOfIndex = new ArrayList<>();
        String index = "";
        double []imageVector = img2vec.img2vec(input_Image);
        for (hashData tmp : collectionOfHashTables){
            for (double[] r: tmp.getbHashVectors()){
                index += CosineHashFamily.hash(imageVector,r);
            }
            collectionOfIndex.add(index);
            index = "";
        }
//        long endTime2 = System.nanoTime();
//        long duration2 = (endTime2 - startTime);
//        System.out.println(duration2/1000000);
        ArrayList<String> similar = new ArrayList<>();
        ArrayList<File> collectionOfFiles;
        int max = 0;
        String maxFile = "";
        for (String ind : collectionOfIndex) {
            for (hashData tmp : collectionOfHashTables) {
                collectionOfFiles = (ArrayList<File>) (tmp.getM().get(ind));
                if (collectionOfFiles != null) {
                    for (File f : collectionOfFiles) {
//                        int sim = doubleC.similarityCheck(input_Image,f);
                        if (!similar.contains(f.getName())) {
                            int sim = doubleC.similarityCheck(input_Image,f);
                            if (sim != 0) {
                                similar.add(f.getName());
//                                System.out.println(f.getName());
                                if (sim > max) {
                                    max = sim;
                                    maxFile = f.getName();
                                }
                            }
                        }
                    }

                }
            }
        }
//        long endTime3 = System.nanoTime();
//        long duration3 = (endTime3 - startTime);
//        System.out.println(duration3/1000000);
            System.out.println(maxFile);
    }
}
