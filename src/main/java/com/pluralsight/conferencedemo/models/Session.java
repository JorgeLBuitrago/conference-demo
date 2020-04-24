package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name="sessions")
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    @Column(name = "session_name")
    private String sessionName;
    @Column(name = "session_description")
    private String sessionDescription;
    @Column(name = "session_length")
    private Integer sessionLength;

    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name="session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private Set<Speaker> speakers;

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Session() {
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public Integer getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }
}
