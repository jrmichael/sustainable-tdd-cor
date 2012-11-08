package cor.processors;

public class TerminalProcessor extends Processor {
    @Override
    protected boolean shouldProcess(int value) {
        return true;
    }

    @Override
    protected int processThis(int value) {
        throw new IllegalArgumentException();
    }

    protected TerminalProcessor() {
        super(null);
    }
}
