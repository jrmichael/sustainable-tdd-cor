package cor.processors;

public class TerminalProcessor extends Processor {

	public TerminalProcessor() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isItMine(int value) {
		return true;
	}

	@Override
	protected int doProcess(int value) {
		throw new IllegalArgumentException();
	}
}
