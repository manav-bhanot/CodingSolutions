package com.misc;

import java.time.Instant;
import java.util.Date;

public class Dates {

    public static void main(String[] args) {
        System.out.println(Date.from(Instant.now()).toString());
        System.out.println(Instant.now().toEpochMilli());
    }
}
