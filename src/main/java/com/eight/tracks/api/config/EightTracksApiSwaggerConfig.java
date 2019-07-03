package com.eight.tracks.api.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;



@Configuration
@EnableSwagger2
public class EightTracksApiSwaggerConfig {

  private static List<ResponseMessage> responseMessageList = new ArrayList<>();

  static {
    responseMessageList.add(
        new ResponseMessageBuilder()
            .code(500)
            .message("500 - Internal Server Error")
            .responseModel(new ModelRef("Error"))
            .build());
    responseMessageList.add(
        new ResponseMessageBuilder().code(403).message("403 - Forbidden").build());
    responseMessageList.add(
        new ResponseMessageBuilder()
            .code(200)
            .message("200 - Successful")
            .responseModel(new ModelRef("Success"))
            .build());
    responseMessageList.add(
        new ResponseMessageBuilder()
            .code(404)
            .message("404 - Not Found")
            .responseModel(new ModelRef("Error"))
            .build());
  }

  /**
   * To initialize headers for each Rest end point accessible from swagger.
   *
   * @return
   */
  @Bean
  public Docket api() {
    Docket docket =
        new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.OPTIONS, responseMessageList);
    return docket;
  }

}

