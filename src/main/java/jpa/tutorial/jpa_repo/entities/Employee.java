package jpa.tutorial.jpa_repo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass
@Data
@ToString
@DiscriminatorColumn(name = "type")
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
