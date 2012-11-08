package cor.processors;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ProcessorDelegationTest {

	private Processor delegate = mock(Processor.class);;
	private Processor processor = alwaysDelegatingProcessor(delegate);
	private static final int VALUE = 5;

	@Test
	public void DelegationHappensWhenItShould() {

		processor.process(VALUE);

		verify(delegate).process(anyInt());
	}

	@Test
	public void DelegationHappensWithUnchangedParameter() {

		processor.process(VALUE );

		verify(delegate).process(VALUE );
	}

	@Test
	public void DelegationHappensWithUnchangedReturn() {
		int returnedByDelegate = 0;
		when(delegate.process(VALUE)).thenReturn(returnedByDelegate);

		assertThat(processor.process(VALUE)).isEqualTo(returnedByDelegate);

	}

	private Processor alwaysDelegatingProcessor(Processor delegate) {
		Processor processor = new Processor(delegate) {
			@Override
			protected boolean isItMine(int value) {
				return false;
			}

			@Override
			protected int doProcess(int value) {
				return 0;
			}
		};
		return processor;
	}
}
