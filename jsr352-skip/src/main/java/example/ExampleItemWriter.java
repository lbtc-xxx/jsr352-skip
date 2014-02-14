package example;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named
public class ExampleItemWriter extends AbstractItemWriter {

	@Override
	public void writeItems(List<Object> items) throws Exception {
		System.out.println("write: " + items);
	}

}
