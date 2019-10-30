package edu.umb.cs.cs680;

import java.util.EventListener;

public interface StockEvObserver extends EventListener {

	void updateStock(StockEvent se);
}
	