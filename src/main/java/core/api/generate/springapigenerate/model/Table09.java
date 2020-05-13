package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "table09")
public class Table09 { 

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

    @ManyToMany(mappedBy = "table09", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Table10> table10;


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

    public void setTable10(List<Table10> table10) {
        this.table10 = table10;
    }

    public List<Table10> getTable10() { 
        return table10;
    }

    @Override
    public String toString() {
        return "Table09{" + 
                  "id=" + id + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnInteger=" + columnInteger + 
                  ", columnDouble=" + columnDouble + 
                  ", table10=" + table10 + 
                 '}';
    }
} 