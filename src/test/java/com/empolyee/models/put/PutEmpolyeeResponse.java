package com.empolyee.models.put;

import com.empolyee.models.put.PutDataBody;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PutEmpolyeeResponse {
    String status;
    String message;
    PutDataBody data;
}
