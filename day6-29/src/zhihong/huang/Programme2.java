package zhihong.huang;
/**
 * 
* <p>Title: Programme2</p>  
* <p>Description:判断101-200之间有多少个素数，并输出所有素数 </p>  
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
				System.out.println("素数"+ i);
				
			}
			
		}
		System.out.print("总共有" + sum +"个素数");
	}

	 private static boolean isSuShu(int i) {

	       for (int j = 2; j < Math.sqrt(i);j++) {
	           if (i%j==0) { //如果能整除，就说明不是素数，可以马上中断，继续对下一个数判断
	              return false;
	           }
	       }   
  
	       return true;

	    }

}
