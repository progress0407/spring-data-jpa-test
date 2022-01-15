package test.sprintdatajpa.philz.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.sprintdatajpa.philz.repository.PostRepository;

@SpringBootTest
public class PostSimpleSavePerformanceTest {

	@Autowired
	PostRepository postRepository;

	// #avgElapsedTime = 958.5
	@Test
	void save() {
		List<Long> elapsedTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			for (int j = 0; j < 1000; j++) {
				Post post = Post.builder().name("post " + j).build();
				postRepository.save(post);
			}
			long elapsedTime = (System.currentTimeMillis() - start);
			elapsedTimes.add(elapsedTime);
			System.out.println("elapsed time : " + elapsedTime);
		}
		double avgElapsedTime = elapsedTimes.stream().mapToLong(e -> e).average().getAsDouble();
		System.out.println("#avgElapsedTimeList = " + elapsedTimes);
		System.out.println("#avgElapsedTime = " + avgElapsedTime);
	}

	// #avgElapsedTime = 467.3
	@Test
	void saveAllTest() {
		List<Long> elapsedTimes = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			List<Post> posts = new ArrayList<>();

			for (int j = 0; j < 1000; j++) {
				Post post = Post.builder().name("post " + j).build();
				posts.add(post);
			}

			postRepository.saveAll(posts);

			long elapsedTime = (System.currentTimeMillis() - start);
			elapsedTimes.add(elapsedTime);
			System.out.println("elapsed time : " + elapsedTime);
		}
		double avgElapsedTime = elapsedTimes.stream().mapToLong(e -> e).average().getAsDouble();
		System.out.println("#avgElapsedTime = " + avgElapsedTime);
	}
}
