package org.ant.guava;

/**
 * Created by zhiboliu2 on 2017/5/26.
 */
public class FindService {
    public static <T extends Comparable<T>> Pair<T> getPair(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        T min = arr[0];
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min.compareTo(arr[i]) > 0) {
                min = arr[i];
            }
            if (min.compareTo(arr[i]) < 0) {
                max = arr[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "b", "c", "d", "z"};
        Pair<String> pairStr = FindService.getPair(strArray);
        System.out.println("min = [" + pairStr.getMin() + "], max = [" + pairStr.getMax() + "]");

        Integer[] intArray = new Integer[]{1, 2, 3, 4, 99};
        Pair<Integer> pairInt = FindService.getPair(intArray);
        System.out.println("min = [" + pairInt.getMin() + "], max = [" + pairInt.getMax() + "]");
    }
}
