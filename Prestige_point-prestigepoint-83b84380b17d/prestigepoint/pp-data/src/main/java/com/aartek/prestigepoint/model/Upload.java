package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "upload1")
public class Upload implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "JAR_ID")
  private Integer jar_Id;

  @Column(name = "JAR_TYPE")
  private String jarType;

  @Column(name = "NAME_OF_JAR")
  private String nameOfJar;

  @Column(name = "PATH_OF_JAR")
  private String pathOfJar;

  public Integer getJar_Id() {
    return jar_Id;
  }

  public void setJar_Id(Integer jar_Id) {
    this.jar_Id = jar_Id;
  }

  public String getJarType() {
    return jarType;
  }

  public void setJarType(String jarType) {
    this.jarType = jarType;
  }

  public String getNameOfJar() {
    return nameOfJar;
  }

  public String getPathOfJar() {
    return pathOfJar;
  }

  public void setPathOfJar(String pathOfJar) {
    this.pathOfJar = pathOfJar;
  }

  public void setNameOfJar(String nameOfJar) {
    this.nameOfJar = nameOfJar;
  }

}
