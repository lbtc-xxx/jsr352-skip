package example;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class ExampleItemProcessor implements ItemProcessor {

	int i;

	@Override
	public Object processItem(Object item) throws Exception {
		if (i++ == 1) {
			throw new RuntimeException("I want to skip this!");
		}
		System.out.println("process: i=" + i + ", item=" + item);
		return item;
	}

}
