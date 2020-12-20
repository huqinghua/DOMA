package com.github.hqh.mgm.persistence;

import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

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

}
