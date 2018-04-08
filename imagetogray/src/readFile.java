/**
 * Created by gaocc on 2018/4/5.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.*;

public class readFile {
    public readFile() {
    }
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            File f = new File("/Users/gaocc/IdeaProjects/lsh/grayv/path.txt");
            OutputStream path = new FileOutputStream(f);
            OutputStreamWriter writer = new OutputStreamWriter(path, "UTF-8");
            if (!file.isDirectory()) {
                //System.out.println("document");
                //System.out.println("path=" + file.getPath());
                String p = file.getPath();
                writer.append(p);
                writer.append("\r\n");
                //System.out.println("absolutepath=" + file.getAbsolutePath());
                //System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                //System.out.println("file");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "/" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        //System.out.println("path=" + readfile.getPath());
                        String p = readfile.getPath();
                        writer.append(p);
                        writer.append("\r\n");
                        //System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        //System.out.println("name=" + readfile.getName());
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "/" + filelist[i]);
                    }
                }
                writer.close();
                path.close();

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()  Exception:" + e.getMessage());
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            readfile("/Users/gaocc/IdeaProjects/lsh/image");
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        //System.out.println("ok");
    }
}

// If use MAC OS there will be a document end with ".DS_Store", you need to delete it in the system.
// Open Terminal cd to the document directory and input ' find ./ -name ".DS_Store" -depth -exec rm {} \; ' then this file is removed.
// To forbid .DS_Store file generation, use ' defaults write com.apple.desktopservices DSDontWriteNetworkStores true '.