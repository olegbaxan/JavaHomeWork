public class IteratingInts {
	public static void main(String[] args) {
		int num=9;
		for (int i=1;i<=num ;i++ ) {
			for (int j=0;j<i ;j++ ) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}