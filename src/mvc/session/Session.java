package mvc.session;

public class Session {
	private String sessionId;
	
	public Session() { }

	public Session(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Session [sessionId=");
		builder.append(sessionId);
		builder.append("]");
		return builder.toString();
	}

	
}
