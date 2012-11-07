package cor.processors;

public class SmallValueProcessor extends Processor {
    @Override
    protected boolean shouldProcess(int value) {
        if (value <= MAX_SMALL_VALUE &&
                value >= MIN_SMALL_VALUE)
            return true;
        return false;
    }

    @Override
    protected int processThis(int value) {
        return (value * 2);
    }

    protected SmallValueProcessor(Processor aProcessor) {
        super(aProcessor);
    }
}
