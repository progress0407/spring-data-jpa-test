package test.sprintdatajpa.philz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.sprintdatajpa.philz.domain.File;

public interface FileRepository extends JpaRepository<File, String> {
}
