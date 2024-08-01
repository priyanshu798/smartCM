package com.scm.smartCM.helpers;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {
    private String content;
    private MessageType type = MessageType.blue;


}
