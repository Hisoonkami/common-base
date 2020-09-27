package com.adev.common.base.domian;

import com.adev.common.base.enums.Enums;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 交易对
 */
@Data
@NoArgsConstructor
@ToString
public class CoinPairBase {

    private String exchange;

    private String currencyPair; //格式：btc-usdt

    private Enums.CoinType coinType;
}
