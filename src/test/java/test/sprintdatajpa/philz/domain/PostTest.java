package test.sprintdatajpa.philz.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import test.sprintdatajpa.philz.repository.PostRepository;

@SpringBootTest
// @DataJpaTest
class PostTest {

	@Autowired
	PostRepository postRepository;

	@BeforeEach
	void setUp() {

		List<Post> posts = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Post post = new Post("post " + i);
			posts.add(post);

		}
		postRepository.saveAll(posts);
	}
	
	@AfterEach
	void after() {
		postRepository.deleteAll();
	}

	@Test
	void findByIdTest() {
		List<Post> posts = postRepository.findAll();
		System.out.println("------------ #1 -------------");
		posts.forEach(System.out::println);
	}

	@Test
	void findByName() {
		Post findPost = postRepository.findByName("post 1").get();
		System.out.println("------------ #2 -------------");
		System.out.println("findPost = " + findPost);
	}
}