package org.fred4jupiter.baseversion;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;

/**
 * This is the main Mojo for executing wetator tests.
 */
@Mojo(name = "execute", defaultPhase = LifecyclePhase.VALIDATE)
public class BaseVersionMojo extends AbstractMojo {

    private static final int DEFAULT_NUMBER_OF_DIGITS = 2;

    @Parameter(defaultValue = "${project.version}")
    private String projectVersion;

    @Parameter(property = "execute.numberOfDigits")
    private String numberOfDigits;

    private BaseVersionCreator creator = new BaseVersionCreator();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        int numDigits = DEFAULT_NUMBER_OF_DIGITS;
        if (StringUtils.isNoneBlank(numberOfDigits)) {
            numDigits = Integer.parseInt(numberOfDigits);
        }

        String baseVersion = creator.createBaseVersionFrom(projectVersion, numDigits);
        writeBaseVersionToFile(baseVersion);
    }

    private void writeBaseVersionToFile(String baseVersion) {
        try {
            String filename = "version.properties";
            FileUtils.writeStringToFile(new File(filename), "BASE_VERSION=" + baseVersion);
            getLog().info("written file: " + filename);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
