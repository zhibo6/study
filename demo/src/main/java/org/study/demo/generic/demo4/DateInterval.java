package org.study.demo.generic.demo4;

import java.util.Date;

public class DateInterval extends Pair<Date> {  
    public DateInterval(Date first, Date second) {  
        super(first, second);  
    }  
      
    public void setSecond(Date second) {  
        if (second.compareTo(getFirst()) >= 0) {  
            super.setSecond(second);  
        } else {  
            throw new IllegalArgumentException("Second date should be no earlier than first date.");  
        }  
    }  
      
    public Date getSecond() {  
        return (Date) super.getSecond().clone();  
    }  
    
    public static void main(String [] args){
    	System.out.println(3.1415926);
    }
}