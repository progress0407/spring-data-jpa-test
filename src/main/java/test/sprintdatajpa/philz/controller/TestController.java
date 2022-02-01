package test.sprintdatajpa.philz.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import test.sprintdatajpa.philz.domain.Bookmark;
import test.sprintdatajpa.philz.domain.Bookmarks;
import test.sprintdatajpa.philz.domain.FileGroup;
import test.sprintdatajpa.philz.domain.Folder;
import test.sprintdatajpa.philz.domain.Folders;

@Controller
public class TestController {

	@GetMapping("/test")
	@Transactional
	public void test() {
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
