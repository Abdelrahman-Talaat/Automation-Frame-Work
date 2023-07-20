package DataDriven;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Data_Driven_Json {
    public Object[][] readJsonData(String pathname,String sheetName) throws IOException, InvalidFormatException {
        File myFile=new File(/*"ExcelSheet/Data_Driven_Rest_Json.xlsx"*/pathname);
        XSSFWorkbook wb=new XSSFWorkbook(myFile);
        XSSFSheet sh=wb.getSheet(/*"Sheet1"*/sheetName);
        int rowCount=sh.getPhysicalNumberOfRows();
        int columnCount=sh.getRow(0).getPhysicalNumberOfCells();
       Object jsonData[][]=new String[rowCount-1][columnCount];
        for(int i=1;i<rowCount;i++){
            for (int j=0;j<columnCount;j++){
                XSSFRow row=sh.getRow(i);
                jsonData[i-1][j]=row.getCell(j).toString();
            }
        }
        return jsonData;
    }
}
