package com.library.user.entity;

import com.library.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_user")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private LocalDate dateOfBirthday;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> userAddresses;

}
