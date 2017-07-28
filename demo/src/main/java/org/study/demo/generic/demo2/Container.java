package org.study.demo.generic.demo2;

public class Container<K, V> {
    private K key;
    private V value;

    public Container(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    public static void main(String[] args) {
        Container<String, String> c1 = new Container<String, String>("name", "Messi");
        Container<String, Integer> c2 = new Container<String, Integer>("age", 30);
        Container<String, Double> c3 = new Container<String, Double>("height", 1.78);
        System.out.println(c1.getKey() + " : " + c1.getValue());
        System.out.println(c2.getKey() + " : " + c2.getValue());
        System.out.println(c3.getKey() + " : " + c3.getValue());
    }
}