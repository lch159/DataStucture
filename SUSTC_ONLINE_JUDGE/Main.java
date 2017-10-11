import java.util.Scanner;

/**
 * Created by 11611423 李晨昊 on 2017/10/11.12:26
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[] list =new int[n];

            for (int j=0;j<n;j++){
                list[j]=input.nextInt();
            }
            int endIndex = 0;
            while (endIndex<n)
            {
                quickSort(list,0,endIndex);
                System.out.print(list[endIndex/2]+" ");
                endIndex+=2;
            }
            System.out.println();
        }
    }
    private static  void quickSort(int[] arr, int low, int high){
        int i,j,temp;
        i=low;
        j=high;
        temp=arr[i];
        while(i<j){
            while(i<j&&temp<=arr[j])
                j--;
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while(i<j&&arr[i]<temp)
                i++;
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=temp;
        if(low<i)
            quickSort(arr,low,i-1);
        if(i<high)
            quickSort(arr,j+1,high);
    }
}
