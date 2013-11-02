package model;

import javax.persistence.*;

@Entity
public class Unit {
	@Id
	@SequenceGenerator(name = "my_seq", sequenceName = "SEQ1", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	private Long Id;
	private String name;
	private String code;

	private Long super_unit_id;

	public Unit() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long ld) {
		this.Id = ld;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getSuper_unit_id() {
		return super_unit_id;
	}

	public void setSuper_unit_id(Long super_unit_id) {
		this.super_unit_id = super_unit_id;
	}

	@Override
	public String toString() {
		return "Unit [Id=" + Id + ", name=" + name + ", code=" + code
				+ ", super_unit_id=" + super_unit_id + "]";
	}

}
