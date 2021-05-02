package com.reservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Reservation {

    @GeneratedValue
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
