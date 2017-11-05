package br.com.uri.led;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.uri.exception.InvalidInputException;

public class LedProcessor {

	private char[] charArray;
	private List<Integer> ledCounts;
	private List<String> answers;
	
	public void process() {
		int times = this.readInt();
		this.ledCounts = new ArrayList<>();
		
		this.processInput(times);
	}
	
	private int processInput(final int times) {
		if (times == 0) {
			this.printAnswers();
			return 1;
		}
		
		this.charArray = this.readLine().toCharArray();
		this.processLedQuantity(this.charArray.length - 1);
		
		return this.processInput(times - 1);
	}
	
	private int processLedQuantity(final int index) {
		
		this.addLedCount(index);
		
		if (index == 0) {
			this.addAnswer();
			this.resetLedCounts();
			return 1;
		}

		
		return this.processLedQuantity(index - 1);
	}

	private void addLedCount(final int index) {
		this.ledCounts.add(LedStorage.getLedQuantityAssociatedToALed().get(this.charArray[index]));
	}
	
	private String readLine() {
		final InputStream is = System.in;
		final InputStreamReader isr = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(isr);
		
		try {
			final String readLine = br.readLine();
			this.validateInput(readLine);
			return readLine;
		} catch (IOException e) {
			throw new RuntimeException("There is an error in readLine", e);
		}
	}
	
	private Integer readInt() {
		return Integer.parseInt(this.readLine());
	}
	
	void addAnswer() {
		if (this.answers == null) {
			this.answers = new ArrayList<>();
		}
		
		this.answers.add(this.ledCounts.stream().mapToInt(Integer::intValue).sum() + " leds");
	}
	
	void resetLedCounts() {
		this.ledCounts = new ArrayList<>();
	}
	
	void printAnswers() {
		this.answers.forEach(System.out::println);
	}
	
	private void validateInput(final String input) {
		if (!Pattern.compile("^\\d+$").matcher(input).matches()) {
			throw new InvalidInputException("Only numbers, please");
		}
	}
}
