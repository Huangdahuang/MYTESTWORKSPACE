package ch1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个N*2的二维数组，看作是一个个二元组，例如[a1,b1],[a2,b2],[a3,b3]
 * 规定：一个如果想把二元组甲放到二元组乙上，甲中的a值必须大于乙中的a值，甲中的b值必须大于乙中b值
 * 如果在二维数组中随意选择二元组，请问二元组最多可以网上纍几个
 * 例如：[[5,4],[6,4],[6,7],[2,3]],最大数量为3，[[2,3],[5,4],[6,7]]
 * 要求：实现时间复杂度为O(NlogN)的算法
 * 
 * @ClassName
 * @Description
 * @author Zhihong_Huang
 * @Date 2017-9-18 下午12:41:58
 */

public class Test1 {
	/** 二元组 */
	public static class Dot {
		int a, b;

		public Dot(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	/**比较器 */
	public static class DotComparator implements Comparator<Dot> {
		public int compare(Dot o1, Dot o2) {
			if (o1.a == o2.a) {
				return o2.b - o1.b;// 这里按b从大到小排序
			} else {
				return o1.a - o2.a;
			}
		}
	}

	/** 开始查找 */
	private static int maxEnvelops(int[][] es) {

		Dot[] dots = new Dot[es.length];
		for (int i = 0; i < es.length; i++) {
			dots[i] = new Dot(es[i][0], es[i][1]);
		}
		Arrays.sort(dots, new DotComparator());
		int[] h = new int[es.length];
		h[0] = dots[0].b;
		int hl = 0;// h中数据个数
		int r = 0;
		int l = 0;
		int mid = 0;
		for (int i = 1; i < dots.length; i++) {
			r = hl;
			l = 0;
			while (l <= r) {
				mid = (l + r) / 2;
				if (h[mid] < dots[i].b) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			hl = Math.max(hl, l);
			h[l] = dots[i].b;
		}
		return hl + 1;
	}

	public static void main(String[] args) {
		int es[][] = { { 4, 5 }, { 4, 6 }, { 6, 7 }, { 2, 3 }, { 1, 1 } };
		System.out.println(maxEnvelops(es));
	}
}
