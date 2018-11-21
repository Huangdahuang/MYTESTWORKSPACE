package huang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,5,43,67,8,56,5,7,7,65,4,3,3,5,7,7,8,9,6,5,3,22,2,2,2,5,6,7};
		int maxFrequenceMun = findMostFrequentInArray(arr);
		System.out.println(maxFrequenceMun);
	}

	private static int findMostFrequentInArray(int[] arr) {
		int result = 0;
		int Key = 0;
		if(arr.length == 0)
			return Integer.MAX_VALUE;
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(m.containsKey(arr[i])){
				m.put(arr[i], m.get(arr[i]) + 1);
			}else{
				m.put(arr[i], 1);
			}
		}
		
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Entry) it.next();
			int key = (Integer) entry.getKey();
			int value = (Integer) entry.getValue();
			if(value > result) {
				result = value;
				Key = key;
			}
		}
		return result;
	}

}
