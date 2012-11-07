package cor.processors;

public class MockProcessor extends  Processor{
    public boolean wasAskedtoProcess;
    public int valueReceived;
    public boolean willElect;
    public int returnValue;

    protected MockProcessor(Processor aProcessor) {
        super(aProcessor);
    }

    @Override
    protected boolean shouldProcess(int value) {
        wasAskedtoProcess = true;
        valueReceived = value;
        return willElect;
    }

    @Override
    protected int processThis(int value) {
        return returnValue;
    }
}
