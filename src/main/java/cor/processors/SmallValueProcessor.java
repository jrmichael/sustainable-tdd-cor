package cor.processors;

public class SmallValueProcessor extends Processor {

	private static final int MAX = 10000;
	private static final int MIN = 0;

	public SmallValueProcessor(Processor delegate) {
		super(delegate);
	}

	@Override
	protected boolean isItMine(int value) {
		return value <= MAX && value >= MIN;
	}

	@Override
	protected int doProcess(int value) {
		return value * 2;
	}
}
