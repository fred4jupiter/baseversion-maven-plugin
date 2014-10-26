package org.fred4jupiter.projecthelper;

import org.apache.commons.io.FileUtils;
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
public class ProjectHelperMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.version}")
    private String projectVersion;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        int indexBeginningSnapshot = projectVersion.indexOf("-SNAPSHOT");

        String baseVersion = projectVersion.substring(0, indexBeginningSnapshot);

        try {
            FileUtils.writeStringToFile(new File("version.properties"), "BASE_VERSION=" + baseVersion);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
