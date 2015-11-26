package com.kelvin.product.web.model.system;

import com.kelvin.product.core.generic.entity.IDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by tangshulei on 2015/11/26.
 */
@Entity
@Table(name="t_log_info")
public class LogInfo extends IDEntity{

    @Column(name="log_type", length = 1)
    private int logType;
    @Column(name="log_msg", length = 2000)
    private String logMsg;
    @Column(name="log_level", length = 1)
    private int logLevel;
    @Column(name="note", length = 1000)
    private String note;

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    public int getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
