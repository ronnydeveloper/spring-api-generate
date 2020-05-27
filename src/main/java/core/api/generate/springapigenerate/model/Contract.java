package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "Contract", uniqueConstraints = @UniqueConstraint(name = "UC_Contract", columnNames = {"id","contractNo"}))
public class Contract { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTRACT_NO", nullable = true, length = 80)
    private String contractNo;

    @Column(name = "CONTRACT_NAME", nullable = true, length = 200)
    private String contractName;

    @Column(name = "PERIODE_FROM")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date periodeFrom;

    @Column(name = "PERIODE_TO")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date periodeTo;

    @JoinColumn(name = "Vendor_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Partner_Vendor_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Partner vendorID;

    @JoinColumn(name = "Partner_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Partner_Partner_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Partner partnerID;

    @JoinColumn(name = "Project_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Project_Project_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Project projectID;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractNo() { 
        return contractNo;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractName() { 
        return contractName;
    }

    public void setPeriodeFrom(Date periodeFrom) {
        this.periodeFrom = periodeFrom;
    }

    public Date getPeriodeFrom() { 
        return periodeFrom;
    }

    public void setPeriodeTo(Date periodeTo) {
        this.periodeTo = periodeTo;
    }

    public Date getPeriodeTo() { 
        return periodeTo;
    }

    public void setVendorID(Partner vendorID) {
        this.vendorID = vendorID;
    }


    public Partner getVendorID() { 
        return vendorID;
    }


    public void setPartnerID(Partner partnerID) {
        this.partnerID = partnerID;
    }


    public Partner getPartnerID() { 
        return partnerID;
    }


    public void setProjectID(Project projectID) {
        this.projectID = projectID;
    }


    public Project getProjectID() { 
        return projectID;
    }


    @Override
    public String toString() {
        return "Contract{" + 
                  "id=" + id + 
                  ", contractNo='" + contractNo+ "\'" + 
                  ", contractName='" + contractName+ "\'" + 
                  ", periodeFrom=" + periodeFrom + 
                  ", periodeTo=" + periodeTo + 
                  ", vendorID=" + vendorID + 
                  ", partnerID=" + partnerID + 
                  ", projectID=" + projectID + 
                 '}';
    }
} 