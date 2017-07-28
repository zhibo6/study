package org.study.demo.classloader;

import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;

public class ClassLoaderDemo {
	public static void doBootstrap() {
		System.out.println("bootstrap classload----------------------");
		final String s = System.getProperty("sun.boot.class.path");
		System.out.println(s);
		System.out.println("----------");

		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]);
		}
	}

	public static void doExt() {
		System.out.println("ext classload----------------------");
		final String s = System.getProperty("java.ext.dirs");
		System.out.println(s);
		System.out.println("----------");

		File[] dirs;
		if (s != null) {
			StringTokenizer st = new StringTokenizer(s, File.pathSeparator);
			int count = st.countTokens();
			dirs = new File[count];
			for (int i = 0; i < count; i++) {
				dirs[i] = new File(st.nextToken());
			}
		} else {
			dirs = new File[0];
		}

		for (File f : dirs) {
			System.out.println(f.getAbsolutePath());
		}
	}

	public static void doApp() {
		System.out.println("app classload----------------------");
		final String s = System.getProperty("java.class.path");
		System.out.println(s);
//		final File[] path = (s == null) ? new File[0] : getClassPath(s);
//		for (File f : path) {
//			System.out.println(f);
//		}
	}

	public static void main(String[] args) {
//		ClassLoader bootstrap = sun.misc.Launcher.getLauncher().getClassLoader();
//		ClassLoader ext = ExtClassLoader.getExtClassLoader();  
//		ClassLoader app = AppClassLoader.getAppClassLoader(ext);  
		ClassLoader system = ClassLoader.getSystemClassLoader();
//		Class.forName();
//		ClassLoader.getSystemClassLoader().loadClass();
		
		if(system != null){
			System.out.println(system);
		}
//		doBootstrap();
//		System.out.println("###########################");
//		doExt();
//		System.out.println("###########################");
//		doApp();
		
		final String s = System.getProperty("java.system.class.loader");
		System.out.println(s);
		
	}
}
