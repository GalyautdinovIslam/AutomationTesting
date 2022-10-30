package ru.itis.tsvetaev.models;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostData {

    @XmlElement(name = "content", required = true)
    private String content;

    @XmlElement(name = "time", required = true)
    private Long time;

    public PostData() {
    }

    public PostData(String content, Long time) {
        this.content = content;
        this.time = time;
    }

    public String content() {
        return content;
    }

    public Long time() {
        return time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostData postData)) return false;
        return Objects.equal(content, postData.content) && Objects.equal(time, postData.time);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(content, time);
    }

    @Override
    public String toString() {
        return "PostData{" +
                "content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
