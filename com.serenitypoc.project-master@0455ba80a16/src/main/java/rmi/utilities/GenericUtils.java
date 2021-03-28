package rmi.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class GenericUtils {
	
	public static String getDate_given_Format(){
		//String element = DA_PROJ_OR.LAST_SEARCH_TIME;
		String sExpectedTime = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		String[] words=sExpectedTime.split("\\s");
    	System.out.println("System Date-->:- "+words[0]);
    			
	    	String sExpectedDate = words[0];
	    	
	    		    	return sExpectedDate;
	}
	
	public static int generate_Random_Number_for_Given_Range(int range){
		Random rand = new Random(); 
		int value = rand.nextInt(range); 
		return value;
	}
	/*The idea is that 1 + nextInt(2) shall always give 1 or 2. 
	You then multiply it by 10000 to satisfy your requirement and then add a number between [0..9999].*/
	
	public static int GetRandomNumber() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	public static String decode(String value) throws Exception {
		byte[] decodedValue = null;
		try{
	     decodedValue = Base64.getDecoder().decode(value);	     
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return new String(decodedValue, StandardCharsets.UTF_8);
	  }

public static void attachDocument(String sFilePath){
		
		File sFile = new File(sFilePath);
		System.out.println("File Path:- "+sFile.getAbsolutePath());
		StringSelection stringSelection = new StringSelection(sFile.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot;
		try {
			robot = new Robot();
			SeleniumUtils.defaultWait(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}

public static  String GetName_From_DownloadedFile() throws IOException {

	try {

		System.out.println(System.getProperty("user.name"));
		String sUsername = System.getProperty("user.name");
		String sPath = "C:\\Users\\" + sUsername + "\\Downloads\\";
		String sFilename = null;
		File fl = new File(sPath);
		File[] files = fl.listFiles();
		
		Arrays.sort(files,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	    File lastmod = files[0];
		sFilename = lastmod.getName();	 
	    System.out.println("File_Name:"+sFilename);
	    return sFilename;
	    
	} catch (NullPointerException e) {
		System.out.println("Value not found");
		return null;
	}
	
	

}










}
