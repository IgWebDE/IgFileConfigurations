package de.igweb.igfileconfigurations.test;

public class Test {

    public static void main(String[] args) {
        TestConfiguration testConfiguration = new TestConfiguration();
        testConfiguration.setTestB("B");
        testConfiguration.save();
    }

}
