package guess_da;

import java.util.Scanner;
public class GuessingGame {
	public static void main(String[] args) {
		int count=0;            //记录玩家猜测的总次数
		char input[]=null;      //保存用户猜测的数据
		char chs[]=generate();       //保存随机生成的字母
		int result[]=new int[2]; //第一个保存完全猜对字母个数 第二个保存猜对字母个数
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("GuessingGame 欢迎尝试猜字母游戏!");
		
		System.out.println("游戏开始，请输入所猜的5个字母序列：（exit-退出）");
		while(true) {
			String inputStr=scanner.next().trim().toUpperCase();  //scanner.next()是从键盘输入一个字符串，trim是去掉字符串首尾的空格，toUpperCase是把字符串中的字母转换成大写
			if("EXIT".equals(inputStr)) {
				System.out.println("感谢您的尝试，再见！");
				break;
			}
			input=inputStr.toCharArray(); //把字符串转为char字符数组
			result=check(chs,input);
			if(result[0]==chs.length) {
				int score=100*chs.length-count*10;
				System.out.println("恭喜你猜对了！你的得分是"+score);
				break;
			}else {
				count++;
				System.out.println("你猜对"+result[1]+"个字符，其中"+result[0]+"个字符位置正确!(总次数="+count+",exit-退出)");
			}
		}
		scanner.close();
	}
	/**
	*随机生成需要猜测的字母序列
	*@return 存储随机字符的数组
	*/
	public static char[] generate(){
		char[] chs =new char[5];
		char letters[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
				'T','U','V','W','X','Y','Z'};
		boolean flags[]=new boolean[letters.length];  //记载字母是否被选中
		for(int i=0;i<chs.length;i++) {               //随机选择5个字母
			int index;
			do {
				index =(int)(Math.random()*(letters.length));  //0到25的随机数
			}while(flags[index]==true);   //当下标对应的开关为true时，表示已存过，应重新生成index
                                          //当下标对应的开头为false时，表示未存过，则index可用，do...while结束
			chs[i]=letters[index];
			flags[index]=true;
		}
		return chs;
	}
	/**
	 * 比较玩家输入字母序列和程序所生成字母序列，逐一比较字符以及位置，并记载比较结果
	 * @param chs
	 *            程序生成字母序列
	 * @param input
	 * 			  玩家输入字符序列
	 * @return 存储比较的结果
	 */
	public static int []check (char[] chs,char[] input) {
		int result[]=new int[2];
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<chs.length;j++) {
				if(input[i]==chs[j]) {
					result[1]++;
					if(i==j) {
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
