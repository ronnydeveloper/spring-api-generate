package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table08")
public class Table08 { 

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

    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Table07_table07"), unique = true, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Table07 table07;


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

    public void setTable07(Table07 table07) {
        this.table07 = table07;
    }


    public Table07 getTable07() { 
        return table07;
    }


    @Override
    public String toString() {
        return "Table08{" + 
                  "id=" + id + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnInteger=" + columnInteger + 
                  ", columnDouble=" + columnDouble + 
                  ", table07=" + table07 + 
                 '}';
    }
} 