package autocomplete;

public class Autocomplete {
	private Term[] myTerms;
	
	// Initializes the data structure from the given array of terms.
	 public Autocomplete(Term[] terms){
		 this.myTerms = terms;
		 sorting();
	 }
	 // Returns all terms that start with the given prefix, in descending order of weight.
	 public Term[] allMatches(String prefix){
		 int length = this.numberOfMatches(prefix);
		 Term searchTerm = new Term(prefix,0);
		 int firstIndex = BinarySearchDeluxe.firstIndexOf(myTerms, searchTerm, Term.byPrefixOrder(prefix.length()));
		 Term[] toReturn= new Term[length];
		 for(int i=0;i<length;i++){
			 toReturn[i]=myTerms[firstIndex+i];
		 }
		 
		 return toReturn;
	 }
	 // Returns the number of terms that start with the given prefix.
	 public int numberOfMatches(String prefix){
		 Term searchTerm = new Term(prefix,0);
		 int firstIndex = BinarySearchDeluxe.firstIndexOf(myTerms, searchTerm, Term.byPrefixOrder(prefix.length()));
		 int lastIndex = BinarySearchDeluxe.lastIndexOf(myTerms, searchTerm, Term.byPrefixOrder(prefix.length()));
		 if(firstIndex>=0&&firstIndex!=lastIndex)return lastIndex-firstIndex;
		 else if(firstIndex<0&&lastIndex<0) return 0;
		 else return 1;
		 
		 
	 }
	 
	 private void sorting(){
		 boolean swapFlag = false;
		 do{
			 swapFlag = false;
			 for(int i=0;i<(myTerms.length-1);i++){
				 if(myTerms[i].compareTo(myTerms[i+1])>1){
					 Term temp = myTerms[i];
					 myTerms[i]=myTerms[i+1];
					 myTerms[i+1]=temp;
					 swapFlag = true;
				 }
			 }

			 
		 }while(swapFlag);
		 
	 }
	 
	 public String toString(){
		 String toReturn = "";
		 for(Term myTerm: myTerms){
			 toReturn+=myTerm.getQuery();
		 }
		 return toReturn;
	 }
	 
	 public static void main(String[] args){
		 Term t1 = new Term("the", 55);
		 Term t2 = new Term("at", 55);
		 Term t3 = new Term("mm", 55);
		 
		 Term[] ts = {t1,t2,t3};
		 Autocomplete a1 = new Autocomplete(ts);
		 System.out.println(a1.toString());
		 Term[] t4 =a1.allMatches("t");
		 for(Term t:t4){
			 System.out.println(t.getQuery());
		 }
		 
	 }

}
