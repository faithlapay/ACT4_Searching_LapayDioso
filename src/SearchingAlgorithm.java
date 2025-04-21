import java.util.*;

public class SearchingAlgorithm {
    
    static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int)Math.floor(Math.sqrt(n));
        int prev = 0;
        while(arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if(prev >= n) return -1;
        }
        while(arr[prev] < target) {
            prev++;
            if(prev == Math.min(step, n)) return -1;
            if(arr[prev] == target) return prev;
        }
            return -1;
    }
    static int exponentialSearch(int[] arr, int target) {
        if(arr[0] == target) return 0;
        int i = 1;
        while(i < arr.length && arr[i] <= target) i *= 2;
        return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), target);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a searching algorithm to perform:\n1.Linear Search\n2.Binary Search\n3.Jump Search\n4.Exponential Search");
        
        System.out.print("Enter your choice(1-4): ");
        int choice=sc.nextInt();

        System.out.print("Enter no. of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("Enter the elements: ");
        for(int i= 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target elements: ");
        int target =sc.nextInt();
        int result=-1;

        if(choice>1)Arrays.sort(arr);
        switch(choice){
            case 1:
            result=linearSearch(arr, target);
            break;

            case 2:
            result=binarySearch(arr, target);
            break;

            case 3:
            result=jumpSearch(arr, target);
            break;

            case 4:
            result=exponentialSearch(arr, target);
            break;

            default:
            System.out.println("Invalid choice!");

            return;
        }

        if (result>=0) {
            System.out.println("Element " + target + " is found at index " + result + ".");
        } else {
            System.out.println("Element " + target + " is not found in the array.");
        }
        }
    }
