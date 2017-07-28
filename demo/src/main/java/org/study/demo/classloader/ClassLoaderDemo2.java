package org.study.demo.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo2 {
	public static void main(String[] args) {
		URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		System.out.println(appClassLoader);
		
		System.out.println("AppClassLoader 的加载路径: ");
		URL[] urls = appClassLoader.getURLs();
		for (URL url : urls)
			System.out.println(url);

		System.out.println("----------------------------");		

		URLClassLoader extClassLoader = (URLClassLoader) appClassLoader.getParent();
		System.out.println(extClassLoader);
		
		System.out.println("ExtClassLoader 的加载路径: ");
		urls = extClassLoader.getURLs();
		for (URL url : urls)
			System.out.println(url);

		System.out.println("----------------------------");

		System.out.println(extClassLoader.getParent());
		
		System.out.println("BootstrapClassLoader 的加载路径: ");
		urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (URL url : urls)
			System.out.println(url);
		System.out.println("----------------------------");



	}
}