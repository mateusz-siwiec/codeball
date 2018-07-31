package pl.mateusz.codeballbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue
    private Integer id;
    private EnrollmentStatus enrollmentStatus;
    @JsonIgnore
    @ManyToOne
    private User user;
    private Integer enrollerId;

    public Enrollment() {
    }

    public Enrollment(EnrollmentStatus enrollmentStatus, User userId, Integer enrollerId) {
        this.enrollmentStatus = enrollmentStatus;
        this.user = userId;
        this.enrollerId = enrollerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getEnrollerId() {
        return enrollerId;
    }

    public void setEnrollerId(Integer enrollerId) {
        this.enrollerId = enrollerId;
    }

    @JsonProperty("userId")
    public int getUserId() {
        return user.getId();
    }

}
