package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Company")
public class Company { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = true, length = 200)
    private String name;

    @Column(name = "COA_Name", nullable = true, length = 200)
    private String coaName;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { 
        return name;
    }

    public void setCoaName(String coaName) {
        this.coaName = coaName;
    }

    public String getCoaName() { 
        return coaName;
    }

    @Override
    public String toString() {
        return "Company{" + 
                  "id=" + id + 
                  ", name='" + name+ "\'" + 
                  ", coaName='" + coaName+ "\'" + 
                 '}';
    }
} 