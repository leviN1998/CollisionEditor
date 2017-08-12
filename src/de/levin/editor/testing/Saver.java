package de.levin.editor.testing;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

/**
 * Created by levin on 09.08.2017.
 */
public class Saver implements Runnable{

    private JFileChooser fc;
    private FileNameExtensionFilter filter;
    private String toSave;
    private boolean finished;
    private Thread thread;

    public Saver(FileNameExtensionFilter filter, String toSave){
        this.filter = filter;
        this.toSave = toSave;
        this.finished = false;
    }

    public boolean isFinished(){
        return finished;
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run(){
        fc = new JFileChooser("C:\\Users");
        fc.setFileFilter(filter);
        int state = fc.showSaveDialog(null);
        if (state == JFileChooser.APPROVE_OPTION){
            try {
                IOUtils.writeToFile(toSave, fc.getSelectedFile().getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("abgebrochen");
        }
        finished = true;
    }

}
