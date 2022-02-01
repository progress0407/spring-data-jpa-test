package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import test.sprintdatajpa.philz.repository.FolderRepository;

@Component
@NoArgsConstructor
public class Folders extends Files {

	private List<Folder> folders = new ArrayList<>();

	@Autowired
	private FolderRepository folderRepository;

	public Folders(List<Folder> folders) {
		this.folders = folders;
	}

	@Override
	public Boolean isExist() {
		return folders.size() > 0;
	}

	@Override
	public Boolean isNotExist() {
		return !isExist();
	}

	@Override
	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here Folders : 동작 수행");
		folderRepository.saveAll(folders);
		out.println("---------------------------");
	}
}
