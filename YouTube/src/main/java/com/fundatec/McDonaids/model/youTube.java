package com.fundatec.McDonaids.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public class youTube {


    @Document
    @Getter
    @Setter
    @NoArgsConstructor
    public class pedidoModel {

        @Id
        private int id;

        private String title;

        private String user;

        private int seguidores;

        private Date date;
    }
}
