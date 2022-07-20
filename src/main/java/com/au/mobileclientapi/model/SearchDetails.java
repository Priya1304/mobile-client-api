package com.au.mobileclientapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDetails {

    @Pattern(regexp ="\\d{4}", message = "Invalid Australian PostCode Format")
    private int postCode;

    private List<String> suburb;

}
