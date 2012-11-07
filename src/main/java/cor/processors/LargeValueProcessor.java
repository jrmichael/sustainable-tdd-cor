package cor.processors;

public class LargeValueProcessor extends Processor {

    public LargeValueProcessor(Processor aProcessor) {
        super(aProcessor);
    }

    protected boolean shouldProcess(int value) {
        if (value >= MIN_LARGE_VALUE &&
                value <= MAX_LARGE_VALUE)
            return true;
        return false;
    }

    protected int processThis(int value) {
        return (value / 2);
    }
}