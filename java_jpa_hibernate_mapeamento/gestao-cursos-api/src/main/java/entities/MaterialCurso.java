package entities;

import javax.persistence.*;

@Entity
public class MaterialCurso {

    @Id
    @GeneratedValue
    private long Id;

    @Column
    private String url;

    public MaterialCurso(){};

    public MaterialCurso(String url) {
        this.url = url;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MaterialCurso{" +
                "Id=" + Id +
                ", url='" + url + '\'' +
                '}';
    }
}