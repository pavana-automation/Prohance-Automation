package test;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ApprovePermissionForfilesInBrowser extends JFrame
{
	
public String givePermissionToDownloadFromChromeBrowser() {
	
	
	  JFrame frame = new JFrame("My Application");
	 this.setSize(500, 400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JFileChooser fileChooser = new JFileChooser();

	    int returnVal = fileChooser.showOpenDialog(frame); 
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	      File selectedFile = fileChooser.getSelectedFile();
	      return selectedFile.getAbsolutePath();
	     
	    }

	    this.setVisible(true);
	    return null;
	  }
	
	
}
