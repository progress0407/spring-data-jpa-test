package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Bookmarks extends Files {

	private List<Bookmark> bookmarks = new ArrayList<>();

	public Bookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public Boolean isExist() {
		return bookmarks.size() > 0;
	}

	@Override
	public Boolean isNotExist() {
		return !isExist();
	}

	@Override
	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here Bookmarks : 동작 수행");
		out.println("---------------------------");
	}
}
