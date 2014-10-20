package com.hawk.apche.excel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
  
  
  
public class Test {  
  
    public static void main(String[] args) throws ParseException {  
          
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
        PlatformDetail platformDetail=new PlatformDetail();  
        List<ProductDetailTab> tabs=platformDetail.getProductDetailTabs();  
        ProductDetailTab tab=new ProductDetailTab();  
        tab.setInvestSum(96800.00);  
        tab.setInvestCycle(7);  
        tab.setAnnualYield(5.45);     
        tab.setInterestSum(1012323.11);  
          
          
        ProductDetailItem item=new ProductDetailItem();  
        item.setInvestorName("唐一娟");  
        item.setInvestment(123200.00);  
        item.setBuyDate(sdf.parse("2014/9/28"));  
        item.setLoansDate(sdf.parse("2014/9/28"));  
        item.setRepayDate(sdf.parse("2014/9/28"));  
        item.setInterestDays(7);  
        item.setInterest(12121210.10);  
        item.setRemark("我是备注");  
        tab.getDatas().add(item);  
        tab.getDatas().add(item);  
        tab.getDatas().add(item);  
        tab.getDatas().add(item);  
          
        tabs.add(tab);  
        tabs.add(tab);  
          
        PlatformDetailXlsCreator creator=new PlatformDetailXlsCreator(platformDetail);  
        try {  
            creator.write("./platformDetail.xls");  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
  
}  
