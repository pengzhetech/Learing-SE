package com.javaman.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author pengzhe
 * @date 2019-07-17 16:31
 */
public class JDKSerialze {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person zhansan = new Person();
        zhansan.setName("玄登");
        zhansan.setAge(23);
        //定义一个字节数组输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);
        //将对象写入到字节数组输出，进行序列化
        out.writeObject(zhansan);

        byte[] zhansanByte = os.toByteArray();

        //字节数组输出流
        ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
        //执行反序列化，从流中读取对象
        ObjectInputStream in = new ObjectInputStream(is);

        Person person = (Person)in.readObject();

        System.out.println("姓名：" + person.getName());
        System.out.println("年龄：" + person.getAge());
    }
}
