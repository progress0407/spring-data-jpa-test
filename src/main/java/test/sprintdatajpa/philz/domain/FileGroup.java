package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileGroup extends Files {

	private List<Files> fileList = new ArrayList<>();

	public FileGroup() {
	}

	public void addGroup(Files files) {
		fileList.add(files);
	}

	public void somethingDoAll() {
		for (Files file : fileList) {
			file.somethingDo();
		}
	}

	@Override
	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here FileGroup : 동작 수행");
		out.println("---------------------------");
	}
}
