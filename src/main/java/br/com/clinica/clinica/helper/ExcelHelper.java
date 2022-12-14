package br.com.clinica.clinica.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import br.com.clinica.clinica.entity.ExcelEntity;

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = {"id","Title", "Description", "Published" };
  static String SHEET = "excels";
  public static boolean hasExcelFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }
  public static List<ExcelEntity> excelToTutorials(InputStream is) {
    try {
      XSSFWorkbook workbook = new XSSFWorkbook(is);
      XSSFSheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();
      List<ExcelEntity> excels = new ArrayList<ExcelEntity>();
      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();
        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }
        Iterator<Cell> cellsInRow = currentRow.iterator();
        ExcelEntity excel = new ExcelEntity();
        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();
          switch (cellIdx) {
          case 0:
          excel.setId((long) currentCell.getNumericCellValue());
            break;
          case 1:
          excel.setTitle(currentCell.getStringCellValue());
            break;
          case 2:
          excel.setDescription(currentCell.getStringCellValue());
            break;
          case 3:
          excel.setPublished(currentCell.getBooleanCellValue());
            break;
          default:
            break;
          }
          cellIdx++;
        }
        excels.add(excel);
      }
      workbook.close();
      return excels;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
