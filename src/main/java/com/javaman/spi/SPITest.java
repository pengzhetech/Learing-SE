package com.javaman.spi;


import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * *
 * * @author pengzhe
 * * @date 2019-02-22 14:12
 * * <p>
 * * 在系统的各个模块中,往往有不同的实现方案,例如数据库连接,日志模块的方案,为了在装载模块时不具体指明实现类,
 * * 我们需要一种服务发现机制,这就是java spi机制,将服务的装配控制权移到程序控制之外
 */

public class SPITest {
    public static void main(String[] args) {

        int a = 7;
        int b = 3;

        INumberOperate iNumberOperate = new INumberOperateImpl();
        iNumberOperate.operate(a, b);
        System.out.println("-----------------------------------------------------");
        ServiceLoader<INumberOperate> loader = ServiceLoader.load(INumberOperate.class);
        Iterator<INumberOperate> iterator = loader.iterator();
        while (iterator.hasNext()) {
            INumberOperate next = iterator.next();
            next.operate(a, b);
        }
    }
}
