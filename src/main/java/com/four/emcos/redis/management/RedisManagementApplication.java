package com.four.emcos.redis.management;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class RedisManagementApplication {
    public static void main(String ... args) {
        Quarkus.run(args);
    }
}