package test.sprintdatajpa.philz.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.sprintdatajpa.philz.domain.Bookmark;
import test.sprintdatajpa.philz.domain.Bookmarks;
import test.sprintdatajpa.philz.domain.Files;
import test.sprintdatajpa.philz.domain.Folder;
import test.sprintdatajpa.philz.domain.Folders;

@SpringBootTest
class FileRepositoryTest {

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private FolderRepository folderRepository;

	@Autowired
	private BookmarkRepository bookmarkRepository;

	@AfterEach
	void tearDown() {
		fileRepository.deleteAll();
		folderRepository.deleteAll();
		bookmarkRepository.deleteAll();
	}

	@Test
	void 폴더와_북마크_모두_있을_경우() {
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

		Folders folders = new Folders(findFolders);
		Bookmarks bookmarks = new Bookmarks(findBookmarks);

		Files files = new Files(folders, bookmarks);

		files.somethingAllDo();
	}

	@Test
	void 폴더만_있을_경우() {
		Folder folderA = new Folder();
		folderA.setName("folder a");
		folderA.setShare(false);

		Folder folderB = new Folder();
		folderB.setName("folderB b");
		folderB.setShare(false);

		folderA.addChildren(folderB);

		List<Folder> saveList = Arrays.asList(folderA, folderB);
		fileRepository.saveAll(saveList);
		folderRepository.saveAll(saveList);

		Folders folders = new Folders(folderRepository.findAll());
		Bookmarks bookmarks = new Bookmarks();

		Files files = new Files(folders, bookmarks);

		files.somethingAllDo();

	}

	@Test
	@DisplayName("북마크만 있을 경우")
	void 북마크만_있을_경우() {
		Bookmark bookmarkA = new Bookmark();
		bookmarkA.setUrl("www.naver.com");

		fileRepository.save(bookmarkA);
		bookmarkRepository.save(bookmarkA);

		List<Bookmark> findBookmarks = bookmarkRepository.findAll();
		Folders folders = new Folders();

		Files files = new Files(folders, new Bookmarks(findBookmarks));
		files.somethingAllDo();

	}
}