package WBGame;

public class Status {

	/*
	 * ״̬��
	 * ����������ľ�����ʱ�ε�״̬
	 * ��������廬����ƶ�
	 * ������㵱ǰ��״̬����ֵ�����ö������㷨
	 */
	private int size = 3;//���������
	private int[] status = {1,-1,1,0,1,-1,-1};//����
	private int statusFuncValue = 0;
	public Status(){
		//Ĭ�Ϲ��췽��
	}
	public int getSize() {
		return this.size;
	}
	public Status(int[]status) {
		//���췽����д
		this.size = status.length/2;
		this.status = status;
	}
	public void setStatus(int[]status) {
		this.status = status;
	}
	public int[] getStatus() {
		return this.status;
	}
	public int getStatusFuncValue() {
		Inversion iv = new Inversion();
		int[] dst = this.status.clone();
		int left = 0;
		int right = dst.length-1;
		this.statusFuncValue = iv.getCount(dst,left,right );
		return statusFuncValue;
	}
	public void setStatusFuncValue() {
		Inversion iv = new Inversion();
		int[] dst = this.status.clone();
		int left = 0;
		int right = dst.length-1;
		this.statusFuncValue = iv.getCount(dst,left,right );
	}
	
}
