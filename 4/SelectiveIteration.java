public class SelectiveIteration {
	public static void main(String[] args) {
		int num = 2000, count=0;
		while(count++<num){
			if(count%3==0){
				continue;
			}
			if((count+5)%7==0){
				continue;
			}
			if (count%10==0){
				continue;
			}
			
			System.out.println(count);
			
			
		}
	}
}