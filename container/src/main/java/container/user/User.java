package container.user;

import java.util.List;

public class User {
	private Long no = 0L;
	private String name = "김준호";
	
//	@Autowired // 오토와이어 없이 하겠음!! 의존성 주입을! 왜 없어야하냐? 라이브러리에 오토와이어즈가 있는 순간 그 라이브러리는
	// 스프링에 고정된 라이브러리가 되어버림!!
	private Friend friend;
	private List<String> friends;
	
	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public User() {
		
	}
	
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public User(String name) {
		this.name = name;
	}
	
	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}
	
	
	public void setNo(Long no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
	
}
