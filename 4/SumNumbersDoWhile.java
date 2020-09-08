public class SumNumbersDoWhile {
	public static void main(String[] args) {
		int n = 5, number=1, sum=0;
		do{
			sum=sum+number;
			number++;
		}while (number<=n);
		System.out.println("Sum is = "+ sum);
	}
}