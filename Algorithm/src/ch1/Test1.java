package ch1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ����һ��N*2�Ķ�ά���飬������һ������Ԫ�飬����[a1,b1],[a2,b2],[a3,b3]
 * �涨��һ�������Ѷ�Ԫ��׷ŵ���Ԫ�����ϣ����е�aֵ����������е�aֵ�����е�bֵ�����������bֵ
 * ����ڶ�ά����������ѡ���Ԫ�飬���ʶ�Ԫ�������������n����
 * ���磺[[5,4],[6,4],[6,7],[2,3]],�������Ϊ3��[[2,3],[5,4],[6,7]]
 * Ҫ��ʵ��ʱ�临�Ӷ�ΪO(NlogN)���㷨
 * 
 * @ClassName
 * @Description
 * @author Zhihong_Huang
 * @Date 2017-9-18 ����12:41:58
 */

public class Test1 {
	/** ��Ԫ�� */
	public static class Dot {
		int a, b;

		public Dot(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	/**�Ƚ��� */
	public static class DotComparator implements Comparator<Dot> {
		public int compare(Dot o1, Dot o2) {
			if (o1.a == o2.a) {
				return o2.b - o1.b;// ���ﰴb�Ӵ�С����
			} else {
				return o1.a - o2.a;
			}
		}
	}

	/** ��ʼ���� */
	private static int maxEnvelops(int[][] es) {

		Dot[] dots = new Dot[es.length];
		for (int i = 0; i < es.length; i++) {
			dots[i] = new Dot(es[i][0], es[i][1]);
		}
		Arrays.sort(dots, new DotComparator());
		int[] h = new int[es.length];
		h[0] = dots[0].b;
		int hl = 0;// h�����ݸ���
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
