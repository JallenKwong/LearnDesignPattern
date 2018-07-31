# 设计模式 - 构建者模式 #

### 介绍 ###

**意图**：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。

**主要解决**：主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。

**何时使用**：一些基本部件不会变，而其组合经常变化的时候。

### 实现 ###

	public class NutritionFacts {
	
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;//钠
		private final int carbohydrate;//碳水化合物
		
		public static class Builder{
			private final int servingSize;
			private final int servings;
			
			private int calories = 0;
			private int fat = 0;
			private int carbohydrate = 0;
			private int sodium = 0;
			
			public Builder(int servingSize, int servings) {
				super();
				this.servingSize = servingSize;
				this.servings = servings;
			}
			
			public Builder calories(int val) {
				calories = val;
				return this;
			}
			public Builder fat(int val) {
				fat = val;
				return this;
			}
			public Builder carbohydrate(int val) {
				carbohydrate = val;
				return this;
			}
			public Builder sodium(int val) {
				sodium = val;
				return this;
			}
			
			public NutritionFacts build() {
				return new NutritionFacts(this);
			}
			
		}
		
		private NutritionFacts(Builder builder) {
			servingSize = builder.servingSize;
			servings = builder.servings;
			calories = builder.calories;
			fat = builder.fat;
			sodium = builder.sodium;
			carbohydrate = builder.carbohydrate;
		}
		
		public static void main(String[] args) {
			
			NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
					.calories(100)
					.sodium(35)
					.carbohydrate(27)
					.build();
		}
	
	}

### 参考及引用 ###

1.《Effective Java中文版（第二版）》Joshua Bloch著，杨春华&俞黎敏 译

[2.建造者模式 | 菜鸟教程](http://www.runoob.com/design-pattern/builder-pattern.html)