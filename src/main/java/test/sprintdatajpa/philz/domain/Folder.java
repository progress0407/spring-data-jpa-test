package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Folder extends File {

	private boolean isShare;

	@OneToMany
	@ToString.Exclude
	private List<File> children = new ArrayList<>();

	public Folder(String id, String name, boolean isShare) {
		super(id, name);
		this.isShare = isShare;
	}

	public void addChildren(File... files) {
		Arrays.stream(files).forEach((File file) -> file.setParent(this));
		children.addAll(Arrays.asList(files));
	}

	@Override
	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here Folder : 동작 수행");
		out.println("---------------------------");
	}
}
