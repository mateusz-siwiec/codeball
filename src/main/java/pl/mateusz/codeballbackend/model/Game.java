package pl.mateusz.codeballbackend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer durationInMinutes;
    @ManyToMany
    private List<Enrollment> enrollments;
    private boolean isEnrollmentOver;
    private boolean isGameOver;
    private Integer pitchId;
    @JsonIgnore
    private LocalDateTime startTime;
    @OneToMany
    private List<User> teamAIds;
    private Integer teamAScore;
    @OneToMany
    private List<User> teamBIds;
    private Integer teamBScore;

    public Game() {
        this.enrollments = new ArrayList<>();
        this.teamAIds = new ArrayList<>();
        this.teamBIds = new ArrayList<>();
    }

    @JsonIgnore
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @JsonIgnore
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @JsonGetter("startTimestamp")
    private long getStartTimestamp() {
        return startTime.toEpochSecond(OffsetDateTime.now().getOffset());
    }

    @JsonSetter("startTimestamp")
    private void setStartTimestamp(long startTimestamp) {
        this.startTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(startTimestamp),
                TimeZone.getDefault().toZoneId());
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

    public Integer getPitchId() {
        return pitchId;
    }

    public void setPitchId(Integer pitchId) {
        this.pitchId = pitchId;
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

    @JsonIgnore
    public BasicGame getBasicGame() {
        return new BasicGame(this.id, this.durationInMinutes, this.pitchId, this.startTime);
    }
}
