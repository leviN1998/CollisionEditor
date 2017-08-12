package de.levin.editor.testing;

import java.io.*;

/**
 * Created by levin on 09.08.2017.
 */
public class IOUtils {

    public static String fileToString(File f){
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String buffer = "";
            while ((buffer = reader.readLine()) != null) {
                result.append(buffer + '\n');
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Konnte den Shader nicht finden");
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String[] splitByNewLine(String s){
        return s.split("[\\r\\n]+");
    }

    public static void writeToFile(String text, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(text);
        if (null != writer){
            writer.close();
        }
    }

}
