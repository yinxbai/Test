package com.example.demo11.byyl;
import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		DFA daf = new DFA();
		daf.input();
		System.out.println("请输入要判断的字符串(#为结束符号):");
		while(sc.hasNext()){
			String str = sc.next();
			if("#".equals(str)){
				System.out.println("程序结束，欢迎下次使用!");
				return;
			}
			char temp = daf.S.charAt(0);
			int i=0;
			for(;i<str.length();i++) {
				//System.out.println("temp="+temp);
				if (str.charAt(i) == 'a') {
					temp = daf.judeNextState(temp, 'a');
				} else if (str.charAt(i) == 'b') {
					temp = daf.judeNextState(temp, 'b');
				} else break;
			}
				if(i >= str.length() && daf.judeZ(temp))
					System.out.println("此字符串'属于'该文法");
				else
					System.out.println("此字符串'不属于'该文法");
				System.out.println("再次判断请输入字符串（若退出输入#）:");
					
			}
		}
	}

