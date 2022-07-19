package com.example.api.demo.Controller;

import com.example.api.demo.Entity.AbowSeqNo;
import com.example.api.demo.Repository.HumanRepository;
import com.example.api.demo.Repository.SeqNoRepository;
import com.example.api.demo.Service.SeqnoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
public class SeqnoController {
    @Autowired
    SeqnoUtil seqnoUtil;
    @RequestMapping(value = "InsertOrUpdate/{SeqNo}/{Type}/{Kind}/{SeqDate}/{Code}",method = RequestMethod.GET)
    public AbowSeqNo InsertOrUpdate(@PathVariable Integer SeqNo,@PathVariable String Type,@PathVariable String Kind,@PathVariable Integer SeqDate,@PathVariable Integer Code){
        AbowSeqNo result;
        result=seqnoUtil.InsertOrUpdate(SeqNo,Type,Kind,SeqDate,Code);
        return result;
    }
}
