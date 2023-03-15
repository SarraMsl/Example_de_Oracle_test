import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

class TriInsertion {
    /*Function to sort array using insertion sort*/
    static int[]  tri(int tableau[]) {

        int n = tableau.length;
        for (int i = 1; i < n; ++i) {
            int key = tableau[i];
            int j = i - 1;


            while (j >= 0 && tableau[j] > key) {
                tableau[j + 1] = tableau[j];
                j = j - 1;
            }
            tableau[j + 1] = key;
        }

        return tableau;
    }

    static int[] randomTable() {
        int val = 10;
        Random r = new Random();
        int[] arr = new int[val];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(val);

        }



        return arr;
    }

    public static void main(String args[]) {


        //  int arr[] = { 12, 11,13, 5, 6,9,3,122,9,15,55 };


        int[] arr = randomTable();

        compare(arr);

tri(arr);
    }



    static void compare(int array[]){

        int[] clone1 = array.clone();
        int[] clone2 = array.clone();

        Arrays.sort(clone1);
        tri(clone2);

        System.out.println(Arrays.toString(clone1));
        System.out.println(Arrays.toString(clone2));






        try{
            Assert.assertArrayEquals(
                    clone1,
                    clone2);

            System.out.println( " - passed");
        }catch(AssertionError e){
            System.out.println( " - failed");

            throw e;
        }

    }
}