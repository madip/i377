package model;

import javax.persistence.*;

@Entity
public class Unit {
	@Id
	@GeneratedValue
	
	private Long Id;
	private String name;
	private String code;
	private String superUnitId;

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

	public String getSuperUnitId() {
        return superUnitId;
}

	public void setSuperUnitId(String superUnitId) {
	        this.superUnitId = superUnitId;
	}

	@Override
	public String toString() {
		return "Unit [Id=" + Id + ", name=" + name + ", code=" + code
				+ ", super_unit_id=" + superUnitId + "]";
	}

}
