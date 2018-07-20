package com.mwp.subject;

/**
 * 题目1：计算大数据的运算，如50!
 * 分析:因为多位数据的运算超出了基本数据类型的长度，所以不能用基本数据类型处理，需要用数组来
 * 思路：数组里的数据从后往前存储大数的各个位数数值，每位与int相乘的结果放入数组中，然后对每位数据做进位留值
 * @author mwp
 *
 */

public class BigNumDemo {
	
	public static void main(String[] args){
		int[] bigNum = new int[10];
		int[] bigNum1 = new int[10];
		bigNum[bigNum.length-1]=1;
		bigNum[bigNum.length-2]=5;
		bigNum[bigNum.length-3]=5;
		bigNum1[bigNum.length-1]=9;
		bigNum1[bigNum.length-2]=1;
		bigNum1[bigNum.length-3]=1;
		
		int[] t = new int[10];
		t=getBigNums(bigNum,bigNum1);
		/*for (int i = 1; i <= 1000; i++) {
			getBigNum(bigNum,i);
		}*/
		
		//打印值
		System.out.print("the result:");
		int index=0;
		for (int i = 0; i < t.length; i++) {
			if(t[i]==0){
				index=i;
				break;
			}
			if(t[i]>=0 && i>index){
				System.out.print(t[i]);
			}
		}
	}

	//一个大数数组*一个int小数
	public static int[] getBigNum(int[] ints,int num){
		
		//将数组每一位与num做相乘的值存到数组对应的位置上
		for (int i = 0; i < ints.length; i++) {
			ints[i]*=num;
		}
		//将数组从后往前进行进位或者留值
		for (int i = ints.length-1; i >1 ; i--) {
			ints[i-1]=ints[i-1]+ints[i]/10;//i-1位上将i位的值进位
			//System.out.println("int["+(i-1)+"]:"+ints[i-1]);
			ints[i]=ints[i]%10;//本身位置上留个位值
			//System.out.println("int["+i+"]:"+ints[i]);
		}
		return ints;
	}
	//一个大数数组*一个大数数组
	public static int[] getBigNums(int[] num1,int[] num2){
		int[] temp = getBigNum(num1, num2[num2.length-1]);
		//将数组每一位与num做相乘的值存到数组对应的位置上
		for (int i = num2.length-1; i>1;i--) {
			int a=1;
			temp = getBigNumSum(temp,getBigNum(num1, num2[i]),a);
			a++;
			
		}
		
		return temp;
	}
	//两个数错位相加
	public static int[] getBigNumSum(int[]num1,int[] num2,int a){
		for (int i = num1.length-1; i>1;i--) {
			num1[i-a]=num1[i-a]+num2[i];
		}
		for (int i = num1.length-1; i >1 ; i--) {
			num1[i-a]=num1[i-a]+num1[i]/10;//i-1位上将i位的值进位
			
			num1[i]=num1[i]%10;//本身位置上留个位值
			
		}
		return num1;
	}
}
