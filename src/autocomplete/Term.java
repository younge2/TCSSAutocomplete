package autocomplete;

import java.lang.*;
import java.util.*;
public class Term implements Comparable<Term> {
	private String query;
	private long weight;
	 // Initializes a term with the given query string and weight.
	 public Term(String query, long weight){
		 if(query==null) throw new NullPointerException();
		 if(weight<0) throw new IllegalArgumentException();
		 this.query = query;
		 this.weight = weight;
	 }
	 public String getQuery(){
		 return this.query;
	 }
	 public long getWeight(){
		 return this.weight;
	 }
	 // Compares the two terms in descending order by weight.
	 public static Comparator<Term> byReverseWeightOrder(){
		 return new Comparator<Term>(){
			 public int compare(Term o1, Term o2){
				 long thatWeight = o1.getWeight();
				 long otherWeight = o2.getWeight();
				 int toReturn = (int)(thatWeight - otherWeight);
				 return toReturn;
			 }
		 };
		
		 
	 }
	 // Compares the two terms in lexicographic order but using only the first r
	//characters of each query.
	 public static Comparator<Term> byPrefixOrder(int r){
		 return new Comparator<Term>(){
			 private int pre = r;
			@Override
			public int compare(Term o1, Term o2) {
				if(r<0)throw new IllegalArgumentException();
				 String thisR = o1.query.substring(0, pre);
				 String thatR = o2.query.substring(0, pre);
				 return thisR.compareToIgnoreCase(thatR);
			}
		 };
		
	 }
	 // Compares the two terms in lexicographic order by query.
	 public int compareTo(Term that){
		 return this.query.compareToIgnoreCase(that.query);
	 }
	 // Returns a string representation of this term in the following format:
	 // the weight, followed by a tab, followed by the query.
	 public String toString(){
		 return "default";
	 }
	 // unit testing (required)
	 public static void main(String[] args){
		 
	 }
	}
