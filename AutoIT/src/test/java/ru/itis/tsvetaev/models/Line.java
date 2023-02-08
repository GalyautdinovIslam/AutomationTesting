package ru.itis.tsvetaev.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "line")
@XmlAccessorType(XmlAccessType.FIELD)
public class Line {

    @XmlElement(name = "line", required = true)
    private String line;

    public Line() {
    }

    public Line(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
