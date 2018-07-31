# 责任链模式 #

### 介绍 ###

**意图**：避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。

**主要解决**：职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了。

**何时使用**：在处理消息的时候以过滤很多道。

**如何解决**：拦截的类都实现统一接口。

### 实现 ###

#### 实现一 ####

创建抽象类 AbstractLogger，带有详细的日志记录级别。然后我们创建三种类型的记录器，都扩展了 AbstractLogger。每个记录器消息的级别是否属于自己的级别，如果是则相应地打印出来，否则将不打印并把消息传给下一个记录器。

![](example1/chain_pattern_uml_diagram.jpg)


	public abstract class AbstractLogger {
		public static int INFO = 1;
		public static int DEBUG = 2;
		public static int ERROR = 3;
	
		protected int level;
	
		// 责任链中的下一个元素
		protected AbstractLogger nextLogger;
	
		public void setNextLogger(AbstractLogger nextLogger) {
			this.nextLogger = nextLogger;
		}
	
		public void logMessage(int level, String message) {
			if (this.level <= level) {
				write(message);
			}
			if (nextLogger != null) {
				nextLogger.logMessage(level, message);
			}
		}
	
		abstract protected void write(String message);
	
	}

---

	public class ConsoleLogger extends AbstractLogger {
	
		public ConsoleLogger(int level) {
			this.level = level;
		}
	
		@Override
		protected void write(String message) {
			System.out.println("Standard Console::Logger: " + message);
		}
	}

---

	public class ErrorLogger extends AbstractLogger {
	
		public ErrorLogger(int level) {
			this.level = level;
		}
	
		@Override
		protected void write(String message) {
			System.out.println("Error Console::Logger: " + message);
		}
	}

---

	public class FileLogger extends AbstractLogger {
	
		public FileLogger(int level) {
			this.level = level;
		}
	
		@Override
		protected void write(String message) {
			System.out.println("File::Logger: " + message);
		}
	}

---

	public class ChainPatternDemo {
		private static AbstractLogger getChainOfLoggers() {
	
			AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
			AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
			AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
	
			errorLogger.setNextLogger(fileLogger);
			fileLogger.setNextLogger(consoleLogger);
	
			return errorLogger;
		}
	
		public static void main(String[] args) {
			AbstractLogger loggerChain = getChainOfLoggers();
	
			loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
	
			System.out.println();
			
			loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
	
			System.out.println();
			
			loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
			
			System.out.println();
		}
	}

---

运行结果

	Standard Console::Logger: This is an information.
	
	File::Logger: This is an debug level information.
	Standard Console::Logger: This is an debug level information.
	
	Error Console::Logger: This is an error information.
	File::Logger: This is an error information.
	Standard Console::Logger: This is an error information.

#### 实现二 ####

模拟Mail邮件处理 以及 Enum 的运用来演示责任链模式

	public class Enums {
		private static Random rand = new Random(47);
	
		public static <T extends Enum<T>> T random(Class<T> ec) {
			return random(ec.getEnumConstants());
		}
	
		public static <T> T random(T[] values) {
			return values[rand.nextInt(values.length)];
		}
	} 

---

	class Mail {
		// The NO's lower the probability of random selection:
		enum GeneralDelivery {
			YES, NO1, NO2, NO3, NO4, NO5
		}
	
		enum Scannability {
			UNSCANNABLE, YES1, YES2, YES3, YES4
		}
	
		enum Readability {
			ILLEGIBLE, YES1, YES2, YES3, YES4
		}
	
		enum Address {
			INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
		}
	
		enum ReturnAddress {
			MISSING, OK1, OK2, OK3, OK4, OK5
		}
	
		GeneralDelivery generalDelivery;
		Scannability scannability;
		Readability readability;
		Address address;
		ReturnAddress returnAddress;
		static long counter = 0;
		long id = counter++;
	
		public String toString() {
			return "Mail " + id;
		}
	
		public String details() {
			return toString() + ", General Delivery: " + generalDelivery + ", Address Scanability: " + scannability
					+ ", Address Readability: " + readability + ", Address Address: " + address + ", Return address: "
					+ returnAddress;
		}
	
		// Generate test Mail:
		public static Mail randomMail() {
			Mail m = new Mail();
			m.generalDelivery = Enums.random(GeneralDelivery.class);
			m.scannability = Enums.random(Scannability.class);
			m.readability = Enums.random(Readability.class);
			m.address = Enums.random(Address.class);
			m.returnAddress = Enums.random(ReturnAddress.class);
			return m;
		}
	
		public static Iterable<Mail> generator(final int count) {
			return new Iterable<Mail>() {
				int n = count;
	
				public Iterator<Mail> iterator() {
					return new Iterator<Mail>() {
						public boolean hasNext() {
							return n-- > 0;
						}
	
						public Mail next() {
							return randomMail();
						}
	
						public void remove() { // Not implemented
							throw new UnsupportedOperationException();
						}
					};
				}
			};
		}
	}
	
	public class PostOffice {
		enum MailHandler {
			GENERAL_DELIVERY {
				boolean handle(Mail m) {
					switch (m.generalDelivery) {
					case YES:
						System.out.println("Using general delivery for " + m);
						return true;
					default:
						return false;
					}
				}
			},
			MACHINE_SCAN {
				boolean handle(Mail m) {
					switch (m.scannability) {
					case UNSCANNABLE:
						return false;
					default:
						switch (m.address) {
						case INCORRECT:
							return false;
						default:
							System.out.println("Delivering " + m + " automatically");
							return true;
						}
					}
				}
			},
			VISUAL_INSPECTION {
				boolean handle(Mail m) {
					switch (m.readability) {
					case ILLEGIBLE:
						return false;
					default:
						switch (m.address) {
						case INCORRECT:
							return false;
						default:
							System.out.println("Delivering " + m + " normally");
							return true;
						}
					}
				}
			},
			RETURN_TO_SENDER {
				boolean handle(Mail m) {
					switch (m.returnAddress) {
					case MISSING:
						return false;
					default:
						System.out.println("Returning " + m + " to sender");
						return true;
					}
				}
			};
			abstract boolean handle(Mail m);
		}
	
		static void handle(Mail m) {
			for (MailHandler handler : MailHandler.values())
				if (handler.handle(m))
					return;
			System.out.println(m + " is a dead letter");
		}
	
		public static void main(String[] args) {
			for (Mail mail : Mail.generator(10)) {
				System.out.println(mail.details());
				handle(mail);
				System.out.println("*****");
			}
		}
	}


---

运行结果：

	Mail 0, General Delivery: NO2, Address Scanability: UNSCANNABLE, Address Readability: YES3, Address Address: OK1, Return address: OK1
	Delivering Mail 0 normally
	*****
	Mail 1, General Delivery: NO5, Address Scanability: YES3, Address Readability: ILLEGIBLE, Address Address: OK5, Return address: OK1
	Delivering Mail 1 automatically
	*****
	Mail 2, General Delivery: YES, Address Scanability: YES3, Address Readability: YES1, Address Address: OK1, Return address: OK5
	Using general delivery for Mail 2
	*****
	Mail 3, General Delivery: NO4, Address Scanability: YES3, Address Readability: YES1, Address Address: INCORRECT, Return address: OK4
	Returning Mail 3 to sender
	*****
	Mail 4, General Delivery: NO4, Address Scanability: UNSCANNABLE, Address Readability: YES1, Address Address: INCORRECT, Return address: OK2
	Returning Mail 4 to sender
	*****
	Mail 5, General Delivery: NO3, Address Scanability: YES1, Address Readability: ILLEGIBLE, Address Address: OK4, Return address: OK2
	Delivering Mail 5 automatically
	*****
	Mail 6, General Delivery: YES, Address Scanability: YES4, Address Readability: ILLEGIBLE, Address Address: OK4, Return address: OK4
	Using general delivery for Mail 6
	*****
	Mail 7, General Delivery: YES, Address Scanability: YES3, Address Readability: YES4, Address Address: OK2, Return address: MISSING
	Using general delivery for Mail 7
	*****
	Mail 8, General Delivery: NO3, Address Scanability: YES1, Address Readability: YES3, Address Address: INCORRECT, Return address: MISSING
	Mail 8 is a dead letter
	*****
	Mail 9, General Delivery: NO1, Address Scanability: UNSCANNABLE, Address Readability: YES2, Address Address: OK1, Return address: OK4
	Delivering Mail 9 normally
	*****

### 参考及引用 ###

1.《Java编程思想（第四版）》

[2.责任链模式](http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html)