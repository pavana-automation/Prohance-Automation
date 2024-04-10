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

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.EncryptedDocumentException;

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

	public String getPDFData() throws IOException, InterruptedException {
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
			// System.out.println("downloaded file:"+mostRecent);
			return mostRecent.getPath();
		} else {

			return "folder is empty!";
		}
	}

	public List<String> getData() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		System.out.println("row" + totalRows);
		for (int i = 2; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount - 2; j++) {
				excelDataList
						.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.print(excelDataList);
		return excelDataList;
	}

	public Set<String> getAllWorkProfilesConfig() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum();
		System.out.println("row" + totalRows);

		for (int i = 5; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			// System.out.println("cellcount"+cellcount);
			for (int j = 1; j < cellcount - 7; j++) {
				// System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1
						.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.print("list" + excelDataList1);
		return excelDataList1;
	}

	public Set<String> getActiveUsers() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		System.out.println("row :" + totalRows);
		String login = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		newRow.createCell(1).setCellValue("ADD");
		newRow.createCell(3).setCellValue(login);
		newRow.createCell(4).setCellValue("SYSTEM");
		newRow.createCell(5).setCellValue(login);
		newRow.createCell(6).setCellValue("NATIVE");
		Thread.sleep(1000);
		newRow.createCell(7).setCellValue("Aishwarya_krihnan");
		Thread.sleep(1000);
		newRow.createCell(23).setCellValue("Team Member");
		Thread.sleep(1000);
		newRow.createCell(26).setCellValue("India Standard Time");
		newRow.createCell(29).setCellValue("Teams");
		newRow.createCell(30).setCellValue("Implementation Team");
		String loginId = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		sheetName.getRow(7).getCell(1).setCellValue("MOD");
		System.out.println("MOd");
		sheetName.getRow(7).getCell(3).setCellValue(loginId);
		sheetName.getRow(10).getCell(1).setCellValue("DEL");
		try {
			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

			// }
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getInactiveUsers() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("inactive users");
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		System.out.println("row :" + totalRows);
		String login = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		newRow.createCell(1).setCellValue("ADD");
		newRow.createCell(3).setCellValue(login);
		newRow.createCell(4).setCellValue("SYSTEM");
		newRow.createCell(5).setCellValue(login);
		newRow.createCell(6).setCellValue("NATIVE");
		Thread.sleep(1000);
		newRow.createCell(7).setCellValue("Aishwarya_krihnan");
		Thread.sleep(1000);
		newRow.createCell(23).setCellValue("Team Member");
		Thread.sleep(1000);
		newRow.createCell(26).setCellValue("India Standard Time");
		newRow.createCell(29).setCellValue("Teams");
		newRow.createCell(30).setCellValue("Implementation Team");
		String loginId = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		sheetName.getRow(3).getCell(1).setCellValue("MOD");
		System.out.println("MOd");
		sheetName.getRow(3).getCell(3).setCellValue(loginId);
		sheetName.getRow(10).getCell(1).setCellValue("DEL");

		try {
			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			Thread.sleep(2000);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getAllUsers() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		String login = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		newRow.createCell(1).setCellValue("ADD");
		for (int j = 0; j < row.getLastCellNum(); j++) {
			newRow.createCell(3).setCellValue(login);
			newRow.createCell(4).setCellValue("SYSTEM");
			newRow.createCell(5).setCellValue(login);
			newRow.createCell(6).setCellValue("NATIVE");
			Thread.sleep(1000);
			newRow.createCell(7).setCellValue("Aishwarya_krihnan");
			Thread.sleep(1000);
			newRow.createCell(23).setCellValue("Team Member");
			Thread.sleep(1000);
			newRow.createCell(26).setCellValue("India Standard Time");
			newRow.createCell(29).setCellValue("Teams");
			newRow.createCell(30).setCellValue("Implementation Team");
			System.out.println(j);
		}

		String loginId = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		sheetName.getRow(8).getCell(1).setCellValue("MOD");
		System.out.println("MOd");
		sheetName.getRow(8).getCell(3).setCellValue(loginId);
		sheetName.getRow(12).getCell(1).setCellValue("DEL");
		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

			// }
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getActiveUsersWithMissingFields()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		String login = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		newRow.createCell(1).setCellValue("ADD");
		// newRow.createCell(3).setCellValue(login);
		newRow.createCell(4).setCellValue("SYSTEM");
		newRow.createCell(5).setCellValue(login);
		newRow.createCell(6).setCellValue("NATIVE");
		Thread.sleep(1000);
		newRow.createCell(7).setCellValue("Aishwarya_krihnan");
		Thread.sleep(1000);
		newRow.createCell(23).setCellValue("Team Member");
		Thread.sleep(1000);
		newRow.createCell(26).setCellValue("India Standard Time");
		newRow.createCell(29).setCellValue("Teams");
		newRow.createCell(30).setCellValue("Implementation Team");

		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

			// }
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getInactiveUsersWithMissingFields()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		String login = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		newRow.createCell(1).setCellValue("ADD");
		newRow.createCell(3).setCellValue(login);
		newRow.createCell(4).setCellValue("SYSTEM");
		newRow.createCell(5).setCellValue(login);
		newRow.createCell(6).setCellValue("NATIVE");
		Thread.sleep(1000);
		newRow.createCell(7).setCellValue("Aishwarya_krihnan");
		Thread.sleep(1000);
		newRow.createCell(23).setCellValue("Team Member");
		Thread.sleep(1000);
		newRow.createCell(26).setCellValue("India Standard Time");
		newRow.createCell(29).setCellValue("Teams");
		/// newRow.createCell(31).setCellValue("Implementation Team");

		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

			// }
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getAllUsersWithMissingFields()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		String login = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		newRow.createCell(1).setCellValue("ADD");
		newRow.createCell(3).setCellValue(login);
		newRow.createCell(4).setCellValue("SYSTEM");
		newRow.createCell(5).setCellValue(login);
		newRow.createCell(6).setCellValue("NATIVE");
		Thread.sleep(1000);
		newRow.createCell(7).setCellValue("Aishwarya_krihnan");
		Thread.sleep(1000);
		newRow.createCell(23).setCellValue("Team Member");
		Thread.sleep(1000);
		newRow.createCell(26).setCellValue("India Standard Time");
		newRow.createCell(29).setCellValue("Teams");
		/// newRow.createCell(31).setCellValue("Implementation Team");

		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

			// }
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getUserLicenceList() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum();
		System.out.println("row" + totalRows);

		for (int i = 7; i <= totalRows; i++) {
			// System.out.println("cellcount"+i);
			int cellcount = sheetName.getRow(i).getLastCellNum();
			// System.out.println("cellcount"+cellcount);
			for (int j = 1; j < 2; j++) {
				// System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1
						.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.print("list" + excelDataList1);
		return excelDataList1;
	}

	public String getPDFdata() throws IOException {
		String path = "C:\\Users\\dipankar.d\\Downloads\\Work Profiles.pdf";
		URL pdfUrl = new URL("file:///" + path);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int numberOfPages = doc.getNumberOfPages();
		System.out.println("The total number of pages " + numberOfPages);
		String content = new PDFTextStripper().getText(doc);
		System.out.println("The total number of pages " + content);
		doc.close();

		return content;
	}

	public String getLicenceListPDFData() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document);
		System.out.println(content);
		document.close();
		return content;
	}

	
	public List<String> getByHearBeatEcxel() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		System.out.println("row" + totalRows);

		for (int i = 4; i <= totalRows; i++) {
			// System.out.println("cellcount"+i);
			int cellcount = sheetName.getRow(i).getLastCellNum();
			// System.out.println("cellcount"+cellcount);
			for (int j = 1; j < 2; j++) {
				// System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1
						.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.print(excelDataList1);
		return excelDataList1;
	}

	public String getHostNameListPDFData() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document).replaceAll("\\s+", "");
		// System.out.print(content.replaceAll("\\s+", ""));
		document.close();
		return content;
	}

	public List<String> getUsersExcelList() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		for (int i = 4; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 2; j < cellcount - 6; j++) {
				// System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1
						.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.println(excelDataList1);
		return excelDataList1;
	}

	public String getListPDFData() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document).replaceAll("\\s+", "");
		System.out.print(content.replaceAll("\\s+", ""));
		document.close();
		return content;
	}

	
	public Set<String> getCustomAttributeAddModifyAndDelete()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);

		newRow.createCell(0).setCellValue("ADD");
		newRow.createCell(3).setCellValue("aa1au");
		newRow.createCell(4).setCellValue("Text Box");
		newRow.createCell(5).setCellValue("5");
		newRow.createCell(6).setCellValue("Alpha-Numeric");
		newRow.createCell(17).setCellValue("Yes");
		newRow.createCell(18).setCellValue("Yes");
		newRow.createCell(19).setCellValue("No");

		// modify
		sheetName.getRow(17).getCell(0).setCellValue("MOD");
		System.out.println("MOd");
		sheetName.getRow(17).getCell(5).setCellValue("13");
		sheetName.getRow(5).getCell(0).setCellValue("DEL");

		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

			// }
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}
	public Set<String> getCustomAttributeWithModifyFieldtype()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);

	
		sheetName.getRow(5).getCell(0).setCellValue("MOD");
		System.out.println("MOd");
		sheetName.getRow(5).getCell(4).setCellValue("Radio Button");

		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} 
        
	catch(Exception e) {
        	
        	System.out.println();
        }
		
		return excelDataList1;
	}

	
	public Set<String> getCustomAttributeWithDeleteWithDependency()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		sheetName.getRow(4).getCell(0).setCellValue("DEL");
	
		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	
	public Set<String> getCustomAttributeWithMissingFields()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		newRow.createCell(0).setCellValue("ADD");
		newRow.createCell(3).setCellValue("aabcbaaTest2");
		newRow.createCell(4).setCellValue("Text Box");
		//newRow.createCell(5).setCellValue("5");
		newRow.createCell(6).setCellValue("Alpha-Numeric");
		newRow.createCell(17).setCellValue("Yes");
		newRow.createCell(18).setCellValue("Yes");
		newRow.createCell(19).setCellValue("No");
	
		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}
	public Set<String> getCustomAttributeWithDuplicateName()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		newRow.createCell(0).setCellValue("ADD");
		newRow.createCell(3).setCellValue("#Parent_01");
		newRow.createCell(4).setCellValue("Text Box");
		newRow.createCell(5).setCellValue("5");
		newRow.createCell(6).setCellValue("Alpha-Numeric");
		newRow.createCell(17).setCellValue("Yes");
		newRow.createCell(18).setCellValue("Yes");
		newRow.createCell(19).setCellValue("No");
	
		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}
	public List<String> getFilterByProcess() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 3; j < cellcount - 16; j++) {
				//System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.println(excelDataList1);
		return excelDataList1;
	}

	public List<String> getWorkStationExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount - 4; j++) {
				//System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.println(excelDataList1);
		return excelDataList1;
	}
	
	public String getWorkStationPDF() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document);
		System.out.print(content.replaceAll("\\s+", ""));
		document.close();
		return content;
	}
	
	public List<String> getSoftwareDefinitionExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount - 4; j++) {
				//System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.println(excelDataList1);
		return excelDataList1;
	}
	
	public String getSoftwareDefinitionPDF() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document).replaceAll("\\s+", "");
		System.out.print(content.replaceAll("\\s+", ""));
		document.close();
		return content;
	}
	
	public List<String> getSoftwareTagsExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 1; j < cellcount - 1; j++) {
				//System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.println(excelDataList1);
		return excelDataList1;
	}
	
	public String getSoftwareTagsPDF() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document).replaceAll("\\s+", "");
		System.out.print(content.replaceAll("\\s+", ""));
		document.close();
		return content;
	}
	
	public List<String> getHierarchyExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);
		List<String> excelDataList1 = new ArrayList();
		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int cellcount = sheetName.getRow(i).getLastCellNum();
			for (int j = 0; j < 1; j++) {
				//System.out.print(sheetName.getRow(i).getCell(j).getStringCellValue().toString());
				excelDataList1.add(sheetName.getRow(i).getCell(j).getStringCellValue().toString().replaceAll("\\s+", ""));
			}
		}
		System.out.println(excelDataList1);
		return excelDataList1;
	}
	
	public String gethierarchyPDF() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String content = new PDFTextStripper().getText(document).replaceAll("\\s+", "");
		System.out.print(content.replaceAll("\\s+", ""));
		document.close();
		return content;
	}
	
	public Set<String> getHierarchyMappingAddModifyAndDelete()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		newRow.createCell(0).setCellValue("ADD");
		newRow.createCell(3).setCellValue("Aishwarya_auto_test12");
		
		/*
		 * sheetName.getRow(17).getCell(0).setCellValue("MOD");
		 * System.out.println("MOd");
		 * sheetName.getRow(17).getCell(5).setCellValue("ENT");
		 * sheetName.getRow(41).getCell(0).setCellValue("DEL");
		 */
		
		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

	public Set<String> getHirearchyMappingModify()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheetAt(0);
		Set<String> excelDataList1 = new TreeSet();
		int totalRows = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		Row row = sheetName.getRow(0);
		Row newRow = sheetName.createRow(totalRows + 1);
		int newRowCount = 0;
		System.out.println("row :" + totalRows);
		
		
		  sheetName.getRow(4).getCell(0).setCellValue("MOD");
		  System.out.println("MOd");
		  sheetName.getRow(4).getCell(3).setCellValue("minchan.sdd1234");
		 
		 
		
		try {

			FileOutputStream fileOut = new FileOutputStream(f);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			System.out.println();
		}

		return excelDataList1;
	}

}

