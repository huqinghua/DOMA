package com.github.hqh.mgm.rpc;


import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.domain.moneyaccount.IMoneyAccount;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountId;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRemoteRepository;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class MoneyAccountRemoteRepositoryImpl implements MoneyAccountRemoteRepository {

    @Override
    public IMoneyAccount find(MoneyAccountId id) {
        MoneyAccountStub account = new MoneyAccountStub();
        return account;
    }

    @Override
    public IMoneyAccount find(UserId userId) {
        return null;
    }

    @Override
    public IMoneyAccount save(IMoneyAccount account) {
        throw new MgmException(MgmErrorCode.NOT_IMPLETMENT);
    }
}
