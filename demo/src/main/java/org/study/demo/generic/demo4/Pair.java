package org.study.demo.generic.demo4;

public class Pair<T> {  
    private T first;  
    private T second;  
  
    public Pair(T first, T second) {  
        this.first = first;  
        this.second = second;  
    }  
  
    public T getFirst() {  
        return first;  
    }  
  
    public T getSecond() {  
        return second;  
    }  
  
    public void setFirst(T newValue) {  
        first = newValue;  
    }  
  
    public void setSecond(T newValue) {  
        second = newValue;  
    }  
} 