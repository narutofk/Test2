import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class Main {

	//产生随机数	
	public static int getNumber(){
				int number = 0;  
		        Random num = new Random();  
		        number = num.nextInt(100+1);  
		        return number;
		}
		//产生运算符
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
			//产生运算式
			creatOperation();
		}
	
	static ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
	private static void creatOperation() {
		boolean flag = true;
		int num=0;
		do {
			System.out.print("请输入需要产生的四则运算的个数：");
			Scanner op_num = new Scanner(System.in);
			num = op_num.nextInt();
			if(num>=1&&num<=1000) {
				flag = true;
			}
			else {
				flag=false;
				System.out.println("输入有误,请重试");
			}
		}while(flag!=true);		
		
		ArrayList<String> Operation = new ArrayList<String>();//运算式
		for(int i=0;i<num;i++)
		{
			//产生3~5个运算数
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
			//将arr转化为数组
			char[] arr_str = arr.toCharArray();
			String arrString = "";
			ArrayList<String> arrslist1 = new ArrayList<String>();
			ArrayList<String> arrslist2 = new ArrayList<String>();
			ArrayList<String> arrslist = new ArrayList<String>();
			//存储运算符
			for(int j=0;j<arr_str.length;j++) {
				if(arr_str[j]=='+'||arr_str[j]=='-'||arr_str[j]=='*'||arr_str[j]=='/') {	
					arrString=String.valueOf(arr_str[j]);
					arr_str[j]=',';
					arrslist1.add(arrString);
				}
			}
			//存储运算数
			String s = new String(arr_str);
			String[] ss = s.split(",");
			for(int k=0;k<ss.length;k++) {
				arrslist2.add(ss[k]);
			}
			//生成运算式
			String[] arrs1 = arrslist1.toArray(new String[arrslist1.size()]);//运算符
			String[] arrs2 = arrslist2.toArray(new String[arrslist2.size()]);//运算数
			
			for(int m=0;m<arrs1.length;m++){
				arrslist.add(arrs1[m]);//运算符
				arrslist.add(arrs2[m]);//运算数
				
			}
			arrslist.add(arrs2[arrs2.length-1]);
			String[] arrs = arrslist.toArray(new String[arrslist2.size()]);//运算式
						
			//输出运算式
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