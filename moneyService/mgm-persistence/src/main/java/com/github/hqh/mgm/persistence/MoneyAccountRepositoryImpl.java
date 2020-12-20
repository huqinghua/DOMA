package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountId;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRepository;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component("accountRepository")
public class MoneyAccountRepositoryImpl implements MoneyAccountRepository {
    @Autowired
    private AccountDORepo accountDORepo;
    @Autowired
    private AccountBuilder accountBuilder;


    @Override
    public MoneyMoneyAccount find(MoneyAccountId id) {
        AccountDO accountDO = accountDORepo.findById(id.getValue()).get();
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public MoneyMoneyAccount find(UserId userId) {
        AccountDO accountDO = accountDORepo.findByUserId(userId.getId());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public MoneyMoneyAccount save(MoneyMoneyAccount moneyAccount) {
        AccountDO accountDO = accountBuilder.fromAccount(moneyAccount);
        accountDORepo.saveAndFlush(accountDO);

        return moneyAccount;
    }
}
