package zhihong.huang;

import java.util.Scanner;

/**
 * 
* <p>Title: Programme1</p>  
* <p>Description:��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һֻ���ӣ�</p>
* <p>С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ����Ӷ���Ϊ���٣� </p>  
* <p>1,1,2</p> 
* @author HuangZhihong  
* @date Jun 29, 2018
 */
public class Programme1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while(true){
			System.out.println("����������֪�����·ݣ�");
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
