package com.example.demo11.byyl;
public class Node {
	char firstState;
	char ch;
	char nextState;
	Node(char f,char c,char n){
		firstState = f;
		ch = c;
		nextState = n;
	}
	public String toString(){
		return "Node[firstState="+firstState+
				",ch="+ch+",nextState="+nextState+"]";
	}
}
