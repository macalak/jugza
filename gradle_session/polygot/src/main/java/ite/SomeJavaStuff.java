package ite;

import java.io.PrintStream;

public class SomeJavaStuff implements SomeStuff{
	private PrintStream out;

	public SomeJavaStuff(PrintStream out){
		this.out = out;
	}
	public void doStuff() {
		out.println("I'm doing some Java stuff...");
	}
}