package com.bernardoms.shortenerurl.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.UUID;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class URLShortenerDTO {
    @Pattern(regexp = "^(https?|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "A Url informada é invalida")
    @NotNull
    private String originalURL;
    @ApiModelProperty(hidden = true)
    private String alias;
    @ApiModelProperty(hidden = true)
    private int redirectCount;

    public void generateShortnerURL() {
        this.alias = URI.create(UUID.randomUUID().toString().substring(0, 6)).toString();
    }
}
