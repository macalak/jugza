package ite;

class SomeGroovyStuff implements SomeStuff{

	private PrintStream output;

	public SomeGroovyStuff(PrintStream output){
		this.output = output;
	}

	public void doStuff() {
		output.println "I'm doing some groovy stuff ..."
	}

}