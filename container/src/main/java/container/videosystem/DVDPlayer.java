package container.videosystem;

public class DVDPlayer {

	private DigitalVideoDisc dvd;
	
	
	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}



	public void play() {
		dvd.play();
	}

	
}
