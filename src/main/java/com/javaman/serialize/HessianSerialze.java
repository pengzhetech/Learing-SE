package com.javaman.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * @author pengzhe
 * @date 2019-07-17 16:34
 */
public class HessianSerialze {
    public static void main(String[] args) throws IOException {
        Person zhansan = new Person();
        zhansan.setName("玄登");
        zhansan.setAge(22);

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //Hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);

        ho.writeObject(zhansan);

        byte[] zhansanByte = os.toByteArray();

        ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
        //Hessian的反序列化读取对象
        HessianInput hi = new HessianInput(is);
        Person person = (Person)hi.readObject();
        System.out.println("姓名："+ person.getName());
        System.out.println("年龄："+ person.getAge());
    }
}
