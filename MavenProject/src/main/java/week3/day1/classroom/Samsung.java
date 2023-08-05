package week3.day1.classroom;

public class Samsung extends AndroidTv implements Android{

	public static void main(String[] args) {

		Samsung phn = new Samsung();
		phn.openApp();
		phn.playVideo();

	}

	public void playVideo() {
		System.out.println("PlayVideo (unimplemented method from Android) is implemented here in Samsung");

	}

}
