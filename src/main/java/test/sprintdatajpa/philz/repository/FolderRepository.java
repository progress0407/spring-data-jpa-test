package test.sprintdatajpa.philz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.sprintdatajpa.philz.domain.File;
import test.sprintdatajpa.philz.domain.Folder;

public interface FolderRepository extends JpaRepository<Folder, String> {
}
