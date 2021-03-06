package test.sprintdatajpa.philz.repository;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import test.sprintdatajpa.philz.domain.Bookmark;
import test.sprintdatajpa.philz.domain.Bookmarks;
import test.sprintdatajpa.philz.domain.FileGroup;
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
	@Transactional
	@Rollback(false)
	@DisplayName("V3 폴더와 북마크 모두 있을 경우")
	public void v3_folder_and_bookmark_all_exist() {

		Folder folderA = new Folder();
		folderA.setName("folder a");
		folderA.setShare(false);

		Folder folderB = new Folder();
		folderB.setName("folderB b");
		folderB.setShare(false);

		Bookmark bookmarkA = new Bookmark();
		bookmarkA.setUrl("www.google.com");

		Bookmark bookmarkB = new Bookmark();
		bookmarkA.setUrl("www.naver.com");

		folderA.addChildren(folderB, bookmarkA);

		Folders folders = new Folders(Arrays.asList(folderA, folderB));
		Bookmarks bookmarks = new Bookmarks(Arrays.asList(bookmarkA, bookmarkB));

		FileGroup fileGroup = new FileGroup();
		fileGroup.addGroup(folders);
		fileGroup.addGroup(bookmarks);

		fileGroup.somethingDoAll();
	}
}