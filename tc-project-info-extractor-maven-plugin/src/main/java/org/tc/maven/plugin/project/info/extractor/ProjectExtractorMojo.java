package org.tc.maven.plugin.project.info.extractor;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

/**
 * ProjectExtractorMojo.java.
 * used with "mvn maven.plugin:project-info-extractor-maven-plugin:extract" commande
 * GroupId;ArtifactId;Version;Packaging;Name;Description
 *
 * @author collonville thomas
 * @version 0.1.0
 */
@Mojo(name = "extract", defaultPhase = LifecyclePhase.CLEAN)
public class ProjectExtractorMojo extends AbstractMojo {

    @Component
    MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("ProjectExtractorMojo execution begin");
        getLog().info(project.getName());
        try {
            final BufferedWriter bos = new BufferedWriter(new FileWriter("C:/resultFile.csv", true));
            bos.newLine();
            bos.write(project.getPackaging());
            bos.write(";");
            bos.write(project.getVersion());
            bos.write(";");
            bos.write(project.getGroupId());
            bos.write(";");
            bos.write(project.getArtifactId());
            bos.write(";");
            bos.write(project.getDescription());
            bos.write(";");
            bos.write(project.getName());
            bos.flush();
            bos.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        getLog().info("ProjectExtractorMojo execution finish");
    }
}
