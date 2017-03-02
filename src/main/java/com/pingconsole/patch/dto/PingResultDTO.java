package com.pingconsole.patch.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PING_RESULT")
public class PingResultDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column Long Keyid;
    @Column boolean result;
    @Column Timestamp timestamp;
    @Column String envType;
    
    public PingResultDTO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public PingResultDTO(Long KeyId,Timestamp timestamp) {
        super();
        this.Keyid = KeyId;
        this.timestamp = timestamp;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getKeyid() {
        return Keyid;
    }
    public void setKeyid(Long keyid) {
        Keyid = keyid;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public boolean getResult() {
        return result;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getEnvType() {
		return envType;
	}
	public void setEnvType(String envType) {
		this.envType = envType;
	}
	@Override
    public String toString() {
        return "PingResultDTO [id=" + id + ", Keyid=" + Keyid + ", result=" + result + ", timestamp=" + timestamp + "]";
    }

}
