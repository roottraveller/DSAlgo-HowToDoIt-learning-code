import java.util.*;

/* 
 * Author @ roottraveller, July 2017
 */

public class TwoDArraysSort {
    public static void main(String[] args) {
        Integer[][] myarr = {{0, 10}, {10, 9}, {2, 9}, {3, 9}, {4, 15}, {5, 10}, {6, 4}};

        for (Integer[] elem : myarr) {
            System.out.print(elem[0] + "," + elem[1]);
            System.out.println();
        }

        Arrays.sort(myarr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] data1, Integer[] data2) {
                return data1[1].compareTo(data2[1]);    // sort on column 2
                // return data1[0].comapreTo(data2[0]); // sort on column 1
            }
        });

        for (Integer[] elem : myarr) {
            System.out.println(elem[0] + "," + elem[1]);
            System.out.println();
        }
    } // main() ends
}
