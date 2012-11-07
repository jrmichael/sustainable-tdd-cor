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

    public int Process(int value) {
        int returnValue = 0;

        if(shouldProcess(value)) {
            returnValue = processThis(value);
        } else {
            returnValue = nextProcessor.Process(value);
        }
        return returnValue;
    }

    protected abstract boolean shouldProcess(int value);
    protected abstract int processThis(int value);
}