package com.four.emcos.redis.management.utils;

import static com.four.emcos.redis.management.constants.RedisMgmtParams.*;
import static java.lang.Integer.parseInt;

public final class Utils {
    private Utils() {}

    public static String determineTtl(Long ttl) {
        if (ttl == null) {
            return TTL_NA;
        }

        if (ttl == -1) {
            return TTL_NO_EXPIRATION;
        }

        long seconds = ttl;
        long minutes = seconds / TTL_MINUTES_SECONDS_DIVISOR;
        long hours = minutes / TTL_HOURS_MINUTES_DIVISOR;
        long days = hours / TTL_DAYS_HOURS_DIVISOR;
        long months = days / TTL_MINUTES_DAYS_DIVISOR;

        if (months > 0) {
            return String.format(TTL_MONTHS, months);
        } else if (days > 0) {
            return String.format(TTL_DAYS, days);
        } else if (hours > 0) {
            return String.format(TTL_HOURS, hours);
        } else if (minutes > 0) {
            return String.format(TTL_MINUTES, minutes);
        } else {
            return String.format(TTL_SECONDS, seconds);
        }
    }
}
