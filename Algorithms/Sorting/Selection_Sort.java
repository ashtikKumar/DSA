package DSA.Algorithms.Sorting;

public class Selection_Sort {
    public static void main(String[] args) {
        Selection_Sort ss = new Selection_Sort();
        int arr[] = {12,4,53,1,64,34,6,8,46};

        //Printing array before sorting
        System.out.println("Before Sorting: ");
        ss.printArray(arr);
        
        //Sorting array using Selection Sort
        arr = ss.selectionSort(arr);

        //Priting array after sorting using Selection Sort
        System.out.println("After Sorting: ");
        ss.printArray(arr);
    }

    public int[] selectionSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
