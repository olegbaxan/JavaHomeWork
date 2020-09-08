public class FindLetterSwitch {
	public static void main(String[] args) {
		char letter = 'A';
		switch(Character.toLowerCase(letter)){
			case 'a': System.out.println(letter + " is a vowel");break;
			case 'e': System.out.println(letter + " is a vowel");break;
			case 'o': System.out.println(letter + " is a vowel");break;
			case 'u': System.out.println(letter + " is a vowel");break;
			case 'i': System.out.println(letter + " is a vowel");break;
			default:System.out.println(letter + " is a consonant");
		}
	}
}