package mvc.model.exception;

/**
 * �˻������� ã���� �ϴ� ������ ���� ��� ����
 * */
public class NotFoundException extends Exception {
	public NotFoundException() {
		
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
