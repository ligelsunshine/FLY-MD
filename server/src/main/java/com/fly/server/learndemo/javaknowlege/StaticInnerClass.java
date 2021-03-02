package com.fly.server.learndemo.javaknowlege;

import lombok.Data;

import java.io.IOException;
import java.util.MissingFormatArgumentException;

/**
 * description: StaticInnerClass
 * date: 2021/3/1 22:07
 * version: 1.0
 * @author: LIGEL
 */
public class StaticInnerClass {

    /**
     * description:
     * version: 1.0
     * date: 2021/3/2 11:07
     * @author: LIGEL
     * @return
     */
    public static Pair minmax(int [] array) throws IOException {
        int min = array[0];
        int max = array[0];

        // 捕捉多个异常
        try {

            if (array.length <= 0) {
                throw new MyException();
            }
            for (int i : array) {
                if (min > i) {
                    min = i ;
                }
                if (max < i) {
                    max = i;
                }
            }
        }catch (NullPointerException e) {
            // 重新解释异常抛出，这里是可以使用自定义异常来解释异常的
            MyException myException = new MyException();
            // 将原始的异常封装到自定义的异常中
            myException.initCause(e);
            throw  myException;

        }catch (MissingFormatArgumentException e) {
            e.printStackTrace();

        }catch (Exception e) {
            e.printStackTrace();

        }finally {

        }

        return new Pair(min, max);
    }
    @Data
    public static class Pair
    {
        private int min;
        private int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
