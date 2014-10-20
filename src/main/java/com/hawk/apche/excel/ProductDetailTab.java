package com.hawk.apche.excel;

import java.util.ArrayList;
import java.util.List;
  
public class ProductDetailTab {  
  
    List<String> heads;  
    private Double investSum;  
    private Integer investCycle;  
    private Double annualYield;  
    private Double interestSum;  
    List<ProductDetailItem> datas;  
      
    public ProductDetailTab() {  
        heads=new ArrayList<String>();  
        heads.add("总额");  
        heads.add("投资周期");  
        heads.add("年化收益率（%）");  
        heads.add("投资人姓名");  
        heads.add("投资金额");  
        heads.add("投资人购买日");  
        heads.add("放款日期");  
        heads.add("回款日期");  
        heads.add("计算利息天数");  
        heads.add("到期利息");  
        heads.add("备注");      
        datas=new ArrayList<ProductDetailItem>();  
    }  
  
  
    public List<String> getHeads() {  
        return heads;  
    }  
  
  
    public void setHeads(List<String> heads) {  
        this.heads = heads;  
    }  
  
  
    public Double getInvestSum() {  
        return investSum;  
    }  
  
  
    public void setInvestSum(Double investSum) {  
        this.investSum = investSum;  
    }  
  
  
    public Integer getInvestCycle() {  
        return investCycle;  
    }  
  
  
    public void setInvestCycle(Integer investCycle) {  
        this.investCycle = investCycle;  
    }  
  
  
    public Double getAnnualYield() {  
        return annualYield;  
    }  
  
  
    public void setAnnualYield(Double annualYield) {  
        this.annualYield = annualYield;  
    }  
  
  
    public Double getInterestSum() {  
        return interestSum;  
    }  
  
  
    public void setInterestSum(Double interestSum) {  
        this.interestSum = interestSum;  
    }  
  
  
    public List<ProductDetailItem> getDatas() {  
        return datas;  
    }  
  
  
    public void setDatas(List<ProductDetailItem> datas) {  
        this.datas = datas;  
    }  
      
      
      
      
      
      
}    
