package com.javaman.bytecode;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * @author pengzhe
 * @date 2019-07-02 16:56
 */
public class JavassistTest {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc = pool.makeClass("com.javaman.Programmer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);

        //定义code方法
        CtMethod coding = CtNewMethod.make("public void coding(){}", cc);

        //插入方法代码
        coding.insertBefore("System.out.println(\"哲哥.....\");");
        cc.addMethod(coding);

        //保存生成的字节码
        cc.writeFile(System.getProperty("user.dir"));
        System.out.println("finished");
    }
}
