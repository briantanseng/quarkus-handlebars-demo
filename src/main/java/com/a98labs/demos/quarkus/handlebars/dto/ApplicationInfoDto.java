package com.a98labs.demos.quarkus.handlebars.dto;

public class ApplicationInfoDto {

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getQuarkusVersion() {
        return quarkusVersion;
    }
    public void setQuarkusVersion(String quarkusVersion) {
        this.quarkusVersion = quarkusVersion;
    }
    public String groupId = "com.a98labs";
    public String artifactId = "quarkus-thymeleaf-demo";
    public String version = "1.0-SNAPSHOT";
    public String quarkusVersion = "0.23.2";
    
}
