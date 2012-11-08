package cor.processors;

public class ProcessorFactory {

    public Processor getProcessor() {
        return createLargeValueProcessor(createSmallValueProcessor(createTerminalProcessor()));
    }

    Processor createLargeValueProcessor(Processor processor) {
        return new LargeValueProcessor(processor);
    }

    Processor createSmallValueProcessor(Processor processor) {
        return new SmallValueProcessor(processor);
    }

    Processor createTerminalProcessor() {
        return new TerminalProcessor();
    }

}
