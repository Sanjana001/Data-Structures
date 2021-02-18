import java.util.*;
class ArrayListExample{
	public static void main(String[] args){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
	        //add elements in arrayList
	        arrayList.add(10);
	        arrayList.add(2);
	        arrayList.add(3);
	        System.out.println("Elements inside arrayList are: "+arrayList);
	        //add elements at a particular position
	        arrayList.add(1,12);
		arrayList.add(4,23);
		arrayList.add(0,11);
		System.out.println("\nAfter adding elements at some particular position the resultant arrayList is "+arrayList);
		//set an element at a particular index
		arrayList.set(5,20);
		arrayList.set(2,50);
		System.out.println("\nAfter setting the elements the resultant arrayList is "+arrayList);
		System.out.println("\nThe size or length of the arrayList is "+arrayList.size());
		//get an element at a particular index
		System.out.println("\nThe third element of the arrayList is "+arrayList.get(2));
		//let's sort the arrayList
		Collections.sort(arrayList);
		/*for(int i=0;i<arrayList.size();i++) System.of.print(arrayList.get(i));
		                        OR
		for(int i:arrayList) System.out.println(i+" ");*/
		System.out.println("\nSorted arrayList is "+arrayList);
		//remove the second element from arrayList
		arrayList.remove(1);
		//we can use use remove(index) or remove(element) like If I want to remove 50 then I can use remove(5) or remove(50)
		System.out.println("\nAfter removing the second element the resultant arrayList is "+arrayList);
		System.out.println("\nIs 2 present in arrayList? "+arrayList.contains(2));
		System.out.println("\nConvert arrayList into array "+arrayList.toArray());
		// clear() method will remove all elements inside arrayList
		// isEmpty() to check whether the arrayList is empty or not
	}
}
