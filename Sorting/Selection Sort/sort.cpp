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

void doSelectionSort( int arr[] , int size ){
    for( int i=0;i<size-1;i++ ){
        int min_index = i;
        for( int j=i+1;j<size;j++ ){
            if( arr[j] < arr[min_index] ){
                min_index = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[min_index];
        arr[min_index] = temp;
    }
}

int main()
{
   int arr[] = { 1, 9, 23, 75, 9, 0, -5, 100, -90 };
   int size = sizeof( arr ) / sizeof( arr[0] );
   cout << "Before Sorting: " << endl;
   display( arr, size );
   // do sort
   doSelectionSort( arr, size );
   cout << "After Sorting: " << endl;
   display( arr, size );
   return 0;
}

/* Working
   At i = 0: arr = [ -90, 9, 23, 75, 9, 0, -5, 100, 1 ];
   At i = 1: arr = [ -90, -5, 23, 75, 9, 0, 9, 100, 1 ]
   At i = 2: arr = [ -90, -5, 0, 75, 9, 23, 9, 100, 1 ]
   At i = 3: arr = [ -90, -5, 0, 1, 9, 23, 9, 100, 75 ]
   At i = 4: arr = [ -90, -5, 0, 1, 9, 23, 9, 100, 75 ]
   At i = 5: arr = [ -90, -5, 0, 1, 9, 9, 23, 100, 75 ]
   At i = 6: arr = [ -90, -5, 0, 1, 9, 9, 23, 100, 75 ]
   At i = 7: arr = [ -90, -5, 0, 1, 9, 9, 23, 75, 100 ]
*/