package excercise.answer;

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public int gotoPrevChannel() {
		return getChannel();
	}
	
}

public class Excercise7_10 {
	public static void main (String args[]) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH: " + t.getChannel());
		t.setVolume(20);
		System.out.println("VOL: " + t.getVolume());
		System.out.println("-------------------");
		
		t.setChannel(10);
		System.out.println("CH: " + t.getChannel());
		t.setChannel(20);
		System.out.println("CH: " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH: " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH: " + t.getChannel());
		
		
		
	}
}
