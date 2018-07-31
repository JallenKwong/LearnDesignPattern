# 设计模式 - 单例模式 #

### 介绍 ###

**意图**：保证一个类仅有一个实例，并提供一个访问它的全局访问点。

**主要解决**：一个全局使用的类频繁地创建与销毁。

**何时使用**：当您想控制实例数目，节省系统资源的时候。

**如何解决**：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。

**关键代码**：构造函数是私有的。

**优点** ：

1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。 

2、避免对资源的多重占用（比如写文件操作）。

### 实现 ###

#### 1.饿汉式（立即加载方式）（线性安全） ####

	public class Singleton {
		// 私有构造
		private Singleton() {
		}
	
		private static Singleton instance = new Singleton();
	
		// 静态工厂方法
		public static Singleton getInstance() {
			return instance;
		}
	}

#### 2.懒汉式（延迟加载方式）（线性不安全） ####

	public class Singleton {
	
		// 私有构造
		private Singleton() {
		}
	
		private static Singleton instance = null;
	
		public static Singleton getInstance() {
			if (instance == null) {
				instance = new Singleton();
			}
			return instance;
		}
	}

#### 3.懒汉式（延迟加载方式）（线性安全） ####

	public class Singleton {
		private static Singleton instance;
	
		private Singleton() {
		}
	
		public static synchronized Singleton getInstance() {
			if (instance == null) {
				instance = new Singleton();
			}
			return instance;
		}
	}

缺点：synchronized使用可能造成性能低下。可用双检锁方式代替。

#### 4.双检锁Double-checked locking（线性安全） ####

	public class Singleton {
		private volatile static Singleton singleton;
	
		private Singleton() {
		}
	
		public static Singleton getSingleton() {
			if (singleton == null) {
				synchronized (Singleton.class) {
					if (singleton == null) {
						singleton = new Singleton();
					}
				}
			}
			return singleton;
		}
	}

#### 5.登记式/静态内部类（线性安全） ####

这种方式同样利用了 classloder 机制来保证初始化 instance 时只有一个线程

	public class Singleton {
		private static class SingletonHolder {
			private static final Singleton INSTANCE = new Singleton();
		}
	
		private Singleton() {
		}
	
		public static final Singleton getInstance() {
			return SingletonHolder.INSTANCE;
		}
	}

#### 6.枚举 ####

>虽然这种方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton最佳方式——Joshua Bloch

	class Resource {
	}
	
	public enum SomeThing {
		INSTANCE;
		private Resource instance;
	
		SomeThing() {
			instance = new Resource();
		}
	
		public Resource getInstance() {
			return instance;
		}
	}

	//SomeThing.INSTANCE.getInstance();//获取实例 

### 引用 ###

1.《Effective Java中文版（第二版）》Joshua Bloch著，杨春华&俞黎敏 译

[2.单例模式 | 菜鸟教程](http://www.runoob.com/design-pattern/singleton-pattern.html)

[3.单例模式的八种写法比较](https://www.cnblogs.com/zhaoyan001/p/6365064.html)

[4.Java 利用枚举实现单例模式](https://blog.csdn.net/yy254117440/article/details/52305175)

[5.【单例深思】枚举实现单例原理](https://blog.csdn.net/gavin_dyson/article/details/70832185)