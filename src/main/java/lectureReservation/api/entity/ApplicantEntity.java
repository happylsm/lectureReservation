package lectureReservation.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="lecture_application_list")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantEntity {
	
	@Id
	@Column(name="id", nullable = false)
	private String id;
	
	@Column(name="lecture_id", nullable = false)
	private String lectureId;
	
	@Column(name="employee_id", length = 5, nullable = false)
	private String employeeId;
	
	@PrePersist
	public void randomId() {
		this.id = "A" + RandomStringUtils.randomNumeric(12);
	}
}
