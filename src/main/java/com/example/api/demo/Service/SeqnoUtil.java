package com.example.api.demo.Service;

import com.example.api.demo.Entity.AbowSeqNo;
import com.example.api.demo.Entity.AbowSeqNoId;
import com.example.api.demo.Repository.SeqNoRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeqnoUtil {
    @Autowired
    SeqNoRepository seqnoRepository;
    public AbowSeqNo InsertOrUpdate(Integer SeqNo, String Type, String Kind, Integer SeqDate, Integer Code) {
        int SeqDateFinal;
        int SeqNO_DB = 0;
        switch (Code) {
            case 1:
                String x = String.valueOf(SeqDate);
                x = x.substring(0, 4);
                x = x.concat("0000");
                SeqDateFinal = Integer.parseInt(x);
                break;
            case 2:
                String c = String.valueOf(SeqDate);
                c = c.substring(0, 6);
                c = c.concat("00");
                SeqDateFinal = Integer.parseInt(c);
                break;
            case 3:
                SeqDateFinal = SeqDate;
                break;
            default:
                SeqDateFinal = 0;
                break;
        }
        AbowSeqNo input = null;
        if (!CollectionUtils.isEmpty(seqnoRepository.findByIdSeqDateAndKindAndType(SeqDateFinal, Kind, Type))) {
            List<AbowSeqNo> date = seqnoRepository.findByIdSeqDateAndKindAndType(SeqDateFinal, Kind, Type);
            if (date.size() == 1) {
                for (AbowSeqNo x : date) {
                    SeqNO_DB = x.getSeqNo();
                }
            }
            //AbowSeqNoId id = new AbowSeqNoId();
            // set id...

            input = new AbowSeqNo();
            //input.setId(id);
            input.setCode(Code);
            input.setType(Type);
            input.setKind(Kind);
            input.setSeqDate(SeqDateFinal);
            input.setSeqNo(SeqNO_DB + 1);
            input.composeAbowSeqNoId();
//            System.out.println(Code);
//            System.out.println(Type);
//            System.out.println(Kind);
//            System.out.println(SeqDateFinal);
//            System.out.println(SeqNO_DB + 1);
            input=seqnoRepository.saveAndFlush(input);
        } else {
            input = new AbowSeqNo();
            input.setCode(Code);
            input.setType(Type);
            input.setKind(Kind);
            input.setSeqDate(SeqDateFinal);
            input.setSeqNo(1);
            input.composeAbowSeqNoId();
            input=seqnoRepository.saveAndFlush(input);
        }
        return input;

        //Optional optional =date.stream().filter(x->x.getSeqNo().equals()).findAny();
        // Optional optional=date.stream().filter(x->x.getKind().equals(Kind)).findAny();
//            if(optional.isPresent()){
//                System.out.println(optional.get());
//                Seqno seqno=new Seqno();
//                seqno.setCode(Code);
//                seqno.setKind(Kind);
//                seqno.setType(Type);
//                seqno.setSeqDate(SeqDateFinal);
//                seqno.setSeqNo();
//            }
//        }else {
//
//        }


    }
}
