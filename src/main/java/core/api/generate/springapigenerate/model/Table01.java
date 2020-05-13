package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table01")
public class Table01 { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "column_string")
    private String columnString;

    @Column(name = "column_integer")
    private Integer columnInteger;

    @Column(name = "column_double")
    private Double columnDouble;


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

    @Override
    public String toString() {
        return "Table01{" + 
                  "id=" + id + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnInteger=" + columnInteger + 
                  ", columnDouble=" + columnDouble + 
                 '}';
    }
} 