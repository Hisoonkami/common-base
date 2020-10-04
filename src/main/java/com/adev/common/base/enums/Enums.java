package com.adev.common.base.enums;

import org.springframework.util.StringUtils;

public class Enums {

    public enum CoinType{
        NORMAL,
        FUTURE,
        SPOT,
        INDEX,
        ETF;
        public static CoinType getCoinType(String coinTypeName){
            try {
                if(!StringUtils.isEmpty(coinTypeName)){
                    return CoinType.valueOf(coinTypeName.toUpperCase());
                }
            } catch (Exception e) {}
            return null;
        }
    }

    /**
     * 订阅类型
     */
    public enum SubType{

        MARK_TICKER, TICKER, DEPTH, TRADE, ALL_TICKER, ALL_TRADE, ALL_DEPTH;

        public static SubType getSubType(String subTypeName){

            try {

                if(!StringUtils.isEmpty(subTypeName)){

                    return SubType.valueOf(subTypeName.toUpperCase());
                }
            } catch (Exception e) {}
            return null;
        }
    }

    public enum AccountBookType{
        INCOME,PAY
    }

    public enum LocalMessageState{
        FAIL,SUCCESS
    }
}
