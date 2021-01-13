class Sorting{

    //Bubble sort
    public static void bubbleSort(int[] a){//Time-Complexity-->O(n^2)
        boolean sorted=false;
        int temp ;
        while(!sorted){
            sorted = true;
            for(int i=0;i<a.length-1;i++){

                if(a[i] > a[i+1]){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;

                }
            
            }
        }
    }

    //Insertion sort
    public static void insertionSort(int[] a){//Time-Complexity-->O(n^2)
        for(int i=1;i<a.length;i++){
            int current = a[i];
            int j=i-1;
            while(j>=0 && current <a[j]){
                a[j+1] = a[j];
                j--;
            }

            //at this point we'he exited ,so j is either -1 or it's at the first 
            //element where current >= a[j]
            
            a[j+1] = current;
        }
    }

    //Selection sort
    public static void selectionSort(int[] a){//Time-Complexity-->O(n^2)
        for(int i=0;i<a.length;i++){
            int min = a[i];
            int minId =i;

            for(int j=i+1;j<a.length;j++){
                if(a[j]<min){
                    min=a[j];
                    minId=j;
                }
            }

            //swapping
            int temp = a[i];
            a[i]=min;
            a[minId] =temp;

        }
    }

    //Merge sort
    static void merge(int[] a,int left,int mid, int right){
      
        //calculating lengths
        int lengthLeft = mid-left+1;
        int lengthRight = right-mid;

        //creating temporary subarrays
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int[lengthRight];

        //copying our sorted subarrays into temporaries
       for(int i=0;i<lengthLeft;i++) leftArray[i] = a[left+i];
       for(int i=0;i<lengthRight;i++)  rightArray[i] = a[mid+i+1];

       //iteration containing current index of temp subarrays
       int leftIndex=0;
       int rightIndex=0;

       //copying from leftArray andrightArray back into Array
       for(int i=0;i<right+1;i++){
           if(leftIndex <lengthLeft && rightIndex <lengthRight){
               if(leftArray[leftIndex] < rightArray[rightIndex]){
                   a[i] = leftArray[leftIndex];

                   leftIndex++;
               }
               else{
                   a[i] = rightArray[rightIndex];
                   rightIndex++;
               }
           }

           //if all the elements have been copied from rightArray,copy the rest of leftArray
           else if(leftIndex <lengthLeft){
               a[i] = leftArray[leftIndex];
               leftIndex++;
           }
          //if all the elements have been copied from leftArray,copy the rest of rightArray
          else if(rightIndex <lengthRight){
              a[i] = rightArray[rightIndex];
              rightIndex++;
          }
       }

    }
    
    public static void mergeSort(int[] a,int left,int right){//uses recursive approach and for finding time complexity we have to be little mathy
     if(right<=left) return;
     int mid =(left+right)/2;
     mergeSort(a, left, mid);
     mergeSort(a, mid+1, right);
     merge(a, left,mid, right);
  
    }


    //Heap sort
    static void heapify(int[] a,int length ,int i){
      int leftChild=2*i+1;
      int rightChild = 2*i+2;
      int largest  =i;

      //if the left child is larger than the parent
      if(leftChild <length && a[leftChild]>a[largest]){
          largest = leftChild;
      }

      //if the right child is larger than the parent
      if(rightChild <length && a[rightChild]>a[largest]){
          largest = rightChild;

      }

      //if a swap need to occur
      int temp = a[i];
      a[i] = a[largest];
      a[largest] = temp;
      heapify(a,length, largest);

    }

    public static void main(int[] a){
        if(a.length == 0) return;

        //Building heap
        int length = a.length;
        //we're going towards firts non-leaf to the heap
        for(int i=length/2-1;i>=0;i--){
            heapify(a, length, i);
        }


        for(int i=length-1;i>=0;i--){
            int temp=a[0];
            a[0] = a[i];
            a[i] = temp;
            
            heapify(a, i, 0);
        }
    }


    static int partition(int[] a,int begin,int end){
        int pivot = end;
        int counter = begin;

        for(int i=begin;i<end;i++){
            if(a[i] <a[pivot]){
                int temp = a[counter];
                a[counter]=a[i];
                a[i] = temp;       
                counter++;    
          }
        }

        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;

        return counter;

    }

    public static void quickSort(int[] a,int begin,int end){
        if(end <= begin)  return;
        int pivot = partition(a,begin,end);
        quickSort( a, begin, pivot-1);
        quickSort(a, pivot+1, end);
     }



}




