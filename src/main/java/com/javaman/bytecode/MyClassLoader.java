package com.javaman.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author pengzhe
 * @date 2019-07-02 16:18
 */
public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get(
        "/Users/pengzhe/Learning/Learing-SE/src/main/java");

    private final Path classDir;

    public MyClassLoader() {
        super();
        classDir = DEFAULT_CLASS_DIR;
    }

    //允许传入指定的class路径
    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);

    }

    //允许传入指定的class路径的同时指定父类加载器
    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    /**
     * 重写父类的findClass方法
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = readClassBytes(name);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException("the class" + name + "cat not loaded");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    /**
     * 将class文件读进内存
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        //将包名分隔符转换为文件路径分隔符
        String classPath = name.replace(".", File.separator);
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("the class" + name + "not found");
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Files.copy(classFullPath, outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("the class" + name + "occur error");
        }
    }

    @Override
    public String toString() {
        return "MyClassLoader{" +
            "classDir=" + classDir +
            '}';
    }
}
