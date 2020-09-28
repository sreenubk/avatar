package com.lotus.security.avatar.model;

import com.lotus.security.avatar.util.Constant;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "authorizationgroup", schema = Constant.SCHEMA )
public class AuthorizationGroup implements java.io.Serializable {

	private BigDecimal authorizationgroupid;
	private OrganizationUnit organizationUnit;
	private Users users;
	//private BigDecimal jobid1;
	private String jobName;
	

	private String createdby;
	private Date createdon;
	private String lastupdatedby;
	private Date lastupdatedon;
	private String authGroupName;


	public AuthorizationGroup() {
	}

	public AuthorizationGroup(BigDecimal authorizationgroupid) {
		this.authorizationgroupid = authorizationgroupid;

	}

	public AuthorizationGroup(BigDecimal authorizationgroupid,
                              OrganizationUnit organizationUnit, Users users, String jobName,
                              String createdby, Date createdon, String lastupdatedby, Date lastupdatedon, String authGrpName) {
		this.authorizationgroupid = authorizationgroupid;
		this.organizationUnit = organizationUnit;
		this.users = users;
		this.jobName = jobName;
		this.createdby = createdby;
		this.createdon = createdon;
		this.lastupdatedby = lastupdatedby;
		this.lastupdatedon = lastupdatedon;
		this.authGroupName = authGrpName ;
	}

	@Id
	@SequenceGenerator(schema = Constant.SCHEMA ,name  = "AuthGrpSeq", sequenceName = "AuthGrpSeq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AuthGrpSeq")
	@Column(name = "authorizationgroupid", unique = true, nullable = false, scale = 0)
	public BigDecimal getAuthorizationgroupid() {
		return this.authorizationgroupid;
	}

	public void setAuthorizationgroupid(BigDecimal authorizationgroupid) {
		this.authorizationgroupid = authorizationgroupid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationUnitid")
	public OrganizationUnit getOrganizationUnit() {
		return this.organizationUnit;
	}

	public void setOrganizationUnit(OrganizationUnit organizationUnit) {
		this.organizationUnit = organizationUnit;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	/*@Column(name = "jobid", scale = 0)
	public BigDecimal getJobid() {
		return this.jobid;
	}

	public void setJobid(BigDecimal jobid) {
		this.jobid = jobid;
	}
*/
	@Column(name = "createdby", length = 64)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdon", length = 13)
	public Date getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	@Column(name = "lastupdatedby", length = 64)
	public String getLastupdatedby() {
		return this.lastupdatedby;
	}

	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lastupdatedon", length = 13)
	public Date getLastupdatedon() {
		return this.lastupdatedon;
	}

	public void setLastupdatedon(Date lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}
    
	@Column(name = "authgroupname", length = 64)
	public String getAuthGroupName() {
		return authGroupName;
	}

	public void setAuthGroupName(String authGroupName) {
		this.authGroupName = authGroupName;
	}
	
	@Column(name = "jobname", length = 50)
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}

