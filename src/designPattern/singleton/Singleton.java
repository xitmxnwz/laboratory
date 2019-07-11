package designPattern.singleton;

 public class Singleton {
//	 //懒汉（不安全）
//	 private Singleton() {};
//	 private static Singleton sgl;
//	 public static  Singleton getIns() {
//		 if(sgl==null) {
//			 sgl = new Singleton();
//		 }
//		 return sgl;
//	 }
	 
//	//懒汉（安全）
//	 private Singleton() {};
//	 private static Singleton sgl;
//	 public static synchronized Singleton getIns() {
//		 if(sgl==null) {
//			 sgl = new Singleton();
//		 }
//		 return sgl;
//	 }
		 
		 
//	//饿汉
//	 private Singleton() {};
//	 private static Singleton sgl=new Singleton();
//	 public static  Singleton getIns() {
//		 return sgl;
//	 }
	 
//	//饿汉(变种）
//	 private Singleton() {};
//	 private static Singleton sgl;
//	 static {
//		 sgl = new Singleton();
//	 }
//	 public static  Singleton getIns() {
//		 return sgl;
//	 }
	 
//	//静态内部类
//	 private Singleton() {};
//	 private static class InnerSingle{
//		 private static Singleton sgl = new Singleton();
//	 }
//	 public static final Singleton getIns() {
//		 return InnerSingle.sgl;
//	 }
	 
	 //双重校验锁
	 private Singleton() {};
	 private volatile static Singleton sgl; 
	 public static final Singleton getIns() {
		 if(sgl==null) {
			 synchronized(Singleton.class){
				 if(sgl==null) {
					 sgl = new Singleton();
				 }
			 }
		 }
		 return sgl;
	 }
	 
	 
	 
	 
	 
 }  
 
// 枚举 
// public enum Singleton{
//	 SQL;
//	 public void getIns() {
//		 
//	 }
// }
 