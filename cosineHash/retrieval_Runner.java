import java.io.*;
import java.util.ArrayList;

public class retrieval_Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File input_Image = new File(args[0]);

        FileInputStream fileIn = new FileInputStream(args[1]);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<hashData> collectionOfHashTables = (ArrayList<hashData>)in.readObject();
        fileIn.close();
        in.close();

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
        ArrayList<String> similar = new ArrayList<>();
        ArrayList<File> collectionOfFiles;
        int i = 0;
        for (String ind : collectionOfIndex) {
            for (hashData tmp : collectionOfHashTables) {
                collectionOfFiles = (ArrayList<File>) (tmp.getM().get(ind));
                if (collectionOfFiles != null) {
                    for (File f : collectionOfFiles) {
                        if (!similar.contains(f.getName()) && (doubleC.similarityCheck(f,input_Image))) {
                            similar.add(f.getName());
                            System.out.println(f.getName());
                        }
                    }

                }
            }
        }
    }
}
