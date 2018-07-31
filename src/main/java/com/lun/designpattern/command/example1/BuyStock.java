package com.lun.designpattern.command.example1;

public class BuyStock implements Order {
	   private Stock abcStock;
	
	   public BuyStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }
	
	   public void execute() {
	      abcStock.buy();
	   }
}
