package pl.mateusz.codeballbackend.model;

import javax.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue
    private Integer id;
    private EnrollmentStatus enrollmentStatus;
    @ManyToOne
    private User userId;
    @ManyToOne
    private User enrollerId;

    public Enrollment() {
    }

    public Enrollment(EnrollmentStatus enrollmentStatus, User userId, User enrollerId) {
        this.enrollmentStatus = enrollmentStatus;
        this.userId = userId;
        this.enrollerId = enrollerId;
    }
}
