package mvc.session;

import java.util.HashSet;
import java.util.Set;


public class SessionSet {
	
	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		this.set = new HashSet<>();
	}
	
	public static SessionSet getInstance() {
		return ss;
	}
	
	/**
	 * 사용자 찾기 (사용하는지 안하는지 모르겠음)
	 * */
	public Session get(String sessionId) {
		for(Session session : set) {
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	// 세션 객체들 반환 (사용하는지 안하는지 모르겠음)
	public Set<Session> getSet(){
		return set;
	}
	
	/**
	 * 로그인 된 사용자 추가
	 * */
	public void add(Session session) {
		set.add(session);
	}
	
	/**
	 * 로그아웃
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
}
