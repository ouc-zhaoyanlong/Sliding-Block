package WBGame;

import java.util.Scanner;

public class Inversion {

	//�鲢����
	private int count = 0;
	public void mSort(int[]dst,int left,int right) {
		/*
		 * ���ȶ�������ж��֣�ֱ���ֳ�2��Ԫ��Ϊһ��
		 * ������Ԫ��֮���������
		 * ���Ϻϲ��Ӽ�
		 */
		if(left==right) {
			return;
		}
		int center = left+(right-left)/2;
		//����
		mSort(dst,left,center);
		mSort(dst,center+1,right);
		int size = right-left+1;//�˿���Ҫ�ϲ��Ӽ����ܳ���
		int[] term = new int[size];
		int p1,p2;//ָ�������Ӽ��ȶ�Ԫ�ص��±�
		int i,j;//ָ����ʱ�Ӽ����±�
		/*
		 * Ĭ�ϴ�С��������
		 * ���ߵ���һ��ʱ��˵��left=center,left+1=right
		 * ��˱��������Ӽ�[left,center],[center+1,right],�������Ӽ��ڲ�������ģ�����Ҫ�����Ǻϲ���һ�������������Ӽ�[left,right]
		 * ���巽����ÿ��ȡ��ÿ���Ӽ�����Ԫ�ؽ��бȶԣ�С��д��һ����ʱ������Ӽ����Դ����ƣ�ֱ�������Ӽ�ȫ��Ԫ�ؾ�д�룬Ȼ�����ʱ�Ӽ������ݸ��Ƶ�Ŀ���Ӽ���
		 */
		p1 = left;
		p2 = center+1;
		i=0;
		//�Ӽ���Ԫ�رȶ�
		while(p1<=center&&p2<=right) {
			if(dst[p1]<=dst[p2]) {
				term[i]=dst[p1];
				i++;
				p1++;
			}else {
				term[i]=dst[p2];
				i++;
				p2++;
				//��dst[p2]С��dst[p1]ĳһԪ��ʱ����ô��һ��С��dst[p1]֮�������Ԫ��
				int num = center-p1+1;
				this.count += num;
			}
		}
		//���Ӽ�ʣ��Ԫ�����
		if(p1<=center) {
			for(j=p1;j<=center;j++) {
				term[i]=dst[j];
				i++;
			}
		}else {
			for(j=p2;j<=right;j++) {
				term[i]=dst[j];
				i++;
			}
		}
		//Ԫ�ظ�ֵ
		j=0;
		for(i=left;i<=right;i++) {
			dst[i] = term[j];
			j++;
		}
	}
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int i;
		int[]src = new int[num];
		for(i=0;i<num;i++) {
			src[i] = scanner.nextInt();
		}
		int len = src.length;
		mSort(src,0,len-1);
//		for(i=0;i<len;i++) {
//			System.out.print(src[i]);
//		}
//		System.out.println();
		System.out.println(count);
	}
*/
	public int getCount(int[] dst, int left, int right) {
		// TODO Auto-generated method stub
		int emptyIndex = 0;
		int[]term = dst.clone();
		this.mSort(term, left, right);
		
		//����������ΪҪ���Կո��Ӱ�죬�ҵ��ո�ǰ��1�ĸ����Լ�����-1�ĸ���
		for(int i=left;i<=right;i++) {
			if(dst[i]==0) {
				emptyIndex = i;
				break;
			}
		}
		for(int i=left;i<emptyIndex;i++) {
			if(dst[i]==1) {
				this.count--;
			}
		}
		for(int i=emptyIndex+1;i<=right;i++) {
			if(dst[i]==-1) {
				this.count--;
			}
		}
		return this.count;
	}
}
