package pl.mateusz.codeballbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    private Integer durationInMinutes;
    @ManyToMany
    private List<Enrollment> enrollments;
    @Id
    @GeneratedValue
    private Integer id;
    private boolean isEnrollmentOver;
    private boolean isGameOver;
    @ManyToOne
    private Pitch pitchId;
    private LocalDateTime startTimestamp;
    @OneToMany
    private List<User> teamAIds;
    private Integer teamAScore;
    @OneToMany
    private List<User> teamBIds;
    private Integer teamBScore;

    public Game(Integer durationInMinutes, Pitch pitchId, LocalDateTime startTimestamp) {
        this.durationInMinutes = durationInMinutes;
        this.pitchId = pitchId;
        this.startTimestamp = startTimestamp;
    }

    public Game() {
    }

    public Integer getDurationInMinutes() {

        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isEnrollmentOver() {
        return isEnrollmentOver;
    }

    public void setEnrollmentOver(boolean enrollmentOver) {
        isEnrollmentOver = enrollmentOver;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Pitch getPitchId() {
        return pitchId;
    }

    public void setPitchId(Pitch pitchId) {
        this.pitchId = pitchId;
    }

    public LocalDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(LocalDateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public List<User> getTeamAIds() {
        return teamAIds;
    }

    public void setTeamAIds(ArrayList<User> teamAIds) {
        this.teamAIds = teamAIds;
    }

    public Integer getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(Integer teamAScore) {
        this.teamAScore = teamAScore;
    }

    public List<User> getTeamBIds() {
        return teamBIds;
    }

    public void setTeamBIds(ArrayList<User> teamBIds) {
        this.teamBIds = teamBIds;
    }

    public Integer getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(Integer teamBScore) {
        this.teamBScore = teamBScore;
    }
}
