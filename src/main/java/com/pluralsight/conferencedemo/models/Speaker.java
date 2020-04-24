package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity(name="speakers")
public class Speaker {
    @Id
    @Column(name = "speaker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speakerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String title;
    private String company;
    @Column(name = "speaker_bio")
    private String speakerBio;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    Set<Session> sessions;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name="speaker_photo")
    private byte[] speakerPhoto;

    public Speaker() {
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeakerBio() {
        return speakerBio;
    }

    public void setSpeakerBio(String speakerBio) {
        this.speakerBio = speakerBio;
    }
    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public byte[] getSpeakerPhoto() {
        return speakerPhoto;
    }

    public void setSpeakerPhoto(byte[] speakerPhoto) {
        this.speakerPhoto = speakerPhoto;
    }
}
