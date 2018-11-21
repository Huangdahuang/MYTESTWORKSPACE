package zhihong.huang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * @ClassName
 * @Description
 * @author Zhihong_Huang
 * @Date 2017-9-22 ����10:10:59
 */
public class Solution {
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> arr = new ArrayList<Integer>(k);
		int c = 0;
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = input.length - 1; j > i; j--) {
				if (input[j] < input[j - 1]) {
					// ���н���
					int tmp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = tmp;
				}
			}
			if (c < k) {
				arr.add(input[c]);
				c++;
			}
		}
		/*
		 * for (int i = 0; i < k; i++) { arr.add(input[i]); }
		 */

		return arr;

	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(GetLeastNumbers_Solution(input, 4));
	}
}