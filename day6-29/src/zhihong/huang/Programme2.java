package zhihong.huang;
/**
 * 
* <p>Title: Programme2</p>  
* <p>Description:�ж�101-200֮���ж��ٸ�������������������� </p>  
* @author shenlan  
* @date Jun 29, 2018
 */
public class Programme2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 101 ; i <= 200 ;i++){
			if(isSuShu(i)){
				sum++;
				System.out.println("����"+ i);
				
			}
			
		}
		System.out.print("�ܹ���" + sum +"������");
	}

	 private static boolean isSuShu(int i) {

	       for (int j = 2; j < Math.sqrt(i);j++) {
	           if (i%j==0) { //�������������˵���������������������жϣ���������һ�����ж�
	              return false;
	           }
	       }   
  
	       return true;

	    }

}
