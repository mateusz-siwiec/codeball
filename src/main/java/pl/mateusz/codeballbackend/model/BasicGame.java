package pl.mateusz.codeballbackend.model;

import java.time.LocalDateTime;

public class BasicGame {
    private Integer id;
    private int durationInMinutes;
    private Integer pitchId;
    private LocalDateTime startTimestamp;

    public BasicGame(Integer id, int durationInMinutes, Integer pitchId, LocalDateTime startTimestamp) {
        this.durationInMinutes = durationInMinutes;
        this.pitchId = pitchId;
        this.startTimestamp = startTimestamp;
    }

    public BasicGame() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Integer getPitchId() {
        return pitchId;
    }

    public void setPitchId(Integer pitchId) {
        this.pitchId = pitchId;
    }

    public LocalDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(LocalDateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
    }


}
