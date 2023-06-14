package excercise.answer;

class SutdaDeck{
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {

		/* SutdaCard를 배열 초기화 */
		for(int i=0; i<CARD_NUM; i++) {
			if(i<10) {
				cards[i].num = i+1;
				if(i==1||i==3||i==8) 
					cards[i].isKwang = true;
			} else {
				cards[i].num = i-9;
			}
		}
	}
	
	

	void shuffle() {
		for(int i=0; i<CARD_NUM; i++) {
			int j = (int)(Math.random()*CARD_NUM);
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
	
	SutdaCard pick(int index) {
		return cards[index];
	}
	
	SutdaCard pick() {
		for(int i=0; i<CARD_NUM; i++) {
			int j = (int) (Math.random()*CARD_NUM);
			return cards[j];
		}
		return null;
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	// info()대신 Object클래스의 toString()을 오버라이딩했다
	public String toString() {
		return num + (isKwang? "K":"");
	}
}


public class Excercise7_1 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for(int i=0; i< deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");
		}
	}

}
