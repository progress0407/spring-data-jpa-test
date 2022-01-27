package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Files {

	private Folders folders;
	private Bookmarks bookmarks;

	// filesCheckAndExecuteMap
	private static final Map<Supplier<Boolean>, Voider> FILES_MAP = new HashMap<>();

	public Files(Folders folders, Bookmarks bookmarks) {
		this.folders = folders;
		this.bookmarks = bookmarks;

		FILES_MAP.put(this::isExist, this::somethingDo);
		FILES_MAP.put(() -> this.folders.isExist() && !this.bookmarks.isExist(), this.folders::somethingDo);
		FILES_MAP.put(() -> this.bookmarks.isExist() && !this.folders.isExist(), this.bookmarks::somethingDo);
	}

	public Boolean isExist() {
		return folders.isExist() && bookmarks.isExist();
	}

	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here Files : 동작 수행");
		out.println("---------------------------");
	}

	public void somethingAllDo() {

		for (Map.Entry<Supplier<Boolean>, Voider> entry : FILES_MAP.entrySet()) {
			Supplier<Boolean> isFilesExist = entry.getKey();
			if (isFilesExist.get()) {
				Voider somethingDo = entry.getValue();
				somethingDo.execute();
			}
		}
	}

	@FunctionalInterface
	private interface Voider {
		void execute();
	}
}
