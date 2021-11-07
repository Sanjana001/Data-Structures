#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;

void displayArray( int arr[], int size ){
    cout << "arr = [ " ;
    for( int i=0;i<size-1;i++ )
       cout << arr[i] << ", ";
    cout << arr[size-1] << endl;
}

int binarySearch( int arr[], int left, int right, int num ){
    if( left <= right ){
        int middle = ( left + right ) / 2;

        if( arr[middle] == num )
           return middle;

        if( arr[middle] < num )
           return binarySearch( arr, middle+1 , right, num );

        return binarySearch( arr, left, middle-1, num );
    }

    return -1;
}

int main()
{
   int num;
   int arr[] = {1, 4, 23, 55, 69, 90};
   int size = sizeof( arr ) / sizeof( arr[0] );
   // display the array
   displayArray( arr, size );
   cout << "Enter the number: ";
   cin >> num;
   cout << endl;
   // do binary serach
   int index = binarySearch( arr, 0 , size, num );
   if( index != -1 )
      cout << num << " is present at index " << index << endl;
   else cout << num << " is absent" << endl;

   return 0;
}