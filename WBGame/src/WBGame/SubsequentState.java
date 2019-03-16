package WBGame;

import java.util.ArrayList;
import java.util.List;

public class SubsequentState {
	//输出某一状态的后继状态
	private int emptyIndex;//空格下标
	private int moveSize;//可以跳过的最大格数，同种颜色n个棋子，可(n+1)/2
	private int[]st;//当前状态
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
	//计算移动情况
	public void setSubsequenceStateList() {
		//定位空格位置
		int i,j,k;
		int cost = 1;
		Status stu = new Status();
		for(i=0;i<this.st.length;i++) {
			if(this.st[i]==0) {
				this.emptyIndex = i;
				break;
			}
		}
		//从空格开始，前后均可与其交换
		int start = this.emptyIndex-this.moveSize-1;
		if(start<0) start=0;
		int end = this.emptyIndex+this.moveSize+1;
		if(end>this.st.length-1) end = this.st.length-1;
		for(i=start;i<=end;i++) {
			if(i!=this.emptyIndex) {
				//不是空格
				int[]term = this.st.clone();
				int termValue = term[i];
				term[i] = term[this.emptyIndex];
				term[this.emptyIndex] = termValue;
				this.statusList.add(term);//新状态入队列
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
