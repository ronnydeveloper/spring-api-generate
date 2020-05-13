package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "table07")
public class Table07 { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "columnString")
    private String columnString;

    @Column(name = "columnInteger")
    private Integer columnInteger;

    @Column(name = "columnDouble")
    private Double columnDouble;

    @OneToMany(mappedBy = "table07", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Table08> table08;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setColumnString(String columnString) {
        this.columnString = columnString;
    }

    public String getColumnString() { 
        return columnString;
    }

    public void setColumnInteger(Integer columnInteger) {
        this.columnInteger = columnInteger;
    }

    public Integer getColumnInteger() { 
        return columnInteger;
    }

    public void setColumnDouble(Double columnDouble) {
        this.columnDouble = columnDouble;
    }

    public Double getColumnDouble() { 
        return columnDouble;
    }

    public void setTable08(List<Table08> table08) {
        this.table08 = table08;
    }

    public List<Table08> getTable08() { 
        return table08;
    }

    @Override
    public String toString() {
        return "Table07{" + 
                  "id=" + id + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnInteger=" + columnInteger + 
                  ", columnDouble=" + columnDouble + 
                  ", table08=" + table08 + 
                 '}';
    }
} 