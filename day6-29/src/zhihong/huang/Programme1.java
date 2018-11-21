package zhihong.huang;

import java.util.Scanner;

/**
 * 
* <p>Title: Programme1</p>  
* <p>Description:题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一只兔子，</p>
* <p>小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？ </p>  
* <p>1,1,2</p> 
* @author HuangZhihong  
* @date Jun 29, 2018
 */
public class Programme1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while(true){
			System.out.println("请输入你想知道的月份：");
			Scanner sc = new Scanner(System.in);
			int month = sc.nextInt();
			int count = fun(month);
			System.out.println(count);
			i++;
			if(i == 3){
				break;
			}
		}
	}

	private static int fun(int month) {
		// TODO Auto-generated method stub
		if(month == 1 || month == 2) {
			return 1;
		}else{
			return fun(month-1) + fun(month-2);
		}
		
	}

}
