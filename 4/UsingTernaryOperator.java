public class UsingTernaryOperator {
	public static void main(String[] args) {
		int num=10000001;
		 String mess = num<=0 ? "Small" : num>= 1000000 ? "Large" : "Medium";
		 System.out.println(mess);
	}
}