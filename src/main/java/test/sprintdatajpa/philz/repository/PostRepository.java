package test.sprintdatajpa.philz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.sprintdatajpa.philz.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
