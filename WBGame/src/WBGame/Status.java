package WBGame;

public class Status {

	/*
	 * 状态类
	 * 负责处理滑动积木块各个时段的状态
	 * 不负责具体滑块的移动
	 * 负责计算当前的状态函数值，采用堆排序算法
	 */
	private int size = 3;//滑块的数量
	private int[] status = {1,-1,1,0,1,-1,-1};//棋盘
	private int statusFuncValue = 0;
	public Status(){
		//默认构造方法
	}
	public int getSize() {
		return this.size;
	}
	public Status(int[]status) {
		//构造方法重写
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
