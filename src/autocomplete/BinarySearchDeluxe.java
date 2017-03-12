package autocomplete;

import java.util.*;
public class BinarySearchDeluxe {
	// Returns the index of the first key in a[] that equals the search key, or -1 if no
	//such key.
	 public static <Key extends Comparable<Key>> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
		 if(a==null||key==null||comparator==null) throw new NullPointerException();
		 int found=-1;
		 if(Arrays.binarySearch(a, key,comparator)>0){
			
			 int counter = 0;
			 while (found<0){
				 found = Arrays.binarySearch(a, 0, counter,  key, comparator);
				 counter++;
			 }
			 
		 }
		 
		 System.out.println("foundF"+found);
		 return found;
	 }
	 // Returns the index of the last key in a[] that equals the search key, or -1 if no
	//such key.
	 public static <Key extends Comparable<Key>> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
		 if(a==null||key==null||comparator==null) throw new NullPointerException();
		 int found=-1;
		 if(Arrays.binarySearch(a, key,comparator)>0){
			
			 int counter = 0;
			 while (found<0){
				 found = Arrays.binarySearch(a, a.length-1-counter, a.length-1,  key, comparator);
				 counter++;
			 }
			 
		 }
		 
		 System.out.println("found"+found);
		 return found;
	 }
	 // unit testing (required)
	 public static void main(String[] args){

		 String [] test1 = {"1","1","2","2","3","44","44","5","5","6","7"};
		 System.out.println("f"+firstIndexOf(test1,"5", new Comparator<String>(){
			 @Override
			 public int compare(String s1, String s2){
				 return s1.compareTo(s2);
			 }
		 }));
		 System.out.println("l"+lastIndexOf(test1,"5", new Comparator<String>(){
			 @Override
			 public int compare(String s1, String s2){
				 return s1.compareTo(s2);
			 }
		 }));
	 }
}
