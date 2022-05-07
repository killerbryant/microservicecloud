package com.edison.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration // 標明是配置類
@EnableOpenApi // 開啟swagger功能
public class SwaggerConfig {
	@Bean
	public Docket createRestApi(Environment environment) {
		/*Profiles profiles = Profiles.of("dev", "test");
        boolean isEnable = environment.acceptsProfiles(profiles);*/
		
      //構造一個全域參數
      /*  Parameter parameter = new ParameterBuilder()
                //參數名稱
                .name("token")
                //參數類型，放在請求頭中
                .parameterType("header")
                //參數描述
                .description("用戶權杖")
                //是否必須
                .required(true)
                //參數類型
                .modelRef(new ModelRef("String"))
                .build();
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parameter);*/

        return new Docket(
                // 設置使用 OpenApi 3.0 規範
                DocumentationType.OAS_30)
                // 是否開啟 Swagger
                .enable(true)
                // 配置專案基本資訊
                .apiInfo(apiInfo())
                // 設置專案組名
                .groupName("v1")
                // 選擇那些路徑和api會生成document
                .select()
                // 對所有api進行監控
                .apis(RequestHandlerSelectors.any())
                // 如果需要指定對某個包的介面進行監控，則可以配置如下
                //.apis(RequestHandlerSelectors.basePackage("mydlq.swagger.example.controller"))
                // 對所有路徑進行監控
                .paths(PathSelectors.any())
                // 忽略以"/error"開頭的路徑,可以防止顯示如404錯誤介面
                .paths(PathSelectors.regex("/error.*").negate())
                // 忽略以"/actuator"開頭的路徑
                .paths(PathSelectors.regex("/actuator.*").negate())
                .build();

	}
	
	/**
     * 隱藏UI上的Models模組
     */
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                // 隐藏UI上的Models模块
                .defaultModelsExpandDepth(-1)
                .defaultModelExpandDepth(0)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .validatorUrl(null)
                .build();
    }

	/**
	 * 用於定義API主介面的資訊，比如可以聲明所有的API的總標題、描述、版本
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("微服務API") // 可以用來自定義API的主標題
				.description("微服務SwaggerAPI管理") // 可以用來描述整體的API
				.termsOfServiceUrl("") // 用於定義服務的功能變數名稱
				.version("1.0") // 可以用來定義版本。
				.build(); //
	}
}
