import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class Main {

	//���������	
	public static int getNumber(){
				int number = 0;  
		        Random num = new Random();  
		        number = num.nextInt(100+1);  
		        return number;
		}
		//���������
	public static char getOperator(){  
	        char operator = 0;  
	        Random op = new Random();  
	        int i = op.nextInt(4);  
	        switch(i){  
	            case 0:  
	                operator = '+';  
	                break;  
	            case 1:  
	                operator = '-';  
	                break;  
	            case 2:  
	                operator = '*';  
	                break;  
	            case 3:  
	                operator = '/';  
	                break;  
	        }  
	        return operator;  
	     }
	
	public static void main(String[] args) {		
			//��������ʽ
			creatOperation();
		}
	
	static ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
	private static void creatOperation() {
		boolean flag = true;
		int num=0;
		do {
			System.out.print("��������Ҫ��������������ĸ�����");
			Scanner op_num = new Scanner(System.in);
			num = op_num.nextInt();
			if(num>=1&&num<=1000) {
				flag = true;
			}
			else {
				flag=false;
				System.out.println("��������,������");
			}
		}while(flag!=true);		
		
		ArrayList<String> Operation = new ArrayList<String>();//����ʽ
		for(int i=0;i<num;i++)
		{
			//����3~5��������
			int opration_num = 0;
			Random n = new Random();
			opration_num = n.nextInt(3)+3;
			
			String arr = "";
			for(int j=0;j<opration_num;j++){
				int number = getNumber();
				String operator = String.valueOf(getOperator());
				arr += number + operator;
			}
			arr =arr.substring(0,arr.length()-1);
			//��arrת��Ϊ����
			char[] arr_str = arr.toCharArray();
			String arrString = "";
			ArrayList<String> arrslist1 = new ArrayList<String>();
			ArrayList<String> arrslist2 = new ArrayList<String>();
			ArrayList<String> arrslist = new ArrayList<String>();
			//�洢�����
			for(int j=0;j<arr_str.length;j++) {
				if(arr_str[j]=='+'||arr_str[j]=='-'||arr_str[j]=='*'||arr_str[j]=='/') {	
					arrString=String.valueOf(arr_str[j]);
					arr_str[j]=',';
					arrslist1.add(arrString);
				}
			}
			//�洢������
			String s = new String(arr_str);
			String[] ss = s.split(",");
			for(int k=0;k<ss.length;k++) {
				arrslist2.add(ss[k]);
			}
			//��������ʽ
			String[] arrs1 = arrslist1.toArray(new String[arrslist1.size()]);//�����
			String[] arrs2 = arrslist2.toArray(new String[arrslist2.size()]);//������
			
			for(int m=0;m<arrs1.length;m++){
				arrslist.add(arrs1[m]);//�����
				arrslist.add(arrs2[m]);//������
				
			}
			arrslist.add(arrs2[arrs2.length-1]);
			String[] arrs = arrslist.toArray(new String[arrslist2.size()]);//����ʽ
						
			//�������ʽ
			System.out.println("201571030109");
			for(String arr: Operation){
				try {
					System.out.println(arr+"="+engine.eval(arr));
				} catch (ScriptException e) {
					e.printStackTrace();
				} 	
			}
			try {
				filewriter(Operation);
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	
	
}
	private static void filewriter(ArrayList<String> operation) {
		// TODO Auto-generated method stub
		
	}
}