package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Partner", uniqueConstraints = @UniqueConstraint(name = "UC_Partner", columnNames = {"id","npwpNo"}))
public class Partner { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = true, length = 200)
    private String name;

    @Column(name = "TITLE", nullable = true, length = 6)
    private String title;

    @Column(name = "PARENT_ID")
    private Long parentID;

    @Column(name = "TYPE", nullable = true, length = 20)
    private String type;

    @Column(name = "IS_COMPANY", nullable = true, length = 1)
    private String isCompany;

    @Column(name = "NPWP_NO", nullable = true, length = 30)
    private String npwpNo;

    @Column(name = "NPWP_ALAMAT", nullable = true, length = 200)
    private String npwpAlamat;

    @Column(name = "ADDRESS", nullable = true, length = 200)
    private String address;

    @Column(name = "STREET", nullable = true, length = 200)
    private String street;

    @Column(name = "CITY", nullable = true, length = 100)
    private String city;

    @Column(name = "PROVINCE", nullable = true, length = 100)
    private String province;

    @Column(name = "COUNTRY", nullable = true, length = 100)
    private String country;

    @Column(name = "ZIP", nullable = true, length = 20)
    private String zip;

    @Column(name = "PHONE", nullable = true, length = 60)
    private String phone;

    @Column(name = "MOBILE", nullable = true, length = 60)
    private String mobile;

    @Column(name = "FAX", nullable = true, length = 60)
    private String fax;

    @Column(name = "EMAIL", nullable = true, length = 100)
    private String email;

    @Column(name = "ACTIVE_STATUS", nullable = true, length = 1)
    private String activeStatus;

    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FK_Company_Company_ID"), unique = false, nullable = false, updatable = false )
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Company companyID;

    @Column(name = "PARTNER_DESC", nullable = true, length = 2000)
    private String partnerDesc;

    @Column(name = "ACCOUNT_REC", nullable = true, length = 60)
    private String accountRec;

    @Column(name = "ACCOUNT_PAY", nullable = true, length = 60)
    private String accountPay;


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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() { 
        return title;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public Long getParentID() { 
        return parentID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() { 
        return type;
    }

    public void setIsCompany(String isCompany) {
        this.isCompany = isCompany;
    }

    public String getIsCompany() { 
        return isCompany;
    }

    public void setNpwpNo(String npwpNo) {
        this.npwpNo = npwpNo;
    }

    public String getNpwpNo() { 
        return npwpNo;
    }

    public void setNpwpAlamat(String npwpAlamat) {
        this.npwpAlamat = npwpAlamat;
    }

    public String getNpwpAlamat() { 
        return npwpAlamat;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() { 
        return address;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() { 
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() { 
        return city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() { 
        return province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() { 
        return country;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() { 
        return zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() { 
        return phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() { 
        return mobile;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() { 
        return fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() { 
        return email;
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


    public void setPartnerDesc(String partnerDesc) {
        this.partnerDesc = partnerDesc;
    }

    public String getPartnerDesc() { 
        return partnerDesc;
    }

    public void setAccountRec(String accountRec) {
        this.accountRec = accountRec;
    }

    public String getAccountRec() { 
        return accountRec;
    }

    public void setAccountPay(String accountPay) {
        this.accountPay = accountPay;
    }

    public String getAccountPay() { 
        return accountPay;
    }

    @Override
    public String toString() {
        return "Partner{" + 
                  "id=" + id + 
                  ", name='" + name+ "\'" + 
                  ", title='" + title+ "\'" + 
                  ", parentID=" + parentID + 
                  ", type='" + type+ "\'" + 
                  ", isCompany='" + isCompany+ "\'" + 
                  ", npwpNo='" + npwpNo+ "\'" + 
                  ", npwpAlamat='" + npwpAlamat+ "\'" + 
                  ", address='" + address+ "\'" + 
                  ", street='" + street+ "\'" + 
                  ", city='" + city+ "\'" + 
                  ", province='" + province+ "\'" + 
                  ", country='" + country+ "\'" + 
                  ", zip='" + zip+ "\'" + 
                  ", phone='" + phone+ "\'" + 
                  ", mobile='" + mobile+ "\'" + 
                  ", fax='" + fax+ "\'" + 
                  ", email='" + email+ "\'" + 
                  ", activeStatus='" + activeStatus+ "\'" + 
                  ", companyID=" + companyID + 
                  ", partnerDesc='" + partnerDesc+ "\'" + 
                  ", accountRec='" + accountRec+ "\'" + 
                  ", accountPay='" + accountPay+ "\'" + 
                 '}';
    }
} 