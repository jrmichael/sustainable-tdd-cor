package cor.processors;

public class ProcessorFactory {

	public Processor getProcessor() {
		return largeValueProcessor(smallValueProcessor(terminalProcessor()));
	}

	public TerminalProcessor terminalProcessor() {
		return new TerminalProcessor();
	}

	public SmallValueProcessor smallValueProcessor(Processor processor) {
		return new SmallValueProcessor(processor);
	}

	public LargeValueProcessor largeValueProcessor(Processor processor) {
		return new LargeValueProcessor(processor);
	}
}
