package com.bosonit.formacion.block6pathvariableheaders;


import lombok.Data;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private Long id;
    private String name;
}