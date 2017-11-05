package br.com.uri.led;

import java.util.HashMap;
import java.util.Map;

public class LedStorage {

	private LedStorage() {}
	
	public static Map<Character, Integer> getLedQuantityAssociatedToALed() {
		final Map<Character, Integer> mapLedQuantity = new HashMap<>();
		
		mapLedQuantity.put('1', 2);
		mapLedQuantity.put('2', 5);
		mapLedQuantity.put('3', 5);
		mapLedQuantity.put('4', 4);
		mapLedQuantity.put('5', 5);
		mapLedQuantity.put('6', 6);
		mapLedQuantity.put('7', 3);
		mapLedQuantity.put('8', 7);
		mapLedQuantity.put('9', 6);
		mapLedQuantity.put('0', 6);
		
		return mapLedQuantity;
	}
	
}
