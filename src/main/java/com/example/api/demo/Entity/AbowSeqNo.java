package com.example.api.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "\"AbowSeqNo\"")
public class AbowSeqNo {
    @EmbeddedId
    AbowSeqNoId id;

    public AbowSeqNoId getId() {
        return id;
    }

    public void setId(AbowSeqNoId id) {
        this.id = id;
    }

    public void composeAbowSeqNoId() {
        this.id = new AbowSeqNoId(
                this.kind,
                this.code,
                this.seqDate
        );
    }


    @Column(name = "\"Kind\"", nullable = false, length = 5,insertable = false,updatable = false)
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String Kind) {
        kind = Kind;
    }

    @Column(name = "\"SeqDate\"", nullable = false,length = 8,insertable = false,updatable = false)
    private Integer seqDate;

    public Integer getSeqDate() {
        return seqDate;
    }

    public void setSeqDate(Integer SeqDate) {
        seqDate = SeqDate;
    }

    @Column(name = "\"Code\"", nullable = false,length = 1,insertable = false,updatable = false)
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    @Column(name = "\"SeqNo\"", nullable = false,length = 8)
    private Integer seqNo;

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    @Column(name = "\"Type\"", nullable = false, length = 2)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}