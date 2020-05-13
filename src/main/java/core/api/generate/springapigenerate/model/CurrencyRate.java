package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "CURRENCY_RATE")
public class CurrencyRate { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_RATE")
    private String companyRate;

    @Column(name = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "KURS_BELI")
    private Double kursBeli;

    @Column(name = "KURS_JUAL")
    private Double kursJual;

    @Column(name = "KURS_TENGAH")
    private Double kursTengah;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setCompanyRate(String companyRate) {
        this.companyRate = companyRate;
    }

    public String getCompanyRate() { 
        return companyRate;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() { 
        return date;
    }

    public void setKursBeli(Double kursBeli) {
        this.kursBeli = kursBeli;
    }

    public Double getKursBeli() { 
        return kursBeli;
    }

    public void setKursJual(Double kursJual) {
        this.kursJual = kursJual;
    }

    public Double getKursJual() { 
        return kursJual;
    }

    public void setKursTengah(Double kursTengah) {
        this.kursTengah = kursTengah;
    }

    public Double getKursTengah() { 
        return kursTengah;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" + 
                  "id=" + id + 
                  ", companyRate='" + companyRate+ "\'" + 
                  ", date=" + date + 
                  ", kursBeli=" + kursBeli + 
                  ", kursJual=" + kursJual + 
                  ", kursTengah=" + kursTengah + 
                 '}';
    }
} 