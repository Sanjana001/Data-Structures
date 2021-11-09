#include<iostream>
#include<cstdio>
using namespace std;

void display( int arr[] , int size ){
    for( int i=0;i<size-1;i++ )
      cout << arr[i] << ", ";
    cout << arr[size-1] << " ]" << endl;
}

void sort( int arr[], int size ){
    int result[size];
    
    // find the max element
    int max = arr[0];
    for( int i=0;i<size;i++ )
       max = arr[i] > max ? arr[i] : max;

    // initialize a counting array of size max
    int count[max+1] = {0};
    for( int i=0;i<size;i++ )
      count[ arr[i] ] += 1;

    // make the cumulative sum
    for( int i=1;i<max+1;i++ )
       count[i] += count[i-1];

    // make the sorted array
    for( int i=size-1;i>=0;i-- ){
        result[ count[ arr[i] ] - 1 ] = arr[i];
        count[ arr[i] ] -= 1;
    }

    cout << "After Sorting: [ " ;
    display( result, size );
}

int main()
{
   int arr[] = {4, 2, 2, 8, 3, 3, 1};
   int size = sizeof( arr ) / sizeof( arr[0] );
   
   cout << "Before Sorting: [ " ;
   display( arr, size );
   // sort the array using counting sort
   sort( arr, size );

   return 0;
}

/* Working
   max = 8
   count[max+1] = count[9] = [ 0, 1, 2, 2, 1, 0, 0, 0, 1 ]
   cumulative sum = [ 0, 1, 3, 5, 6, 0, 0, 0, 7 ]
*/