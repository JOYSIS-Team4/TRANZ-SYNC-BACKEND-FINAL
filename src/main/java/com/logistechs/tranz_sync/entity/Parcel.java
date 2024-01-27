package com.logistechs.tranz_sync.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "parcels")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parcel_id;

    private String tracking_code;
    private String parcel_type;
    private String sender;
    private String sender_contact;
    private String sender_address;
    private String receiver;
    private String receiver_contact;
    private String receiver_address;
    private String status;

    @CreationTimestamp
    private LocalDateTime date_created;


}
