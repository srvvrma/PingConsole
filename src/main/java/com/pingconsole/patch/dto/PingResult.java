package com.pingconsole.patch.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="API_PING_RESULT")
public class PingResult {
	
	@Id
    @Column Long keyId;
    @Column boolean result;
    @Column Timestamp timestamp;
    @Column String envType;
    public PingResult() {
        super();
        // TODO Auto-generated constructor stub
    }
    public PingResult(Long i, boolean result, Timestamp timestamp,String envType) {
        super();
        this.keyId = i;
        this.result = result;
        this.timestamp = timestamp;
        this.envType = envType;
    }
    public Long getKeyid() {
        return keyId;
    }
    public void setKeyid(Long keyid) {
        keyId = keyid;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
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
    

}
