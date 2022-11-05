package de.igweb.igfileconfigurations.test;

import de.igweb.igfileconfigurations.FileConfiguration;
import de.igweb.igfileconfigurations.FileSettings;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@FileSettings("config.yml")
public class TestConfiguration extends FileConfiguration {

    private String testA;

    private String testB;

    private String testC;

    private String testD;

    private String testE;

}
