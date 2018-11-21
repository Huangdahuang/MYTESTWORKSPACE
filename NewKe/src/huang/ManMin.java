package huang;

public class ManMin {

	static int max = 0;
	static int min = 0;
	static int secondMax = 0;
	public static void main(String[] args) {
		int[] array = {7,3,10,40,4,7,1};
		int[] minAndmax = getMaxAndMin(array);
		System.out.println(3^5);
		for (int i = 0 ; i < minAndmax.length;i++) {
			System.out.println(minAndmax[i]);
		}
	}

	private static int[] getMaxAndMin(int[] array) {
		int[] result = new int[3];
		max = array[0];
		min = array[0];
		secondMax = array[0];
		for(int i = 0;i < array.length;i++){
			if(array[i] > max) {
				secondMax = max;
				max = array[i];
			}
			if(array[i] < min)
				min = array[i];
		}
		result[0] = min;
		result[1] = max;
		result[2] = secondMax;
		return result;
	}

}
