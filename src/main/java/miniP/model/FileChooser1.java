/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniP.model;

/**
 *
 * @author mefta
 */
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
public class FileChooser1 {
    
  public static String selectFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        File se=null;
        // int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            se = jfc.getSelectedFile();  
        }
        return se.getAbsolutePath();
    }

}  







  