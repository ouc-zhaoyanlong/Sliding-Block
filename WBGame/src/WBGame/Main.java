package WBGame;

import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i,j;
		int[] status = {1,-1,-1,1,1,1,0,-1,1,1,-1,-1,1,1,-1,-1,-1};
		int value,cost;
		
		SubsequentState ss = new SubsequentState(status);
		ss.setSubsequenceStateList();
		
		List<int[]> statusList = ss.getStatus();
		List<Integer> valueList = ss.getValue();
		List<Integer> costList = ss.getCost();
		
		System.out.println("��ǰ״̬");
		status = ss.getStatusNow();
		for(j=0;j<status.length;j++) {
			System.out.print(status[j]+"\t");
		}
		
		System.out.println();
		
		System.out.println("���״̬");
		for(i=0;i<statusList.size();i++) {
			status = statusList.get(i);
			value = valueList.get(i);
			cost = costList.get(i);
			for(j=0;j<status.length;j++) {
				System.out.print(status[j]+"\t");
			}
			System.out.println("��ɢֵ��"+cost+"  ״ֵ̬��"+value);
		}
	}
	
}
