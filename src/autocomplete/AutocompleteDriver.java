package autocomplete;
import java.util.*;
import java.io.*;
public class AutocompleteDriver {
	public static void main(String[] args) throws IOException{
		try{
			Scanner in = new Scanner(new File("wiktionary.txt"));
			int N = in.nextInt();
			Term[] terms = new Term[N];
			
			for(int i=0;i<N;i++){
				long weight = in.nextLong();
				String query = in.nextLine();
				terms[i]= new Term(query.replaceFirst("\t", ""), weight);
			}
			int k=0;
			Scanner ip = new Scanner(System.in);
			boolean termFlag = false;
			System.out.println("How many matching terms do you want to see?");
			do{
			try{
				k = ip.nextInt();
				termFlag=true;
			}catch(InputMismatchException e){
				System.out.println("That was not an integer, please enter an integer");
				termFlag=false;
			}
			}while(!termFlag);
		
			Autocomplete a1 = new Autocomplete(terms);
			boolean queryFlag = false;
			while(!queryFlag){
				System.out.println("Enter the term you are searching for. Enter * to exit");
				String prefix = ip.next();
				if(prefix!="*"){
					Term[] results = a1.allMatches(prefix);
					System.out.println(results.length);
					for(int i=0;i<Math.min(k, results.length);i++){
						System.out.println(results[i].toString());
					}
				}else queryFlag = true;
					
			}
			
		} catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		
		
	}
}
