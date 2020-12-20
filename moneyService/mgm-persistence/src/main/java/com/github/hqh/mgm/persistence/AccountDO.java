package com.github.hqh.mgm.persistence;



import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author ：huqinghua
 * @description：
 */

@Entity
@Table(name="account")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private BigDecimal currency;

}
