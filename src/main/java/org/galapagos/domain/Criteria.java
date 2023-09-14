package org.galapagos.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

@ToString
@Setter
@Getter
public class Criteria {

    private int pageNum;
    private int amount;

    public Criteria(){this(1, 10);}
    public Criteria(int pageNum){this(pageNum, 10);}

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public int getOffset(){
        return (pageNum - 1) * amount;
    }

    public String getQueryList(){
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromPath("")
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount);

//              .queryParam("type", type)
//              .queryParam("keyword", keyword)

        return builder.toUriString();
    }
}
