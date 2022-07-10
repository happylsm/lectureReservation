package lectureReservation.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="lecture")
@Data
@DynamicUpdate
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureEntity {
	@Id
	@Column(name="id", nullable = false)
	private String id;
	
	@Version
	private Integer version;
	
	@Column(name="lecturer")
	private String lecturer;
	
	@Column(name="lecture_hall")
	private String lectureHall;
	
	@Column(name="lecture_day")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	private Date lectureDay;
	
	@Column(name="lecture_contents")
	private String lectureContents;
	
	@Column(name="number_applicants")
	private int numberApplicants;
	
	@PrePersist
	public void randomId() {
		this.id = "L" + RandomStringUtils.randomNumeric(12);
	}
}
