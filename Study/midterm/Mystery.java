public class Mystery{
    public static void main(String[] args) {
        int[] arr1= {10, 20, 30, 40, 50};
        int[] arr2= {50, 60, 75, 60, 50};
        Method1(arr1, arr2);
        Method2(arr1[0], arr2[4]);
        System.out.print("The Values in arr1 are: ");
        for (int values: arr1) {
            System.out.print(values + " ");
        }

    }

public static void Method1(int[] arr1, int[] arr2) {
        arr1[2] = 300;
        arr2 = arr1;
        arr1[1] = 200;
        arr2[3] = 400;
    }  

 public static void Method2(int arr1, int arr2) {  

    int temp = arr1;
    arr1 = arr2;
    arr2 = temp;

    }
}