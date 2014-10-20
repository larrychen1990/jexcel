package com.hawk.apche.excel;

import java.util.ArrayList;
import java.util.List;

public class PlatformDetail {  
	  
    private List<ProductDetailTab> productDetailTabs;  
    private Borrower borrower;  
    private Investor investor;  
      
    public PlatformDetail(){  
        productDetailTabs=new ArrayList<ProductDetailTab>();  
        borrower=new Borrower();  
        investor=new Investor();  
    }  	
      
    public List<ProductDetailTab> getProductDetailTabs() {  
        return productDetailTabs;  
    }  
    public void setProductDetailTabs(List<ProductDetailTab> productDetailTabs) {  
        this.productDetailTabs = productDetailTabs;  
    }  
    public Borrower getBorrower() {  
        return borrower;  
    }  
    public void setBorrower(Borrower borrower) {  
        this.borrower = borrower;  
    }  
    public Investor getInvestor() {  
        return investor;  
    }  
    public void setInvestor(Investor investor) {  
        this.investor = investor;  
    }  
      
      
}  
