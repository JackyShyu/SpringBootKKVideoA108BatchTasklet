package org.shyu.springboot.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.batch.item.ItemWriter;

public class MyItemWriter implements ItemWriter<String> {

	private Stream<String> stream;

	@Override
	public void write(List<? extends String> paths) throws Exception {
		for (String filePath: paths) {
			System.out.println("filePath: " + filePath);
			try {
				stream = Files.lines(Paths.get(filePath));
				stream.forEach(System.out::println);
			} catch (IOException e) {
				throw(e);
			}
		}
	}

}
