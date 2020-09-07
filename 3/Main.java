public class Main {
	public static void main(String[] args) {
		//1.1 (a = 20) ++a + ++a + ++a + a-- -6 = 21 + 22 + 23 + 23 - 6 = 83, a=22
		/*1.2 (a = 10) a++ + a + a-- + a-- + -- a + a++ - --a + a++ - a-- + a - --a + a++ + ++a =?   
					   10 + 11 + 11  + 10  + 8    + 8   - 8   + 9   - 10  + 9 - 8   + 8   + 10  =66, a=10*/
		/*1.3 (a = 10) a++ + a * a-- + a-- * -- a + a++ - --a * a++ - a-- + a - --a * a++ + ++a =?
					   10  + 11 *11  + 10  * 8    + 8   - 8   * 8   - 9   + 8 - 7   * 7   + 9   =	
					   10  + 121     + 80         + 8   - 64        - 9   + 8 - 49        + 9   =114, a=9*/

		int a;
		//1.1
		a=20;
		System.out.println("a="+a);

		System.out.println("a(1.1)="+ (++a + ++a + ++a + a-- -6));

		//1.2
		a=10;
		System.out.println("a(1.2)="+ (a++ + a + a-- + a-- + -- a + a++ - --a + a++ - a-- + a - --a + a++ + ++a));

		//1.3
		a=10;
		System.out.println("a(1.3)="+ (a++ + a * a-- + a-- * -- a + a++ - --a * a++ - a-- + a - --a * a++ + ++a));

		//1.4
		boolean isTrue;
		if(a>5){
			isTrue=true;
		}else isTrue=false;
		System.out.println("a(1.4)="+ isTrue);

		//1.5
		char ch='z';
		char codeCh='\u007A';
		char decimalCh=122;
		System.out.println("a(1.5); Character = "+ ch + " / Code = "+ codeCh + " / Decimal = "+ decimalCh);

		//1.6
		int x=-1;
		boolean bool1,bool2;
		bool1=x<100 && x++>=0;
		x=-1;
		bool2=x<100 & x++ > 0;

		System.out.println("a(1.6); bool1 = "+ bool1 + " / bool2 = "+bool2);

		/*
		Outputs:
		a=20
		a(1.1)=83
		a(1.2)=66
		a(1.3)=114
		a(1.4)=true
		a(1.5); Character = z / Code = z / Decimal = z
		a(1.6); bool1 = false / bool2 = false
		*/
	}
}