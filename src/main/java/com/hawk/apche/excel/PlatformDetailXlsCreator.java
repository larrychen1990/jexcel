package com.hawk.apche.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
  
public class PlatformDetailXlsCreator {  
  
    private HSSFWorkbook wb;  
	private PlatformDetail pfd;  
    private CellStyle alignCenter;  
    private CellStyle alignRight;     
    private CellStyle dateStyle;  
    private CellStyle topBorder;      
    private CellStyle totalTopBorder;  
    private CellStyle money;      
      
    public PlatformDetailXlsCreator(PlatformDetail pfd){  
           
        this.wb= new HSSFWorkbook();  
        this.pfd=pfd;  
          
        alignCenter=wb.createCellStyle();//居中对齐的样式  
        alignCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中对齐的样式  
        alignRight=wb.createCellStyle();  
        alignRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);  
        dateStyle=wb.createCellStyle();  
        HSSFDataFormat format = wb.createDataFormat();    
        dateStyle.setDataFormat(format.getFormat("yyyy/MM/dd"));  
        dateStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);  
        topBorder=wb.createCellStyle();  
        topBorder.setBorderTop(HSSFCellStyle.BORDER_THICK);  
        totalTopBorder=wb.createCellStyle();  
        totalTopBorder.setBorderTop(HSSFCellStyle.BORDER_THICK);  
        totalTopBorder.setAlignment(HSSFCellStyle.ALIGN_RIGHT);  
        totalTopBorder.setDataFormat(format.getFormat("#,##0.00"));  
        money=wb.createCellStyle();  
        money.setDataFormat(format.getFormat("#,##0.00"));  
        money.setAlignment(HSSFCellStyle.ALIGN_RIGHT);  
        init();  
          
    }  
      
    public void init(){  
          
          
          
        HSSFSheet sheet1 = wb.createSheet("产品明细");        
        createSheet1(sheet1);  
          
    }  
      
    public void write(String path) throws IOException{  
        File outPutFile=new File(path);  
        if(!outPutFile.exists()){  
            outPutFile.createNewFile();  
        }  
          
        FileOutputStream os = new FileOutputStream(outPutFile);    
        wb.write(os);    
        os.close();   
    }  
    //sheet1  
    private void createSheet1(HSSFSheet sheet){  
          
        sheet.setDefaultColumnWidth(12);  
        int totalrow=0;  
        List<ProductDetailTab> tabs=pfd.getProductDetailTabs();  
        List<String> heads= tabs.get(0).getHeads();         
          
        //写表头  
        sheet.createFreezePane(0, 1);  
        HSSFRow row0 = sheet.createRow(0);   
        for(int i=0;i<heads.size();i++){  
             Cell cell= row0.createCell(i);  
             cell.setCellValue(heads.get(i));  
            cell.setCellStyle(alignCenter);  
               
        }  
        totalrow++;  
          
        //写数据  
        for(int i=0;i<tabs.size();i++){  
              
            ProductDetailTab tab=tabs.get(i);             
              
            for(int i1=0;i1<tab.getDatas().size();i1++)  
            {                 
                ProductDetailItem item=tab.getDatas().get(i1);  
                HSSFRow row=sheet.createRow(totalrow);  
                totalrow++;  
                if(i1==0){  
                    //总额  
                    Cell cell_0 = row.createCell(0);  
                    cell_0.setCellValue(tab.getInvestSum());  
                    cell_0.setCellStyle(alignCenter);  
                    //投资周期（天）  
                    Cell cell_1=row.createCell(1);  
                    cell_1.setCellValue(tab.getInvestCycle()+"天");  
                    cell_1.setCellStyle(alignCenter);  
                    //年化收益率（%）  
                    Cell cell_2=row.createCell(2);  
                    cell_2.setCellValue(tab.getAnnualYield()+"%");  
                    cell_2.setCellStyle(alignCenter);  
                }  
                  
                Cell cell_3=row.createCell(3);  
                cell_3.setCellValue(item.getInvestorName());  
                cell_3.setCellStyle(alignCenter);  
                  
                Cell cell_4=row.createCell(4);  
                cell_4.setCellValue(item.getInvestment());  
                cell_4.setCellStyle(money);  
                  
                Cell cell_5=row.createCell(5);  
                cell_5.setCellValue(item.getBuyDate());  
                cell_5.setCellStyle(dateStyle);  
                  
                Cell cell_6=row.createCell(6);  
                cell_6.setCellValue(item.getLoansDate());  
                cell_6.setCellStyle(dateStyle);  
                  
                Cell cell_7=row.createCell(7);  
                cell_7.setCellValue(item.getRepayDate());  
                cell_7.setCellStyle(dateStyle);  
                  
                Cell cell_8=row.createCell(8);  
                cell_8.setCellValue(item.getInterestDays());  
                cell_8.setCellStyle(alignRight);  
                  
                Cell cell_9=row.createCell(9);  
                cell_9.setCellValue(item.getInterest());  
                cell_9.setCellStyle(money);  
                  
                Cell cell_10=row.createCell(10);  
                cell_10.setCellValue(item.getRemark());   
                  
            }  
            HSSFRow row=sheet.createRow(totalrow);  
            totalrow++;       
              
            Cell total4 =row.createCell(4);  
            total4.setCellValue(tab.getInterestSum());  
            total4.setCellStyle(totalTopBorder);  
              
            Cell total5=row.createCell(9);  
            total5.setCellValue(tab.getInvestSum());  
            total5.setCellStyle(totalTopBorder);              
              
            row.setRowStyle(topBorder);  
              
            row=sheet.createRow(totalrow);  
            totalrow++;  
              
//          for(int i1=0;i1<heads.size();i1++){  
//              Cell cell=row.createCell(i1);  
//              cell.setCellStyle(bottomBorder);  
//                
//          }  
              
        }      
          
         
    }  
}  
