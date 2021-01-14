package container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component    //스캐닝할것 자동으로!!
public class CDPlayer {

	@Autowired
	private CompactDisc cd;
	
	public void play() {
		cd.play();
		
	}

}
