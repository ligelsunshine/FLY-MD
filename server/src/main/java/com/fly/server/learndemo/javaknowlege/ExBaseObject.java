package com.fly.server.learndemo.javaknowlege;

import lombok.Data;

import java.util.Date;

/**
 * description: ExplandBaseObject
 * date: 2021/3/1 16:11
 * version: 1.0
 *
 * @author: LIGEL
 */
@Data
public class ExBaseObject extends BaseObject implements Comparable<Object>, Cloneable {
    private Date date;

    public ExBaseObject(Integer id, String userName, String passWord, Date date) {
        super(id,userName,passWord);
        this.date = date;
    }

    public ExBaseObject() {
    }

    @Override
    public int compareTo(Object o) {
        /*只有实现该方法才能调用对象排序方法*/
        return 0;
    }

    /**
     * description: 重写clone方法
     * version: 1.0
     * date: 2021/3/1 19:34
     * @author: LIGEL
     * @param
     * @return java.lang.Object
     */
    @Override
    public ExBaseObject clone() throws CloneNotSupportedException {
        return (ExBaseObject)super.clone();
    }

    public boolean compareT(){

        return  true;
    }

}
