package ru.itis.tsvetaev.models.jaxb;

import ru.itis.tsvetaev.models.Line;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "lines")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lines {

    @XmlElement(name = "line")
    private List<Line> lines;

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
