package qspiderdemoapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String fetchDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\eclipse workshop\\ddtandpom\\src\\main\\java\\propertyfile\\prop");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);	
	}
	
	public String fetchDataFromExcel(String name, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\eclipse workshop\\ddtandpom\\src\\main\\java\\TestData\\data.xlsx");
		String value=WorkbookFactory.create(fis).getSheet(name).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
		
	

}
