#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;

void display( int arr[] , int size ){
    cout << "arr = [";
    for( int i=0;i<size-1;i++ ){
        cout << arr[i] << ", ";
    }
    cout << arr[size-1] << "]" << endl;
}

void doBubbleSort( int arr[] , int size ){
    for( int i=0;i<size-1;i++ ){
        bool swapped = false;
        for( int j=0;j<size-i-1;j++ ){
            if( arr[j] > arr[j+1] ){
                arr[j] = arr[j] ^ arr[j+1];
                arr[j+1] = arr[j] ^ arr[j+1];
                arr[j] = arr[j] ^ arr[j+1];
                swapped = true;
            }
        }
        if( !swapped ) return ;
    }
}

int main()
{
   /* 
      In Optimized solution we take a variable swapped
      which checks the swapping at every pass,
      when the swapping does not occur it means that the array is now sorted
   */
   int arr[] = { 1, 94, 23, 75, 9, 0, -5 };
   int size = sizeof( arr ) / sizeof( arr[0] );
   cout << "Before Sorting: " << endl;
   display( arr, size );
   // do sort
   doBubbleSort( arr, size );
   cout << "After Sorting: " << endl;
   display( arr, size );
   return 0;
}