public class SumNumbersWhile {
	public static void main(String[] args) {
		int n = 5, number=1, sum=0;
		while (number<=n){
			sum=sum+number;
			number++;
		}
		System.out.println("Sum is = "+ sum);
	}
}