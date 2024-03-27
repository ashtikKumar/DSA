package DSA.Algorithms.Sorting;

public class Merge_Sort {
    public static void main(String[] args) {
        int arr[] = {12,4,53,1,64,34,6,8,46};

        Merge_Sort ms = new Merge_Sort();

        System.out.println("Before Sorting: ");
        printArray(arr);

        ms.mergeSort(arr, 0, arr.length-1);

        System.out.println("After Sorting: ");
        printArray(arr);
    }

    public void merge(int arr[], int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int lArray[] = new int[n1];
        int rArray[] = new int[n2];

        for(int x=0; x<n1; x++){
            lArray[x] = arr[left+x];
        }
        for(int y=0; y<n2; y++){
            rArray[y] = arr[mid+1+y];
        }

        int i, j, k=left;
        for(i=0,j=0; i<n1 && j<n2;){
            if(lArray[i]<=rArray[j]){
                arr[k++] = lArray[i++];
            } else {
                arr[k++] = rArray[j++];
            }
        }

        while(i<n1){
            arr[k++] = lArray[i++];
        }
        while(j<n2){
            arr[k++] = rArray[j++];
        }
    }

    public void mergeSort(int arr[], int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
