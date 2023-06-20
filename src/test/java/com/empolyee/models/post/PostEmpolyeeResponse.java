package com.empolyee.models.post;


import com.empolyee.models.post.DataPostResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostEmpolyeeResponse {
    String status;
    String message;
    DataPostResponse data;
}
