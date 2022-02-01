package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import java.util.Objects;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark extends File {

	String url;

	@Override
	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here Bookmark : 동작 수행");
		out.println("---------------------------");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Bookmark bookmark = (Bookmark)o;
		return Objects.equals(getUrl(), bookmark.getUrl());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUrl());
	}
}
