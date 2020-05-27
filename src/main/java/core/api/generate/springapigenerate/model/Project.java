package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "Project", uniqueConstraints = @UniqueConstraint(name = "UC_Project", columnNames = {"id","noProject"}))
public class Project { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = true, length = 200)
    private String name;

    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Partner_Partner_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Partner partnerID;

    @Column(name = "NO_PROJECT", nullable = true, length = 100)
    private String noProject;

    @Column(name = "NO_KONTRAK", nullable = true, length = 100)
    private String noKontrak;

    @Column(name = "DATE_START")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateStart;

    @Column(name = "DATE_END")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateEnd;

    @Column(name = "STATUS_BA", nullable = true, length = 20)
    private String statusBA;

    @Column(name = "TGL_KONTRAK")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tglKontrak;

    @Column(name = "TGL_PERJANJIAN_FROM")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tglPerjanjianFrom;

    @Column(name = "TGL_PERJANJIAN_TO")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tglPerjanjianTo;

    @Column(name = "PROJECT_STATUS", nullable = true, length = 20)
    private String projectStatus;

    @Column(name = "PARENT_ID")
    private Long parentID;

    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Company_Company_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Company companyID;


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

    public void setPartnerID(Partner partnerID) {
        this.partnerID = partnerID;
    }


    public Partner getPartnerID() { 
        return partnerID;
    }


    public void setNoProject(String noProject) {
        this.noProject = noProject;
    }

    public String getNoProject() { 
        return noProject;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getNoKontrak() { 
        return noKontrak;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateStart() { 
        return dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateEnd() { 
        return dateEnd;
    }

    public void setStatusBA(String statusBA) {
        this.statusBA = statusBA;
    }

    public String getStatusBA() { 
        return statusBA;
    }

    public void setTglKontrak(Date tglKontrak) {
        this.tglKontrak = tglKontrak;
    }

    public Date getTglKontrak() { 
        return tglKontrak;
    }

    public void setTglPerjanjianFrom(Date tglPerjanjianFrom) {
        this.tglPerjanjianFrom = tglPerjanjianFrom;
    }

    public Date getTglPerjanjianFrom() { 
        return tglPerjanjianFrom;
    }

    public void setTglPerjanjianTo(Date tglPerjanjianTo) {
        this.tglPerjanjianTo = tglPerjanjianTo;
    }

    public Date getTglPerjanjianTo() { 
        return tglPerjanjianTo;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus() { 
        return projectStatus;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public Long getParentID() { 
        return parentID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }


    public Company getCompanyID() { 
        return companyID;
    }


    @Override
    public String toString() {
        return "Project{" + 
                  "id=" + id + 
                  ", name='" + name+ "\'" + 
                  ", partnerID=" + partnerID + 
                  ", noProject='" + noProject+ "\'" + 
                  ", noKontrak='" + noKontrak+ "\'" + 
                  ", dateStart=" + dateStart + 
                  ", dateEnd=" + dateEnd + 
                  ", statusBA='" + statusBA+ "\'" + 
                  ", tglKontrak=" + tglKontrak + 
                  ", tglPerjanjianFrom=" + tglPerjanjianFrom + 
                  ", tglPerjanjianTo=" + tglPerjanjianTo + 
                  ", projectStatus='" + projectStatus+ "\'" + 
                  ", parentID=" + parentID + 
                  ", companyID=" + companyID + 
                 '}';
    }
} 