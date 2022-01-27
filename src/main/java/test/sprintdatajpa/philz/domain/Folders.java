package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Folders extends Files {

	private List<Folder> folders = new ArrayList<>();

	public Folders(List<Folder> folders) {
		this.folders = folders;
	}

	public Boolean isExist() {
		return folders.size() > 0;
	}

	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here Folders : 동작 수행");
		out.println("---------------------------");
	}
}
