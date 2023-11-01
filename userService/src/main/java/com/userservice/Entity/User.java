package com.userservice.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

 @Id
 @Column(name = "ID")
 private  String userId;

 @Column(name = "NAME",length = 20)
 private  String name;

 @Column(name = "EMAIL")
 private String email;

 @Column(name = "ABOUT")
 private String about;


}
