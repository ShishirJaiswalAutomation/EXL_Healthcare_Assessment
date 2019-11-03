package com.exlhealthcare.qa.util;

import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.exlhealthcare.qa.base.TestBase;
import com.google.common.io.Files;

public class Utilities extends TestBase{
	
	private final String scrPath = userDirectory + "/Screenshots/";

	public void writeDataToTextFile(HashMap<String, String> map, String filePath) {

		try {

			Writer writer = null;
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}

			writer = new FileWriter(filePath);
			BufferedWriter br = new BufferedWriter(writer);

			for (Map.Entry<String, String> m : map.entrySet()) {
				br.write(m.getKey() + "=" + m.getValue());
				br.newLine();
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitforPageToLoad(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void takeScreenshot(String fileName) {
		try {
			String screenshotPath = userDirectory + "Screenshots\\";
			java.util.Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file, new File(screenshotPath + fileName + "_" + dateFormat.format(now) + ".jpg"));
		} catch (Exception e) {
//			logInfo("Unable to take screenshot");
		}
	}
}
