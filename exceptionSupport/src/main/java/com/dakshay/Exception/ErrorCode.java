package com.dakshay.Exception;

/**
 * Created by stpl on 20/9/18.
 */
public interface ErrorCode {
    int SUCCESS = 0;
    int INVALID_AGENT_USER_NAME = 1;
    int NO_USER_FOUND = 2;
    int AGENT_EXIST = 3;
    int EMAIL_EXIST = 4;
    int EXTRA_DATABASE_VALUES = 5;
    int CUSTOMER_EXIST = 6;
    int COUPON_NOT_FOUND = 7;
    int COUPON_EXPIRED = 8;
    int COUPON_CODE_LIMIT_EXCEEDED = 8;
    int COUPON_CODE_NOT_APPLICABLE_FOR_USER = 9;
    int COUPON_ALREADY_EXISTS = 10;
}
