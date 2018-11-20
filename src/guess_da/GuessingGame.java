package guess_da;

import java.util.Scanner;
public class GuessingGame {
	public static void main(String[] args) {
		int count=0;            //��¼��Ҳ²���ܴ���
		char input[]=null;      //�����û��²������
		char chs[]=generate();       //����������ɵ���ĸ
		int result[]=new int[2]; //��һ��������ȫ�¶���ĸ���� �ڶ�������¶���ĸ����
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("GuessingGame ��ӭ���Բ���ĸ��Ϸ!");
		
		System.out.println("��Ϸ��ʼ�����������µ�5����ĸ���У���exit-�˳���");
		while(true) {
			String inputStr=scanner.next().trim().toUpperCase();  //scanner.next()�ǴӼ�������һ���ַ�����trim��ȥ���ַ�����β�Ŀո�toUpperCase�ǰ��ַ����е���ĸת���ɴ�д
			if("EXIT".equals(inputStr)) {
				System.out.println("��л���ĳ��ԣ��ټ���");
				break;
			}
			input=inputStr.toCharArray(); //���ַ���תΪchar�ַ�����
			result=check(chs,input);
			if(result[0]==chs.length) {
				int score=100*chs.length-count*10;
				System.out.println("��ϲ��¶��ˣ���ĵ÷���"+score);
				break;
			}else {
				count++;
				System.out.println("��¶�"+result[1]+"���ַ�������"+result[0]+"���ַ�λ����ȷ!(�ܴ���="+count+",exit-�˳�)");
			}
		}
		scanner.close();
	}
	/**
	*���������Ҫ�²����ĸ����
	*@return �洢����ַ�������
	*/
	public static char[] generate(){
		char[] chs =new char[5];
		char letters[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
				'T','U','V','W','X','Y','Z'};
		boolean flags[]=new boolean[letters.length];  //������ĸ�Ƿ�ѡ��
		for(int i=0;i<chs.length;i++) {               //���ѡ��5����ĸ
			int index;
			do {
				index =(int)(Math.random()*(letters.length));  //0��25�������
			}while(flags[index]==true);   //���±��Ӧ�Ŀ���Ϊtrueʱ����ʾ�Ѵ����Ӧ��������index
                                          //���±��Ӧ�Ŀ�ͷΪfalseʱ����ʾδ�������index���ã�do...while����
			chs[i]=letters[index];
			flags[index]=true;
		}
		return chs;
	}
	/**
	 * �Ƚ����������ĸ���кͳ�����������ĸ���У���һ�Ƚ��ַ��Լ�λ�ã������رȽϽ��
	 * @param chs
	 *            ����������ĸ����
	 * @param input
	 * 			  ��������ַ�����
	 * @return �洢�ȽϵĽ��
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
