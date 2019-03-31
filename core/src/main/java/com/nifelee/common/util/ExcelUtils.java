package com.nifelee.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelUtils {

  public static String getStringCellValue(String key, XSSFCell cell) {
    if (cell == null)
      return StringUtils.isBlank(key) ? null : key;

    String result;
    if (cell.getCellType() == CellType.NUMERIC) {
      result = String.valueOf(cell.getNumericCellValue());
      result = StringUtils.removeEnd(result, ".0");
    } else if (cell.getCellType() == CellType.STRING) {
      result = cell.getStringCellValue();
    } else if (cell.getCellType() == CellType.FORMULA) {
      result = String.valueOf((int)cell.getNumericCellValue());
    } else if (cell.getCellType() == CellType.BOOLEAN) {
      result = String.valueOf(cell.getBooleanCellValue());
    } else {
      result = key;
    }
    return result;
  }

}

