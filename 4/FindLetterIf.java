public class FindLetterIf {
	public static void main(String[] args) {
		char letter = 'A';
		if (Character.toLowerCase(letter) == 'a' || Character.toLowerCase(letter) == 'e' || Character.toLowerCase(letter) == 'o' || Character.toLowerCase(letter)=='i'|| Character.toLowerCase(letter) =='u'){
			System.out.println(letter + " is a vowel");
		}
		else System.out.println(letter + " is a consonant");
	}
}