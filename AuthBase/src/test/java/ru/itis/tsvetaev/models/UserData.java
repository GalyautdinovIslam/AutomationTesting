package ru.itis.tsvetaev.models;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserData {

    @XmlElement(name = "login", required = true)
    private String login;

    @XmlElement(name = "password", required = true)
    private String password;

    @XmlElement(name = "path", required = true)
    private String path;

    public UserData() {
    }

    public UserData(String login, String password, String path) {
        this.login = login;
        this.password = password;
        this.path = path;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPath() {
        return path;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData userData)) return false;
        return Objects.equal(login, userData.login)
                && Objects.equal(password, userData.password)
                && Objects.equal(path, userData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(login, password, path);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
