package com.jad.test;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test2() {
        Parser.init(); // 初始化变量
        // Parser.identifyVnVt(Parser.readFile(new File(Parser.PATH)));// 符号分类,并以key-value形式存于MAP中
        Parser.identifyVnVt(Parser.InitGrammar());
        Parser.reformMap();// 消除左递归和提取左公因子
        Parser.findFirst(); // 求FIRST集合
        Parser.findFollow(); // 求FOLLOW集合
        if (Parser.isLL1()) {
            Parser.preForm(); // 构建预测分析表
            // printAutoPre("aacbd"); // 示例推导
            System.out.println("请输入要分析的单词串:");
            Scanner in = new Scanner(System.in);
            Parser.printAutoPre(in.nextLine());
            in.close();
        }
    }
}