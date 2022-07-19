package com.example.api.demo.Entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AbowSeqNoId implements Serializable {
    private static final long serialVersionUID = 5960242028094167307L;

    @Column(name = "\"Kind\"", nullable = false, length = 5)
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String Kind) {
        kind = Kind;
    }


    @Column(name = "\"SeqDate\"", nullable = false,length = 8)
    private Integer seqDate;

    public Integer getSeqDate() {
        return seqDate;
    }

    public void setSeqDate(Integer SeqDate) {
        seqDate = SeqDate;
    }


    @Column(name = "\"Code\"", nullable = false,length = 1)
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public AbowSeqNoId(){
    }

    public AbowSeqNoId(String kind, Integer code, Integer seqDate) {
        this.kind=kind;
        this.code=code;
        this.seqDate=seqDate;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AbowSeqNoId entity = (AbowSeqNoId) o;
        return Objects.equals(this.seqDate, entity.seqDate) &&
                Objects.equals(this.code, entity.code) &&
                Objects.equals(this.kind, entity.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqDate, code, kind);
    }

}