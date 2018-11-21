package FibonacciSequence;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n� n<=39
 * 1,1,2,3,5,8,13,21,34,55,89,144,...
 * 
 * @ClassName
 * @Description
 * @author Zhihong_Huang
 * @Date 2017-9-18 ����2:07:42
 */
public class Solution {
	public static int Fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int f = 0, g = 1;
		int N = 0;
		for (int i = 2; i <= n; i++) {
			N = f + g;
			f = g;
			g = N;
		}
		return N;
	}

	public static void main(String[] args) {
		System.out.println(Fibonacci(8));
	}
}