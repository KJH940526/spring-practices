package container.soundsystem;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component    //스캐닝할것 자동으로!!
public class CDPlayer {

//  Wiring01 : 필드(reflection) 주입(CGLib)
//	@Inject     //(자바 표준이지만 Wiring Annotation) but 잘 안씀!
	@Autowired
	@Qualifier("highSchoolRapper3Final")      //자바랑 스프링것이 있는데 스프링이면 스프링껄 써야함!!
	private CompactDisc cd;			//이름 지정해줌!!
	
	public CDPlayer() {
	}
	
//  Wiring02 : 생성자 주입!
//	@Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
//  Wiring03 : setter 주입!
//	@Autowired
	public void setCD(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}

//  Wiring04 : 일반 메소드 주입!	
//	@Autowired
	public void insertCD(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	public void play() {
		cd.play();
		
	}

}
