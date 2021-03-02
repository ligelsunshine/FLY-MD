package com.fly.server.learndemo.javaknowlege.test;

import com.fly.server.learndemo.javaknowlege.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

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

    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        // 常量
        System.out.println("~~~~~~~~~~~~~~~~~~~~数据类型~~~~~~~~~~~~~~~~~~~~~~~");
        final Integer CIRCL_FAAFA = 13131313;
        System.out.println("二进制数：" + 0B101);
        System.out.println("十进制：" + 123);
        System.out.println("二进制：" + 0b101_10101_1110_1111);
        System.out.println("十六进制：" + 0X1110CFE1);
        System.out.println("长整数：" + 1234141414L);
        BigDecimal aa = new BigDecimal(231241.12323);
        System.out.println("小数：" + aa);
        double d = 1231313F;
        System.out.println("判断：" + Double.isNaN(d));
        System.out.println("正无穷" + Double.POSITIVE_INFINITY);
        System.out.println("负无穷" + Double.NEGATIVE_INFINITY);
//        结果为无穷大
        System.out.println("浮点数除以零：" + d / 0);
        System.out.println("平方：" + Math.sqrt(2.14) + "幂" + Math.pow(2.14, 4));
        int n = 0b1111;
        System.out.println(0b1110 << 1);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~字符串String~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String string = "helloWorld";
        System.out.println(string.substring(0, 3));
        int codeCount = string.codePointCount(0, string.length());
        System.out.println("码点：" + codeCount);
        int index = string.offsetByCodePoints(0, 3);
        System.out.println(string.codePointAt(index));
        System.out.println("获取最后一个码点内容：" + string.charAt(string.length() - 1));
        /*查看字符串每一位码点*/
        int[] codePoints = string.codePoints().toArray();
        int indexI = 0;
        for (int point : codePoints) {
            System.out.println("第" + indexI + "码点" + point);
            indexI++;
        }
        /*把码点转换成String*/
        String stringNew = new String(codePoints, 0, codePoints.length);
        System.out.println("码点转换成字符串：" + stringNew);
        System.out.println(string.compareTo(stringNew));

        StringBuilder stringBuilder = new StringBuilder();
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
        double number = 1231313.231313131;
        System.out.printf("%8.2f\n", number);
        System.out.printf("%x\n", 12313123);
        System.out.printf("%tc\n", new Date());
        System.out.printf("%tF\n", new Date());
        System.out.printf("%tD\n", new Date());
        System.out.printf("%tT  \n", new Date());

        BigDecimal bigDecimal = BigDecimal.valueOf(number);
        bigDecimal.add(bigDecimal);
        bigDecimal.subtract(bigDecimal);
        bigDecimal.multiply(bigDecimal);
        bigDecimal.divide(bigDecimal);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~数组~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] arrayList = {9, 7, 2, 4, 5, 6, 3, 8};
        Arrays.sort(arrayList);
        System.out.println("打印数组：" + Arrays.toString(arrayList));
        int[] newArrayList = Arrays.copyOf(arrayList, arrayList.length);
        System.out.println("拷贝后的数组：" + Arrays.toString(newArrayList));
        int[][] binaryW = {
                {1, 3, 4},
                {2, 3, 4}
        };
        String s = Arrays.deepToString(binaryW);
        System.out.println(s);
        for (int i = 0; i < binaryW.length; i++) {
            // 内部可以用迭代器来遍历
            for (int i1 : binaryW[i]) {
                System.out.println("二维数组遍历：" + i1);
            }
        }
        int maxIndex = 10;
        int[][] odds = new int[maxIndex][];
        // 画杨辉三角，for循环和递归
        //printArrayW(createWByFor(maxIndex));
        LocalDateTime now = LocalDateTime.now();
        System.out.println("一千年以后：" + now.plusDays(1000));
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek.getValue()+" "+ dayOfWeek);
        System.out.println(now.getMonth()+ " "+now.getDayOfMonth()+ " " + now.getMonth()+ " "+ now.minusDays(2) );

        System.out.println("~~~~~~~~~~~~~~~~~~~~~对象~~~~~~~~~~~~~~~~~~~~~~");
        BaseObject object= new BaseObject();
        BaseObject object1= new BaseObject();
        BaseObject object2 = new BaseObject();
        BaseObject object3= new BaseObject();
        BaseObject object4= new BaseObject();
        BaseObject object5 = new BaseObject();
        System.out.println("对象初始化次数："+BaseObject.count);

        Random random= new Random();
        int i = random.nextInt(1024);
        System.out.println(i);
        java.time.LocalDateTime today= java.time.LocalDateTime.now();
        System.out.println(today);

        ExBaseObject exBaseObject= new ExBaseObject(1, "user", "131313131", new Date());
        ExBaseObject clone = exBaseObject.clone();
        clone.setDate(new Date());
        System.out.println(clone+ " " + exBaseObject);
        System.out.println("~~~~~~~~~~~~~~~~~~~~数组自带public clone方法~~~~~~~~~~~~~~~~~~~~~~~");
        int[][] copy= createWByFor(8).clone();
        printArrayW(copy);
        TalkingClock talkingClock= new TalkingClock(1, true);
        talkingClock.start();
        // 构建内部类
        TalkingClock.TimePrinter timePrinter = talkingClock.new TimePrinter();
        System.out.println("~~~~~~~~~~~~~~~~~~~~静态内部类的使用~~~~~~~~~~~~~~~~~~~~~~~");
        StaticInnerClass.Pair minmax = StaticInnerClass.minmax(arrayList);
        System.out.println("最大："+minmax.getMax()+ "最小："+ minmax.getMin());

        System.out.println("~~~~~~~~~~~~~~~~~~~~泛型编程~~~~~~~~~~~~~~~~~~~~~~~");
        Pair<BaseObject> pair= new Pair<BaseObject>(exBaseObject,exBaseObject );
        Pair<String> stringPair= new Pair<>();
        System.out.println(pair.getFirst());
        // getClass 返回的是原始类型Pair
        boolean b = stringPair.getClass() == pair.getClass();
        // java 不支持泛型类型数组
        // 不能再静态域和方法中引用类型变量
        // 泛型类不能拓展Throwable

        System.out.println("~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~");
        int[] abba= new int[8];
        StaticInnerClass.Pair minmax1 = StaticInnerClass.minmax(abba);
        System.out.println("自定义异常");

        System.out.println("~~~~~~~~~~~~~~~~~~~~并发，多线程~~~~~~~~~~~~~~~~~~~~~~~");
        // 创建线程
        Runnable task = () ->{
            System.out.println("this is the first thread");
        };
        Thread thread= new Thread(task);
        try {
            // thread.wait(500);
            thread.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 常见线程的第二种方式，使用lambda表达式
        Thread thread1 = new Thread(() ->{
            System.out.println("fajfakf a");
        });
        thread1.start();

        System.out.println("~~~~~~~~~~~~~~~~~~~~异常处理~~~~~~~~~~~~~~~~~~~~~~~");
        ExceptionLearn exceptionLearn = new ExceptionLearn();
        exceptionLearn.learnTest();


        System.out.println("~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~");
    }





    private static int[][] createWByFor(int MaxIndex){
        int[][] odds= new int[8][];
        for (int i = 0; i <odds.length ; i++) {
            odds[i]= new int[i+1];
            for (int j = 0; j <odds[i].length-1 ; j++) {
                if (i==0 || j==0 || j == odds[i].length-1) {
                    odds[i][j] = 1;
                }else {
                    odds[i][j] = odds[i-1][j] + odds[i-1][j-1];
                }
            }
        }
        return odds;
    }
    private static void printArrayW(int[][] aa){
        for (int i = 0; i < aa.length ; i++) {
            for (int j = 0; j <aa[i].length ; j++) {
                if (j== aa[i].length-1 && i< aa.length-1) {
                    System.out.println(aa[i][j]);
                }
                System.out.print(aa[i][j]+ "\t");

                if (j== aa[i].length-1 && i== aa.length-1){
                    System.out.println();
                }
            }
        }
    }
}
