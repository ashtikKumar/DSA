package DSA.Algorithms.Sorting;

public class Insertion_Sort {
    public static void main(String[] args) {
        Insertion_Sort is = new Insertion_Sort();
        int arr[] = {12,53,1,74,7,2,96,3,20,11};

        //Printing array before sorting
        System.out.println("Before Sorting: ");
        is.printArray(arr);

        //Sorting array using Insertion Sort
        arr = is.insertionSort(arr);

        //Printing array after sorting using Insertion Sort
        System.out.println("After Sorting using Insertion Sort: ");
        is.printArray(arr);
    }

    //Method for Insertion Sort
    public int[] insertionSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j>0 && arr[j-1]>arr[j]; j--){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp; 
            }
        }
        return arr;
    }

    //Method to print the array
    public void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
