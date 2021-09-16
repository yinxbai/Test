package com.example.demo11.byyl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DFA {
	static List<Node> listNode = new ArrayList<Node>();//状态集合
	static String S;
	static String Z;
	static boolean judeZ(char ch){
		for(int i=0;i<Z.length();i++){
			if(Z.charAt(i)==ch)
				return true;
		}
		return false;
	}
	static void input(){
		Scanner sc = new Scanner(System.in);
		String inputStr = null;
		String subStr[] = null;
		System.out.println("请输入开始符号：");
		S = sc.next();
		System.out.println("请输入终止集：");
		Z = sc.next();
		System.out.println("请输入正规文法并以end为结束：");
		System.out.println("————————");
		System.out.println("| S-aU |");
		System.out.println("| S-bV |");
		System.out.println("| U-bV |");
		System.out.println("| .... |");
		System.out.println("| end  |");
		System.out.println("————————");
		while(sc.hasNext()){
			inputStr = sc.next();
			if("end".equals(inputStr)){
				break;
			}
			subStr = inputStr.split("-|\\|");
			String s = subStr[0];
			for(int i=1;i<subStr.length;i++){
				Node n =null;
				if(subStr[i].length()==2){
					char c = subStr[i].charAt(0);//有穷符号表
					char n1 = subStr[i].charAt(1);//状态集合
					listNode.add(new Node(s.charAt(0),c,n1));//f(S,a)=U
			}
				if(subStr[i].length()==1){
					char c = subStr[i].charAt(0);//有穷符号表
					listNode.add(new Node(s.charAt(0),c,Z.charAt(0)));//f(S,a)=U
			}
				
			
		}
	}
}
	static char judeNextState(char s,char ch){
		for(int i=0;i<listNode.size();i++){
			if(s==listNode.get(i).firstState && ch==listNode.get(i).ch){
				return listNode.get(i).nextState;
			}
		}
		return '0';
	}
}