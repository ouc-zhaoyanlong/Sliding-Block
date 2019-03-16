package WBGame;

import java.util.ArrayList;
import java.util.List;

public class SubsequentState {
	//���ĳһ״̬�ĺ��״̬
	private int emptyIndex;//�ո��±�
	private int moveSize;//������������������ͬ����ɫn�����ӣ���(n+1)/2
	private int[]st;//��ǰ״̬
	private List<int[]> statusList = new ArrayList<int[]>();
	private List<Integer> costList = new ArrayList<Integer>();
	private List<Integer> valueList = new ArrayList<Integer>();
	
	public int[] getStatusNow() {
		return this.st;
	}
	public SubsequentState() {
		Status stu = new Status();
		this.st = stu.getStatus();
		this.moveSize = (stu.getSize()+1)/2; 
	}
	public SubsequentState(int[]status) {
		Status stu = new Status(status);
		this.st = stu.getStatus();
		this.moveSize = (stu.getSize()+1)/2; 
	}
	public SubsequentState(int[]status,int movesize) {
		Status stu = new Status(status);
		this.st = stu.getStatus();
		this.moveSize = movesize;
	}
	//�����ƶ����
	public void setSubsequenceStateList() {
		//��λ�ո�λ��
		int i,j,k;
		int cost = 1;
		Status stu = new Status();
		for(i=0;i<this.st.length;i++) {
			if(this.st[i]==0) {
				this.emptyIndex = i;
				break;
			}
		}
		//�ӿո�ʼ��ǰ��������佻��
		int start = this.emptyIndex-this.moveSize-1;
		if(start<0) start=0;
		int end = this.emptyIndex+this.moveSize+1;
		if(end>this.st.length-1) end = this.st.length-1;
		for(i=start;i<=end;i++) {
			if(i!=this.emptyIndex) {
				//���ǿո�
				int[]term = this.st.clone();
				int termValue = term[i];
				term[i] = term[this.emptyIndex];
				term[this.emptyIndex] = termValue;
				this.statusList.add(term);//��״̬�����
				stu.setStatus(term);
				this.valueList.add(stu.getStatusFuncValue());
				if(Math.abs(i-this.emptyIndex)>1)
					cost = Math.abs(i-this.emptyIndex)-1;
				else
					cost=1;
				this.costList.add(cost);
			}
		}
	}
	public List<int[]> getStatus(){
		return this.statusList;
	}
	public List<Integer> getValue(){
		return this.valueList;
	}
	public List<Integer> getCost(){
		return this.costList;
	}
}
