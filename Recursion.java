/**
*Class holding several different recursion methods.
*
*@author lulku3
*@version 11.0.13
*/
public class Recursion {
    /**
    *Method that is a recursive sorting function/helper function for mergeSort.
    *@param arr what is divided
    *@return String[] what is being merged
    */
    public static String[] sorter(String[] arr) {
        int middle = arr.length / 2;
        int midRem = arr.length % 2;
        String[] arr1 = new String[middle];
        String[] arr2 = new String[middle + midRem];
        String[] output = new String[arr.length];
        arr1 = RecursionUtils.copyOfRange(arr, 0, middle);
        arr2 = RecursionUtils.copyOfRange(arr, middle, arr.length);
        System.out.println("ARR1");
        for (String item : arr1) {
            System.out.println(item);
        }
        System.out.println("ARR2");
        for (String word : arr2) {
            System.out.println(word);
        }
        if (arr1.length > 1) {
            sorter(arr1);
        }
        if (arr2.length > 1) {
            sorter(arr2);
        }
        output = RecursionUtils.merge(arr1, arr2);
        System.out.println("OUTPUT");
        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }
        return output;
    }
    /**
    *Method that has recursive helper method (above).
    *@param arr what is being passed in to sort
    *@return String[] what is sorted
    */
    public static String[] mergeSort(String[] arr) {
        sorter(arr);
        return arr;
    }
    /**
    *Method that is sorting a 2D array into 1D array, uses mergeSort(sorry).
    *@param in is input array
    *@return String[] is sorted 1D array
    */
    public static String[] mergeAll(String[][] in) {
        int count = 0;
        int it = 0;
        for (String[] item : in) {
            for (String word : item) {
                count += 1;
            }
        }
        System.out.println(count);
        System.out.println(in.length);
        String[] out = new String[count];
        for (int k = 0; k < in.length; k++) {
            for (int l = 0; l < in[k].length; l++) {
                out[it] = in[k][l];
                it += 1;
            }
        }
        return mergeSort(out);
    }
    /**
    *Method that counts duplicates in array. Is recursive.
    *@param in is input to be checked through
    *@return int is how many duplicates
    */
    public static int countDuplicates(String[] in) {
        int count = 0;
        int j = in.length - 1;
        if (in.length == 0 || in.length == 1) {
            return 0;
        } else {
            String[] out = new String[j];
            for (int x = 0; x < j; x++) {
                out[x] = in[x];
            }
            if (in[j] == in[j - 1]) {
                count += 1;
                j -= 1;
                return count + countDuplicates(out);
            } else {
                j -= 1;
                return count + countDuplicates(out);
            }
        }
    }
    /**
    *Method that verifies if word is palindrome. Is recursive.
    *@param word is input to be checked through
    *@return boolean is if it is palindrome
    */
    public static boolean verifyPalindrome(String word) {
        word = word.toLowerCase();
        if (word.equals(null)) {
            return false;
        } else if (word.length() == 0 || word.length() == 1) {
            return true;
        } else {
            if (word.charAt(0) == word.charAt(word.length() - 1)) {
                return verifyPalindrome(word.substring(1, word.length() - 1));
            } else {
                return false;
            }
        }
    }
    /**
    *Method that checks if point in circle. Is recursive, uses point.
    *@param point is point array
    *@param radius is radius of circle
    *@return int is how many points in circle
    */
    public static int numInteriorPoints(Point[] point, int radius) {
        int j = point.length - 1;
        double pythag = 0.0;
        int count = 0;
        if (point.length == 0) {
            return 0;
        } else {
            Point[] pOut = new Point[j];
            System.out.println("Pythag");
            System.out.println(point[j]);
            pythag = (Math.pow(point[j].getX(), 2)) + (Math.pow(point[j].getY(), 2));
            System.out.println(pythag);
            for (int x = 0; x < j; x++) {
                pOut[x] = point[x];
                System.out.println(pOut[x]);
            }
            if (pythag < Math.pow(radius, 2)) {
                count += 1;
                j -= 1;
                return count + numInteriorPoints(pOut, radius);
            } else {
                j -= 1;
                return count + numInteriorPoints(pOut, radius);
            }
        }
    }
    /**
    *Main method.
    *@param args is string input
    */
    public static void main(String[] args) {
        String[][] ma1 = {{"Alex", "Brian"}, {"Aaron", "David"}, {"Charlie"}};
        for (String item : mergeAll(ma1)) {
            System.out.println(item);
        }
       /*String[] ms1 = {"Brian", "Alex", "David", "Charlie", "Aaron"};
        for (String item : mergeSort(ms1)) {
            System.out.println(item);
        }*/
        //System.out.println(mergeSort(ms1));
        /*for (String item : splitFirst(ms1)) {
            System.out.println(item);
        }*/
        /*for (String word: sortSecond(ms1)) {
            System.out.println(word);
        }*/
        //System.out.println(mergeSort(ms1));
        //String[] i1 = {"A", "A"};
        //System.out.println(countDuplicates(i1));
        //String[] in = {"A", "A", "B", "C", "C", "C", "D"};
        //System.out.println(countDuplicates(in));
        //System.out.println(verifyPalindrome("Racecar"));
        //String[] ms1 = {"Brian", "Alex", "David", "Charlie", "Aaron"};
        //for (String name : mergeSort(ms1) ) {
        //    System.out.println(name);
        //}
        //System.out.println(numInteriorPoints(Point.getArrayOfRandomPoints(8, 9), 5));
        //come back to later!
    //combine into one sorting function, hopefully that will work as intended
    /*public static String[] splitFirst(String[] arr) {
        int middle = 0;
        if (arr.length == 0 || arr.length == 1) {
            return null;
        } else {
            if (arr.length % 2 == 0) {
                middle = arr.length / 2;
            } else {
                middle = arr.length / 2 + 1;
            }
            String[] arr1 = new String[middle];
            for (int i = 0; i < middle; i++) {
                arr1[i] = arr[i];
                System.out.println(arr[i]);
            }*/
            //sort arr1
            /*if (arr1 != null && arr1.length != 0) {
                for (int k = 0; k < arr1.length; k++) {
                    System.out.println("SORT FIRST");
                    if (k != arr1.length - 1 && arr1[k].compareTo(arr1[k + 1]) == 1) {
                        String med = arr1[k];
                        arr1[k] = arr1[k+1];
                        arr1[k+1] = med;
                    } else {
                        continue;
                    }
                }
            }*/
            /*return splitFirst(arr1);
        }
    }
    public static String[] splitSecond(String[] arr) {
        int j = arr.length;
        int middle = arr.length / 2;
        String[] arr2 = new String[middle];
        //copy to arr2
        for (int x = 0; x < middle; x++) {
            arr2[x] = arr[j-1];
            j -= 1;
        }
        //sort arr2
        for (int f = 0; f < arr2.length; f++) {
            System.out.println("SORT SECOND");
            if (f != arr2.length - 1 && arr2[f].compareTo(arr2[f + 1]) == 1) {
                String med = arr2[f];
                arr2[f] = arr2[f+1];
                arr2[f+1] = med;
            } else {
                continue;
            }
        }
        return arr2;
    }*/
    }
}