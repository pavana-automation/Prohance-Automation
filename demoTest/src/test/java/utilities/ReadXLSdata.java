package utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Method;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.Set;
import java.util.TreeSet;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;

import test.BaseTest;
import test.Login;

public class ReadXLSdata extends BaseTest {

	Login log = new Login();
	WebDriver driver;
	List<String> excelDataList = new ArrayList<String>();

	public ReadXLSdata(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getDataFromExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);

		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int totalColumn = sheetName.getRow(i).getLastCellNum();
			for (int j = 0; j < totalColumn; j++) {

				if (sheetName.getRow(i).getCell(j).getCellType() == CellType.STRING) {

					excelDataList.add(sheetName.getRow(i).getCell(j).getStringCellValue());
				} else {
					double cellData = (int) sheetName.getRow(i).getCell(j).getNumericCellValue();
					excelDataList.add(String.valueOf(cellData));
				}
			}
		}
		return excelDataList;
	}
	
	public String getPDFData() throws IOException, InterruptedException{
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);	
		String content = new PDFTextStripper().getText(document);
		document.close();
		return content;
	}

	public String getRecentFilePath() {
		File mostRecent = null;

		String downloadDirectory = System.getProperty("user.home") + "/Downloads";

		Path parentFolder = Paths.get(downloadDirectory);

		Optional<File> mostRecentFileOrFolder = Arrays.stream(parentFolder.toFile().listFiles())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
		Optional<File> mostRecentFile = Arrays.stream(parentFolder.toFile().listFiles()).filter(f -> f.isFile())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
		Optional<File> mostRecentFolder = Arrays.stream(parentFolder.toFile().listFiles()).filter(f -> f.isDirectory())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

		if (mostRecentFolder.isPresent()) {
			mostRecent = mostRecentFileOrFolder.get();
			System.out.println("downloaded file:"+mostRecent);
			return mostRecent.getPath();
		} else {

			return "folder is empty!";
		}
	}
	public List<String> getData() throws EncryptedDocumentException, IOException,
	  InterruptedException { Thread.sleep(2000); File f = new
	  File(getRecentFilePath()); FileInputStream fis = new FileInputStream(f);
	  Workbook wb = WorkbookFactory.create(fis); Sheet sheetName =
	  wb.getSheetAt(0); List<String> excelDataList = new ArrayList(); int totalRows
	  = sheetName.getLastRowNum(); System.out.println("row" +totalRows); for(int
	  i=2;i<=totalRows;i++){ int cellcount=sheetName.getRow(i).getLastCellNum();
	  for(int j=0;j<cellcount-2;j++){ excelDataList.add(
	  sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll(
	  "\\s+","")); } } System.out.print(excelDataList); return excelDataList; }
	 
	public Set<String> getAllWorkProfilesConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 =  new TreeSet();
		int totalRows = sheetName.getLastRowNum();
		System.out.println("row" +totalRows);
		
		
		for(int i=5;i<=totalRows;i++){
            int cellcount=sheetName.getRow(i).getLastCellNum();   
           // System.out.println("cellcount"+cellcount);
            for(int j=1;j<cellcount-7;j++){
            	// System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
                excelDataList1.add( sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+",""));
            }
        }
		
		
		System.out.print("list"+excelDataList1);
		return excelDataList1;
	}
	public Set<String> getAllUsers() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		//Workbook wb = new XSSFWorkbook(fis);
		Workbook wb = new HSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 =  new TreeSet();
		int totalRows = sheetName.getLastRowNum()-sheetName.getFirstRowNum();
		System.out.println("row :" +totalRows);
		try {
		for(int i=3;i<totalRows;i++){
			sheetName.getRow(3).getCell(1).setCellValue("MOD");
			
			sheetName.getRow(3).getCell(3).setCellValue("xxxxxx");
			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
	        fileOut.flush();
	        fileOut.close();
            //int cellcount=sheetName.getRow(i).getLastCellNum();   
            
          //  System.out.println("cellcount"+cellcount);
           // for(int j=3;j<cellcount;j++){
            	//if(sheetName.getRow(i).getCell(28).getStringCellValue().toString().equals("")) {
            	//	if(sheetName.getRow(i).getCell(30).getStringCellValue().toString().equals("")) {
            			System.out.println(sheetName.getRow(i).getCell(1).getStringCellValue().toString());
            			System.out.println(i);
            		//}
            	//}
                //excelDataList1.add( sheetName.getRow(i).getCell(j).getStringCellValue().toString());
                
               // System.out.print("\n");
            //}
           // System.out.print("\n");

        }}catch(Exception e) {
     
        	
        	
        	
        	System.out.println();
        }
		
		
		
		return excelDataList1;
	}
	
	public String getPDFdata() throws IOException
	{
		String path = "C:\\Users\\dipankar.d\\Downloads\\Work Profiles.pdf";
		URL pdfUrl = new URL("file:///" +path);
	    InputStream in = pdfUrl.openStream();
	    BufferedInputStream bf = new BufferedInputStream(in);
	    PDDocument doc = PDDocument.load(bf);
	    int numberOfPages = doc.getNumberOfPages();
	    System.out.println("The total number of pages "+numberOfPages);
	    String content = new PDFTextStripper().getText(doc);
	    System.out.println("The total number of pages "+content);
	    doc.close();

	    return content;
	}
	}