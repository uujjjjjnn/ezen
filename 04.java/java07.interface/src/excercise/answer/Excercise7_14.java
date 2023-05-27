package excercise.answer;

class SutdaCard2 {
	final int NUM;
	final boolean ISKWANG;
	
	SutdaCard2() {
		this(1, true);
	}
	
	SutdaCard2(int num, boolean isKwang) {
		this.NUM = num;
		this.ISKWANG = isKwang;
	}
	
	public String toString() {
		return NUM + (ISKWANG ? "K":"");
	}
}


public class Excercise7_14 {

	public static void main(String[] args) {
		SutdaCard2 card = new SutdaCard2(1, true);
	}
}
