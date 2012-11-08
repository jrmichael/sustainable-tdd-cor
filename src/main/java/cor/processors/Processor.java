package cor.processors;

public abstract class Processor {

	final Processor delegate;

	public Processor(Processor delegate) {
		this.delegate = delegate;
	}

	public int process(int value) {
		if (!isItMine(value)) {
			return delegate.process(value);
		}
		return doProcess(value);
	}

	protected abstract boolean isItMine(int value);

	protected abstract int doProcess(int value);

}
