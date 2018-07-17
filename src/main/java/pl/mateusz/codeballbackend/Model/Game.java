package pl.mateusz.codeballbackend.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {
    private Integer durationInMinutes;
    private ArrayList<Enrollment> enrollments;
    private Integer id;
    private boolean isEnrollmentOver;
    private boolean isGameOver;
    private Pitch pitchId;
    private LocalDateTime startTimestamp;
    private ArrayList<User> teamAIds;
    private Integer teamAScore;
    private ArrayList<User> teamBIds;
    private Integer teamBScore;

    
}
