package pl.mateusz.codeballbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pitch {
    @Column(unique = true)
    private String address;
    @Id
    @GeneratedValue
    private Integer id;
    private int maxNumberOfPlayers;
    private int minNumberOfPlayers;
    private String name;
    private PitchType pitchType;

    public Pitch() {
    }

    public Pitch(String address, String name) {

        this.address = address;
        this.name = name;
    }

    public Pitch(String address, int maxNumberOfPlayers, int minNumberOfPlayers, String name, PitchType pitchType) {
        this.address = address;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.minNumberOfPlayers = minNumberOfPlayers;
        this.name = name;
        this.pitchType = pitchType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public int getMinNumberOfPlayers() {
        return minNumberOfPlayers;
    }

    public void setMinNumberOfPlayers(int minNumberOfPlayers) {
        this.minNumberOfPlayers = minNumberOfPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PitchType getPitchType() {
        return pitchType;
    }

    public void setPitchType(PitchType pitchType) {
        this.pitchType = pitchType;
    }
}
