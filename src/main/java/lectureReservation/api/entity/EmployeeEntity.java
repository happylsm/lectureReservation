package lectureReservation.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="employee")
@Data
@ToString
public class EmployeeEntity {
	@Id
	@Column(name="employe_id", length = 5, nullable = false)
	private String employeeId;
	
	@PrePersist
	public void randomId() {
		this.employeeId = "E" + RandomStringUtils.randomNumeric(4);
	}
}
