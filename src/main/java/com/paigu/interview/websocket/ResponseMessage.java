package com.paigu.interview.websocket;

import lombok.Data;

@Data
public class ResponseMessage {
    private String id;
    private String name;
    private String content;
}
