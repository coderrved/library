package com.library.address.entity;

import com.library.user.entity.User;
import com.library.address.enums.AddressTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(name = "seq_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_address", strategy = GenerationType.SEQUENCE)
    private long id;

    private String addressExplanation;

    @Enumerated
    private AddressTypeEnum addressType;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
