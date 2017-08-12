package de.levin.editor.testing;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by levin on 09.08.2017.
 */
public class Chooser implements Runnable{

    private File file;
    private JFileChooser fc;
    private FileNameExtensionFilter filter;
    private boolean finished;
    private Thread thread;

    public Chooser(FileNameExtensionFilter filter){
        this.filter = filter;
        this.finished = false;
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }


    public File getFile(){
        return file;
    }

    public boolean isFinished(){
        return finished;
    }

    @Override
    public void run() {
        fc = new JFileChooser();
        fc.setFileFilter(filter);
        int state = fc.showOpenDialog(null);
        if (state == JFileChooser.APPROVE_OPTION){
            file = fc.getSelectedFile();
        }else {
            System.out.println("abgebrochen");
        }
        finished = true;
    }
}
