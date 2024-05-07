package com.bosonit.formacion.block6pathvariableheaders;


import lombok.Data;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class ResultUser {


    private String body;

    private List<String> headers;

    private List<String> requestParams;

}