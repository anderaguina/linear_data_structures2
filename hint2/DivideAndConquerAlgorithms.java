package hint2;
import java.math.*;


import hint1.MyDynamicList;
import hint1.MyList;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){
		
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		for (int i=0; i<m.length(); i++) {
			m1.addElement(m1.length(), m.getElement(i));
		}

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		if (m1.length() == 0) {
			scenario = 1;
		}else {
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
			case 1:
				// System.out.println("Empty mylist");
				break;				
			case 2: 
				if (m1.length() -1  != -1) {
					int aux = m1.getElement(0);
					System.out.println("Item : " +aux);
					m1.removeElement(0);
					recursiveDisplayElements(m1);					
				}				
				break;
		}			
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		// List for the results
		MyList<Integer> res = new MyDynamicList<Integer>();
		
		
		// Dummy list so we don't mess with the original list
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		// Fill the dummy list
		for (int i=0; i<m.length(); i++) {
			m1.addElement(m1.length(), m.getElement(i));
		}
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------
	
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (m1.length() == 0) {
			scenario = 1;
		} else {
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
			case 1:
				break;
			case 2:
				// Only keep executing if the list has elements
				if (m1.length() - 1 >= 0) {
					
					// If the element in 0 is smaller than e add it to result list
					if (m1.getElement(0) < e) {
						res.addElement(0, m1.getElement(0));
					}
					
					// Truncate list
					m1.removeElement(0);
					
					// Return the concatenation of the res list of this execution and
					// the res list returned by the recursive algorithm which
					// will contain all the res list from consecutive
					// executions
					return concatenate(res, smallerMyList(m1, e));
				}
				break;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------	
		return res;
		
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		// List for the results
		MyList<Integer> res = new MyDynamicList<Integer>();
		
		
		// Dummy list so we don't mess with the original list
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		// Fill the dummy list
		for (int i=0; i<m.length(); i++) {
			m1.addElement(m1.length(), m.getElement(i));
		}

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (m1.length() == 0) {
			scenario = 1;
		} else {
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
			case 1:
				break;
			case 2:
				// Only keep executing if the list has elements
				if (m1.length() - 1 >= 0) {
					
					// If the element in 0 is bigger or = than e add it to result list
					if (m1.getElement(0) >= e) {
						res.addElement(0, m1.getElement(0));
					}
					
					// Truncate list
					m1.removeElement(0);
					// Return the concatenation of the res list of this execution and
					// the res list returned by the recursive algorithm which
					// will contain all the res list from consecutive
					// executions
					return concatenate(res, biggerEqualMyList(m1, e));
				}
				break;
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res1 = new MyDynamicList<Integer>();
		
		for (int i=0; i<m1.length(); i++) {
			res1.addElement(res1.length(), m1.getElement(i));
		}
		MyList<Integer> res2 = new MyDynamicList<Integer>();
		
		for (int j=0; j<m2.length(); j++) {
			res2.addElement(res2.length(), m2.getElement(j));
		}
		/*
		System.out.println("RES 1 LENGTH : " + res1.length());
		System.out.println("RES 2 LENGTH : " + res2.length());
		*/

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (m1.length() == 0 && m2.length() == 0) {
			scenario = 1;
		} else if (m2.length() == 0) { 
			return res1;
		} else {
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
			
		switch(scenario){	
			case 1:
				break;
			case 2:
				// System.out.println("RES 1 BEFORE ADD : " + res1.length());
				res1.addElement(res1.length(), res2.getElement(0));
				// System.out.println("RES 1 AFTER ADD : " + res1.length());
				// System.out.println("RES 2 BEFORE RM : " + res2.length());
				res2.removeElement(0);
				// System.out.println("RES 2 AFTER RM : " + res2.length());
				// System.out.println("CONCAT RES 2 LENGTH: " + res2.length());
				if (res2.length()>0) {
					return concatenate(res1, res2);
				}
				break;
		}
			
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		// System.out.println("FINAL RES 1: " + res1.length());
		return res1;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
			
		switch(scenario){	
							
		}		
	
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}		
	
}
