package cor.processors;

public abstract class Processor {
    public final static int MIN_SMALL_VALUE = 1;
    public final static int MAX_SMALL_VALUE = 10000;
    public final static int MIN_LARGE_VALUE = 10001;
    public final static int MAX_LARGE_VALUE = 20000;

    private  Processor nextProcessor;

    protected Processor(Processor aProcessor) {
        nextProcessor = aProcessor;
    }

    public int process(int value) {
        if(shouldProcess(value)) {
            return processThis(value);
        } else {
            return nextProcessor.process(value);
        }
    }

    protected abstract boolean shouldProcess(int value);
    protected abstract int processThis(int value);
}