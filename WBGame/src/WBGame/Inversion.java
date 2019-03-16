package WBGame;

import java.util.Scanner;

public class Inversion {

	//归并排序
	private int count = 0;
	public void mSort(int[]dst,int left,int right) {
		/*
		 * 首先对数组进行二分，直到分成2个元素为一组
		 * 在两个元组之间进行排序
		 * 不断合并子集
		 */
		if(left==right) {
			return;
		}
		int center = left+(right-left)/2;
		//二分
		mSort(dst,left,center);
		mSort(dst,center+1,right);
		int size = right-left+1;//此刻需要合并子集的总长度
		int[] term = new int[size];
		int p1,p2;//指向两个子集比对元素的下标
		int i,j;//指向临时子集的下标
		/*
		 * 默认从小到大排序
		 * 当走到这一步时，说明left=center,left+1=right
		 * 因此便有两个子集[left,center],[center+1,right],这两个子集内部是有序的，现在要把他们合并成一个更大的有序的子集[left,right]
		 * 具体方案是每次取出每个子集的首元素进行比对，小的写入一个临时构造的子集，以此类推，直至两个子集全部元素均写入，然后把临时子集的数据复制到目标子集上
		 */
		p1 = left;
		p2 = center+1;
		i=0;
		//子集首元素比对
		while(p1<=center&&p2<=right) {
			if(dst[p1]<=dst[p2]) {
				term[i]=dst[p1];
				i++;
				p1++;
			}else {
				term[i]=dst[p2];
				i++;
				p2++;
				//当dst[p2]小于dst[p1]某一元素时，那么他一定小于dst[p1]之后的所有元素
				int num = center-p1+1;
				this.count += num;
			}
		}
		//将子集剩余元素填充
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
		//元素赋值
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
		
		//稍做处理，因为要忽略空格的影响，找到空格前面1的个数以及后面-1的个数
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
