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
public class DepositResultMessage {
	private Long id;
    private UserId userId;
    private Money money;
    private Boolean status;

    public static DepositResultMessage deserialize(String json) {
    	Gson gson = new Gson();
        return gson.fromJson(json, DepositResultMessage.class);
    }

    public static String serialize(DepositResultMessage depositResultMessage) {
        return new Gson().toJson(depositResultMessage);
    }
}

