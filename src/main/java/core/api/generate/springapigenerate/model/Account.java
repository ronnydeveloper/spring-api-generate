package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Account", uniqueConstraints = @UniqueConstraint(name = "UC_Account", columnNames = {"id","Code"}))
public class Account { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Code", nullable = true, length = 60)
    private String code;

    @Column(name = "Name", nullable = true, length = 200)
    private String name;

    @Column(name = "Parent_ID")
    private Integer parentID;

    @Column(name = "Currency", nullable = true, length = 3)
    private String currency;

    @Column(name = "Internal_Type", nullable = true, length = 20)
    private String internalType;

    @Column(name = "Account_Type", nullable = true, length = 20)
    private String accountType;

    @Column(name = "Active_Status", nullable = true, length = 1)
    private String activeStatus;

    @JoinColumn(name = "Company_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Company_Company_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Company companyID;

    @Column(name = "Note", nullable = true, length = 5000)
    private String note;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() { 
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { 
        return name;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getParentID() { 
        return parentID;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() { 
        return currency;
    }

    public void setInternalType(String internalType) {
        this.internalType = internalType;
    }

    public String getInternalType() { 
        return internalType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() { 
        return accountType;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getActiveStatus() { 
        return activeStatus;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }


    public Company getCompanyID() { 
        return companyID;
    }


    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() { 
        return note;
    }

    @Override
    public String toString() {
        return "Account{" + 
                  "id=" + id + 
                  ", code='" + code+ "\'" + 
                  ", name='" + name+ "\'" + 
                  ", parentID=" + parentID + 
                  ", currency='" + currency+ "\'" + 
                  ", internalType='" + internalType+ "\'" + 
                  ", accountType='" + accountType+ "\'" + 
                  ", activeStatus='" + activeStatus+ "\'" + 
                  ", companyID=" + companyID + 
                  ", note='" + note+ "\'" + 
                 '}';
    }
} 