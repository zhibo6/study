package org.study.demo.classloader;

public class ClassLoaderDemo1 {
	public static void main(String [] args){
		try {
			ClassLoader system = ClassLoader.getSystemClassLoader();
			Class<Config> cls = null;
			
//			System.out.println("----------方法3----------");
//			cls = (Class<Config>)Class.forName("com.ips.classloader.Config", true, system);
//			
//			System.out.println("----------方法1----------");
//			cls = (Class<Config>)Class.forName("com.ips.classloader.Config");
//			
//			System.out.println("----------方法2----------");
//			cls = (Class<Config>)Class.forName("com.ips.classloader.Config", false, system);
			

			
			System.out.println("-----方法4-----");
			cls = (Class<Config>)ClassLoader.getSystemClassLoader().loadClass("com.ips.classloader.Config");
			
//			System.out.println("-----ClassLoader.getSystemClassLoader().loadClass(String name, boolean resolve)-----");
//			cls = (Class<Config>)ClassLoader.getSystemClassLoader().loadClass("com.ips.classloader.Config", true);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
