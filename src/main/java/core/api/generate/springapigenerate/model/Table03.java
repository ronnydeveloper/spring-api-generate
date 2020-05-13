package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table03")
public class Table03 { 
    @Id
    @SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "columnString")
    private String columnString;

    @Column(name = "columnInteger")
    private Integer columnInteger;

    @Column(name = "columnDouble")
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
        return "Table03{" + 
                  "id=" + id + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnInteger=" + columnInteger + 
                  ", columnDouble=" + columnDouble + 
                 '}';
    }
} 