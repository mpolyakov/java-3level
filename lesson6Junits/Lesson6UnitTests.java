import java.util.Arrays;

public class Lesson6UnitTests {

    public static void main(String[] args) throws RuntimeException {
        Lesson6UnitTests arrObj = new Lesson6UnitTests();
        System.out.println(Arrays.toString(arrObj.getNumsAfter4(new int[]{7, 8, 9, 4, 2, 1, 5})));
//        System.out.println(arrObj.ifContains4and1(new int[]{4, 5, 9, 4, 4, 1, 1}));
//        System.out.println(arrObj.ifContains4and1(new int[]{1, 4, 1}));
    }

    int[] getNumsAfter4(int[] arr) throws RuntimeException {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i] == 4) {
                int[] resArr = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, resArr, 0, resArr.length);
                return resArr;
            }
        throw new RuntimeException("В массиве нет ни одной цифры 4");

    }

    boolean ifContains4and1(int[] arr) {
        boolean cont1 = false;
        boolean cont4 = false;
        for (int i : arr)
            if (i == 1)
                cont1 = true;
            else if (i == 4)
                cont4 = true;
            else
                return false;
        return cont1 && cont4;
    }
}