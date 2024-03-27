package DSA.Algorithms.Sorting;

public class Bubble_Sort {
    public static void main(String[] args) {
        Bubble_Sort bs = new Bubble_Sort();
        int arr[] = {12,5,2,6,4,1,31,0,78};

        //Priting array before sorting
        System.out.println("Before Sorting: ");
        bs.printArray(arr);

        //Sorting array using Bubble Sort
        arr = bs.bubbleSort(arr);
        
        //Priting array after sorting using Bubble Sort
        System.out.println("After Sorting: ");
        bs.printArray(arr);
    }

    public int[] bubbleSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
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
