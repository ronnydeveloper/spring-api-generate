package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Static_Data")
public class StaticData { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Data_Category", nullable = true, length = 60)
    private String dataCategory;

    @Column(name = "Code", nullable = true, length = 100)
    private String code;

    @Column(name = "Name", nullable = true, length = 200)
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setDataCategory(String dataCategory) {
        this.dataCategory = dataCategory;
    }

    public String getDataCategory() { 
        return dataCategory;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() { 
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { 
        return name;
    }

    @Override
    public String toString() {
        return "StaticData{" + 
                  "id=" + id + 
                  ", dataCategory='" + dataCategory+ "\'" + 
                  ", code='" + code+ "\'" + 
                  ", name='" + name+ "\'" + 
                 '}';
    }
} 