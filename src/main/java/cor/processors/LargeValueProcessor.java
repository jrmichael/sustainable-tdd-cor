package cor.processors;

public class LargeValueProcessor extends Processor {

	private static final int MAX = 20000;
	private static final int MIN = 10000;

	public LargeValueProcessor(Processor delegate) {
		super(delegate);
	}

	@Override
	protected boolean isItMine(int value) {
		return value <= MAX && value > MIN;
	}

	@Override
	protected int doProcess(int value) {
		return value / 2;
	}

}