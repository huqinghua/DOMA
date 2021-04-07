package com.github.hqh.mgm.persistence;

import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public interface AccountDORepo extends JpaRepository<AccountDO, Long> {
    Optional<AccountDO> findById(MoneyAccountId value);

    AccountDO findByUserId(Long id);

    @Override
    AccountDO saveAndFlush(AccountDO accountDO);

    @Modifying
    @Query("update AccountDO m set m.currency=?2, m.version=1+?3 where m.version=?2 and m.id=?1")
    void updateByMoney(Long id, BigDecimal money, Long version);
}
