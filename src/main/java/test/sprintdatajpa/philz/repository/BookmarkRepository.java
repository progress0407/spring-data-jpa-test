package test.sprintdatajpa.philz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.sprintdatajpa.philz.domain.Bookmark;
import test.sprintdatajpa.philz.domain.File;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {
}
