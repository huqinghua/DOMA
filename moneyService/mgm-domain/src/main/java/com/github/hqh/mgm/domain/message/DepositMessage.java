package com.github.hqh.mgm.domain.message;

import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.user.UserId;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author ：huqinghua
 * @description：
 */

@Data
@AllArgsConstructor
@ToString
public class DepositMessage {
	private Long id;
    private UserId userId;
    private Money money;

    public static DepositMessage deserialize(String jsonStr) {
        Gson gs = new Gson();
        DepositMessage depositMessage = gs.fromJson(jsonStr, DepositMessage.class);
        return depositMessage;
    }

    public static String serialize(DepositMessage depositMessage) {
        return new Gson().toJson(depositMessage);
    }
}
