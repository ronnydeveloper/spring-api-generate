package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "DATA_TYPE")
public class DataType { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long columnLong;

    @Column(name = "columnInt")
    private Integer columnInt;

    @Column(name = "columnDouble")
    private Double columnDouble;

    @Column(name = "columnFloat")
    private Float columnFloat;

    @Column(name = "columnShort")
    private Short columnShort;

    @Column(name = "columnBigDecimal", precision = 32, scale  = 2)
    private BigDecimal columnBigDecimal;

    @Column(name = "columnByte")
    private Byte columnByte;

    @Column(name = "columnCharacter", columnDefinition  = "char(3)")
    private Character columnCharacter;

    @Column(name = "columnBoolean")
    private Boolean columnBoolean;

    @Column(name = "columnString", nullable = false, length = 50)
    private String columnString;

    @Column(name = "columnDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date columnDate;


    public void setColumnLong(Long columnLong) {
        this.columnLong = columnLong;
    }

    public Long getColumnLong() { 
        return columnLong;
    }

    public void setColumnInt(Integer columnInt) {
        this.columnInt = columnInt;
    }

    public Integer getColumnInt() { 
        return columnInt;
    }

    public void setColumnDouble(Double columnDouble) {
        this.columnDouble = columnDouble;
    }

    public Double getColumnDouble() { 
        return columnDouble;
    }

    public void setColumnFloat(Float columnFloat) {
        this.columnFloat = columnFloat;
    }

    public Float getColumnFloat() { 
        return columnFloat;
    }

    public void setColumnShort(Short columnShort) {
        this.columnShort = columnShort;
    }

    public Short getColumnShort() { 
        return columnShort;
    }

    public void setColumnBigDecimal(BigDecimal columnBigDecimal) {
        this.columnBigDecimal = columnBigDecimal;
    }

    public BigDecimal getColumnBigDecimal() { 
        return columnBigDecimal;
    }

    public void setColumnByte(Byte columnByte) {
        this.columnByte = columnByte;
    }

    public Byte getColumnByte() { 
        return columnByte;
    }

    public void setColumnCharacter(Character columnCharacter) {
        this.columnCharacter = columnCharacter;
    }

    public Character getColumnCharacter() { 
        return columnCharacter;
    }

    public void setColumnBoolean(Boolean columnBoolean) {
        this.columnBoolean = columnBoolean;
    }

    public Boolean getColumnBoolean() { 
        return columnBoolean;
    }

    public void setColumnString(String columnString) {
        this.columnString = columnString;
    }

    public String getColumnString() { 
        return columnString;
    }

    public void setColumnDate(Date columnDate) {
        this.columnDate = columnDate;
    }

    public Date getColumnDate() { 
        return columnDate;
    }

    @Override
    public String toString() {
        return "DataType{" + 
                  "columnLong=" + columnLong + 
                  ", columnInt=" + columnInt + 
                  ", columnDouble=" + columnDouble + 
                  ", columnFloat=" + columnFloat + 
                  ", columnShort=" + columnShort + 
                  ", columnBigDecimal=" + columnBigDecimal + 
                  ", columnByte=" + columnByte + 
                  ", columnCharacter=" + columnCharacter + 
                  ", columnBoolean=" + columnBoolean + 
                  ", columnString='" + columnString+ "\'" + 
                  ", columnDate=" + columnDate + 
                 '}';
    }
} 