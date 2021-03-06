package com.lti.lifht.entity;

import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLInsert;

import com.lti.lifht.model.EntryDateBean;

@Entity
@Table(name = "entry_date", uniqueConstraints = @UniqueConstraint(columnNames = {
        "ps_number",
        "swipe_date",
        "swipe_door",
        "duration" }))
@SQLInsert(sql = " ON DUPLICATE KEY UPDATE ps_number = VALUES(ps_number)")
public class EntryDate {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "ps_number")
    private String psNumber;

    @Column(name = "swipe_date")
    private LocalDate swipeDate;

    @Column(name = "swipe_door")
    private String swipeDoor;

    @Column(name = "duration")
    private long duration;

    @Column(name = "compliance")
    private long compliance;

    @Column(name = "first_in")
    private LocalTime firstIn;

    @Column(name = "last_out")
    private LocalTime lastOut;

    @Column(name = "filo")
    private long filo;

    public EntryDate() {
        super();
    }

    public EntryDate(EntryDateBean bean) {
        super();
        psNumber = bean.getPsNumber();
        swipeDate = bean.getSwipeDate();
        swipeDoor = bean.getSwipeDoor();
        duration = bean.getDuration().toMillis();
        compliance = bean.getCompliance().toMillis();
        firstIn = bean.getFirstIn();
        lastOut = bean.getLastOut();
        filo = bean.getFilo().toMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPsNumber() {
        return psNumber;
    }

    public void setPsNumber(String psNumber) {
        this.psNumber = psNumber;
    }

    public LocalDate getSwipeDate() {
        return swipeDate;
    }

    public void setSwipeDate(LocalDate swipeDate) {
        this.swipeDate = swipeDate;
    }

    public String getSwipeDoor() {
        return swipeDoor;
    }

    public void setSwipeDoor(String swipeDoor) {
        this.swipeDoor = swipeDoor;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getCompliance() {
        return compliance;
    }

    public void setCompliance(long compliance) {
        this.compliance = compliance;
    }

    public LocalTime getFirstIn() {
        return firstIn;
    }

    public void setFirstIn(LocalTime firstIn) {
        this.firstIn = firstIn;
    }

    public LocalTime getLastOut() {
        return lastOut;
    }

    public void setLastOut(LocalTime lastOut) {
        this.lastOut = lastOut;
    }

    public long getFilo() {
        return filo;
    }

    public void setFilo(long filo) {
        this.filo = filo;
    }

}
