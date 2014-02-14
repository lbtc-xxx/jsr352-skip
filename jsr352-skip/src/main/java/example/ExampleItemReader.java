package example;

import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;
import javax.inject.Named;

@Named
public class ExampleItemReader implements ItemReader {

	private static final Integer[] DATA = new Integer[] { 1, 2, 3 };

	int index;

	@Override
	public Object readItem() throws Exception {
		Object item = readItem0();
		System.out.println("readItem: " + item);
		return item;
	}

	protected Object readItem0() {
		if (index >= DATA.length) {
			return null;
		}

//		if (index == 1) {
//			throw new RuntimeException("I want to skip this!");
//		}

		return DATA[index++];
	}

	@Override
	public void open(Serializable checkpoint) throws Exception {
		index = checkpoint == null ? 0 : (Integer) checkpoint;
	}

	@Override
	public void close() throws Exception {
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return index;
	}
}
