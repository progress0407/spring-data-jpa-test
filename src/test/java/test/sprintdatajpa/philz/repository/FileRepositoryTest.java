package test.sprintdatajpa.philz.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.sprintdatajpa.philz.domain.Bookmark;
import test.sprintdatajpa.philz.domain.Files;
import test.sprintdatajpa.philz.domain.Folder;

@SpringBootTest
class FileRepositoryTest {

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private FolderRepository folderRepository;

	@Autowired
	private BookmarkRepository bookmarkRepository;

	@Test
	void test1() {
		Folder folderA = new Folder();
		folderA.setName("folder a");
		folderA.setShare(false);

		Folder folderB = new Folder();
		folderB.setName("folderB b");
		folderB.setShare(false);

		Bookmark bookmarkA = new Bookmark();
		bookmarkA.setUrl("www.naver.com");

		folderA.addChildren(folderB, bookmarkA);

		fileRepository.saveAll(Arrays.asList(folderA, folderB, bookmarkA));
		folderRepository.saveAll(Arrays.asList(folderA, folderB));
		bookmarkRepository.save(bookmarkA);

		List<Folder> findFolders = folderRepository.findAll();
		List<Bookmark> findBookmarks = bookmarkRepository.findAll();

		Files files = new Files();

		if (findFolders.size() > 0) {

		} else if (findBookmarks.size() > 0) {

		} else {

		}
	}
}