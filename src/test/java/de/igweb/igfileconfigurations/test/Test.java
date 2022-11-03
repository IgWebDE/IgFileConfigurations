package de.igweb.igfileconfigurations.test;

import lombok.SneakyThrows;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {

        // save a new configuration
        TestConfiguration tc = TestConfiguration.builder()
                .testA("TestA")
                .testB("TestB")
                .testC("TestC")
                .testD("TestD")
                .testE("TestE")
                .build();
        Thread.sleep(100);
        tc.save();

        TestConfiguration testConfiguration = new TestConfiguration();
       Thread.sleep(100);
        testConfiguration.getValues().forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
       Thread.sleep(100);
        testConfiguration.setTestA("New TestA");
       testConfiguration.setTestB("New TestB");

       testConfiguration.save();
    }

}
