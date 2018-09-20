package com.example.javaemo.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Title:com.example.javaemo.file
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/15  11:22
 */
public class Persion implements Serializable {

    private static final long serialVersionUID = 100l;
    private String name;
    private  int age ;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //自定义序列化，来自定处理序列化方法
    //自定义序列化，负责写入特定类的实例状态
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }
    //自定义序列化，负责从流中读取并恢复对象的实例变量
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
