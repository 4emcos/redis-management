package com.four.emcos.redis.management.constants;

public final class RedisMgmtParams {
    private RedisMgmtParams() {}

    public static final String TTL_NO_EXPIRATION = "No expiration";
    public static final String TTL_NA = "N/A";
    public static final String TTL_MONTHS = "%s months";
    public static final String TTL_DAYS = "%s days";
    public static final String TTL_HOURS = "%s hours";
    public static final String TTL_SECONDS = "%s seconds";
    public static final String TTL_MINUTES = "%s minutes";

    public static final Integer TTL_MINUTES_SECONDS_DIVISOR = 60;
    public static final Integer TTL_DAYS_HOURS_DIVISOR = 24;
    public static final Integer TTL_HOURS_MINUTES_DIVISOR = 60;
    public static final Integer TTL_MINUTES_DAYS_DIVISOR = 30;

}
