package de.levin.editor.testing;

import org.lwjgl.Sys;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by levin on 09.08.2017.
 */
public class ChooserTest {

    public static void main(String[] args){

        Chooser c = new Chooser(null);
        c.start();
        System.out.println("test");
        while (!c.isFinished()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = IOUtils.fileToString(c.getFile());
        System.out.println(IOUtils.splitByNewLine(s)[0]);

        Saver saver = new Saver(null, s);
        saver.start();
    }

}
