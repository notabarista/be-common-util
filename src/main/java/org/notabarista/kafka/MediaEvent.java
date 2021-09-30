package org.notabarista.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaEvent {

    private MediaEventType mediaEventType;
    private String itemID;
    private List<String> mediaURLs;
    private String userID;
}
