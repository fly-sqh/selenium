package Packing;

import net.bytebuddy.pool.TypePool;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;


import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    final static LoggerControler log = LoggerControler.getLog(ExcelUtil.class);
    private static HSSFWorkbook workbook = null;

    //保存excel文件
    public static void savefile(String filepath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //判断sheet是否存在
    public static boolean sheetexist(String filepath, String sheetname) {
        boolean flag = false;
        File file = new File(filepath);
        if (file.exists()) {
            try {
                workbook = new HSSFWorkbook(new FileInputStream(file));
                HSSFSheet sheet = workbook.getSheet(sheetname);
                if (sheet != null) {
                    flag = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!file.exists()) {
            flag = false;
        }
        return flag;
    }

    //创建一个excel文件，并新建对应内容的sheet
    public static void CreateFile(String filepath, String sheetname, String titleraw[]) {
        if (filepath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetname);
            FileOutputStream fileoutputStream = null;
            Row row = workbook.getSheet(sheetname).createRow(0);
            for (int i = 0; i < titleraw.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(titleraw[i]);
            }
            ExcelUtil.savefile(filepath);
        }
    }

    //单纯的判断文件是否存在，不存在就创建一个
    public static void CreatExcel(String filepath) {
        if (filepath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
            Sheet sheet1 = workbook.createSheet("sheet1");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(filepath);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //向一个excel文件添加数据（如果没有该excel就创建一个），指定几组数据，向文件中插入数据
    public static void WriteInfoToExcel(String filepath, String sheetname, List<List<String>> infos) {
        if (MyFile.FileExists(filepath) == false) {
            ExcelUtil.CreatExcel(filepath);
        }
        workbook = new HSSFWorkbook();
        Sheet sheet = null;
        try {
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            sheet = workbook.createSheet(sheetname);
        }
        for (int i = 0; i < infos.size(); i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < infos.get(i).size(); j++) {
                Cell cell = row.createCell(j, CellType.STRING);
                cell.setCellValue(infos.get(i).get(j));
            }
            ExcelUtil.savefile(filepath);
        }
    }

    //从指定列开始插入数据
    public static void WriteInfoToExcelByRow(String filepath, String sheetname, int row, List<List<String>> infos) {
        if (MyFile.FileExists(filepath) == false) {
            ExcelUtil.CreatExcel(filepath);
        }
        workbook = new HSSFWorkbook();
        Sheet sheet = null;
        try {
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            sheet = workbook.createSheet(sheetname);
        }
        for (int i = 0; i < infos.size(); i++) {
            Row row1 = sheet.createRow(row - 1);
            for (int j = 0; j < infos.get(i).size(); j++) {
                Cell cell = row1.createCell(j, CellType.STRING);
                cell.setCellValue(infos.get(j).get(j));
            }
            ExcelUtil.savefile(filepath);
        }
    }

    //在指定列插入数据
    public static void WriteInfoToExcelByCell(String filepath, String sheetname, int cell, List<String> infos) {
        if (MyFile.FileExists(filepath) == false) {
            ExcelUtil.CreatExcel(filepath);
        }
        workbook = new HSSFWorkbook();
        Sheet sheet = null;
        try {
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            sheet = workbook.createSheet(sheetname);
        }
        for (int i = 0; i < infos.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell1 = row.createCell(cell - 1);
            cell1.setCellValue(infos.get(i));
        }
        ExcelUtil.savefile(filepath);
    }

    //读取excel文件数据
    public static List<List<Row>> readExcels(String filepath) {
        File file = new File(filepath);
        try {
            workbook = new HSSFWorkbook(new FileInputStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int sheetNum = workbook.getNumberOfSheets();
        List<List<Row>> rowlist = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        return rowlist;
    }

    public static List readFromExcel(String filePath, String sheetName, Object object) {
        //创建workbook
        File file = new File(filePath);
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List result = new ArrayList();
        // 获取该对象的class对象
        Class class_ = object.getClass();
        // 获得该类的所有属性
        Field[] fields = class_.getDeclaredFields();
        // 读取excel数据
        // 获得指定的excel表
        HSSFSheet sheet = workbook.getSheet(sheetName);
        // 获取表格的总行数
        int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        System.out.println("rowCount:" + rowCount);
        if (rowCount < 1) {
            return result;
        }
        // 获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();
        // 读取表头信息,确定需要用的方法名---set方法
        // 用于存储方法名
        String[] methodNames = new String[columnCount]; // 表头列数即为需要的set方法个数
        // 用于存储属性类型
        String[] fieldTypes = new String[columnCount];
        // 获得表头行对象
        HSSFRow titleRow = sheet.getRow(0);
        // 遍历
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) { // 遍历表头列
            String data = titleRow.getCell(columnIndex).toString(); // 某一列的内容
            String Udata = Character.toUpperCase(data.charAt(0))
                    + data.substring(1, data.length()); // 使其首字母大写
            methodNames[columnIndex] = "set" + Udata;
            for (int i = 0; i < fields.length; i++) { // 遍历属性数组
                if (data.equals(fields[i].getName())) { // 属性与表头相等
                    fieldTypes[columnIndex] = fields[i].getType().getName(); // 将属性类型放到数组中
                }
            }
        }
        // 逐行读取数据 从1开始 忽略表头
        for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
            // 获得行对象
            HSSFRow row = sheet.getRow(rowIndex);
            if (row != null) {
                Object obj = null;
                // 实例化该泛型类的对象一个对象
                try {
                    obj = class_.newInstance();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                // 获得本行中各单元格中的数据
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                    String data = row.getCell(columnIndex).toString();
                    // 获取要调用方法的方法名
                    String methodName = methodNames[columnIndex];
                    Method method = null;
                    try {
                        // 这部分可自己扩展
                        if (fieldTypes[columnIndex].equals("java.lang.String")) {
                            method = class_.getDeclaredMethod(methodName,
                                    String.class); // 设置要执行的方法--set方法参数为String
                            method.invoke(obj, data); // 执行该方法
                        } else if (fieldTypes[columnIndex].equals("int")) {
                            method = class_.getDeclaredMethod(methodName,
                                    int.class); // 设置要执行的方法--set方法参数为int
                            double data_double = Double.parseDouble(data);
                            int data_int = (int) data_double;
                            method.invoke(obj, data_int); // 执行该方法
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                result.add(obj);
            }
        }
        return result;

    }

}

