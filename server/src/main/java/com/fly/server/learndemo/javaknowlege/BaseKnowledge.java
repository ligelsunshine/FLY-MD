package com.fly.server.learndemo.javaknowlege;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * description: BaseKnowlege
 * date: 2021/2/28 20:35
 * version: 1.0
 *
 * @author: LIGEL
 */

public class BaseKnowledge {
//    类常量
    private static final double CM_PER_INCH = 2.4;
    public static void main(String[] args) {
        // 常量
        System.out.println("~~~~~~~~~~~~~~~~~~~~数据类型~~~~~~~~~~~~~~~~~~~~~~~");
        final Integer CIRCL_FAAFA= 13131313;
        System.out.println("二进制数："+ 0B101);
        System.out.println("十进制："+ 123);
        System.out.println("二进制："+ 0b101_10101_1110_1111);
        System.out.println("十六进制："+ 0X1110CFE1);
        System.out.println("长整数：" + 1234141414L);
        BigDecimal aa= new BigDecimal(231241.12323);
        System.out.println("小数："+ aa);
        double d= 1231313F;
        System.out.println("判断："+ Double.isNaN(d));
        System.out.println("正无穷"+ Double.POSITIVE_INFINITY);
        System.out.println("负无穷"+ Double.NEGATIVE_INFINITY);
//        结果为无穷大
        System.out.println("浮点数除以零："+d/0);
        System.out.println("平方：" + Math.sqrt(2.14)+"幂"+ Math.pow(2.14, 4));
        int n= 0b1111;
        System.out.println(0b1110 << 1);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~字符串String~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String string= "helloWorld";
        System.out.println(string.substring(0,3));
        int codeCount= string.codePointCount(0, string.length());
        System.out.println("码点："+ codeCount);
        int index= string.offsetByCodePoints(0, 3);
        System.out.println(string.codePointAt(index));
        System.out.println("获取最后一个码点内容："+ string.charAt(string.length()-1));
        /*查看字符串每一位码点*/
        int[] codePoints = string.codePoints().toArray();
        int indexI = 0;
        for (int point : codePoints) {
            System.out.println("第"+indexI+"码点"+point);
            indexI++;
        }
        /*把码点转换成String*/
        String stringNew = new String(codePoints, 0, codePoints.length);
        System.out.println("码点转换成字符串："+ stringNew);
        System.out.println(string.compareTo(stringNew));

        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("hello");
        System.out.println(stringBuilder);
        stringBuilder.append("World");
        System.out.println(stringBuilder);
        stringBuilder.toString();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~输入输出~~~~~~~~~~~~~~~~~~~~~~~~~~");
       /* Scanner in= new Scanner(System.in);
        System.out.println(in.nextLine());*/

       /* Console console= System.console();
        String userName= console.readLine("userName:");
        char[] passWord = console.readPassword("passWord:");*/
        double number= 1231313.231313131;
        System.out.printf("%8.2f\n", number);
        System.out.printf("%x\n", 12313123);
        System.out.printf("%tc\n", new Date());
        System.out.printf("%tF\n", new Date());
        System.out.printf("%tD\n", new Date());
        System.out.printf("%tT  \n", new Date());

        BigDecimal bigDecimal= BigDecimal.valueOf(number);
        bigDecimal.add(bigDecimal);
        bigDecimal.subtract(bigDecimal);
        bigDecimal.multiply(bigDecimal);
        bigDecimal.divide(bigDecimal);

        int[] arrayList= {1,2,3,4,5,6,7,8};
        System.out.println("打印数组：" + Arrays.toString(arrayList));
        System.out.println("~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
