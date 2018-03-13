package testers;

import java.lang.reflect.Array;

import indexList.IndexList;
import indexList.LLIndexList;
import linkedLists.DLDHDTList;
import linkedLists.SLFLList;

public class ToArrayTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLIndexList<Integer> SLList = new LLIndexList<Integer>(new SLFLList<Integer>());
		LLIndexList<Integer> DLList = new LLIndexList<Integer>(new DLDHDTList<Integer>());
		SLList.add(0, 5);
		SLList.add(1);
		SLList.add(7);
		DLList.add(0, 5);
		DLList.add(1);
		DLList.add(7);
		try{
			LLIndexList<Integer> SLList2 = (LLIndexList<Integer>) SLList.clone();
			Object[] test3 = SLList2.toArray();
			for(int i=0; i<test3.length; i++){
				System.out.print(test3[i] + " ");
			}
			System.out.println("");
		} catch (CloneNotSupportedException c){}
		Object[] test = SLList.toArray();
		for(int i=0; i<test.length; i++){
			System.out.print(test[i] + " ");
		}
		System.out.println("");
		Integer[] test2 = DLList.toArray(new Integer[3]);
		for(int i=0; i<test.length; i++){
			System.out.print(test2[i] + " ");
		}
		System.out.println("");
	}

}
