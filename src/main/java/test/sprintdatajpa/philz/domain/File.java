package test.sprintdatajpa.philz.domain;

import static java.lang.System.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter @ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class File {

	@Id @GeneratedValue(generator = "item_id_generator")
	@GenericGenerator(name = "item_id_generator", strategy = "uuid")
	private String id;

	private String name;

	@ToString.Exclude
	@JoinColumn(name = "PARENT_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private File parent;

	public File(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void somethingDo() {
		out.println("---------------------------");
		out.println("#here File : 동작 수행");
		out.println("---------------------------");
	}
}
