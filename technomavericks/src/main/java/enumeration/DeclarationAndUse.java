package enumeration;

public class DeclarationAndUse {
	public static void main(String args[]){
		Beer beer = Beer.KF;
		System.out.println(beer.ordinal() );
	}
}

enum Beer{
	KF,RC;
}