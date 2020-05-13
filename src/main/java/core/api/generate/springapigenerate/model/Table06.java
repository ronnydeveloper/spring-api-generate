package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table06")
public class Table06 { 

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

    @OneToOne(optional = false, mappedBy = "table06", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Table05 table05;


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

    public void setTable05(Table05 table05) {
        this.table05 = table05;
    }


    public Table05 getTable05() { 
        return table05;
    }


    @Override
    public String toString() {
        return "Table06{" + 
                  "id=" + id + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnInteger=" + columnInteger + 
                  ", columnDouble=" + columnDouble + 
                  ", table05=" + table05 + 
                 '}';
    }
} 